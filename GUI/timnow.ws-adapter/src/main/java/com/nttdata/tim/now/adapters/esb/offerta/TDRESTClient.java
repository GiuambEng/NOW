package com.nttdata.tim.now.adapters.esb.offerta;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.td.ListaCodiciTdOutputDTO;
import com.nttdata.tim.now.data.dto.td.TdCodeInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TDRESTClient extends RestClientFacade {

	@Value("${rest.order.td.contextpath}")
	private String serviceContextPath;

	@Value("${auth.rest.order.td.contextpath}")
	private String authserviceContextPath;

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public ListaCodiciTdOutputDTO getTdCodes(String codificaOloAgcom, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		TdCodeInputDTO dtoInput = new TdCodeInputDTO();
		dtoInput.setCodcfOloAgcom(codificaOloAgcom);
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(dtoInput, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaCodiciTdOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
