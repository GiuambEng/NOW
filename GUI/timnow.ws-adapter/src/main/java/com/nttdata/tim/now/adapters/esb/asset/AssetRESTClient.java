package com.nttdata.tim.now.adapters.esb.asset;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.asset.DettaglioAssetWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.asset.ListaAssetOutputDTO;
import com.nttdata.tim.now.data.dto.asset.ListaFeederOutputDTO;
import com.nttdata.tim.now.data.dto.asset.ListaSediOltOutputDTO;
import com.nttdata.tim.now.data.dto.asset.RecuperoAssetWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.asset.VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AssetRESTClient extends RestClientFacade {
	private static final String VALUE_QUERYPARAMETER_NAME = "value";
	private static final String VALUE_QUERYPARAMETER_OAODONATING_NAME = "oaoDonating";
	private static final String VALUE_QUERYPARAMETER_TIPOLAVORAZIONE = "tipoLavorazione";
	private static final String VALUE_QUERYPARAMETER_USERID = "userId";

	//R1E-21-0325
	private static final String VALUE_QUERYPARAMETER_TIPOPROFILO = "tipoProfilo";

	//RU_1184
	private static final String VALUE_QUERYPARAMETER_IDASSET = "idAsset";
	private static final String VALUE_QUERYPARAMETER_DISABILITAZIONE = "disabilitazione";

	@Value("${rest.order.asset.contextpath}")
	private String serviceContextPath;

	@Value("${rest.order.asset_detail.contextpath}")
	private String detailServiceContextPath;

	@Value("${rest.order.asset.recupero.contextpath}")
	private String recuperoAssetServiceContextPath;

	@Value("${auth.rest.order.asset.contextpath}")
	private String authserviceContextPath;

	@Value("${auth.rest.order.asset_detail.contextpath}")
	private String authdetailServiceContextPath;

	@Value("${auth.rest.order.asset.recupero.contextpath}")
	private String authrecuperoAssetServiceContextPath;

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	//RU_1184
	@Value("${rest.controls.verifica_stato_asset_abilitazione_disabilitazione.contextpath}")
	private String verificaStatoAssetAbilitazioneDisabilitazioneContextPath;
	
	//R1I-21-0203
	@Value("${rest.order.sedi_olt_dettaglio_asset.contextpath}")
	private String recuperoSediOltAssetContextPath;
	
	@Value("${auth.rest.order.sedi_olt_dettaglio_asset.contextpath}")
	private String authRecuperoSediOltAssetContextPath;
	
	@Value("${rest.order.feeders_dettaglio_asset.contextpath}")
	private String recuperoFeedersAssetContextPath;
	
	@Value("${auth.rest.order.feeders_dettaglio_asset.contextpath}")
	private String authRecuperoFeedersAssetContextPath;
	
	
	public DettaglioAssetWrapperOutputDTO getAssetByParametro(String flagConsistenza, String nomeCampo,
			String valoreCampo, String codDonating, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authdetailServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authdetailServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck

		try {
			//RU_1294
			 WebTarget webTarget =
			 guiOrderRestClient.getBaseTarget().path(detailServiceContextPath).path(flagConsistenza).path(nomeCampo).queryParam(VALUE_QUERYPARAMETER_NAME, valoreCampo). queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO,tipoProfilo);
			if (codDonating != null) {
				webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_OAODONATING_NAME, codDonating);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(DettaglioAssetWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaAssetOutputDTO getAssets(String codOloAgcom, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).path(codOloAgcom)
					.path(tipoProfilo);
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaAssetOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaAssetOutputDTO advancedSearch(AdvancedResearchInputDTO body, String codOloAgcom, String tipoProfilo, String userId)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).path(codOloAgcom)
					.path(tipoProfilo);
			if (userId!=null){
				webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaAssetOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	//RU_1058
	public RecuperoAssetWrapperOutputDTO recuperoasset(String codAgcom, String idRisorsa, String tipoLavorazione, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authrecuperoAssetServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authrecuperoAssetServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			String encodeIdRisorsa = URLEncoder.encode(idRisorsa, StandardCharsets.UTF_8.toString()).replaceAll("\\+",
					"%20");
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperoAssetServiceContextPath)
					.path(codAgcom).path(encodeIdRisorsa);
			if (tipoLavorazione!=null){
				webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_TIPOLAVORAZIONE, tipoLavorazione);
			}
			//R1E-21-0325
			if (tipoProfilo != null){
				webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperoAssetWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	//RU_1184
	public VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputDTO verificaStatoAssetAbilitazioneDisabilitazione(String idAsset, String disabilitazione, String tipoProfilo)
			throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authrecuperoAssetServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authrecuperoAssetServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		try {
			WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaStatoAssetAbilitazioneDisabilitazioneContextPath);

			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_IDASSET, idAsset);
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_DISABILITAZIONE, disabilitazione);

			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//R1I-21-0203
	public ListaSediOltOutputDTO listaSediOlt(String idAsset, String tipoProfilo)
			throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authRecuperoSediOltAssetContextPath))
				&& (!isAuthorizedService(tipoProfilo, authRecuperoSediOltAssetContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperoSediOltAssetContextPath);
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_IDASSET, idAsset);

			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaSediOltOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//R1I-21-0203
	public ListaFeederOutputDTO listaFeeder(String idAsset, String tipoProfilo)
			throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authRecuperoFeedersAssetContextPath))
				&& (!isAuthorizedService(tipoProfilo, authRecuperoFeedersAssetContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperoFeedersAssetContextPath);
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_IDASSET, idAsset);

			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaFeederOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
