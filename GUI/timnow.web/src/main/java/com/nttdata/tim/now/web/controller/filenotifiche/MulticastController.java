package com.nttdata.tim.now.web.controller.filenotifiche;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.AccessDeniedException;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.InvalidFilenameException;
import com.nttdata.tim.now.core.service.filenotifiche.MulticastManagerBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.bean.notifica.FileMulticastOutputBean;
import com.nttdata.tim.now.data.bean.notifica.VerificaContrattoMulticastWrapperOutputBean;
import com.nttdata.tim.now.data.bean.notifica.VerificaFileEsitiMulticastWrapperOutputBean;
import com.nttdata.tim.now.data.bean.result.Result;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.enumeration.ResultCodeEnum;
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

//RU_1180
@RestController
@RequestMapping("/multicast")
public class MulticastController extends FileDownloadController {

	private static final String FILE_EMPTY_ERROR_MESSAGE = "Selezionare un file non vuoto!";

	@Autowired
	private MulticastManagerBL multicastManagerBL;

	// File -> File Multicast
	@JsonGetMapping
	public GenericListBean<FileMulticastOutputBean> getAllMulticastFiles(HttpSession session)
			throws BusinessLayerException {
		logger.info("get multicast");
		UserBean currentUser = getCurrentUser(session);
		GenericListBean<FileMulticastOutputBean> bean = multicastManagerBL.getAllMulticastFiles(currentUser.getCodificaOloAgcom(), currentUser.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	//C13M05F06 - Verifica Contratto Multicast
	@JsonGetMapping("/verificaContrattoMulticast")
	public VerificaContrattoMulticastWrapperOutputBean verificaContrattoMulticast(@RequestParam("codOloAgcom") String codOloAgcom, HttpSession session)
			throws BusinessLayerException {
		logger.info("verifica contratto multicast");
		VerificaContrattoMulticastWrapperOutputBean bean = multicastManagerBL.verificaContrattoMulticast(codOloAgcom);
		bean = ensureBeanResult(bean, VerificaContrattoMulticastWrapperOutputBean.class);
		return bean;
	}

	// File -> Caricamento File Multicast da GUI
	@JsonPostMapping("/upload")
	public EmptyBean uploadFileMulticast(
			@RequestParam(value = "file") MultipartFile file,
			@RequestParam(value = "codAgcom", required = false) String codAgcom,
			@RequestParam(value = "codNumericoAgcom") String codNumericoAgcom,
			@RequestParam(value = "idContratto", required = false) String idContratto,
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

				multicastManagerBL.uploadFileMulticast(uploadedFile, codiceAGCOM, codNumericoAgcom, idContratto, user.getCodiceProfilo());

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

	@JsonGetMapping("/downloadFileEsiti")
	public ResponseEntity<byte[]> downloadFileEsitiMulticast(
			@RequestParam(value = "idFile") String idFile, 
			@RequestParam(value = "fileName") String fileName,
			@RequestParam(value = "interfaccia") String interfaccia,
			HttpSession session) throws FileNotFoundHttpException {
		UserBean user = getCurrentUser(session);
		try {
			FileScaricatoBean fileBean = multicastManagerBL.downloadFileEsitiMulticast(idFile, fileName, interfaccia, user);			
			return getFileResponseEntity(fileBean);
		} catch (Exception e) {
			logger.info("Impossibile effettuare il download del file", e);
			throw new FileNotFoundHttpException();
		}
	}  

	//CR1-CR4
	@JsonGetMapping("/verificaFileEsiti")
	public VerificaFileEsitiMulticastWrapperOutputBean verificaFileEsitiMulticast(
			@RequestParam(value = "idFile") String idFile, 
			@RequestParam(value = "fileName") String fileName,
			@RequestParam(value = "interfaccia") String interfaccia,
			HttpSession session) throws FileNotFoundHttpException, BusinessLayerException {
		UserBean user = getCurrentUser(session);
		VerificaFileEsitiMulticastWrapperOutputBean bean = multicastManagerBL.verificaFileEsitiMulticast(idFile, fileName, interfaccia, user);			
		bean = ensureBeanResult(bean, VerificaFileEsitiMulticastWrapperOutputBean.class);
		return bean;
	}  
}
