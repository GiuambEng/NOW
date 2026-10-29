package com.nttdata.tim.now.adapters.esb.pps;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.pps.ListaAmbitiMonitoraggioOutputDTO;
import com.nttdata.tim.now.data.dto.pps.ListaAmministrazioneDatiOutputDTO;
import com.nttdata.tim.now.data.dto.pps.ListaDettagliAmministrazioneDatiOutputDTO;
import com.nttdata.tim.now.data.dto.pps.SogliaWrapperInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PpsRESTClient extends RestClientFacade {

	@Value("${rest.pps.administration.ppsparameters.contextpath}")
	private String serviceContextPath;

	@Value("${rest.pps.administration.ppsparameters.update.contextpath}")
	private String updateServiceContextPath;

	@Value("${auth.rest.pps.administration.ppsparameters.contextpath}")
	private String authserviceContextPath;
	
	@Value("${auth.rest.pps.administration.ppsparameters.update.contextpath}")
	private String authupdateServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public ListaAmministrazioneDatiOutputDTO getResearch(String ambito, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(serviceContextPath).path(ambito);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaAmministrazioneDatiOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaDettagliAmministrazioneDatiOutputDTO getDetail(String ambito, String report, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(serviceContextPath).path(report).path(ambito);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaDettagliAmministrazioneDatiOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// change for RU 532 form put to post
	public ESBResultDTO editThreshold(SogliaWrapperInputDTO body, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authupdateServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authupdateServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(updateServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ESBResultDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaAmbitiMonitoraggioOutputDTO getScopes(String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(serviceContextPath);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaAmbitiMonitoraggioOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
