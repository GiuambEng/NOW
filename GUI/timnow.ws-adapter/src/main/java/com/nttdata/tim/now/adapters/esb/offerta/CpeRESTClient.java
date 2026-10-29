package com.nttdata.tim.now.adapters.esb.offerta;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.cpe.CpeWrapperOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_921
@Component
public class CpeRESTClient extends RestClientFacade {

	@Value("${rest.order.cpe.contextpath}")
	private String serviceContextPath;

	@Value("${auth.rest.order.cpe.contextpath}")
	private String authserviceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	private final String CODICE_PROFILO_FWA = "codiceProfiloFWA";

	public CpeWrapperOutputDTO getCpeList(String tipoProfilo, String codiceProfiloFwa) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).queryParam(CODICE_PROFILO_FWA, codiceProfiloFwa);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(CpeWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
