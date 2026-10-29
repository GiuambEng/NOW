package com.nttdata.tim.now.adapters.esb.ambito;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.ambito.ListaAmbitiOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AmbitoRESTClient extends RestClientFacade {

	@Value("${rest.integration.ambiti.contextpat}")
	private String serviceContextPath;

	public ListaAmbitiOutputDTO getList() throws IntegrationLayerException {
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaAmbitiOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
