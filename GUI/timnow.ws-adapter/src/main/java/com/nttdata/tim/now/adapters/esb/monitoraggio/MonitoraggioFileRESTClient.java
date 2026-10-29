package com.nttdata.tim.now.adapters.esb.monitoraggio;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.monitoring.file.ContatoreMonitoraggioFileInputDTO;
import com.nttdata.tim.now.data.dto.monitoring.file.DettaglioMonitoraggioFileOutputWrapperDTO;
import com.nttdata.tim.now.data.dto.monitoring.file.ListaContatoriMonitoraggioFileOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.file.MonitoraggioFileOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;
import com.nttdata.tim.now.util.FlagHelper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MonitoraggioFileRESTClient extends RestClientFacade {
	private static final String VALUE_QUERYPARAMETER_FLAG_EXPORT = "flagExport";

	@Value("${rest.pps.monitoraggio.file.list.contextpath}")
	private String listaServiceContextPath;
	
	@Value("${rest.pps.monitoraggio.file.contatore.contextpath}")
	private String contatoriServiceContextPath;
	
	@Value("${rest.pps.monitoraggio.file.dettaglio.contextpath}")
	private String dettaglioServiceContextPath;

	@Value("${auth.rest.pps.monitoraggio.file.list.contextpath}")
	private String authlistaServiceContextPath;
	
	@Value("${auth.rest.pps.monitoraggio.file.contatore.contextpath}")
	private String authcontatoriServiceContextPath;
	
	@Value("${auth.rest.pps.monitoraggio.file.dettaglio.contextpath}")
	private String authdettaglioServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	private static final String VALUE_QUERYPARAMETER_USERID = "userId";
	private static final String VALUE_QUERYPARAMETER_TIPOPROFILO = "tipoProfilo";

	public MonitoraggioFileOutputDTO getLista(boolean flagExport, String tipoProfilo, String userId) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authlistaServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authlistaServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(listaServiceContextPath);
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
			return response.readEntity(MonitoraggioFileOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaContatoriMonitoraggioFileOutputDTO getContatori(ContatoreMonitoraggioFileInputDTO body, String tipoProfilo, String userId)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authcontatoriServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authcontatoriServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(contatoriServiceContextPath);
			if (tipoProfilo!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_TIPOPROFILO, tipoProfilo);
			}
			if (userId!=null){
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaContatoriMonitoraggioFileOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public DettaglioMonitoraggioFileOutputWrapperDTO getDettaglio(String idFileProcessato, String tipoContatore, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authdettaglioServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authdettaglioServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(dettaglioServiceContextPath)
					.path(idFileProcessato).path(tipoContatore);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(DettaglioMonitoraggioFileOutputWrapperDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
