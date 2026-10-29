package com.nttdata.tim.now.adapters.esb.ordine;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.referente.ReferenteContattatoWrapperOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReferenteContattatoRESTClient extends RestClientFacade {

    @Value("${rest.order.contactedReferents.contextpath}")
    private String serviceContextPath;

    @Value("${auth.rest.order.contactedReferents.contextpath}")
    private String authserviceContextPath;
    
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

    public ReferenteContattatoWrapperOutputDTO getContactedReferents(String orderOLOCode, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).path(orderOLOCode);
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(ReferenteContattatoWrapperOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }
}
