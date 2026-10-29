package com.nttdata.tim.now.web.controller.anagrafica;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.AccessDeniedException;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.InvalidFilenameException;
import com.nttdata.tim.now.core.service.anagrafica.ComuniCoinvestitiManagerBL;
import com.nttdata.tim.now.data.bean.anagraficacoinvestimento.ComuniCoinvestimentoInputBean;
import com.nttdata.tim.now.data.bean.anagraficacoinvestimento.ComuniCoinvestimentoWrapperOutputBean;
import com.nttdata.tim.now.data.bean.anagraficacoinvestimento.DownloadFileEsitiComuniCoinvestimentoInputBean;
import com.nttdata.tim.now.data.bean.anagraficacoinvestimento.FileComuniCoinvestimentoOutputBean;
import com.nttdata.tim.now.data.bean.anagraficacoinvestimento.ListaFileComuniCoinvestimentoWrapperOutputBean;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.bean.result.Result;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.enumeration.ResultCodeEnum;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.FileDownloadController;
import com.nttdata.tim.now.web.exception.FileNotFoundHttpException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//RU_1164
@RestController
@RequestMapping("/comuniCoinvestiti")
public class ComuniCoinvestitiController extends FileDownloadController  {

    @Autowired
    private ComuniCoinvestitiManagerBL comuniCoinvestitiManagerBL;
    
    private static final String FILE_EMPTY_ERROR_MESSAGE = "Selezionare un file non vuoto!";
    
    // Lista Comuni coinvestiti-> Request
    //RU_1276
    @JsonPostMapping
    public ComuniCoinvestimentoWrapperOutputBean listaComuniCoinvestimento(@RequestBody ComuniCoinvestimentoInputBean input, HttpSession session) throws BusinessLayerException {
    	logger.debug("Comuni coinvestimento");
        UserBean user = getCurrentUser(session);
        input.setTipoProfilo(user.getCodiceProfilo());
        input.setUserId(user.getUserId());
        ComuniCoinvestimentoWrapperOutputBean bean = comuniCoinvestitiManagerBL.listaComuniCoinvestimento(input, user.getCodiceProfilo());
        return bean;
    } 
    
    // Lista file Comuni coinvestiti-> Request
    @JsonGetMapping
    public ListaFileComuniCoinvestimentoWrapperOutputBean listaFileComuniCoinvestiti(@RequestParam String codOloAgcom, @RequestParam String idContratto, HttpSession session) throws BusinessLayerException {
    	logger.debug("Lista file Comuni coinvestiti");
        UserBean user = getCurrentUser(session);
        ListaFileComuniCoinvestimentoWrapperOutputBean bean = comuniCoinvestitiManagerBL.listaFileComuniCoinvestimento(codOloAgcom, idContratto, user.getCodiceProfilo());
        return bean;
    }
    
	// File -> Caricamento File Comuni coinvestimento da GUI
	@JsonPostMapping("/uploadFileComuniCoinvestiti")
	public EmptyBean uploadFileComuniCoinvestiti(
			@RequestParam(value = "file") MultipartFile file,
			@RequestParam(value = "codOloAgcom") String codOloAgcom,
			@RequestParam(value = "offerta") String offerta,
			@RequestParam(value = "idContratto") String idContratto,
			HttpSession session) throws IOException, BusinessLayerException {
		if (!file.isEmpty()) {
			logger.info("uploading file");
			UserBean user = getCurrentUser(session);
			try {
				FileScaricatoBean uploadedFile = new FileScaricatoBean();
				uploadedFile.setName(file.getOriginalFilename());
				uploadedFile.setSize(file.getSize());
				uploadedFile.setMime(file.getContentType());
				uploadedFile.setFileData(file.getBytes());

				comuniCoinvestitiManagerBL.uploadFileComuniCoinvestiti(uploadedFile, codOloAgcom, offerta, idContratto, user.getCodiceProfilo());

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
	
	//RU_1276
	@JsonGetMapping("/downloadFileEsiti")
	public ResponseEntity<byte[]> downloadFileEsitiComuniCoinvestiti(
			@RequestParam String idFile,
			@RequestParam String codOloAgcom,
			@RequestParam String fileName,
			@RequestParam String offerta,
			HttpSession session) throws FileNotFoundHttpException {
		UserBean user = getCurrentUser(session);
		try {
			DownloadFileEsitiComuniCoinvestimentoInputBean inputBean = new DownloadFileEsitiComuniCoinvestimentoInputBean();
			inputBean.setCodOloAgcom(codOloAgcom);
			inputBean.setIdFile(idFile);
			inputBean.setNomeFile(fileName);
			inputBean.setOfferta(offerta);
			FileScaricatoBean fileBean = comuniCoinvestitiManagerBL.downloadFileEsitiComuniCoinvestiti(inputBean, user);			
			return getFileResponseEntity(fileBean);
		} catch (Exception e) {
			logger.info("Impossibile effettuare il download del file", e);
			throw new FileNotFoundHttpException();
		}
	} 
	
	//RU_1301
    // Ricerca Avanzata
    @JsonPostMapping("/search")
    public GenericListBean<FileComuniCoinvestimentoOutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session) throws BusinessLayerException {

        UserBean user = getCurrentUser(session);
        GenericListBean<FileComuniCoinvestimentoOutputBean> bean = comuniCoinvestitiManagerBL.advancedSearch(body, user.getUserId(), user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
    }   
}
