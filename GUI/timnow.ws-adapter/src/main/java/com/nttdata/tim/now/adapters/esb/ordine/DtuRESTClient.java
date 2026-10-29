package com.nttdata.tim.now.adapters.esb.ordine;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.dtu.DettaglioDtuWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.dtu.ListaDtuOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DtuRESTClient extends RestClientFacade {

	@Value("${rest.integration.dtu.list.contextpath}")
	private String serviceContextPath;

	@Value("${rest.integration.dtu.detail.contextpath}")
	private String detailServiceContextPath;

	@Value("${auth.rest.integration.dtu.list.contextpath}")
	private String authserviceContextPath;
	
	@Value("${auth.rest.integration.dtu.detail.contextpath}")
	private String authdetailServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public DettaglioDtuWrapperOutputDTO getDtu(String idEventoNow, String tipoProfilo, String progressivoEventoDtu, String idRichiestaOlo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authdetailServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authdetailServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(detailServiceContextPath).path(idEventoNow).path(progressivoEventoDtu).path(idRichiestaOlo);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(DettaglioDtuWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaDtuOutputDTO getDtus(String tipoProfilo, String idrichiestaolo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(tipoProfilo).path(idrichiestaolo);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaDtuOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
