package com.nttdata.tim.now.adapters.esb.utente;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.utente.UserWrapperDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UtenteRESTClient extends RestClientFacade {

	@Value("${rest.integration.user.contextpath}")
	private String serviceContextPath;

	public UserWrapperDTO getUserDetail(String uid) throws IntegrationLayerException {
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(uid);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(UserWrapperDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
