package com.nttdata.tim.now.adapters.esb.ordine;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.ordine.draft.OrderDraftListDTO;
import com.nttdata.tim.now.data.dto.ordine.draft.OrdineBozzaInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrdineBozzaRESTClient extends RestClientFacade {
	private static final String VALUE_QUERYPARAMETER_COD_OLO_AGCOM = "codOloAgcom";
	private static final String VALUE_QUERYPARAMETER_COD_ORD_OLO = "codOrdOlo";
	private static final String VALUE_QUERYPARAMETER_USER_ID = "userid";

	@Value("${rest.order.draft.contextpath}")
	private String saveServiceContextPath;
	
	@Value("${rest.order.draft.update.contextpath}")
	private String updateServiceContextPath;
	
	@Value("${rest.order.draft.list.contextpath}")
	private String listServiceContextPath;
	
	@Value("${rest.order.draft.delete.contextpath}")
	private String deleteServiceContextPath;
	
	@Value("${rest.order.draft.detail.contextpath}")
	private String detailServiceContextPath;

	@Value("${auth.rest.order.draft.contextpath}")
	private String authsaveServiceContextPath;
	
	@Value("${auth.rest.order.draft.update.contextpath}")
	private String authupdateServiceContextPath;
	
	@Value("${auth.rest.order.draft.list.contextpath}")
	private String authlistServiceContextPath;
	
	@Value("${auth.rest.order.draft.delete.contextpath}")
	private String authdeleteServiceContextPath;
	
	@Value("${auth.rest.order.draft.detail.contextpath}")
	private String authdetailServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public ESBResultDTO createDraft(OrdineBozzaInputDTO dto, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authsaveServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authsaveServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(saveServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(dto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ESBResultDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public OrderDraftListDTO getDrafts(String tipoProfilo, String codOloAgcom, String userId)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authlistServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authlistServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(listServiceContextPath).path(tipoProfilo);
		if (codOloAgcom != null) {
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_COD_OLO_AGCOM, codOloAgcom);
		}
		if (userId != null) {
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USER_ID, userId);
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(OrderDraftListDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public OrderDraftListDTO getDraft(String codOrdOlo, String codOloAgcom, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authdetailServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authdetailServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(detailServiceContextPath);
		if (codOloAgcom != null) {
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_COD_OLO_AGCOM, codOloAgcom);
		}
		if (codOrdOlo != null) {
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_COD_ORD_OLO, codOrdOlo);
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(OrderDraftListDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// change from delete to get for RU_532
	public ESBResultDTO deleteDraft(String codOrdOlo, String codOloAgcom, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authdeleteServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authdeleteServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(deleteServiceContextPath);
		if (codOloAgcom != null) {
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_COD_OLO_AGCOM, codOloAgcom);
		}
		if (codOrdOlo != null) {
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_COD_ORD_OLO, codOrdOlo);
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ESBResultDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// change from put to post for RU_532
    public ESBResultDTO updateDraft(OrdineBozzaInputDTO inputDTO, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authupdateServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authupdateServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(updateServiceContextPath);
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
                    .post(Entity.entity(inputDTO, MediaType.APPLICATION_JSON_TYPE));
            checkStatus(response);
            return response.readEntity(ESBResultDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

}
