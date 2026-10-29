package com.nttdata.tim.now.adapters.esb.monitoraggio;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.monitoring.kodel103.MonitoraggioKoDelibera103ListDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Change Request #42013
@Component
public class MonitoraggioKoDelibera103RESTClient extends RestClientFacade {

	@Value("${rest.pps.monitoring.delibera103.ko.contextpath}")
	private String serviceContextPath;

	@Value("${auth.rest.pps.monitoring.delibera103.ko.contextpath}")
	private String authserviceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public MonitoraggioKoDelibera103ListDTO advancedSearch(AdvancedResearchInputDTO body, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(serviceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(MonitoraggioKoDelibera103ListDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
