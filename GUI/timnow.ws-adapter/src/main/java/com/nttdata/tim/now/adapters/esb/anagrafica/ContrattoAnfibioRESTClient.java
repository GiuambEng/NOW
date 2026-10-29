package com.nttdata.tim.now.adapters.esb.anagrafica;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.contratto.ContrattoAnfibioOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ContrattoAnfibioRESTClient extends RestClientFacade {
	
    @Value("${rest.controls.verifica.contrattoanfibio.contextpath}")
	private String serviceContextPath;

    @Value("${auth.rest.controls.verifica.contrattoanfibio.contextpath}")
    private String authserviceContextPath;

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public ContrattoAnfibioOutputDTO getAnfibioContract(String idContratto, String tipoProfilo) throws IntegrationLayerException {
	       //call method for check authorization services 
			if ((StringUtils.isNotEmpty(authserviceContextPath))&&(!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))){
				throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
			}
	        // endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(serviceContextPath).path(idContratto);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ContrattoAnfibioOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
}
