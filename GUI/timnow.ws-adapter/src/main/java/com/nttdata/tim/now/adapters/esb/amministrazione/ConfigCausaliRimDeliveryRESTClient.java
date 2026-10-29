package com.nttdata.tim.now.adapters.esb.amministrazione;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.configcausali.ListaConfigCausaliRimDeliveryOutputDTO;
import com.nttdata.tim.now.data.dto.configcausali.ListaModificaConfigCausaliRimDeliveryInputDTO;
import com.nttdata.tim.now.data.dto.configcausali.ListaModificaConfigCausaliRimDeliveryOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigCausaliRimDeliveryRESTClient extends RestClientFacade {

	@Value("${rest.pps.administration.configcausalirimdelivery.lista.contextpath}")
	private String getListaConfigCusaliRimDeliveryContextPath;

	@Value("${rest.pps.administration.configcausalirimdelivery.modifica.contextpath}")
	private String modifyConfigCusaliRimDeliveryContextPath;

	@Value("${rest.pps.administration.configcausalirimdelivery.delete.contextpath}")
	private String deleteConfigCusaliRimDeliveryContextPath;

	@Value("${auth.rest.pps.administration.configcausalirimdelivery.lista.contextpath}")
	private String authgetListaConfigCusaliRimDeliveryContextPath;
	
	@Value("${auth.rest.pps.administration.configcausalirimdelivery.modifica.contextpath}")
	private String authmodifyConfigCusaliRimDeliveryContextPath;
	
	@Value("${auth.rest.pps.administration.configcausalirimdelivery.delete.contextpath}")
	private String authdeleteConfigCusaliRimDeliveryContextPath;

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public ListaConfigCausaliRimDeliveryOutputDTO getLista(String flagEsplicita, String profilo) throws IntegrationLayerException {
	       //call method for check authorization services 
			if ((StringUtils.isNotEmpty(authgetListaConfigCusaliRimDeliveryContextPath))&&(!isAuthorizedService(profilo, authgetListaConfigCusaliRimDeliveryContextPath, checkAuthorizationContextPath))){
				throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
			}
	        // endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(getListaConfigCusaliRimDeliveryContextPath).path(flagEsplicita);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaConfigCausaliRimDeliveryOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaModificaConfigCausaliRimDeliveryOutputDTO modificaLista(ListaModificaConfigCausaliRimDeliveryInputDTO dtoInput, String profilo) throws IntegrationLayerException {
	       //call method for check authorization services 
			if ((StringUtils.isNotEmpty(authmodifyConfigCusaliRimDeliveryContextPath))&&(!isAuthorizedService(profilo, authmodifyConfigCusaliRimDeliveryContextPath, checkAuthorizationContextPath))){
				throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
			}
	        // endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(modifyConfigCusaliRimDeliveryContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(dtoInput, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaModificaConfigCausaliRimDeliveryOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaModificaConfigCausaliRimDeliveryOutputDTO deleteLista(ListaModificaConfigCausaliRimDeliveryInputDTO dtoInput, String profilo) throws IntegrationLayerException {
	       //call method for check authorization services 
			if ((StringUtils.isNotEmpty(authdeleteConfigCusaliRimDeliveryContextPath))&&(!isAuthorizedService(profilo, authdeleteConfigCusaliRimDeliveryContextPath, checkAuthorizationContextPath))){
				throw  new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
			}
	        // endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(deleteConfigCusaliRimDeliveryContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(dtoInput, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaModificaConfigCausaliRimDeliveryOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
