package com.nttdata.tim.now.adapters.esb.reporthashing;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.ordine.hashing.CreazioneReportInputDTO;
import com.nttdata.tim.now.data.dto.ordine.hashing.DettaglioReportOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.hashing.ReportWrapperOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//R1F-21-0411
@Component
public class ReportHashingRESTClient extends RestClientFacade {

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	@Value("${rest.order.reporthash.nuovo_report.contextpath}")
	private String nuovoReportContextPath;

	@Value("${auth.rest.order.reporthash.nuovo_report.contextpath}")
	private String authNuovoReportContextPath;
	
	@Value("${rest.order.reporthash.lista_report.contextpath}")
	private String listaReportContextPath;

	@Value("${auth.rest.order.reporthash.lista_report.contextpath}")
	private String authListaReportContextPath;
	
	@Value("${rest.order.reporthash.dettaglio_lista_report.contextpath}")
	private String dettaglioListaReportContextPath;

	@Value("${auth.rest.order.reporthash.dettaglio_lista_report.contextpath}")
	private String authDettaglioListaReportContextPath;
	
	private final String ID_REPORT_QUERY_PARAM = "idReport";
	private final String TIPO_LISTA_QUERY_PARAM = "tipoLista";


	public ESBResultDTO creazioneReport(CreazioneReportInputDTO dto, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authNuovoReportContextPath))
				&& (!isAuthorizedService(tipoProfilo, authNuovoReportContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(nuovoReportContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(dto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ESBResultDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public ReportWrapperOutputDTO listaReport(String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authListaReportContextPath))
				&& (!isAuthorizedService(tipoProfilo, authListaReportContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(listaReportContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ReportWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public DettaglioReportOutputDTO dettaglioReport(String idReport, String tipoLista, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authDettaglioListaReportContextPath))
				&& (!isAuthorizedService(tipoProfilo, authDettaglioListaReportContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(dettaglioListaReportContextPath)
								.queryParam(ID_REPORT_QUERY_PARAM, idReport)
								.queryParam(TIPO_LISTA_QUERY_PARAM, tipoLista);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(DettaglioReportOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
