package com.nttdata.tim.now.adapters.esb.offerta;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.dto.vp.ListaCodiciVpOutputDTO;
import com.nttdata.tim.now.data.dto.vp.ListaVpOutputDTO;
import com.nttdata.tim.now.data.dto.vp.MaxVCVPInputDTO;
import com.nttdata.tim.now.data.dto.vp.MaxVCVPOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VpRESTClient extends RestClientFacade {

	@Value("${rest.order.vp.contextpath}")
	private String serviceContextPath;

	@Value("${rest.order.vp.cod.contextpath}")
	private String vpServiceContextPath;

	@Value("${rest.controls.vp.maxvcvp.contextpath}")
	private String maxVcVpServiceContextPath;

	@Value("${auth.rest.order.vp.contextpath}")
	private String authserviceContextPath;
	
	@Value("${auth.rest.order.vp.cod.contextpath}")
	private String authvpServiceContextPath;
	
	@Value("${auth.rest.controls.vp.maxvcvp.contextpath}")
	private String authmaxVcVpServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public ListaVpOutputDTO getVps(String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaVpOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaCodiciVpOutputDTO getVpCodeList(String codOlo, String idOfferta, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authvpServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authvpServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(vpServiceContextPath).path(idOfferta).path(codOlo);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaCodiciVpOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public MaxVCVPOutputDTO getMaxVcVp(MaxVCVPInputDTO body, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authmaxVcVpServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authmaxVcVpServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(maxVcVpServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(MaxVCVPOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaVpOutputDTO advancedSearch(AdvancedResearchInputDTO body, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaVpOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
