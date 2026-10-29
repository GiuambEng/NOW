package com.nttdata.tim.now.adapters.esb.monitoraggio;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.monitoring.koolo.ListaDettaglioMonitoraggioKoOloOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.koolo.ListaMonitoraggiiKoOloOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;
import com.nttdata.tim.now.util.FlagHelper;
import com.nttdata.tim.now.util.date.DateHelper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MonitoraggioKoOloRESTClient extends RestClientFacade {

	private static final String FLAG_EXPORT = "flagExport";
	private static final String TOT = "TOT";

	@Value("${rest.pps.monitoring.olo.ko.contextpath}")
	private String koOloServiceContextPath;

	@Value("${auth.rest.pps.monitoring.olo.ko.contextpath}")
	private String authkoOloServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	private static final String VALUE_QUERYPARAMETER_USERID = "userId";
	private static final String VALUE_QUERYPARAMETER_TIPOPROFILO = "tipoProfilo";

    public ListaMonitoraggiiKoOloOutputDTO getKoOloMonitoringLevel0(boolean flagExport, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authkoOloServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authkoOloServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(koOloServiceContextPath).path("scartiaggregati");
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
			return response.readEntity(ListaMonitoraggiiKoOloOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaDettaglioMonitoraggioKoOloOutputDTO getKoOloMonitoringLevel1(String famiglia, String causale, String dataTotale, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authkoOloServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authkoOloServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(koOloServiceContextPath).path("richieste").path(famiglia).path(causale);
			if (dataTotale != null) {
				webTarget = webTarget.path(DateHelper.convertFromFE(dataTotale));
			} else {
				webTarget = webTarget.path(TOT);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaDettaglioMonitoraggioKoOloOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
