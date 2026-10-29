package com.nttdata.tim.now.core.service.filenotifiche;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.filenotifiche.MulticastRESTClient;
import com.nttdata.tim.now.core.exception.AccessDeniedException;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.InvalidFilenameException;
import com.nttdata.tim.now.core.exception.NotFoundException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.bean.notifica.FileMulticastOutputBean;
import com.nttdata.tim.now.data.bean.notifica.VerificaContrattoMulticastWrapperOutputBean;
import com.nttdata.tim.now.data.bean.notifica.VerificaFileEsitiMulticastOutputBean;
import com.nttdata.tim.now.data.bean.notifica.VerificaFileEsitiMulticastWrapperOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.file.FileMulticastToUploadDTO;
import com.nttdata.tim.now.data.dto.file.FileWrapperDTO;
import com.nttdata.tim.now.data.dto.notifica.FileMulticastWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.notifica.VerificaContrattoMulticastWrapperOutputDTO;
import com.nttdata.tim.now.data.enumeration.BackEndResultCode;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//RU_1180
@Service
public class MulticastManagerBL extends AbstractBL {
	
    @Value("${filename.multicast.pattern}")
    private String filenamePattern;

	@Autowired
	private MulticastRESTClient multicastRestIL;

	public GenericListBean<FileMulticastOutputBean> getAllMulticastFiles(String codOloAgcom, String tipoProfilo)
			throws BusinessLayerException {
		GenericListBean<FileMulticastOutputBean> list = new GenericListBean<>();
        boolean isLimited;
		try {
			FileMulticastWrapperOutputDTO dto = multicastRestIL.getAllMulticastFiles(codOloAgcom, tipoProfilo);
			isLimited = validateResponseResult(dto);
			if (dto != null && dto.getOutputVisualizzaFileSediCanali() != null) {
				list.setData(mapper.translateList(dto.getOutputVisualizzaFileSediCanali(), FileMulticastOutputBean.class));
				list.setIsLimitedList(isLimited);
			}
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}
	
	public VerificaContrattoMulticastWrapperOutputBean verificaContrattoMulticast(String codOloAgcom)
			throws BusinessLayerException {
		VerificaContrattoMulticastWrapperOutputBean bean = null;
		try {
			VerificaContrattoMulticastWrapperOutputDTO dto = multicastRestIL.verificaContrattoMulticast(codOloAgcom);
			validateResponseResult(dto);
			bean = mapper.translate(dto, VerificaContrattoMulticastWrapperOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	public void uploadFileMulticast(FileScaricatoBean uploadedFile, String codOloAgcom, String codOloNumerico, String idContratto, String tipoProfilo) throws BusinessLayerException, AccessDeniedException {
		ESBResultDTO result;
		try {
			validateFileName(uploadedFile.getName(), codOloAgcom, codOloNumerico);
			FileMulticastToUploadDTO fileDTO = new FileMulticastToUploadDTO();			
			fileDTO.setCodOloAgcom(codOloAgcom);
			fileDTO.setNomeFile(normalizeExtension(uploadedFile.getName()));
			fileDTO.setContenutoFile(uploadedFile.getFileData());
			fileDTO.setIdContratto(idContratto);
			result = multicastRestIL.uploadFileMulticast(fileDTO, tipoProfilo);
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
	
	
	private void validateFileName(String name, String codOloAgcom, String codOloNumerico) throws InvalidFilenameException {
		
		String patternOloAgcom = "_"+ codOloNumerico +"_";
		
		Pattern patternName = Pattern.compile(filenamePattern, Pattern.CASE_INSENSITIVE);
		Matcher matcherName = patternName.matcher(name);
		if (!matcherName.matches()) {
			throw new InvalidFilenameException("Il nome " + name + " non rispetta la naming convention condivisa");
		} else if(!name.toUpperCase().contains(patternOloAgcom.toUpperCase())) {
			throw new InvalidFilenameException("L'Olo numerico " + codOloNumerico + " selezionato non corrisponde a quello del file");
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
	
	public FileScaricatoBean downloadFileEsitiMulticast(String idFile, String fileName, String interfaccia, UserBean user)throws BusinessLayerException {
		FileWrapperDTO wrapper;
		try {
			wrapper = multicastRestIL.downloadFileEsitiMulticast(idFile, fileName, interfaccia, user);
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
	
	//CR01-CR04
	public VerificaFileEsitiMulticastWrapperOutputBean verificaFileEsitiMulticast(String idFile, String fileName, String interfaccia, UserBean user)throws BusinessLayerException {
		FileWrapperDTO wrapper;
		try {
			wrapper = multicastRestIL.downloadFileEsitiMulticast(idFile, fileName, interfaccia, user);			
		} catch (IntegrationLayerException e) {
			logger.error("Error verifyng file", e);
			throw new BusinessLayerException(e);
		}
		VerificaFileEsitiMulticastWrapperOutputBean bean = new VerificaFileEsitiMulticastWrapperOutputBean();
		if (wrapper != null) {			
			VerificaFileEsitiMulticastOutputBean result = new VerificaFileEsitiMulticastOutputBean();
			result.setEsito(wrapper.getResult().getCode());
			result.setMessage(wrapper.getResult().getDetails());
			bean.setOutputVerificaFileEsitiMulticast(result);
		} else {
			throw new BusinessLayerException("Not found file with id " + idFile);
		}
		return bean;
	}
	
}
