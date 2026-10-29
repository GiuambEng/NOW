package com.nttdata.tim.now.adapters.esb.ordine;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.base.CreateResponseDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1492
@Component
public class LavorazioneManualeRESTClient extends RestClientFacade {

	@Value("${rest.integration.openfiber.lavorazionemanuale.confermako.contextpath}")
	private String confermaKoServiceContextPath;

	@Value("${rest.integration.openfiber.lavorazionemanuale.risottometti.contextpath}")
	private String risottomettiServiceContextPath;
	
	@Value("${rest.integration.openfiber.lavorazionemanuale.modifica.contextpath}")
	private String modificaServiceContextPath;
	
	@Value("${auth.rest.integration.openfiber.lavorazionemanuale.confermako.contextpath}")
	private String authConfermaKoServiceContextPath;

	@Value("${auth.rest.integration.openfiber.lavorazionemanuale.risottometti.contextpath}")
	private String authRisottomettiServiceContextPath;
	
	@Value("${auth.rest.integration.openfiber.lavorazionemanuale.modifica.contextpath}")
	private String authModificaServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	private static final String ID_RICHIESTA_OLO = "idRichiestaOlo";
	private static final String ID_BUILDING = "idBuilding";

	public CreateResponseDTO scarta(String tipoProfilo, String idRichiestaOlo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authConfermaKoServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authConfermaKoServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(confermaKoServiceContextPath).queryParam(ID_RICHIESTA_OLO, idRichiestaOlo);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(CreateResponseDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public CreateResponseDTO risottometti(String tipoProfilo, String idRichiestaOlo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authRisottomettiServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authRisottomettiServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(risottomettiServiceContextPath).queryParam(ID_RICHIESTA_OLO, idRichiestaOlo);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(CreateResponseDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public CreateResponseDTO modifica(String tipoProfilo, String idRichiestaOlo, String idBuilding) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authModificaServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authModificaServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = null;
		if(idBuilding != null) {
			webTarget = guiIntegrationClient.getBaseTarget().path(modificaServiceContextPath).queryParam(ID_RICHIESTA_OLO, idRichiestaOlo).queryParam(ID_BUILDING, idBuilding);
		}else {
			webTarget = guiIntegrationClient.getBaseTarget().path(modificaServiceContextPath).queryParam(ID_RICHIESTA_OLO, idRichiestaOlo);
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(CreateResponseDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
