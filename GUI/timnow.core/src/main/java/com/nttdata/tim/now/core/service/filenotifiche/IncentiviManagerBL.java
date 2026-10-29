package com.nttdata.tim.now.core.service.filenotifiche;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.filenotifiche.IncentiviRESTClient;
import com.nttdata.tim.now.core.exception.AccessDeniedException;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.InvalidFilenameException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.bean.notifica.DettaglioFileIncentiviOutputBean;
import com.nttdata.tim.now.data.bean.notifica.FileIncentiviOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.file.FileToUploadDTO;
import com.nttdata.tim.now.data.dto.notifica.DettaglioFileIncentiviOutputDTO;
import com.nttdata.tim.now.data.dto.notifica.FileIncentiviWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.enumeration.BackEndResultCode;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//RU_1127
@Service
public class IncentiviManagerBL extends AbstractBL {

	@Value("${filename.decommissioning.pattern}")
	private String filenameDecommissioningPattern;

	//RU_1312
	@Value("${filename.switchoff.operatore.pattern}")
	private String filenameSwitchoffOperatorePattern;

	@Value("${filename.switchoff.old_incentivi.pattern}")
	private String filenameSwitchoffOldIncentiviPattern;

	@Value("${filename.switchoff.new_incentivi.pattern}")
	private String filenameSwitchoffNewIncentiviPattern;

	@Value("${filename.switchoff.incentivi.pattern}")
	private String filenameSwitchoffIncentiviPattern;


	@Autowired
	private IncentiviRESTClient incentiviRestIL;

	//SM_10035
	public GenericListBean<FileIncentiviOutputBean> getAllDecommissioningFiles(String codOloAgcom, String tipoProfilo)
			throws BusinessLayerException {
		GenericListBean<FileIncentiviOutputBean> list = new GenericListBean<>();
		boolean isLimited;
		try {
			FileIncentiviWrapperOutputDTO dto = incentiviRestIL.getAllDecommissioningFiles(codOloAgcom, tipoProfilo);
			isLimited = validateResponseResult(dto);
			if (dto != null && dto.getListaFileIncentivi() != null) {
				list.setData(mapper.translateList(dto.getListaFileIncentivi(), FileIncentiviOutputBean.class));
				list.setIsLimitedList(isLimited);
			}
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public void upload(FileScaricatoBean uploadedFile, String oloAgcomCode, String tipoProfilo) throws BusinessLayerException, AccessDeniedException {
		ESBResultDTO result;
		try {
			validateFileName(uploadedFile.getName(), oloAgcomCode);
			validateDateInFileName(uploadedFile.getName());
			FileToUploadDTO fileDTO = new FileToUploadDTO();			
			fileDTO.setCodagcom(oloAgcomCode);
			fileDTO.setNomefile(normalizeExtension(uploadedFile.getName()));
			fileDTO.setContenutofile(uploadedFile.getFileData());
			result = incentiviRestIL.upload(fileDTO, tipoProfilo);
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

	public GenericListBean<FileIncentiviOutputBean> advancedResearch(RicercaAvanzataInputBean body, String codOloAgcom, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<FileIncentiviOutputBean> bean = new GenericListBean<>();
		boolean isLimited;
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(body, AdvancedResearchInputDTO.class);
			FileIncentiviWrapperOutputDTO dto = incentiviRestIL.advancedResearch(inputDto, codOloAgcom, tipoProfilo);
			isLimited = validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getListaFileIncentivi(), FileIncentiviOutputBean.class));
			bean.setIsLimitedList(isLimited);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	//RU_1312
	public DettaglioFileIncentiviOutputBean getDecommissioningFileDetails(String idFile, String tipologiaFile, String tipoProfilo)
			throws BusinessLayerException {
		DettaglioFileIncentiviOutputBean bean = new DettaglioFileIncentiviOutputBean();
		try {
			DettaglioFileIncentiviOutputDTO dto = incentiviRestIL.getDecommissioningFileDetails(idFile, tipologiaFile, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, DettaglioFileIncentiviOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}


	private void validateFileName(String name, String codOloAgcom) throws InvalidFilenameException {

		String patternOloAgcom = "_"+ codOloAgcom +"_";

		//Bug #36462
		Matcher matcherFileDecommissioning = Pattern.compile(filenameDecommissioningPattern).matcher(name);

		//RU_1312
		Matcher matcherFileSwitchoffOperatore = Pattern.compile(filenameSwitchoffOperatorePattern).matcher(name);

		if (!matcherFileDecommissioning.matches() && !matcherFileSwitchoffOperatore.matches()) {
			throw new InvalidFilenameException("Il nome " + name + " non rispetta la naming convention condivisa");
		} 

		if((matcherFileDecommissioning.matches() || matcherFileSwitchoffOperatore.matches()) && !name.toUpperCase().contains(patternOloAgcom.toUpperCase())) {
			throw new InvalidFilenameException("L'Olo " + codOloAgcom + " selezionato non corrisponde a quello del file");
		}
	}

	private void validateDateInFileName(String name) throws InvalidFilenameException {

		Matcher matcherFileDecommissioning = Pattern.compile(filenameDecommissioningPattern).matcher(name);
		Matcher matcherFileSwitchoffOperatore = Pattern.compile(filenameSwitchoffOperatorePattern).matcher(name);

		Pattern _datePattern = null;
		Matcher _dateMatcher = null;
		String _extractedDate = null;
		DateFormat _dateFormat = null;

		if (matcherFileDecommissioning.matches()) {

			_datePattern = Pattern.compile("\\d{2}\\d{2}\\d{4}");
			_dateFormat = new SimpleDateFormat("ddMMyyyy");

		}else if(matcherFileSwitchoffOperatore.matches()) {
			_datePattern = Pattern.compile("\\d{2}\\d{4}");
			_dateFormat = new SimpleDateFormat("MMyyyy");
		}

		_dateMatcher = _datePattern.matcher(name);
		while (_dateMatcher.find()) {
			_extractedDate = _dateMatcher.group();
		}

		if(_extractedDate == null || _extractedDate.isEmpty()) {
			throw new InvalidFilenameException("Il file " + name + " selezionato non contiene una data valida");
		}

		_dateFormat.setLenient(false);
		try {
			_dateFormat.parse(_extractedDate); 
		} catch (ParseException e) {
			throw new InvalidFilenameException("Il file " + name + " selezionato non contiene una data valida");
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
