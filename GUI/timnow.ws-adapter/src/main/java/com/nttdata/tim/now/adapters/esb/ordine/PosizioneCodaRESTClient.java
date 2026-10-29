package com.nttdata.tim.now.adapters.esb.ordine;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.posizionecoda.PosizioneCodaOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PosizioneCodaRESTClient extends RestClientFacade {

    @Value("${rest.order.position.contextpath}")
    private String serviceContextPath;

    @Value("${auth.rest.order.position.contextpath}")
    private String authserviceContextPath;
    
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	private static final String ID_RISORSA = "idRisorsa";

   public PosizioneCodaOutputDTO getQueuePosition(String idRisorsa, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		
		//RU_1233
		//RU_1303
        //WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).queryParam(ID_RISORSA, idRisorsa); //.path(idRichiesta);
		WebTarget webTarget = guiHigthSecRestClient.getBaseTarget().path(serviceContextPath).queryParam(ID_RISORSA, idRisorsa);
		
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(PosizioneCodaOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

}
