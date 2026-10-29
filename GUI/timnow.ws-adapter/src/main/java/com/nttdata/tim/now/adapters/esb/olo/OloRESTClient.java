package com.nttdata.tim.now.adapters.esb.olo;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.bean.carrier.VerificaCarrierOloCPSInputBean;
import com.nttdata.tim.now.data.dto.contratto.VerificaContrattoInputDTO;
import com.nttdata.tim.now.data.dto.contratto.VerificaContrattoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.olo.CodiceOloListDTO;
import com.nttdata.tim.now.data.dto.olo.VerificaCarrierOloCPSWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.olo.VerificaOloNumericoOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OloRESTClient extends RestClientFacade {

	@Value("${rest.controls.olo.verify.numeric.contextpath}")
	private String serviceContextPath;

	@Value("${rest.controls.olo.verify.univocal.contextpath}")
	private String univocalServiceContextPath;

	@Value("${auth.rest.controls.olo.verify.numeric.contextpath}")
	private String authserviceContextPath;
	
	@Value("${auth.rest.controls.olo.verify.univocal.contextpath}")
	private String authunivocalServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	//RU_915
	@Value("${rest.controls.olo.verify.carrier.cps.contextpath}")
	private String checkOloCarrierCpsContextPath;
	
	@Value("${auth.rest.controls.olo.verify.carrier.cps.contextpath}")
	private String authcheckOloCarrierCpsContextPath;
	
	@Value("${rest.controls.olo.verify.contract.contextpath}")
	private String checkOloContractContextPath;
	
	@Value("${auth.rest.controls.olo.verify.contract.contextpath}")
	private String authcheckOloContractContextPath;
	
	private static final String VALUE_QUERYPARAMETER_CODOLOAGCOM = "codificaOloAgcom";
	private static final String VALUE_QUERYPARAMETER_CODCARRIEROLO = "codiceCarrierOlo";
	private static final String VALUE_QUERYPARAMETER_LAVORAZIONE = "lavorazione";

	public VerificaOloNumericoOutputDTO verificaOloNumerico(String codOlo, String tipoProfilo ) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(serviceContextPath).path(codOlo);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaOloNumericoOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public CodiceOloListDTO checkUnivocalOlo(String codOlo, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authunivocalServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authunivocalServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(univocalServiceContextPath).path(codOlo);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(CodiceOloListDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//RU_915
	public VerificaCarrierOloCPSWrapperOutputDTO checkCarrierOloCps(String tipoProfilo, VerificaCarrierOloCPSInputBean request) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authcheckOloCarrierCpsContextPath))
				&& (!isAuthorizedService(tipoProfilo, authcheckOloCarrierCpsContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(checkOloCarrierCpsContextPath);
		try {			
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_CODOLOAGCOM, request.getCodificaOloAgcom());
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_CODCARRIEROLO, request.getCodiceCarrierOlo());
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_LAVORAZIONE, request.getLavorazione());
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaCarrierOloCPSWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	
	//RU_915
	public VerificaContrattoWrapperOutputDTO checkContract(String tipoProfilo, VerificaContrattoInputDTO inputDto) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authcheckOloContractContextPath))
				&& (!isAuthorizedService(tipoProfilo, authcheckOloContractContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(checkOloContractContextPath);
		try {			
			//Pezzotto
			inputDto.setLavorazione(inputDto.getLavorazione().toUpperCase());
			
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaContrattoWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
