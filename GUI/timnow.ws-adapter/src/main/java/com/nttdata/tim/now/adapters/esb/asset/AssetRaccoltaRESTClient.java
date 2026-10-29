package com.nttdata.tim.now.adapters.esb.asset;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.asset.AssetRaccoltaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.asset.DettaglioAssetRaccoltaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1188
@Component
public class AssetRaccoltaRESTClient extends RestClientFacade {

	@Value("${rest.order.asset.raccolta.contextpath}")
	private String serviceContextPath;

	@Value("${rest.order.asset.raccolta.dettaglio.contextpath}")
	private String detailServiceContextPath;

	@Value("${auth.rest.order.asset.raccolta.contextpath}")
	private String authserviceContextPath;

	@Value("${auth.rest.order.asset.raccolta.dettaglio.contextpath}")
	private String authdetailServiceContextPath;

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	private static final String VALUE_QUERYPARAMETER_IDASSET_NAME = "idAsset";
	
	private static final String VALUE_QUERYPARAMETER_USERID = "userId";
	
	private static final String VALUE_QUERYPARAMETER_TIPOPROFILO = "tipoProfilo";
	private static final String VALUE_QUERYPARAMETER_CODOLO = "codOlo";

	public DettaglioAssetRaccoltaWrapperOutputDTO getAsset(String idAsset, String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authdetailServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authdetailServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(detailServiceContextPath).queryParam(VALUE_QUERYPARAMETER_IDASSET_NAME, idAsset);
			//WebTarget webTarget = guiIntegrationClient.client.target("https://10.172.71.76:8181").path(detailServiceContextPath).queryParam(VALUE_QUERYPARAMETER_IDASSET_NAME, idAsset);

			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(DettaglioAssetRaccoltaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	
	public AssetRaccoltaWrapperOutputDTO getAssetsRaccolta(String codOloAgcom, String tipoProfilo, String userId) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(codOloAgcom).path(tipoProfilo);
			//WebTarget webTarget = guiIntegrationClient.client.target("https://10.172.71.76:8181").path(serviceContextPath).path(codOloAgcom).path(tipoProfilo);
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(AssetRaccoltaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public AssetRaccoltaWrapperOutputDTO advancedSearch(AdvancedResearchInputDTO body, String codOloAgcom, String tipoProfilo, String userId)
			throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).queryParam(VALUE_QUERYPARAMETER_CODOLO, codOloAgcom).queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			//WebTarget webTarget = guiIntegrationClient.client.target("https://10.172.71.76:8181").path(serviceContextPath).queryParam(VALUE_QUERYPARAMETER_CODOLO, codOloAgcom).queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(AssetRaccoltaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	
}
