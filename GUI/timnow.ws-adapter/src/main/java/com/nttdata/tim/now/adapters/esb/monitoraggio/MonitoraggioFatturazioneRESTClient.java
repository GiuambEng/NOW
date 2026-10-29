package com.nttdata.tim.now.adapters.esb.monitoraggio;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.monitoring.fatturazione.MonitoraggioFatturazioneContatoreListOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.fatturazione.MonitoraggioFatturazioneDettaglioListOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.fatturazione.MonitoraggioFatturazioneWrapperOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;
import com.nttdata.tim.now.util.FlagHelper;
import com.nttdata.tim.now.util.date.DateHelper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MonitoraggioFatturazioneRESTClient extends RestClientFacade {
	private static final String FLAG_EXPORT = "flagExport";

	@Value("${rest.pps.monitoraggio.fatturazione.list.contextpath}")
	private String listServiceContextPath;

	@Value("${rest.pps.monitoraggio.fatturazione.contatore.contextpath}")
	private String contatoreServiceContextPath;

	@Value("${rest.pps.monitoraggio.fatturazione.dettaglio.contextpath}")
	private String dettaglioServiceContextPath;

	@Value("${auth.rest.pps.monitoraggio.fatturazione.list.contextpath}")
	private String authlistServiceContextPath;
	
	@Value("${auth.rest.pps.monitoraggio.fatturazione.contatore.contextpath}")
	private String authcontatoreServiceContextPath;
	
	@Value("${auth.rest.pps.monitoraggio.fatturazione.dettaglio.contextpath}")
	private String authdettaglioServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	private static final String VALUE_QUERYPARAMETER_USERID = "userId";
	private static final String VALUE_QUERYPARAMETER_TIPOPROFILO = "tipoProfilo";

	public MonitoraggioFatturazioneWrapperOutputDTO getList(boolean flagExport, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authlistServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authlistServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(listServiceContextPath).queryParam(FLAG_EXPORT, FlagHelper.convertFromFE(flagExport));
			if (tipoProfilo!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			}
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(MonitoraggioFatturazioneWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public MonitoraggioFatturazioneContatoreListOutputDTO getContatore(String dataEstrazione, String statoRichiestaNow, String descrizioneFamigliaOfferta, boolean flagExport, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authcontatoreServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authcontatoreServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			String data = DateHelper.convertFromFE(dataEstrazione);
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(contatoreServiceContextPath).path(data).path(statoRichiestaNow).path(descrizioneFamigliaOfferta);
			if (flagExport) {
				webTarget = webTarget.queryParam(FLAG_EXPORT, FlagHelper.convertFromFE(flagExport));
			}
			if (tipoProfilo!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			}
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(MonitoraggioFatturazioneContatoreListOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public MonitoraggioFatturazioneDettaglioListOutputDTO getDetail(String codiceOrdineTI, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authcontatoreServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authcontatoreServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(dettaglioServiceContextPath).path(codiceOrdineTI);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(MonitoraggioFatturazioneDettaglioListOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
