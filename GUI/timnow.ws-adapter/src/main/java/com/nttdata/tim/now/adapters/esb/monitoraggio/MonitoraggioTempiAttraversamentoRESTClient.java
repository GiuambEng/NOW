package com.nttdata.tim.now.adapters.esb.monitoraggio;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.monitoring.tempiattraversamento.TempiAttraversamentoOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;
import com.nttdata.tim.now.util.FlagHelper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MonitoraggioTempiAttraversamentoRESTClient extends RestClientFacade {
	private static final String VALUE_QUERYPARAMETER_FLAG_EXPORT = "flagExport";
	private static final String VALUE_QUERYPARAMETER_TIPO_LISTA = "tipoLista";

	@Value("${rest.pps.monitoring.times.contextpath}")
	private String timesServiceContextPath;

	@Value("${auth.rest.pps.monitoring.times.contextpath}")
	private String authtimesServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	private static final String VALUE_QUERYPARAMETER_USERID = "userId";
	private static final String VALUE_QUERYPARAMETER_TIPOPROFILO = "tipoProfilo";
	
	public TempiAttraversamentoOutputDTO getCrossingTimesMonitoringLevel0(boolean flagExport, String tipoLista, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authtimesServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authtimesServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(timesServiceContextPath).path("lista");
			if (flagExport && tipoLista != null) {
				webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_FLAG_EXPORT, FlagHelper.convertFromFE(flagExport)).queryParam(VALUE_QUERYPARAMETER_TIPO_LISTA, tipoLista);
			}
			if (tipoProfilo!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			}
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(TempiAttraversamentoOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public TempiAttraversamentoOutputDTO getCrossingTimesMonitoringLevel1(boolean flagExport, String idTempiAttraversamento, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authtimesServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authtimesServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(timesServiceContextPath).path("dettaglio").path(idTempiAttraversamento);
			if (flagExport) {
				webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_FLAG_EXPORT, FlagHelper.convertFromFE(flagExport));
			}
			if (tipoProfilo!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			}
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(TempiAttraversamentoOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
