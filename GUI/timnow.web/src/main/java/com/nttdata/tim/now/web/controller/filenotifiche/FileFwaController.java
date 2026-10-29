package com.nttdata.tim.now.web.controller.filenotifiche;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.AccessDeniedException;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.InvalidFilenameException;
import com.nttdata.tim.now.core.service.filenotifiche.FileFwaManagerBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.bean.notifica.FileFwaOutputBean;
import com.nttdata.tim.now.data.bean.result.Result;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.enumeration.ResultCodeEnum;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.FileDownloadController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//RU_1335
@RestController
@RequestMapping("/fwa")
public class FileFwaController extends FileDownloadController {
    private static final String FILE_EMPTY_ERROR_MESSAGE = "Selezionare un file non vuoto!";

    @Autowired
    private FileFwaManagerBL fileFwaManagerBL;
    
	// File -> File FWA
	@JsonGetMapping
	public GenericListBean<FileFwaOutputBean> getAllFwaFiles(HttpSession session)
			throws BusinessLayerException {
		logger.info("get FWA file list");
		UserBean currentUser = getCurrentUser(session);
		GenericListBean<FileFwaOutputBean> bean = fileFwaManagerBL.getAllFwaFiles(currentUser.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}
    	
	// File -> Caricamento File FWA da GUI
	@JsonPostMapping("/upload")
	public EmptyBean upload(
			@RequestParam(value = "file") MultipartFile file,
			HttpSession session) throws IOException, BusinessLayerException {
		if (!file.isEmpty()) {
			logger.info("uploading file FWA " + file.getOriginalFilename());
			UserBean user = getCurrentUser(session);
			try {
				FileScaricatoBean uploadedFile = new FileScaricatoBean();
				uploadedFile.setName(file.getOriginalFilename());
				uploadedFile.setSize(file.getSize());
				uploadedFile.setMime(file.getContentType());
				uploadedFile.setFileData(file.getBytes());
				fileFwaManagerBL.upload(uploadedFile, user.getCodiceProfilo());
				
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
}
