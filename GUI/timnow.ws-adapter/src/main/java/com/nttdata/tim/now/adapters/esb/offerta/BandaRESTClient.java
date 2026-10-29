package com.nttdata.tim.now.adapters.esb.offerta;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.banda.ControlloValoriBandaPiccoOutputDTO;
import com.nttdata.tim.now.data.dto.banda.ListaBandeDedicateOutputDTO;
import com.nttdata.tim.now.data.dto.banda.ListaBandePiccoOutputDTO;
import com.nttdata.tim.now.data.dto.banda.ListaControlloValoriBandaPiccoInputDTO;
import com.nttdata.tim.now.data.dto.banda.ListaTipoBandeOutputDTO;
import com.nttdata.tim.now.data.dto.banda.VerificaCoppiaBandePiccoInputDTO;
import com.nttdata.tim.now.data.dto.banda.VerificaCoppiaBandePiccoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.banda.VerificaSommaBandePiccoInputDTO;
import com.nttdata.tim.now.data.dto.banda.VerificaSommaBandePiccoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BandaRESTClient extends RestClientFacade {
	private static final String TIPO_VLAN = "tipoVlan";
	private static final String TIPO_COS = "tipoCos";
	private static final String ID_OFFERTA = "idOfferta";
	private static final String PROFILO_TECNICO_LINEA = "profTecnicoLinea";

	@Value("${rest.order.band.contextpath}")
	private String serviceContextPath;

	@Value("${rest.order.bandneworder.contextpath}")
	private String newOrderserviceContextPath;
	
	@Value("${rest.controls.band.verify.contextpath}")
	private String checkBandServiceContextPath;

	@Value("${rest.order.band.viewdedicated.contextpath}")
	private String viewDedicatedBandServiceContextPath;

	@Value("${rest.order.band.viewtype.contextpath}")
	private String viewTypeBandServiceContextPath;

	@Value("${rest.controls.band.couple.verify.contextpath}")
	private String checkBandCoupleServiceContextPath;

	@Value("${rest.controls.check.band.values.contextpath}")
	private String checkBandValuesContextPath;

	@Value("${auth.rest.order.band.contextpath}")
	private String authserviceContextPath;
	
	@Value("${auth.rest.order.bandneworder.contextpath}")
	private String authnewOrderserviceContextPath;
	
	@Value("${auth.rest.controls.band.verify.contextpath}")
	private String authcheckBandServiceContextPath;
	
	@Value("${auth.rest.order.band.viewdedicated.contextpath}")
	private String authviewDedicatedBandServiceContextPath;
	
	@Value("${auth.rest.order.band.viewtype.contextpath}")
	private String authviewTypeBandServiceContextPath;
	
	@Value("${auth.rest.controls.band.couple.verify.contextpath}")
	private String authcheckBandCoupleServiceContextPath;
	
	@Value("${auth.rest.controls.check.band.values.contextpath}")
	private String authcheckBandValuesContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;


	public ListaBandePiccoOutputDTO getBands(String tipoCos, String codiceLan, String idOfferta, String profTecnicoLinea, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath);
			if (StringUtils.isNotEmpty(tipoCos)) {
				webTarget = webTarget.queryParam(TIPO_COS, tipoCos);
			}
			if (StringUtils.isNotEmpty(codiceLan)) {
				webTarget = webTarget.queryParam(TIPO_VLAN, codiceLan);
			}
			if (StringUtils.isNotEmpty(idOfferta)) {
				webTarget = webTarget.queryParam(ID_OFFERTA, idOfferta);
			}
			if (StringUtils.isNotEmpty(profTecnicoLinea)) {
				webTarget = webTarget.queryParam(PROFILO_TECNICO_LINEA, profTecnicoLinea);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaBandePiccoOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaBandePiccoOutputDTO getBandsNewOrder(String tipoCos, String codiceLan, String idOfferta, String profTecnicoLinea, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authnewOrderserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authnewOrderserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(newOrderserviceContextPath);
			if (StringUtils.isNotEmpty(tipoCos)) {
				webTarget = webTarget.queryParam(TIPO_COS, tipoCos);
			}
			if (StringUtils.isNotEmpty(codiceLan)) {
				webTarget = webTarget.queryParam(TIPO_VLAN, codiceLan);
			}
			if (StringUtils.isNotEmpty(idOfferta)) {
				webTarget = webTarget.queryParam(ID_OFFERTA, idOfferta);
			}
			if (StringUtils.isNotEmpty(profTecnicoLinea)) {
				webTarget = webTarget.queryParam(PROFILO_TECNICO_LINEA, profTecnicoLinea);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaBandePiccoOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public VerificaSommaBandePiccoWrapperOutputDTO checkBand(VerificaSommaBandePiccoInputDTO input, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authcheckBandServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authcheckBandServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(checkBandServiceContextPath);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(input, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaSommaBandePiccoWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public VerificaCoppiaBandePiccoWrapperOutputDTO checkCouple(VerificaCoppiaBandePiccoInputDTO body, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authcheckBandCoupleServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authcheckBandCoupleServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(checkBandCoupleServiceContextPath);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaCoppiaBandePiccoWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaBandeDedicateOutputDTO viewDedicatedBand(String idOfferta, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authviewDedicatedBandServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authviewDedicatedBandServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(viewDedicatedBandServiceContextPath).path(idOfferta);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaBandeDedicateOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaTipoBandeOutputDTO viewTypeBand(String codVlanSvlan, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authviewTypeBandServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authviewTypeBandServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(viewTypeBandServiceContextPath).path(codVlanSvlan);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaTipoBandeOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public ListaBandePiccoOutputDTO advancedSearch(AdvancedResearchInputDTO body, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaBandePiccoOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ControlloValoriBandaPiccoOutputDTO checkValues(ListaControlloValoriBandaPiccoInputDTO input, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authcheckBandValuesContextPath))
				&& (!isAuthorizedService(tipoProfilo, authcheckBandValuesContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(checkBandValuesContextPath);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(input, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ControlloValoriBandaPiccoOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
