package com.nttdata.tim.now.adapters.esb.monitoraggio;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.monitoring.kogiornalieri.ListaAllarmiKoGiornalieriOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.kogiornalieri.ListaRichiesteAllarmiKoGiornalieriDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;
import com.nttdata.tim.now.util.FlagHelper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AllarmiKoGiornalieriRESTClient extends RestClientFacade {
	private static final String FLAG_EXPORT = "flagExport";

	@Value("${rest.pps.administration.alarm.contextpath}")
	private String serviceContextPath;

	@Value("${auth.rest.pps.administration.alarm.contextpath}")
	private String authserviceContextPath;

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	private static final String VALUE_QUERYPARAMETER_USERID = "userId";
	private static final String VALUE_QUERYPARAMETER_TIPOPROFILO = "tipoProfilo";

	public ListaAllarmiKoGiornalieriOutputDTO getAlarmsLevel0(boolean flagExport, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(serviceContextPath).queryParam(FLAG_EXPORT, FlagHelper.convertFromFE(flagExport));
			if (tipoProfilo!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			}
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaAllarmiKoGiornalieriOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaRichiesteAllarmiKoGiornalieriDTO getAlarmsLevel1(String ambito, String codCausaleOlo, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(serviceContextPath).path(ambito).path(codCausaleOlo);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaRichiesteAllarmiKoGiornalieriDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
