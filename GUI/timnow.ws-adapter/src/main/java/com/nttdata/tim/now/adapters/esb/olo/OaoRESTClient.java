package com.nttdata.tim.now.adapters.esb.olo;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OaoRESTClient extends RestClientFacade {
	private static final String VALUE_QUERYPARAMETER_ID_CONTRATTO = "idContratto";

	@Value("${rest.controls.oao.verify.activation.contextpath}")
	private String serviceContextPath;

	@Value("${rest.controls.oao.verify.cessation.contextpath}")
	private String cessationServiceContextPath;

	@Value("${auth.rest.controls.oao.verify.activation.contextpath}")
	private String authserviceContextPath;
	
	@Value("${auth.rest.controls.oao.verify.cessation.contextpath}")
	private String authcessationServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public EsitoDTO checkActivationOao(String codOlo, String offer, String idContratto, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(serviceContextPath).path(codOlo).path(offer);
		if (idContratto != null) {
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_ID_CONTRATTO, idContratto);
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public EsitoDTO checkCessationOao(String codOlo, String idResource, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authcessationServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authcessationServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(cessationServiceContextPath).path(codOlo).path(idResource);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
