package com.nttdata.tim.now.adapters.esb.amministrazione;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.faq.FaqDTO;
import com.nttdata.tim.now.data.dto.faq.ListaFaqDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FaqRESTClient extends RestClientFacade {

	@Value("${rest.integration.faq.get.contextpath}")
	private String getServiceContextPath;

	@Value("${rest.integration.faq.post.contextpath}")
	private String postServiceContextPath;

	@Value("${rest.integration.faq.put.contextpath}")
	private String putServiceContextPath;

	@Value("${rest.integration.faq.delete.contextpath}")
	private String deleteServiceContextPath;

	@Value("${auth.rest.integration.faq.get.contextpath}")
	private String authgetServiceContextPath;
	
	@Value("${auth.rest.integration.faq.post.contextpath}")
	private String authpostServiceContextPath;
	
	@Value("${auth.rest.integration.faq.put.contextpath}")
	private String authputServiceContextPath;
	
	@Value("${auth.rest.integration.faq.delete.contextpath}")
	private String authdeleteServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;


	public ListaFaqDTO getFaq(String tipoProfilo) throws IntegrationLayerException {
	       //call method for check authorization services 
			if ((StringUtils.isNotEmpty(authgetServiceContextPath))&&(!isAuthorizedService(tipoProfilo, authgetServiceContextPath, checkAuthorizationContextPath))){
				throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
			}
	        // endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(getServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaFaqDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaFaqDTO createFaq(FaqDTO dtoInput, String profilo) throws IntegrationLayerException {
	       //call method for check authorization services 
			if ((StringUtils.isNotEmpty(authpostServiceContextPath))&&(!isAuthorizedService(profilo, authpostServiceContextPath, checkAuthorizationContextPath))){
				throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
			}
	        // endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(postServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(dtoInput, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaFaqDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaFaqDTO updateFaq(FaqDTO dtoInput, String profilo) throws IntegrationLayerException {
		//change from put to post for RU_532
	       //call method for check authorization services 
			if ((StringUtils.isNotEmpty(authputServiceContextPath))&&(!isAuthorizedService(profilo, authputServiceContextPath, checkAuthorizationContextPath))){
				throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
			}
	        // endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(putServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(dtoInput, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaFaqDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaFaqDTO deleteFaq(String idfaq, String profilo) throws IntegrationLayerException {
		//change from delete to get for RU_532
	       //call method for check authorization services 
			if ((StringUtils.isNotEmpty(authdeleteServiceContextPath))&&(!isAuthorizedService(profilo, authdeleteServiceContextPath, checkAuthorizationContextPath))){
				throw  new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
			}
	        // endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(deleteServiceContextPath).path(idfaq);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaFaqDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
