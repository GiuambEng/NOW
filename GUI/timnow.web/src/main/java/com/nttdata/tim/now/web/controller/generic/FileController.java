package com.nttdata.tim.now.web.controller.generic;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.AccessDeniedException;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.InvalidFilenameException;
import com.nttdata.tim.now.core.service.generic.FileManagerBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.bean.result.Result;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.enumeration.ProfiloCRM;
import com.nttdata.tim.now.data.enumeration.ResultCodeEnum;
import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.util.properties.PropertiesHelper;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.FileDownloadController;
import com.nttdata.tim.now.web.exception.FileNotFoundHttpException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController extends FileDownloadController {
    private static final String FILE_EMPTY_ERROR_MESSAGE = "Selezionare un file non vuoto!";

    @Autowired
    private FileManagerBL fileManagerBL;
    
	// File -> Caricamento File da GUI
	@JsonPostMapping("/order_request")
	public EmptyBean uploadMultipart(
			@RequestParam(value = "file") MultipartFile file,
			@RequestParam(value = "codAgcom", required = false) String codAgcom, 
			HttpSession session) throws IOException, BusinessLayerException {
		String codiceAGCOM = codAgcom;
		if (!file.isEmpty()) {
			logger.info("uploading file");
			UserBean user = getCurrentUser(session);
			try {
				FileScaricatoBean uploadedFile = new FileScaricatoBean();
				uploadedFile.setName(file.getOriginalFilename());
				uploadedFile.setSize(file.getSize());
				uploadedFile.setMime(file.getContentType());
				uploadedFile.setFileData(file.getBytes());

				if (codAgcom == null) {
					codiceAGCOM = user.getCodificaOloAgcom();
				}

				fileManagerBL.uploadFile(uploadedFile, codiceAGCOM, user.getCodiceProfilo());
				
			} catch (IOException e) {
				logger.warn("Error file not uploaded correctly!", e);
				throw e;
			} catch (InvalidFilenameException ifne) {
				logger.warn("Invalid filename: file not uploaded!", ifne);
				ResultCodeEnum code = ResultCodeEnum.VALIDATION_ERROR;
				return getEmptyBean(new Result(code.getCode(), ifne.getMessage(), code.getMessage()));
			} catch (AccessDeniedException e) {
				logger.warn("Access denied to the file!", e);
				ResultCodeEnum code = ResultCodeEnum.VALIDATION_ERROR;
				return getEmptyBean(new Result(code.getCode(), e.getMessage(), code.getMessage()));
			}
		} else {
			logger.info("uploading an empty file");
			ResultCodeEnum code = ResultCodeEnum.VALIDATION_ERROR;
			return getEmptyBean(new Result(code.getCode(), FILE_EMPTY_ERROR_MESSAGE, FILE_EMPTY_ERROR_MESSAGE));
		}
		return getSuccessEmptyBean();
	}

	// File -> Download
	@JsonGetMapping()
	public ResponseEntity<byte[]> download(
			@RequestParam(value = "idFile") String idFile, 
			@RequestParam(value = "vista", required = false) String vista, //SM_8904
			HttpSession session) throws FileNotFoundHttpException {
		//logger.debug("INSIDE DOWNLOAD#################################");
		UserBean user = getCurrentUser(session);
		try {
			//RU_902 //SM_8904
			FileScaricatoBean fileBean = fileManagerBL.downloadFile(idFile, user.getCodiceProfilo(),user.getUserId(), vista, user);			
			return getFileResponseEntity(fileBean);
		} catch (Exception e) {
			logger.info("Impossibile effettuare il download del file", e);
			throw new FileNotFoundHttpException();
		}
	}

	// Download manuale
	@JsonGetMapping("/manuale")
	public ResponseEntity<byte[]> downloadManuale(HttpSession session) throws FileNotFoundHttpException {
		try {
			UserBean user = getCurrentUser(session);
			ProfiloCRM profilo = ProfiloCRM.getProfilo(user.getCodiceProfilo());

			String filepath;
			// Il download del manuale e' dinamico in base al Profilo
			// dell'utente loggato: Se profilo *OLO* viene effettuato il
			// download del Manuale Utente specifico per gli OLO, altrimenti
			// vien effettato il download di un Manuale Utente ad uso interno.
			if (ProfiloCRM.CRM_OLO == profilo || ProfiloCRM.CRM_OLORO ==  profilo) {
				filepath = PropertiesHelper.getStringProperty(Constants.FILES_MANUALE_OLO_PATH);
			} else {
				filepath = PropertiesHelper.getStringProperty(Constants.FILES_MANUALE_UTENTE_PATH);
			}

			FileScaricatoBean fileBean = fileManagerBL.downloadLocalFile(filepath);

			return getFileResponseEntity(fileBean);
		} catch (Exception e) {
			logger.info("Impossibile effettuare il download del file", e);
			throw new FileNotFoundHttpException();
		}
	}

}
