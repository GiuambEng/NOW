package com.nttdata.tim.now.adapters.esb.utente;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;
import com.nttdata.tim.now.data.dto.track.TrackDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TrackAccessRESTClient extends RestClientFacade {

	@Value("${rest.integration.track.contextpath}")
	private String serviceContextPath;

	public EsitoDTO trackAccess(TrackDTO body) throws IntegrationLayerException {
		
		//final RestClientConfiguration testConfig = guiIntegrationClient.getRestClientConfiguration();
		//WebTarget webTarget = guiIntegrationClient.getClient(testConfig).target("https://vt-masulloil:8181").path("/loggerservice");
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
