package com.nttdata.tim.now.adapters.esb.monitoraggio;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.monitoring.agcom.MonitoraggioAgcomT1OutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.agcom.MonitoraggioAgcomT2OutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.agcom.MonitoraggioAgcomT3OutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.agcom.MonitoraggioAgcomT4OutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.agcom.MonitoraggioAgcomT5OutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;
import com.nttdata.tim.now.util.FlagHelper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MonitoraggioAgcomRESTClient extends RestClientFacade {
	private static final String VALUE_QUERYPARAMETER_FLAG_EXPORT = "flagExport";

	@Value("${rest.pps.monitoraggio.agcom.t1.contextpath}")
	private String listaMonitoraggioT1ContextPath;
	
	@Value("${rest.pps.monitoraggio.agcom.t2.contextpath}")
	private String listaMonitoraggioT2ContextPath;
	
	@Value("${rest.pps.monitoraggio.agcom.t3.contextpath}")
	private String listaMonitoraggioT3ContextPath;
	
	@Value("${rest.pps.monitoraggio.agcom.t4.contextpath}")
	private String listaMonitoraggioT4ContextPath;
	
	@Value("${rest.pps.monitoraggio.agcom.t5.contextpath}")
	private String listaMonitoraggioT5ContextPath;
	
	@Value("${auth.rest.pps.monitoraggio.agcom.t1.contextpath}")
	private String authlistaMonitoraggioT1ContextPath;
	
	@Value("${auth.rest.pps.monitoraggio.agcom.t2.contextpath}")
	private String authlistaMonitoraggioT2ContextPath;
	
	@Value("${auth.rest.pps.monitoraggio.agcom.t3.contextpath}")
	private String authlistaMonitoraggioT3ContextPath;
	
	@Value("${auth.rest.pps.monitoraggio.agcom.t4.contextpath}")
	private String authlistaMonitoraggioT4ContextPath;
	
	@Value("${auth.rest.pps.monitoraggio.agcom.t5.contextpath}")
	private String authlistaMonitoraggioT5ContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	private static final String VALUE_QUERYPARAMETER_USERID = "userId";
	private static final String VALUE_QUERYPARAMETER_TIPOPROFILO = "tipoProfilo";

	public MonitoraggioAgcomT1OutputDTO getDettaglioT1(String flagDettaglio, String dataEstrazione, boolean flagExport, String tipoProfilo, String userId)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authlistaMonitoraggioT1ContextPath))
				&& (!isAuthorizedService(tipoProfilo, authlistaMonitoraggioT1ContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(listaMonitoraggioT1ContextPath)
					.path(flagDettaglio).path(dataEstrazione);
			if (flagExport) {
				webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_FLAG_EXPORT,
						FlagHelper.convertFromFE(flagExport));
			}
			if (tipoProfilo!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			}
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(MonitoraggioAgcomT1OutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public MonitoraggioAgcomT2OutputDTO getDettaglioT2(String flagDettaglio, String dataEstrazione, boolean flagExport, String tipoProfilo, String userId)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authlistaMonitoraggioT2ContextPath))
				&& (!isAuthorizedService(tipoProfilo, authlistaMonitoraggioT2ContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(listaMonitoraggioT2ContextPath)
					.path(flagDettaglio).path(dataEstrazione);
			if (flagExport) {
				webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_FLAG_EXPORT,
						FlagHelper.convertFromFE(flagExport));
			}
			if (tipoProfilo!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			}
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(MonitoraggioAgcomT2OutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public MonitoraggioAgcomT3OutputDTO getDettaglioT3(String dataEstrazione, boolean flagExport, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authlistaMonitoraggioT3ContextPath))
				&& (!isAuthorizedService(tipoProfilo, authlistaMonitoraggioT3ContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(listaMonitoraggioT3ContextPath).path(dataEstrazione);
			if (flagExport) {
				webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_FLAG_EXPORT,
						FlagHelper.convertFromFE(flagExport));
			}
			if (tipoProfilo!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			}
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(MonitoraggioAgcomT3OutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public MonitoraggioAgcomT4OutputDTO getDettaglioT4(String dataEstrazione, boolean flagExport, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authlistaMonitoraggioT4ContextPath))
				&& (!isAuthorizedService(tipoProfilo, authlistaMonitoraggioT4ContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(listaMonitoraggioT4ContextPath).path(dataEstrazione);
			if (flagExport) {
				webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_FLAG_EXPORT,
						FlagHelper.convertFromFE(flagExport));
			}
			if (tipoProfilo!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			}
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(MonitoraggioAgcomT4OutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public MonitoraggioAgcomT5OutputDTO getDettaglioT5(String dataEstrazione, boolean flagExport, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authlistaMonitoraggioT5ContextPath))
				&& (!isAuthorizedService(tipoProfilo, authlistaMonitoraggioT5ContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(listaMonitoraggioT5ContextPath).path(dataEstrazione);
			if (flagExport) {
				webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_FLAG_EXPORT,
						FlagHelper.convertFromFE(flagExport));
			}
			if (tipoProfilo!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			}
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(MonitoraggioAgcomT5OutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
