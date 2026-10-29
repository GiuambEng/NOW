package com.nttdata.tim.now.adapters.esb.offerta;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.profilolinea.LineProfileListDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProfiloLineaRESTClient extends RestClientFacade {

	@Value("${rest.integration.line.contextpath}")
	private String serviceContextPath;

	@Value("${rest.order.lineprofiles.contextpath}")
	private String serviceLanProfilesContextPath;

	@Value("${auth.rest.integration.line.contextpath}")
	private String authserviceContextPath;
	
	@Value("${auth.rest.order.lineprofiles.contextpath}")
	private String authserviceLanProfilesContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public LineProfileListDTO getLineProfiles(String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(LineProfileListDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public LineProfileListDTO getLineProfilesByOffer(String offerId, String modulazione, String caratteristica, String tipoProfilo, String protocollo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceLanProfilesContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceLanProfilesContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceLanProfilesContextPath).path(offerId);
		if (StringUtils.isNotEmpty(modulazione)) {
			webTarget = webTarget.queryParam("modulazione", modulazione);
		}
		if (StringUtils.isNotEmpty(caratteristica)) {
			webTarget = webTarget.queryParam("caratteristica", caratteristica);
		}
		if (StringUtils.isNotEmpty(protocollo)) {
			webTarget = webTarget.queryParam("protocollo", protocollo); //SM_8252
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(LineProfileListDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public LineProfileListDTO advancedSearch(AdvancedResearchInputDTO body,String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(LineProfileListDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
