package com.nttdata.tim.now.adapters.esb.monitoraggio;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.codice.ListaCodiceOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.reinviomail.RinvioMailListInputDTO;
import com.nttdata.tim.now.data.dto.monitoring.reinviomail.RinvioMailListOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailResendRESTClient extends RestClientFacade {

	@Value("${rest.pps.rinvioemail.search.contextpath}")
	private String searchContextPath;
	
	@Value("${rest.pps.rinvioemail.reinvio.contextpath}")
	private String sendContextPath;
	
	@Value("${auth.rest.pps.rinvioemail.search.contextpath}")
	private String authsearchContextPath;
	
	@Value("${auth.rest.pps.rinvioemail.reinvio.contextpath}")
	private String authsendContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;


	public ListaCodiceOutputDTO invioEmail(RinvioMailListInputDTO inputDTO, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authsendContextPath))
				&& (!isAuthorizedService(tipoProfilo, authsendContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(sendContextPath);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDTO, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaCodiceOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public RinvioMailListOutputDTO advancedSearch(AdvancedResearchInputDTO input, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authsearchContextPath))
				&& (!isAuthorizedService(tipoProfilo, authsearchContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(searchContextPath);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(input, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(RinvioMailListOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
