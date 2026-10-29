package com.nttdata.tim.now.adapters.esb.anagrafica;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.anagraficamarcaggio.ListaAnagraficaMarcaggioComuneOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_963
@Component
public class MarcaggioComuneRESTClient extends RestClientFacade {
	
	@Value("${rest.amministrazione.marcaggio.comuni.pricing.contextpath}")
	private String serviceContextPath;
		
	@Value("${auth.rest.amministrazione.marcaggio.comuni.pricing.contextpath}")
	private String authserviceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;


	public ListaAnagraficaMarcaggioComuneOutputDTO advancedSearch(AdvancedResearchInputDTO body, String userId, String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).queryParam("userId", userId).queryParam("tipoProfilo", tipoProfilo);
		
		//WebTarget webTarget = guiIntegrationClient.client.target("https://10.172.68.81:8181").path(serviceContextPath).queryParam("userId", userId).queryParam("tipoProfilo", tipoProfilo);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaAnagraficaMarcaggioComuneOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
