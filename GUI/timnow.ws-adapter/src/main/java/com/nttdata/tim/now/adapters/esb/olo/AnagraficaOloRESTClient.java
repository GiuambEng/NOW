package com.nttdata.tim.now.adapters.esb.olo;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.anagraficaolo.AnagraficaOloWrapperOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AnagraficaOloRESTClient extends RestClientFacade {
	private static final String VALUE_QUERYPARAMETER_NO_DIFFIDA = "nodiffida";

	@Value("${rest.order.srolo.contextpath}")
	private String serviceContextPath;

	@Value("${auth.rest.order.srolo.contextpath}")
	private String authserviceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public AnagraficaOloWrapperOutputDTO getSROLOs(String tipoProfilo, String codiceAgcom, boolean noDiffida) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).path(tipoProfilo).path(codiceAgcom);
		if (noDiffida) {
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_NO_DIFFIDA, VALUE_QUERYPARAMETER_NO_DIFFIDA);
		}
		try {
			return webTarget.request(MediaType.APPLICATION_JSON_TYPE).get(AnagraficaOloWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
