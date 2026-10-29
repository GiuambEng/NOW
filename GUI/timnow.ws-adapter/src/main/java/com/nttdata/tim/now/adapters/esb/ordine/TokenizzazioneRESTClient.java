package com.nttdata.tim.now.adapters.esb.ordine;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.TokenizzazioneReferentiInputDTO;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.TokenizzazioneReferentiWrapperOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1084
@Component
public class TokenizzazioneRESTClient extends RestClientFacade {
    
	@Value("${rest.order.tokenizzazione.referenti.contextpath}")
	private String tokenizzazioneReferentiContextPath;

	public TokenizzazioneReferentiWrapperOutputDTO tokenizzazioneReferenti(TokenizzazioneReferentiInputDTO inputDTO) throws IntegrationLayerException {
	    
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(tokenizzazioneReferentiContextPath);		
		try {
	        Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDTO, MediaType.APPLICATION_JSON_TYPE));			
			return response.readEntity(TokenizzazioneReferentiWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
