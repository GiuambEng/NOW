package com.nttdata.tim.now.adapters.esb.monitoraggio;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.GeneraNotificheInputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.ListaGeneraNotificheOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.ListaOloOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.ListaRichiesteOloOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.ListaTipologiaNotificheAtteseInputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.ListaTipologiaNotificheAtteseOutputDTO;
import com.nttdata.tim.now.data.dto.olo.encoding.CodificaOloDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NotificationGenerationRESTClient extends RestClientFacade {

	@Value("${rest.pps.notification.pending.contextpath}")
	private String pendingServiceContextPath;

	@Value("${rest.pps.notification.generation.contextpath}")
	private String generationServiceContextPath;

	@Value("${rest.pps.olo.list.contextpath}")
	private String oloListServiceContextPath;

	@Value("${rest.pps.olo.request.list.contextpath}")
	private String oloRequestListServiceContextPath;

	@Value("${auth.rest.pps.notification.pending.contextpath}")
	private String authpendingServiceContextPath;
	
	@Value("${auth.rest.pps.notification.generation.contextpath}")
	private String authgenerationServiceContextPath;
	
	@Value("${auth.rest.pps.olo.list.contextpath}")
	private String autholoListServiceContextPath;
	
	@Value("${auth.rest.pps.olo.request.list.contextpath}")
	private String autholoRequestListServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	
	public ListaTipologiaNotificheAtteseOutputDTO pendingNotification(ListaTipologiaNotificheAtteseInputDTO body,String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authpendingServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authpendingServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck

		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(pendingServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaTipologiaNotificheAtteseOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaGeneraNotificheOutputDTO notificationGeneration(GeneraNotificheInputDTO body, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authgenerationServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authgenerationServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(generationServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaGeneraNotificheOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaOloOutputDTO getOlos(String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(autholoListServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, autholoListServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(oloListServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaOloOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaRichiesteOloOutputDTO getOloRequests(CodificaOloDTO body, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(autholoRequestListServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, autholoRequestListServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(oloRequestListServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaRichiesteOloOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
