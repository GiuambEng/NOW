package com.nttdata.tim.now.adapters.esb.ordine;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.ordine.fiberstream.CodiceVlanFiberstreamInputDTO;
import com.nttdata.tim.now.data.dto.ordine.fiberstream.ListaApparatiFiberstreamOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.fiberstream.ListaCodiceVlanFiberstreamOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.fiberstream.ListaNomeServizioAggiuntivoFiberstreamOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.fiberstream.TipologiaApparatoFiberstreamOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1462
@Component
public class FiberstreamRESTClient extends RestClientFacade {

	@Value("${rest.order.visualizzazione_vlan_fiberstream.contextpath}")
	private String visualizzazioneVlanFiberstreamContextPath;
	
	@Value("${auth.rest.order.visualizzazione_vlan_fiberstream.contextpath}")
	private String authVisualizzazioneVlanFiberstreamContextPath;
	
	@Value("${rest.order.visualizzazione_nome_servizio_agg_fiberstream.contextpath}")
	private String visualizzazioneNomeServizioAggFiberstreamContextPath;
	
	@Value("${auth.rest.order.visualizzazione_nome_servizio_agg_fiberstream.contextpath}")
	private String authVisualizzazioneNomeServizioAggFiberstreamContextPath;
	
	@Value("rest.order.visualizzazione_tipologia_apparato_fiberstream.contextpath")
	private String visualizzazioneTipologiaApparatoFiberstreamContextpath;
	
	@Value("auth.rest.order.visualizzazione_tipologia_apparato_fiberstream.contextpath")
	private String authVisualizzazioneTipologiaApparatoFiberstreamContextpath;
	
	@Value("rest.order.visualizzazione_apparati_fiberstream.contextpath")
	private String visualizzazioneApparatiFiberstreamContextpath;
	
	@Value("auth.rest.order.visualizzazione_apparati_fiberstream.contextpath")
	private String authVisualizzazioneApparatiFiberstreamContextpath;

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	private final String QUERY_PARAM_COD_NMU = "codNMU";
	private final String QUERY_PARAM_COD_NMU_LIGHT = "codNMUlight";

	public ListaCodiceVlanFiberstreamOutputDTO getVlanFiberstream(CodiceVlanFiberstreamInputDTO inputDto, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authVisualizzazioneVlanFiberstreamContextPath))
				&& (!isAuthorizedService(tipoProfilo, authVisualizzazioneVlanFiberstreamContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(visualizzazioneVlanFiberstreamContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaCodiceVlanFiberstreamOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public ListaNomeServizioAggiuntivoFiberstreamOutputDTO getNomeServizioAggiuntivoFiberstream(String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authVisualizzazioneNomeServizioAggFiberstreamContextPath))
				&& (!isAuthorizedService(tipoProfilo, authVisualizzazioneNomeServizioAggFiberstreamContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(visualizzazioneNomeServizioAggFiberstreamContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaNomeServizioAggiuntivoFiberstreamOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public TipologiaApparatoFiberstreamOutputDTO getTipologiaApparatoFiberstream(String codiceNmu, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authVisualizzazioneTipologiaApparatoFiberstreamContextpath))
				&& (!isAuthorizedService(tipoProfilo, authVisualizzazioneTipologiaApparatoFiberstreamContextpath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(visualizzazioneTipologiaApparatoFiberstreamContextpath).queryParam(QUERY_PARAM_COD_NMU, codiceNmu);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(TipologiaApparatoFiberstreamOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public ListaApparatiFiberstreamOutputDTO getApparatiFiberstream(String codiceNmuLight, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authVisualizzazioneApparatiFiberstreamContextpath))
				&& (!isAuthorizedService(tipoProfilo, authVisualizzazioneApparatiFiberstreamContextpath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(visualizzazioneApparatiFiberstreamContextpath).queryParam(QUERY_PARAM_COD_NMU_LIGHT, codiceNmuLight);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaApparatiFiberstreamOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
