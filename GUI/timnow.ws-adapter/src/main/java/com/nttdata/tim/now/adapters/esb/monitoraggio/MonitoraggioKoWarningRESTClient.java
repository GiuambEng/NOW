package com.nttdata.tim.now.adapters.esb.monitoraggio;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.monitoring.warning.ListaDettagliMonitoraggioKoWarningOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.warning.ListaMonitoraggiKoWarningOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.warning.ListaRichiesteMonitoraggioKoWarningOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;
import com.nttdata.tim.now.util.FlagHelper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MonitoraggioKoWarningRESTClient extends RestClientFacade {
	private static final String VALUE_QUERYPARAMETER_FLAG_EXPORT = "flagExport";

	@Value("${rest.pps.monitoring.warning.ko.list.contextpath}")
	private String koWarningServiceContextPath;

	@Value("${rest.pps.monitoring.warning.ko.detail.contextpath}")
	private String detailKoWarningServiceContextPath;

	@Value("${auth.rest.pps.monitoring.warning.ko.list.contextpath}")
	private String authkoWarningServiceContextPath;

	@Value("${auth.rest.pps.monitoring.warning.ko.detail.contextpath}")
	private String authdetailKoWarningServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	private static final String VALUE_QUERYPARAMETER_USERID = "userId";

	public ListaMonitoraggiKoWarningOutputDTO getKoWarningMonitoringLevel0(boolean flagExport, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authkoWarningServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authkoWarningServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(koWarningServiceContextPath).queryParam(VALUE_QUERYPARAMETER_FLAG_EXPORT, FlagHelper.convertFromFE(flagExport));
		if (userId!=null){
		    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaMonitoraggiKoWarningOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaDettagliMonitoraggioKoWarningOutputDTO getKoWarningMonitoringLevel1(String dataOperazione, String causale, boolean flagExport, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authkoWarningServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authkoWarningServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(koWarningServiceContextPath).path(dataOperazione).queryParam(VALUE_QUERYPARAMETER_FLAG_EXPORT, FlagHelper.convertFromFE(flagExport)).path(causale);
		if (userId!=null){
		    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaDettagliMonitoraggioKoWarningOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaRichiesteMonitoraggioKoWarningOutputDTO getKoWarningMonitoringLevel2(String dataAggiornamento, String codCausaleOLO, String tipoErrore, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authdetailKoWarningServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authdetailKoWarningServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(detailKoWarningServiceContextPath).path(dataAggiornamento).path(codCausaleOLO).path(tipoErrore);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaRichiesteMonitoraggioKoWarningOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
