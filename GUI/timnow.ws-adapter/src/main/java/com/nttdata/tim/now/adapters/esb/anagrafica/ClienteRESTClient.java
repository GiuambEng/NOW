package com.nttdata.tim.now.adapters.esb.anagrafica;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.cliente.ListaClienteOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClienteRESTClient extends RestClientFacade {

	@Value("${rest.integration.customer.contextpath}")
	private String serviceContextPath;

	@Value("${auth.rest.integration.customer.contextpath}")
	private String authserviceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	private static final String VALUE_QUERYPARAMETER_USERID = "userId";

	public ListaClienteOutputDTO getCustomers(String codOloAgcom, String tipoProfilo, String userId) throws IntegrationLayerException {
	       //call method for check authorization services 
			if ((StringUtils.isNotEmpty(authserviceContextPath))&&(!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))){
				throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
			}
	        // endCheck
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(codOloAgcom).path(tipoProfilo);
			if (userId!=null & !userId.isEmpty()) {
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaClienteOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaClienteOutputDTO advancedSearch(AdvancedResearchInputDTO body, String codOloAgcom, String tipoProfilo, String userId) throws IntegrationLayerException {
	       //call method for check authorization services 
			if ((StringUtils.isNotEmpty(authserviceContextPath))&&(!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))){
				throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
			}
	        // endCheck
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(codOloAgcom).path(tipoProfilo);
			if (userId!=null & !userId.isEmpty()) {
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaClienteOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
