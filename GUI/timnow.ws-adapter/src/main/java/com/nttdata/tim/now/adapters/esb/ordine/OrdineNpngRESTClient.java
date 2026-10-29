package com.nttdata.tim.now.adapters.esb.ordine;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.ordine.npng.CambioOloNpngInputDTO;
import com.nttdata.tim.now.data.dto.ordine.npng.CambioOloNpngOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.npng.DettaglioAssetNpngWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.npng.DettaglioOrdineNpngWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.npng.LavorazioneManualeOrdineNpngInputDTO;
import com.nttdata.tim.now.data.dto.ordine.npng.RicercaOrdiniNpngInputDTO;
import com.nttdata.tim.now.data.dto.ordine.npng.RicercaOrdiniNpngWrapperOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1203
@Component
public class OrdineNpngRESTClient extends RestClientFacade {

	@Value("${rest.order.npng.ricerca_ordini.contextpath}")
	private String ricercaOrdiniContextPath;
	
	@Value("${rest.order.npng.dettaglio_ordine.contextpath}")
	private String dettaglioOrdineContextPath;
	
	@Value("${rest.order.npng.lavorazione_manuale_ordine.contextpath}")
	private String lavorazioneManualeOrdineContextPath;
	
	@Value("${rest.order.npng.ricerca_asset.contextpath}")
	private String ricercaAssetContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	@Value("${rest.order.npng.dettaglio_asset.contextpath}")
	private String dettaglioAssetContextPath;
	
	@Value("${rest.order.npng.cambio_olo.contextpath}")
	private String cambioOloContextPath;
	
	@Value("${auth.rest.order.npng.ricerca_ordini.contextpath}")
	private String authRicercaOrdiniContextPath;
	
	@Value("${auth.rest.order.npng.dettaglio_ordine.contextpath}")
	private String authDettaglioOrdineContextPath;
	
	@Value("${auth.rest.order.npng.lavorazione_manuale_ordine.contextpath}")
	private String authLavorazioneManualeOrdineContextPath;	
	
	@Value("${auth.rest.order.npng.ricerca_asset.contextpath}")
	private String authRicercaAssetContextPath;
	
	@Value("${auth.rest.order.npng.dettaglio_asset.contextpath}")
	private String authDettaglioAssetContextPath;
	
	@Value("${auth.rest.order.npng.cambio_olo.contextpath}")
	private String authCambioOloContextPath;
	
	private static final String ID_ORDINE = "idOrdine";
	private static final String ID_ASSET = "idAsset";
	private static final String DN = "dn";
	
	public RicercaOrdiniNpngWrapperOutputDTO ricercaOrdini(RicercaOrdiniNpngInputDTO inputDto, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authRicercaOrdiniContextPath))
				&& (!isAuthorizedService(tipoProfilo, authRicercaOrdiniContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(ricercaOrdiniContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(RicercaOrdiniNpngWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public DettaglioOrdineNpngWrapperOutputDTO dettaglioOrdine(String idOrdine, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authDettaglioOrdineContextPath))
				&& (!isAuthorizedService(tipoProfilo, authDettaglioOrdineContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(dettaglioOrdineContextPath).queryParam(ID_ORDINE, idOrdine);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(DettaglioOrdineNpngWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public ESBResultDTO lavorazioneManualeOrdine(LavorazioneManualeOrdineNpngInputDTO inputDto, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authLavorazioneManualeOrdineContextPath))
				&& (!isAuthorizedService(tipoProfilo, authLavorazioneManualeOrdineContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(lavorazioneManualeOrdineContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ESBResultDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public RicercaOrdiniNpngWrapperOutputDTO ricercaAsset(String dn, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authRicercaAssetContextPath))
				&& (!isAuthorizedService(tipoProfilo, authRicercaAssetContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(ricercaAssetContextPath).queryParam(DN, dn);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RicercaOrdiniNpngWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public DettaglioAssetNpngWrapperOutputDTO dettaglioAsset(String idAsset, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		DettaglioAssetNpngWrapperOutputDTO result = null;
		
		if ((StringUtils.isNotEmpty(authDettaglioAssetContextPath))
				&& (!isAuthorizedService(tipoProfilo, authDettaglioAssetContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(dettaglioAssetContextPath).queryParam(ID_ASSET, idAsset);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			result = response.readEntity(DettaglioAssetNpngWrapperOutputDTO.class);			
			return result;
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public CambioOloNpngOutputDTO cambioOlo(CambioOloNpngInputDTO inputDto, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authCambioOloContextPath))
				&& (!isAuthorizedService(tipoProfilo, authCambioOloContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(cambioOloContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(CambioOloNpngOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
