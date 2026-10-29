package com.nttdata.tim.now.core.service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nttdata.tim.now.core.exception.InvalidFilenameException;
import com.nttdata.tim.now.data.bean.ricerca.ConditionBean;
import com.nttdata.tim.now.data.bean.track.TrackBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.base.ResultDTO;
import com.nttdata.tim.now.data.dto.monitoring.rimodulazionedac.MonitoraggioRimodulazioniDACOutputWrapperDTO;
import com.nttdata.tim.now.data.dto.track.TrackDTO;
import com.nttdata.tim.now.data.enumeration.TrackingEvent;
import com.nttdata.tim.now.data.enumeration.TrackingEventResult;
import com.nttdata.tim.now.data.exception.BackEndException;
import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.util.data.DozerHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBL {

    private static final String LIMIT = "LIMIT";
	private static final String INFO = "INFO";
	private static final String DUPLICATEFILE = "DUPLICATEFILE";

	protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected DozerHelper mapper;

    protected boolean validateResponseResult(ESBResultDTO esbResult) throws BackEndException,InvalidFilenameException {
        if (esbResult == null) {
            logger.debug("Bad response from BE: result not present");
            throw new BackEndException("Wrong message from BE: 'result' is missing");
        }
        ResultDTO result = esbResult.getResult();
        if (!INFO.equalsIgnoreCase(result.getSeverity())) {
        	if (result.getCode()!=null && DUPLICATEFILE.equals(result.getCode())){
                logger.debug("Duplicate file name - file yet update");
        		throw new InvalidFilenameException(result.getDetails());
        	}
            logger.debug("KO message from BE");
            throw new BackEndException("Error message received from BE: " + result.getDetails());
        } 
        return LIMIT.equalsIgnoreCase(result.getCode());
    }
    
	protected boolean checkPassValidationInputSearch(List<ConditionBean> conditions, Pattern pattern) {
		logger.debug("******************Pattern regex= "+ pattern.toString());
		if (conditions!=null && !conditions.isEmpty()){
			for (int i=0; i< conditions.size(); i++){
				 Matcher matcher = pattern.matcher(conditions.get(i).getValore());
			     if  (matcher.matches()) return true;				
			}
		}
		return false;
	}
	
	//--- Inizio SM_8906 ---
	public boolean checkStatusLite(MonitoraggioRimodulazioniDACOutputWrapperDTO dto) {
		return (dto.getMonitoraggioRimodulazioniDAC() != null && dto.getMonitoraggioRimodulazioniDAC().getExportData() != null);
	}

	protected TrackBean getTrackBean(UserBean user) {    	
		TrackBean trackBean = null;    	
		try {
			trackBean = mapper.translate(user.getRequestInfo(), TrackBean.class);
			trackBean.setApplicazioneClient(Constants.APPLICATION_NAME);
			trackBean.setParametriOperazione("");
			trackBean.setUserId(user.getUserId());
			trackBean.setDescrizioneProfilo(user.getCodiceProfilo());
		} catch (Exception e) {
			logger.error("Errore durante il tracciamento evento", e);
		}
		return trackBean;
	}
	
	protected TrackDTO buildRequestTrackRestService(UserBean user, TrackingEvent event, String vista, MonitoraggioRimodulazioniDACOutputWrapperDTO monitoraggioRimodulazioniDACOutputWrapperDTO) {
		TrackBean trackBean = getTrackBean(user);
		trackBean.setTimestampInizio(new Date());
		trackBean.setTipoOperazione(event.getCode());
		trackBean.setDescrizioneFunzione(vista);
		trackBean.setTimestampFine(new Date());		

		if(checkStatusLite(monitoraggioRimodulazioniDACOutputWrapperDTO)) {
			trackBean.setEsito(TrackingEventResult.OK.getDescription());
			trackBean.setContenutoFile(monitoraggioRimodulazioniDACOutputWrapperDTO.getMonitoraggioRimodulazioniDAC().getExportData());
			trackBean.setNomeFile(monitoraggioRimodulazioniDACOutputWrapperDTO.getMonitoraggioRimodulazioniDAC().getNomeFileToExport());
		}else {
			trackBean.setEsito(TrackingEventResult.KO.getDescription());
		}			
		TrackDTO trackDto = mapper.translate(trackBean, TrackDTO.class);
		return trackDto;
	}
	//--- Fine SM_8906 ---


}
