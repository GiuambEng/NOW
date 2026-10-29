package com.nttdata.tim.now.adapters.esb.ordine;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.anagraficaidullco.AnagraficaIdullcoListOutputDTO;
import com.nttdata.tim.now.data.dto.idullco.ListaIdullcoOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IdullcoRESTClient extends RestClientFacade {

    @Value("${rest.order.idullco.contextpath}")
    private String serviceContextPath;

    @Value("${rest.integration.idullco.anagrafica.contextpath}")
    private String anagraficaIdullcoServiceContextPath;

    @Value("${auth.rest.order.idullco.contextpath}")
    private String authserviceContextPath;
    
    @Value("${auth.rest.integration.idullco.anagrafica.contextpath}")
    private String authanagraficaIdullcoServiceContextPath;
    
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

    public ListaIdullcoOutputDTO getIdullcos(String codiceAgcom, String valoreRicerca, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).path(codiceAgcom).queryParam("valoreRicerca", valoreRicerca);
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(ListaIdullcoOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

	public AnagraficaIdullcoListOutputDTO advancedSearch(AdvancedResearchInputDTO body, String codOloAgcom, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authanagraficaIdullcoServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authanagraficaIdullcoServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(anagraficaIdullcoServiceContextPath).path(tipoProfilo).path(codOloAgcom);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(AnagraficaIdullcoListOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
