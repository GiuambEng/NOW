package com.nttdata.tim.now.adapters.esb.ordine;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.base.CreateResponseDTO;
import com.nttdata.tim.now.data.dto.richiesta.EsitiRichiesteInputDTO;
import com.nttdata.tim.now.data.dto.richiesta.EsitiRichiesteOutputDTO;
import com.nttdata.tim.now.data.dto.richiesta.RecuperaNotificheRichiestaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.richiesta.RequestDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EsitiRichiesteRESTClient extends RestClientFacade {

	private static final String TIPO_PROFILO = "tipoProfilo";
	private static final String COD_AGCOM = "codAgcom";
	private static final String ID_RICHIESTA = "idRichiesta";
	
	
	@Value("${rest.order.request.contextpath}")
	private String getRequestsServiceContextPath;
	
	@Value("${rest.order.createrequest.contextpath}")
	private String createRequestServiceContextPath;

	@Value("${auth.rest.order.request.contextpath}")
	private String authgetRequestsServiceContextPath;
	
	@Value("${auth.rest.order.createrequest.contextpath}")
	private String authcreateRequestServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	@Value("${rest.order.recupera_notifiche_richiesta.contextpath}")
	private String recuperaNotificheRichistaServiceContextPath;
	
	@Value("${auth.rest.order.recupera_notifiche_richiesta.contextpath}")
	private String authRecuperaNotificheRichistaServiceContextPath;
	
	//SM_9693
	@Value("${rest.order.esitiRichieste.contextpath}")
	private String recuperaEsitiRichiesteContextPath;
	
	
	public EsitiRichiesteOutputDTO getOutcomesRequets(String codiceOrdine, String tipoProfilo, String codAgcom) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authgetRequestsServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authgetRequestsServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(getRequestsServiceContextPath).path(codiceOrdine).path(tipoProfilo).path(codAgcom);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(EsitiRichiesteOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public CreateResponseDTO createRequest(RequestDTO request, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authcreateRequestServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authcreateRequestServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(createRequestServiceContextPath); 
		//WebTarget webTarget = guiOrderRestClient.client.target("https://10.175.67.249:8180").path(createRequestServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(CreateResponseDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//RU_888
	public RecuperaNotificheRichiestaWrapperOutputDTO getNotificheRichiesta(String codiceOrdine, String tipoProfilo, String codAgcom) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authRecuperaNotificheRichistaServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authRecuperaNotificheRichistaServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaNotificheRichistaServiceContextPath).queryParam(TIPO_PROFILO, tipoProfilo).queryParam(COD_AGCOM, codAgcom).queryParam(ID_RICHIESTA, codiceOrdine);
		//WebTarget webTarget = guiControlsRestClient.client.target("http://www.json-generator.com/api/json/get/cfRaJEOMmW?indent=2");
		//WebTarget webTarget = guiIntegrationClient.client.target("https://VT-MasulloIl:8181").path(serviceContextPath).path(orderCode).queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperaNotificheRichiestaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//SM_9693
	public EsitiRichiesteOutputDTO recuperaEsitiERichieste(EsitiRichiesteInputDTO request) throws IntegrationLayerException {
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaEsitiRichiesteContextPath);
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(EsitiRichiesteOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
}
