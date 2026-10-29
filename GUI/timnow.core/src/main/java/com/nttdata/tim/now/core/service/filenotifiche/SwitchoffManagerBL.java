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
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.file.FileToUploadDTO;
import com.nttdata.tim.now.data.enumeration.BackEndResultCode;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SwitchoffManagerBL extends AbstractBL {

	@Value("${filename.switchoff.old_incentivi.pattern}")
	private String filenameSwitchoffOldIncentiviPattern;

	@Value("${filename.switchoff.new_incentivi.pattern}")
	private String filenameSwitchoffNewIncentiviPattern;

	@Value("${filename.switchoff.incentivi.pattern}")
	private String filenameSwitchoffIncentiviPattern;

	@Autowired
	private IncentiviRESTClient incentiviRestIL;

	public void upload(FileScaricatoBean uploadedFile, String tipoProfilo) throws BusinessLayerException, AccessDeniedException {
		ESBResultDTO result;
		try {
			validateFileName(uploadedFile.getName());
			validateDateInFileName(uploadedFile.getName());
			FileToUploadDTO fileDTO = new FileToUploadDTO();	
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

	private void validateFileName(String name) throws InvalidFilenameException {
		
		Matcher matcherFileSwitchoffOldIncentivi = Pattern.compile(filenameSwitchoffOldIncentiviPattern).matcher(name);
		Matcher matcherFileSwitchoffNewIncentivi = Pattern.compile(filenameSwitchoffNewIncentiviPattern).matcher(name);
		Matcher matcherFileSwitchoffIncentivi = Pattern.compile(filenameSwitchoffIncentiviPattern).matcher(name);

		if (!matcherFileSwitchoffOldIncentivi.matches() &&
			!matcherFileSwitchoffNewIncentivi.matches() &&
			!matcherFileSwitchoffIncentivi.matches()) {
			throw new InvalidFilenameException("Il nome " + name + " non rispetta la naming convention condivisa");
		} 
	}

	private void validateDateInFileName(String name) throws InvalidFilenameException {

		Pattern _datePattern = Pattern.compile("\\d{2}\\d{2}\\d{4}");
		DateFormat _dateFormat = new SimpleDateFormat("ddMMyyyy");
		Matcher _dateMatcher = null;
		String _extractedDate = null;
		
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
