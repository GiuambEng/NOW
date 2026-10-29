package com.nttdata.tim.now.adapters.esb.ordine;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.ordine.donating.OrdineDonatingDetailListOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.donating.OrdineDonatingInputDTO;
import com.nttdata.tim.now.data.dto.ordine.donating.OrdineDonatingListOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrdineDonatingRESTClient extends RestClientFacade {

    @Value("${rest.integration.ordine.donating.search.contextpath}")
	private String listContextPath;
	
	@Value("${rest.integration.ordine.donating.detail.contextpath}")
	private String detailContextPath;

	@Value("${auth.rest.integration.ordine.donating.search.contextpath}")
	private String authlistContextPath;
	
	@Value("${auth.rest.integration.ordine.donating.detail.contextpath}")
	private String authdetailContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public OrdineDonatingListOutputDTO getList(OrdineDonatingInputDTO input, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authlistContextPath))
				&& (!isAuthorizedService(tipoProfilo, authlistContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(listContextPath).path(input.getTipoProfilo()).path(input.getCodificaAgcom());
			if (StringUtils.isNotBlank(input.getNomeFileNotifica())) {
				webTarget = webTarget.queryParam("nomeFileNotifica", input.getNomeFileNotifica());
			}
			if (StringUtils.isNotBlank(input.getCodiceOrdineTI())) {
				webTarget = webTarget.queryParam("codOrdineTI", input.getCodiceOrdineTI());
			}
			if (StringUtils.isNotBlank(input.getCodiceSessione())) {
				webTarget = webTarget.queryParam("codiceSessione", input.getCodiceSessione());
			}
			if (StringUtils.isNotBlank(input.getIdRisorsa())) {
				webTarget = webTarget.queryParam("idRisorsa", input.getIdRisorsa());
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(OrdineDonatingListOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public OrdineDonatingDetailListOutputDTO getDetailList(String idRichiestaOLO, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authdetailContextPath))
				&& (!isAuthorizedService(tipoProfilo, authdetailContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(detailContextPath).path(idRichiestaOLO).path(tipoProfilo);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(OrdineDonatingDetailListOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
}
