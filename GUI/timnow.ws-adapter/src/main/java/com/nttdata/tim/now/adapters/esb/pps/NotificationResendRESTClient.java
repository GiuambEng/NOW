package com.nttdata.tim.now.adapters.esb.pps;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.ListaGeneraNotificheOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.ListaOloOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.NotificationRequestListDTO;
import com.nttdata.tim.now.data.dto.monitoring.reinvionotifica.ListaRinvioNotificheOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.reinvionotifica.RichiestaRinvioNotificaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.olo.template.OloRequestListDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NotificationResendRESTClient extends RestClientFacade {

	@Value("${rest.pps.notification.resend.contextpath}")
	private String resendServiceContextPath;

	@Value("${auth.rest.pps.notification.resend.contextpath}")
	private String authresendServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public ListaOloOutputDTO getNotificationResend(String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authresendServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authresendServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(resendServiceContextPath).path("olo");
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaOloOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaRinvioNotificheOutputDTO resendNotificationLevel1(OloRequestListDTO body, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authresendServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authresendServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(resendServiceContextPath).path("notifiche");
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaRinvioNotificheOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public RichiestaRinvioNotificaWrapperOutputDTO resendNotificationRequests(String codOloAgcom, String codOloNow, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authresendServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authresendServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(resendServiceContextPath).path("richiesta").path(codOloAgcom).path(codOloNow);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RichiestaRinvioNotificaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaGeneraNotificheOutputDTO resendNotificationLevel2(NotificationRequestListDTO body, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authresendServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authresendServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(resendServiceContextPath).path("rinvio");
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaGeneraNotificheOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
