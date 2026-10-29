package com.nttdata.tim.now.adapters.esb.offerta;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.dto.vc.ListaProfiliVcOutputDTO;
import com.nttdata.tim.now.data.dto.vc.MaxVcKitInputDTO;
import com.nttdata.tim.now.data.dto.vc.VcProfileOutputDTO;
import com.nttdata.tim.now.data.dto.vp.MaxVCVPOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VcRESTClient extends RestClientFacade {

	private static final String VALUE_QUERYPARAMETER_PROTOCOLLO = "protocollo";
	private static final String VALUE_QUERYPARAMETER_PROFILOTECNICOLINEA = "profTecnicoLinea";
	private static final String VALUE_QUERYPARAMETER_CARATTERISTICA = "caratteristica";
	
	@Value("${rest.integration.vc.contextpath}")
	private String serviceContextPath;

	@Value("${rest.order.vc.visualizzaprofilo.contextpath}")
	private String visualizzaProfiloVCServiceContextPath;

	@Value("${rest.controls.vc.maxvcperkit.contextpath}")
	private String maxVcPerKitServiceContextPath;

	@Value("${auth.rest.integration.vc.contextpath}")
	private String authserviceContextPath;
	
	@Value("${auth.rest.order.vc.visualizzaprofilo.contextpath}")
	private String authvisualizzaProfiloVCServiceContextPath;
	
	@Value("${auth.rest.controls.vc.maxvcperkit.contextpath}")
	private String authmaxVcPerKitServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public ListaProfiliVcOutputDTO getProfilesVc(String tipoProfilo) throws IntegrationLayerException {
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
			return response.readEntity(ListaProfiliVcOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public VcProfileOutputDTO viewProfilesVC(String tipoProfilo, String idOfferta, String codiceProfilo, String protocollo, String profilotecnicolinea, String caratteristica) throws IntegrationLayerException {
		VcProfileOutputDTO dto;
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authvisualizzaProfiloVCServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authvisualizzaProfiloVCServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(visualizzaProfiloVCServiceContextPath).path(tipoProfilo).path(idOfferta).path(codiceProfilo);
		if (!StringUtils.isEmpty(protocollo) && protocollo!=null){
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_PROTOCOLLO,protocollo);	
		}
		if (!StringUtils.isEmpty(profilotecnicolinea) && profilotecnicolinea!=null){
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_PROFILOTECNICOLINEA,profilotecnicolinea);	
		}
		if (!StringUtils.isEmpty(caratteristica) && caratteristica!=null){
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_CARATTERISTICA,caratteristica);	
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			dto = response.readEntity(VcProfileOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
		return dto;
	}

	public ListaProfiliVcOutputDTO advancedSearch(AdvancedResearchInputDTO body, String tipoProfilo) throws IntegrationLayerException {
		ListaProfiliVcOutputDTO dto;
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
			dto = response.readEntity(ListaProfiliVcOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
		return dto;
	}

	public MaxVCVPOutputDTO checkMaxVcPerKit(MaxVcKitInputDTO input, String tipoProfilo) throws IntegrationLayerException {
		MaxVCVPOutputDTO dto;
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authmaxVcPerKitServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authmaxVcPerKitServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(maxVcPerKitServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(input, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			dto = response.readEntity(MaxVCVPOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
		return dto;
	}

}
