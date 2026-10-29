package com.nttdata.tim.now.adapters.esb.amministrazione;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.architd.GestioneArchiNumerazioniTDEditInputDTO;
import com.nttdata.tim.now.data.dto.architd.GestioneArchiNumerazioniTDWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ArchiTDRESTClient extends RestClientFacade {

	@Value("${rest.integration.gestionearchinumerazionitd.request.contextpath}")
	private String gestionearchinumerazionitdContextPath;

	@Value("${auth.rest.integration.gestionearchinumerazionitd.request.contextpath}")
	private String authgestionearchinumerazionitdContextPath;

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public GestioneArchiNumerazioniTDWrapperOutputDTO gestionearchinumerazionitd(String profilo) throws IntegrationLayerException {
       //call method for check authorization services 
		if ((StringUtils.isNotEmpty(authgestionearchinumerazionitdContextPath))&&(!isAuthorizedService(profilo, authgestionearchinumerazionitdContextPath, checkAuthorizationContextPath))){
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
		}
        // endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(gestionearchinumerazionitdContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(GestioneArchiNumerazioniTDWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public EsitoDTO update(GestioneArchiNumerazioniTDEditInputDTO inputDto, String profilo) throws IntegrationLayerException {
	       //call method for check authorization services 
			if ((StringUtils.isNotEmpty(authgestionearchinumerazionitdContextPath))&&(!isAuthorizedService(profilo, authgestionearchinumerazionitdContextPath, checkAuthorizationContextPath))){
				throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
			}
	        // endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(gestionearchinumerazionitdContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	
	public EsitoDTO insert(GestioneArchiNumerazioniTDEditInputDTO inputDto, String profilo) throws IntegrationLayerException {
	       //call method for check authorization services 
			if ((StringUtils.isNotEmpty(authgestionearchinumerazionitdContextPath))&&(!isAuthorizedService(profilo, authgestionearchinumerazionitdContextPath, checkAuthorizationContextPath))){
				throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
			}
	        // endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(gestionearchinumerazionitdContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
