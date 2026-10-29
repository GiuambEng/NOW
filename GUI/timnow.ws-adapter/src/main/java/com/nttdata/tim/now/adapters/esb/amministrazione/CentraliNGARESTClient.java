package com.nttdata.tim.now.adapters.esb.amministrazione;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.centralinga.ListaCentraliNGAOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1058
@Component
public class CentraliNGARESTClient extends RestClientFacade {
	
	@Value("${rest.integration.centrali.nga.contextpath}")
	private String serviceContextPath;
		
	public ListaCentraliNGAOutputDTO getList() throws IntegrationLayerException {
		
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath);
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaCentraliNGAOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
