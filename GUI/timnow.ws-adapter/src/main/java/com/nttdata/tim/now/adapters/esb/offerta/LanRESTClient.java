package com.nttdata.tim.now.adapters.esb.offerta;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.lan.ListaCodiceVlanSVlanOutputDTO;
import com.nttdata.tim.now.data.dto.lan.VerificaUnivocitaSVlanCVlanInputDto;
import com.nttdata.tim.now.data.dto.lan.VerificaUnivocitaSvlanCvlanWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LanRESTClient extends RestClientFacade {

	@Value("${rest.order.lan.contextpath}")
	private String serviceContextPath;

	@Value("${rest.controls.lan.verify.contextpath}")
	private String verifyServiceContextPath;

	@Value("${rest.order.research.lan.contextpath}")
	private String researchServiceContextPath;

	@Value("${auth.rest.order.lan.contextpath}")
	private String authserviceContextPath;
	
	@Value("${auth.rest.controls.lan.verify.contextpath}")
	private String authverifyServiceContextPath;
	
	@Value("${auth.rest.order.research.lan.contextpath}")
	private String authresearchServiceContextPath;

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;


	public ListaCodiceVlanSVlanOutputDTO getVlanSVlan(String codificaOloAgcom, String encapsulation, String servizio, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).path(codificaOloAgcom).path(servizio);
		if (StringUtils.isNotEmpty(encapsulation)) {
			webTarget = webTarget.queryParam("encapsulation", encapsulation);
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaCodiceVlanSVlanOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaCodiceVlanSVlanOutputDTO getVlanSVlan(String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authresearchServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authresearchServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(researchServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaCodiceVlanSVlanOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public VerificaUnivocitaSvlanCvlanWrapperOutputDTO verifySVlanCVlan(VerificaUnivocitaSVlanCVlanInputDto inputDto, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authverifyServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authverifyServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verifyServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaUnivocitaSvlanCvlanWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaCodiceVlanSVlanOutputDTO advancedSearch(AdvancedResearchInputDTO body, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authresearchServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authresearchServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(researchServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaCodiceVlanSVlanOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaCodiceVlanSVlanOutputDTO advancedSearchVlanSvlan(AdvancedResearchInputDTO body, String codOloAgcom, String servizio,
			String encapsulation,String idContratto, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).path(codOloAgcom).path(servizio);
		try {
	        if (StringUtils.isNotEmpty(idContratto)) {
	        	webTarget = webTarget.queryParam("idContratto", idContratto);
	        }
	        if (StringUtils.isNotEmpty(encapsulation)) {
		            webTarget = webTarget.queryParam("encapsulation", encapsulation);
		    }
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaCodiceVlanSVlanOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
