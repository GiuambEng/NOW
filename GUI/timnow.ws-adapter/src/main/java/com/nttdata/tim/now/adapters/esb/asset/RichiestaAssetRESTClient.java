package com.nttdata.tim.now.adapters.esb.asset;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.asset.ListaCodiciRifiutoOutputDTO;
import com.nttdata.tim.now.data.dto.asset.RichiesteAssetWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RichiestaAssetRESTClient extends RestClientFacade {



	@Value("${rest.order.asset.listaRichieste.contextpath}")
	private String listaRichiesteServiceContextPath;

	@Value("${rest.order.asset.visualizzacodicirifiuto.contextpath}")
	private String visualizzacodicirifiutoServiceContextPath;
	
	@Value("${auth.rest.order.asset.listaRichieste.contextpath}")
	private String authlistaRichiesteServiceContextPath;
	
	@Value("${auth.rest.order.asset.visualizzacodicirifiuto.contextpath}")
	private String authvisualizzacodicirifiutoServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	private static final String VALUE_QUERYPARAMETER_USERID = "userId";

	public RichiesteAssetWrapperOutputDTO advancedSearch(AdvancedResearchInputDTO body, String codOloAgcom, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authlistaRichiesteServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authlistaRichiesteServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck

		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(listaRichiesteServiceContextPath).path(codOloAgcom).path(tipoProfilo);
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(RichiesteAssetWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaCodiciRifiutoOutputDTO visualizzacodicirifiuto(String ambitoServizioRecipient,
			String ambitoServizioDonating, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authvisualizzacodicirifiutoServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authvisualizzacodicirifiutoServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck

		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(visualizzacodicirifiutoServiceContextPath).path(ambitoServizioRecipient).path(ambitoServizioDonating);

			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaCodiciRifiutoOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	

}
