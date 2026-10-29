package com.nttdata.tim.now.adapters.esb.filenotifiche;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.dto.semaforo.ListaSemaforiOutputDTO;
import com.nttdata.tim.now.data.dto.semaforo.RisottomissioneOutputWrapperDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SemaforoRESTClient extends RestClientFacade {

	@Value("${rest.integration.order_request.filestate.contextpath}")
	private String serviceContextPath;

	@Value("${rest.integration.risottomissionefileinelaborazione.request.contextpath}")
	private String risottomissioneServiceContextPath;

	@Value("${auth.rest.integration.order_request.filestate.contextpath}")
	private String authserviceContextPath;

	@Value("${auth.rest.integration.risottomissionefileinelaborazione.request.contextpath}")
	private String authrisottomissioneServiceContextPath;

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	private static final String VALUE_QUERYPARAMETER_USERID = "userId";
	private static final String ID_FILE = "idFile";

	public ListaSemaforiOutputDTO getOrderRequestFileState(String codoloagcom, String tipoProfilo, String userId)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(codoloagcom)
					.path(tipoProfilo);
			if (userId != null) {
				webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaSemaforiOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaSemaforiOutputDTO advancedSearch(AdvancedResearchInputDTO body, String codOloAgcom, String tipoProfilo,
			String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(codOloAgcom)
					.path(tipoProfilo);
			if (userId != null) {
				webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaSemaforiOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public RisottomissioneOutputWrapperDTO risottomissione(String idFile, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authrisottomissioneServiceContextPath)) && (!isAuthorizedService(tipoProfilo,
				authrisottomissioneServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(risottomissioneServiceContextPath).queryParam(ID_FILE, idFile); //path(idFile); SM_7978
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RisottomissioneOutputWrapperDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
