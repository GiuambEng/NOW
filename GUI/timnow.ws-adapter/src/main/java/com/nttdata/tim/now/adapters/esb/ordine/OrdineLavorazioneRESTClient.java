package com.nttdata.tim.now.adapters.esb.ordine;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.ordine.lavorazione.OutputRecuperoTipologiaLavorazioneDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrdineLavorazioneRESTClient extends RestClientFacade {

    @Value("${rest.integration.ordine.lavorazione.search.contextpath}")
    private String serviceContextPath;

    @Value("${auth.rest.integration.ordine.lavorazione.search.contextpath}")
    private String authserviceContextPath;
    
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

    public OutputRecuperoTipologiaLavorazioneDTO getTipologiaLavorazione(String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath);
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(OutputRecuperoTipologiaLavorazioneDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

}
