package com.nttdata.tim.now.core.service.anagrafica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.anagrafica.ComuniCoinvestitiRESTClient;
import com.nttdata.tim.now.core.exception.AccessDeniedException;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.InvalidFilenameException;
import com.nttdata.tim.now.core.exception.NotFoundException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.anagraficacoinvestimento.ComuniCoinvestimentoInputBean;
import com.nttdata.tim.now.data.bean.anagraficacoinvestimento.ComuniCoinvestimentoWrapperOutputBean;
import com.nttdata.tim.now.data.bean.anagraficacoinvestimento.DownloadFileEsitiComuniCoinvestimentoInputBean;
import com.nttdata.tim.now.data.bean.anagraficacoinvestimento.FileComuniCoinvestimentoOutputBean;
import com.nttdata.tim.now.data.bean.anagraficacoinvestimento.ListaFileComuniCoinvestimentoWrapperOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.anagraficacoinvestimento.ComuniCoinvestimentoInputDTO;
import com.nttdata.tim.now.data.dto.anagraficacoinvestimento.ComuniCoinvestimentoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.anagraficacoinvestimento.DownloadFileEsitiComuniCoinvestimentoInputDTO;
import com.nttdata.tim.now.data.dto.anagraficacoinvestimento.FileComuniCoinvestimentoToUploadDTO;
import com.nttdata.tim.now.data.dto.anagraficacoinvestimento.ListaFileComuniCoinvestimentoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.file.FileWrapperDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.enumeration.BackEndResultCode;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//RU_1164
@Service
public class ComuniCoinvestitiManagerBL extends AbstractBL {

	@Autowired
	private ComuniCoinvestitiRESTClient comuniCoinvestitiRESTClient;
	
    @Value("${filename.comuni.coinvestimento.pattern}")
    private String filenamePattern;
    
    //RU_1301
	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	//RU_1276
    public ComuniCoinvestimentoWrapperOutputBean listaComuniCoinvestimento(ComuniCoinvestimentoInputBean bean, String tipoProfilo)
            throws BusinessLayerException {

    	ComuniCoinvestimentoWrapperOutputDTO resultDto = null;
    	ComuniCoinvestimentoWrapperOutputBean resultBean = null;
    	ComuniCoinvestimentoInputDTO inputDto = new ComuniCoinvestimentoInputDTO();
        try {        	
        	inputDto = mapper.translate(bean, ComuniCoinvestimentoInputDTO.class);
        	resultDto = comuniCoinvestitiRESTClient.listaComuniCoinvestimento(inputDto, tipoProfilo);            
            validateResponseResult(resultDto);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        
        if(resultDto != null) {
        	resultBean = mapper.translate(resultDto, ComuniCoinvestimentoWrapperOutputBean.class);
        }
        return resultBean;
    }
    
	//RU_1276
    public ListaFileComuniCoinvestimentoWrapperOutputBean listaFileComuniCoinvestimento(String codOloAgcom, String idContratto, String tipoProfilo)
            throws BusinessLayerException {

    	ListaFileComuniCoinvestimentoWrapperOutputDTO resultDto = null;
    	ListaFileComuniCoinvestimentoWrapperOutputBean resultBean = null;
        try {        	
        	resultDto = comuniCoinvestitiRESTClient.listaFileComuniCoinvestimento(codOloAgcom, idContratto, tipoProfilo);            
            validateResponseResult(resultDto);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        
        if(resultDto != null) {
        	resultBean = mapper.translate(resultDto, ListaFileComuniCoinvestimentoWrapperOutputBean.class);
        }
        return resultBean;
    }
    
    //RU_1276
	public void uploadFileComuniCoinvestiti(FileScaricatoBean uploadedFile, String codOloAgcom, String offerta, String idContratto, String tipoProfilo) throws BusinessLayerException, AccessDeniedException {
		ESBResultDTO result;
		try {
			validateFileName(uploadedFile.getName(), codOloAgcom, offerta);
			FileComuniCoinvestimentoToUploadDTO fileDTO = new FileComuniCoinvestimentoToUploadDTO();	
			fileDTO.setNomeFile(normalizeExtension(uploadedFile.getName()));
			fileDTO.setContenutoFile(uploadedFile.getFileData());
			fileDTO.setCodOloAgcom(codOloAgcom);
			fileDTO.setIdContratto(idContratto);
			result = comuniCoinvestitiRESTClient.uploadFileComuniCoinvestiti(fileDTO, tipoProfilo);
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
	
	private void validateFileName(String name, String codOloAgcom, String offerta) throws InvalidFilenameException {
		
		String patternOloAgcom = codOloAgcom + "_" + offerta;
		
		Pattern patternName = Pattern.compile(filenamePattern, Pattern.CASE_INSENSITIVE);
		Matcher matcherName = patternName.matcher(name);
		if (!matcherName.matches()) {
			throw new InvalidFilenameException("Il nome " + name + " non rispetta la naming convention condivisa");
		} else if(!name.toUpperCase().contains(patternOloAgcom.toUpperCase())) {
			//CR #37752
			throw new InvalidFilenameException("Nomenclatura del file non corrispondente al contratto selezionato");
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
	
	//RU_1276
	public FileScaricatoBean downloadFileEsitiComuniCoinvestiti(DownloadFileEsitiComuniCoinvestimentoInputBean inputBean, UserBean user)throws BusinessLayerException {
		FileWrapperDTO wrapper;
		DownloadFileEsitiComuniCoinvestimentoInputDTO inputDto = null;	
		try {
			inputDto = mapper.translate(inputBean, DownloadFileEsitiComuniCoinvestimentoInputDTO.class);
			wrapper = comuniCoinvestitiRESTClient.downloadFileEsitiComuniCoinvestiti(inputDto, user);
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
			throw new NotFoundException("Not found file with id " + inputDto.getIdFile());
		}
		return bean;
	}
	
	//RU_1301
	 public GenericListBean<FileComuniCoinvestimentoOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String userId, String tipoProfilo)
	            throws BusinessLayerException {
	    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
	    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
				logger.info("checkPassValidationInputSearch NON SUPERATO*******");
				throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata Ordine");
	    	}

	        GenericListBean<FileComuniCoinvestimentoOutputBean> list = new GenericListBean<>();
	        ListaFileComuniCoinvestimentoWrapperOutputDTO result = null;
	        boolean isLimited;
	        try {
	            AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
	            result = comuniCoinvestitiRESTClient.advancedSearch(inputDto, userId, tipoProfilo);
	            isLimited = validateResponseResult(result);
	            list.setData(mapper.translateList(result.getListaFileComuniCoinvestiti(), FileComuniCoinvestimentoOutputBean.class));
	            list.setIsLimitedList(isLimited);
	        } catch (Exception e) {
	            throw new BusinessLayerException(e);
	        }
	        return list;
	    }
}
