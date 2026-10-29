package com.nttdata.tim.now.adapters.esb.monitoraggio;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.codice.ListaCodiceOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.rigenerazionemail.ListaNotificheMonitoraggioRigenerazioneMailOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.rigenerazionemail.ListaRichiesteMonitoraggioRigenerazioneMailOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.rigenerazionemail.RinvioNotificheMonitoraggioRigenerazioneMailListInputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MonitoraggioRigenerazioneMailRESTClient extends RestClientFacade {

	@Value("${rest.pps.monitoring.rigenerazionemail.contextpath}")
	private String serviceContextPath;

	@Value("${rest.pps.monitoring.rigenerazionemail.send.contextpath}")
	private String sendContextPath;
	
	@Value("${auth.rest.pps.monitoring.rigenerazionemail.contextpath}")
	private String authserviceContextPath;
	
	@Value("${auth.rest.pps.monitoring.rigenerazionemail.send.contextpath}")
	private String authsendContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	private static final String VALUE_QUERYPARAMETER_USERID = "userId";
	private static final String VALUE_QUERYPARAMETER_TIPOPROFILO = "tipoProfilo";


	public ListaRichiesteMonitoraggioRigenerazioneMailOutputDTO advancedSearch(AdvancedResearchInputDTO body, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(serviceContextPath);
			if (tipoProfilo!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			}
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaRichiesteMonitoraggioRigenerazioneMailOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	
	public ListaNotificheMonitoraggioRigenerazioneMailOutputDTO getListaNotifiche(String idRichiestaOlo, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(serviceContextPath);
			webTarget = webTarget.queryParam("idRichiestaOlo", idRichiestaOlo);
			if (tipoProfilo!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			}
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaNotificheMonitoraggioRigenerazioneMailOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}


	public ListaCodiceOutputDTO invioNotifiche(RinvioNotificheMonitoraggioRigenerazioneMailListInputDTO inputDto, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authsendContextPath))
				&& (!isAuthorizedService(tipoProfilo, authsendContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(sendContextPath);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaCodiceOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
