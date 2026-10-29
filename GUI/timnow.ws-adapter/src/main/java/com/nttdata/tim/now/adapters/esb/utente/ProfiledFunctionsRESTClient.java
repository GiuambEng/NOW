package com.nttdata.tim.now.adapters.esb.utente;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.profiledfunctions.ProfiledFunctionsListDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProfiledFunctionsRESTClient extends RestClientFacade {
	
	@Value("${rest.integration.profiledfunctions.contextpath}")
	private String serviceContextPath;

	public ProfiledFunctionsListDTO getMapping() throws IntegrationLayerException {
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ProfiledFunctionsListDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
