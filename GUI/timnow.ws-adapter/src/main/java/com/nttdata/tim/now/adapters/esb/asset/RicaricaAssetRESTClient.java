package com.nttdata.tim.now.adapters.esb.asset;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.asset.NuovaRicaricaInputDTO;
import com.nttdata.tim.now.data.dto.asset.NuovaRicaricaOutputDTO;
import com.nttdata.tim.now.data.dto.asset.RicaricaAssetWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.asset.RichiesteAssetWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.asset.TaglioRicaricaAssetWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RicaricaAssetRESTClient extends RestClientFacade {


	@Value("${rest.order.asset.listaRichiesteRicarica.contextpath}")
	private String listaRichiesteRicaricaServiceContextPath;

	@Value("${rest.order.asset.nuovaRicarica.contextpath}")
	private String nuovaRicaricaServiceContextPath;

	@Value("${rest.order.asset.listaRichieste.contextpath}")
	private String listaRichiesteServiceContextPath;

	@Value("${rest.order.asset.taglioRicarica.contextpath}")
	private String taglioRicaricaServiceContextPath;
	
	@Value("${auth.rest.order.asset.taglioRicarica.contextpath}")
	private String authtaglioRicaricaServiceContextPath;
	
	@Value("${auth.rest.order.asset.listaRichiesteRicarica.contextpath}")
	private String authlistaRichiesteRicaricaServiceContextPath;
	
	@Value("${auth.rest.order.asset.nuovaRicarica.contextpath}")
	private String authnuovaRicaricaServiceContextPath;

	@Value("${auth.rest.order.asset.listaRichieste.contextpath}")
	private String authlistaRichiesteServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	private static final String VALUE_QUERYPARAMETER_USERID = "userId";
	
	public RicaricaAssetWrapperOutputDTO advancedSearch(AdvancedResearchInputDTO body, String codOloAgcom, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authlistaRichiesteRicaricaServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authlistaRichiesteRicaricaServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck

		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(listaRichiesteRicaricaServiceContextPath).path(codOloAgcom).path(tipoProfilo);
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(RicaricaAssetWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public NuovaRicaricaOutputDTO nuovaRicarica(NuovaRicaricaInputDTO inputDto, String codiceProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authnuovaRicaricaServiceContextPath))
				&& (!isAuthorizedService(codiceProfilo, authnuovaRicaricaServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(nuovaRicaricaServiceContextPath);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(NuovaRicaricaOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public RichiesteAssetWrapperOutputDTO listaRichieste(String idRicarica, String codiceProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authlistaRichiesteServiceContextPath))
				&& (!isAuthorizedService(codiceProfilo, authlistaRichiesteServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(listaRichiesteServiceContextPath).path(idRicarica);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RichiesteAssetWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public TaglioRicaricaAssetWrapperOutputDTO getTaglioRicarica(String offerta, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authtaglioRicaricaServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authtaglioRicaricaServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(taglioRicaricaServiceContextPath).path(offerta);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(TaglioRicaricaAssetWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
