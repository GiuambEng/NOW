package com.nttdata.tim.now.adapters.esb.filenotifiche;

import java.net.URLEncoder;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.notifica.ListaFileNotificheOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NotificaRESTClient extends RestClientFacade {

	@Value("${rest.integration.notification.contextpath}")
	private String serviceContextPath;

	@Value("${rest.integration.notifications.contextpath}")
	private String allServiceContextPath;

	@Value("${auth.rest.integration.notification.contextpath}")
	private String authserviceContextPath;
	
	@Value("${auth.rest.integration.notifications.contextpath}")
	private String authallServiceContextPath;

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	private static final String VALUE_QUERYPARAMETER_USERID = "userId";
	
	//RU_844
	private static final String VALUE_QUERYPARAMETER_TIPOPROFILO = "tipoProfilo"; //RU_844
	
	public ListaFileNotificheOutputDTO getNotifications(String orderCode, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		//RU_844
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(orderCode).queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaFileNotificheOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaFileNotificheOutputDTO getAllNotificationFiles(String codOloAgcom, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authallServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authallServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(allServiceContextPath).path(codOloAgcom).path(tipoProfilo);
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, URLEncoder.encode(userId, "UTF-8").replaceAll("\\+","%20"));
			}
			return webTarget.request(MediaType.APPLICATION_JSON_TYPE).get(ListaFileNotificheOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaFileNotificheOutputDTO fileDiNotificheAdvanceResearch(AdvancedResearchInputDTO inputDto, String codOloAgcom, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authallServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authallServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(allServiceContextPath).path(codOloAgcom).path(tipoProfilo);
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, URLEncoder.encode(userId, "UTF-8").replaceAll("\\+","%20"));
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaFileNotificheOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
