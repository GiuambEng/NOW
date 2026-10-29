package com.nttdata.tim.now.adapters.esb.localizzatore;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.locator.SystemLocatorInputDTO;
import com.nttdata.tim.now.data.dto.locator.SystemLocatorOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemLocatorRESTClient extends RestClientFacade {

	@Value("${rest.integration.locator.contextpath}")
	private String serviceContextPath;

	public SystemLocatorOutputDTO createSystemLocator(SystemLocatorInputDTO dtoInput) throws IntegrationLayerException {
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(dtoInput, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(SystemLocatorOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
