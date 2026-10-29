package com.nttdata.tim.now.adapters.esb.ordine;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.ordine.tracking.OrderTrackingInputLevel2DTO;
import com.nttdata.tim.now.data.dto.ordine.tracking.OrderTrackingListLevel2OutputDTO;
import com.nttdata.tim.now.data.dto.ordine.tracking.OrderTrackingListOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrdineTrackingRESTClient extends RestClientFacade {

	@Value("${rest.integration.data_recovery.contextpath}")
	private String serviceContextPath;

	@Value("${auth.rest.integration.data_recovery.contextpath}")
	private String authserviceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public OrderTrackingListOutputDTO getOrderTracking(String idRichiestaOlo, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(idRichiestaOlo).path(tipoProfilo);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();

			checkStatus(response);
			return response.readEntity(OrderTrackingListOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public OrderTrackingListLevel2OutputDTO getOrderTrackingLevel2(OrderTrackingInputLevel2DTO inputDto) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(inputDto.getProfiloUtente(), authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(OrderTrackingListLevel2OutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}


}
