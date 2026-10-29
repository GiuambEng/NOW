package com.nttdata.tim.now.adapters.rest;

import java.util.Date;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.esb.utente.TrackAccessRESTClient;
import com.nttdata.tim.now.adapters.rest.client.GuiControlsClient;
import com.nttdata.tim.now.adapters.rest.client.GuiHightSecRestClient;
import com.nttdata.tim.now.adapters.rest.client.GuiIntegrationRestClient;
import com.nttdata.tim.now.adapters.rest.client.GuiOrderRestClient;
import com.nttdata.tim.now.adapters.rest.client.GuiPpsRestClient;
import com.nttdata.tim.now.data.bean.track.TrackBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.base.ESBAUTHResultDTO;
import com.nttdata.tim.now.data.dto.file.FileWrapperDTO;
import com.nttdata.tim.now.data.dto.track.TrackDTO;
import com.nttdata.tim.now.data.enumeration.TrackingEvent;
import com.nttdata.tim.now.data.enumeration.TrackingEventResult;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;
import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.util.data.DozerHelper;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class RestClientFacade {

	private static final String VALUE_QUERYPARAMETER_PROFILO = "codProfilo";
	private static final String VALUE_QUERYPARAMETER_SERVIZIO = "areaFunzione";

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected GuiIntegrationRestClient guiIntegrationClient;

	@Autowired
	protected GuiPpsRestClient guiPpsRestClient;

	@Autowired
	protected GuiOrderRestClient guiOrderRestClient;

	@Autowired
	protected GuiControlsClient guiControlsRestClient;
	
	//RU_1233
	@Autowired
	protected GuiHightSecRestClient guiHigthSecRestClient;

	//RU_902
	@Autowired
	protected DozerHelper mapper;

	@Autowired
	protected TrackAccessRESTClient trackAccessRestClient;

	public boolean checkStatus(Response response) throws IntegrationLayerException {
		if (response == null) {
			throw new IntegrationLayerException("Wrong response received from BE: response structure not found in json");
		} else if (response.getStatus() != 200 && response.getStatus() != 201) {
			String path = response.getLocation() != null ? response.getLocation().getPath() : "";
			throw new IntegrationLayerException("KO from the service " + path + " status:" + response.getStatus());
		}
		return true;
	}

	protected boolean isAuthorizedService(String profilo, String services, String serviceContextPath) throws IntegrationLayerException {
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath);
		try {
			logger.debug("Profilo= "+profilo+" | services= "+services);
			if (profilo!=null){
				webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_PROFILO, profilo);
			}
			if (services!=null){
				webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_SERVIZIO, services);
			}

			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			ESBAUTHResultDTO result = response.readEntity(ESBAUTHResultDTO.class);
			if (checkStatus(response)&&("OK".equals(result.getEsito().getCodice()))) {
				return true;
			}else return false;
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	//--- Inizio RU_902 ---    
	public boolean checkStatusLite(Response response) {
		return (response != null && (response.getStatus() == 200 || response.getStatus() == 201));
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

	protected TrackDTO buildRequestTrackRestService(UserBean user, TrackingEvent event, String vista, FileWrapperDTO fileWrapperDTO, Response response) {
		TrackBean trackBean = getTrackBean(user);
		trackBean.setTimestampInizio(new Date());
		trackBean.setTipoOperazione(event.getCode());
		trackBean.setDescrizioneFunzione(vista);
		trackBean.setTimestampFine(new Date());		

		//CR01-CR04
		if(checkStatusLite(response) && fileWrapperDTO.getFile() != null) {
			trackBean.setEsito(TrackingEventResult.OK.getDescription());
			trackBean.setContenutoFile(fileWrapperDTO.getFile().getContenutoFile());
			trackBean.setNomeFile(fileWrapperDTO.getFile().getNomeFile());
		}else {
			trackBean.setEsito(TrackingEventResult.KO.getDescription());
		}			
		TrackDTO trackDto = mapper.translate(trackBean, TrackDTO.class);
		return trackDto;
	}
	
	//--- Fine RU_902 ---  
	
	/**
	 * Verifica se utente corrente abilitato al servizio richiesto
	 * @param servicePath
	 * @param authorizationPath
	 * @param tipoProfilo
	 * @throws IntegrationLayerException
	 */
	protected void checkAuthorizationService(String servicePath, String authorizationPath, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(servicePath))
				&& (!isAuthorizedService(tipoProfilo, servicePath,
						authorizationPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
	}
}
