package com.nttdata.tim.now.core.service.generic;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.generic.FileRESTClient;
import com.nttdata.tim.now.core.exception.AccessDeniedException;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.InvalidFilenameException;
import com.nttdata.tim.now.core.exception.NotFoundException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.file.FileToUploadDTO;
import com.nttdata.tim.now.data.dto.file.FileWrapperDTO;
import com.nttdata.tim.now.data.enumeration.BackEndResultCode;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileManagerBL extends AbstractBL {

    @Value("${filename.pattern}")
    private String filenamePattern;
    
    @Value("${filename.np.pattern}")
    private String filenameNpPattern;

	@Autowired
	private FileRESTClient fileRestIL;

	public FileScaricatoBean downloadLocalFile(String filepath) throws BusinessLayerException {
		FileScaricatoBean bean = new FileScaricatoBean();
		try {
			File file = new File(filepath);
			Path path = file.toPath();
			
			byte[] data = Files.readAllBytes(path);
			String mime = Files.probeContentType(path);

			bean.setMime(mime);
			bean.setFileData(data);
			bean.setName(file.getName());
			bean.setSize(data.length);
		} catch (Exception e) {
			throw new BusinessLayerException("Impossibile leggere il file", e);
		}
		return bean;
	}
	
	//SM_8904
	public FileScaricatoBean downloadFile(String idFile, String tipoProfilo, String userId, String vista, UserBean user) throws BusinessLayerException {
		FileWrapperDTO wrapper;
		try {
			//RU_902 //SM_8904
			wrapper = fileRestIL.download(idFile, tipoProfilo, userId, vista, user);
			validateResponseResult(wrapper);
		} catch (IntegrationLayerException e) {
			logger.error("Error downloading file", e);
			throw new BusinessLayerException(e);
		}
		FileScaricatoBean bean = null;
		if (wrapper != null && wrapper.getFile() != null) {
			bean = new FileScaricatoBean();
			byte[] fileData = new Base64().decode(wrapper.getFile().getContenutoFile().getBytes());
			bean.setFileData(fileData);
			bean.setName(wrapper.getFile().getNomeFile());
			bean.setSize(fileData.length);
		} else {
			throw new NotFoundException("Not found file with id " + idFile);
		}
		return bean;
	}

	public void uploadFile(FileScaricatoBean uploadedFile, String oloAgcomCode, String tipoProfilo) throws BusinessLayerException, AccessDeniedException {
		ESBResultDTO result;
		try {
			validateFileName(uploadedFile.getName());
			FileToUploadDTO fileDTO = new FileToUploadDTO();
			fileDTO.setCodagcom(oloAgcomCode);
			fileDTO.setNomefile(normalizeExtension(uploadedFile.getName()));
			fileDTO.setContenutofile(uploadedFile.getFileData());
			result = fileRestIL.upload(fileDTO, tipoProfilo);
			validateResponseResult(result);
		} catch (IntegrationLayerException e) {
			throw new BusinessLayerException("Impossibile completare l'upload del file " + uploadedFile.getName(), e);
		}
		
		if (result != null && result.getResult() != null) {
			String code = result.getResult().getCode();
			if (BackEndResultCode.USER_NOT_ENABLED.getCode().equals(code)) {
				String detail = result.getResult().getDetails();
				throw new AccessDeniedException(detail);
			}
		}
	}

	private void validateFileName(String name) throws InvalidFilenameException {
		Pattern pattern = Pattern.compile(filenamePattern, Pattern.CASE_INSENSITIVE);
		Pattern patternNP = Pattern.compile(filenameNpPattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(name);
		Matcher matcherNP = patternNP.matcher(name);
		if (matcher.matches()) {
			logger.debug("filename is valid " + name);
		} else if (matcherNP.matches()){
			throw new InvalidFilenameException("L'upload dei file NP non è consentito");
		} else {
			throw new InvalidFilenameException("Il nome " + name + " non rispetta la naming convention condivisa");
		}
	}
	
	private String normalizeExtension(String filename){
		String result = "";
		String[] tokens = filename.split("\\.");
		if(tokens.length != 0){
			int size = tokens.length;
			String extension = tokens[size - 1];
			extension.toLowerCase();
			for(int i = 0;i<size-1;i++){
				result = result + tokens[i] + '.';
			}
			result = result + extension.toLowerCase();
			logger.debug("Filename di upload normalizzato!");
		}
		else{
			result = filename;
		}
		return result;
	}

}
