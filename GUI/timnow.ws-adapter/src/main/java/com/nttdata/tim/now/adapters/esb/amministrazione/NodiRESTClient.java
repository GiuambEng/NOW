package com.nttdata.tim.now.adapters.esb.amministrazione;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.nodi.ListaNodiOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1058
@Component
public class NodiRESTClient extends RestClientFacade {
	
	@Value("${rest.integration.nodi.contextpath}")
	private String serviceContextPath;
		
	public ListaNodiOutputDTO getList() throws IntegrationLayerException {
		
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath);
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaNodiOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
