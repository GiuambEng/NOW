package com.nttdata.tim.now.adapters.esb.ordine;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.dac.VerificaDacOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DacRESTClient extends RestClientFacade {

    private static final String VALUE_QUERYPARAMETER_FLAG_NP = "flagNP";
    private static final String VALUE_QUERYPARAMETER_SOTTOLAVORAZIONE = "sottolavorazione";
    
    //RU_920
    private static final String VALUE_QUERYPARAMETER_LAVORAZIONE = "lavorazione";
    private static final String VALUE_QUERYPARAMETER_ID_OFFERTA = "idOfferta";
    
	@Value("${rest.controls.dac.working.contextpath}")
	private String workingServiceContextPath;

	@Value("${rest.controls.dac.sla.contextpath}")
	private String slaServiceContextPath;

	@Value("${auth.rest.controls.dac.working.contextpath}")
	private String authworkingServiceContextPath;
	
	@Value("${auth.rest.controls.dac.sla.contextpath}")
	private String authslaServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	//RU_920
	public VerificaDacOutputDTO getWorkingDac(String dac, String lavorazione, String idOfferta, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authworkingServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authworkingServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(workingServiceContextPath).path(dac);
		//WebTarget webTarget = guiControlsRestClient.client.target("https://vt-masulloil.valueteam.com:8184").path(workingServiceContextPath).path(dac);
		
		//RU_920
		if(idOfferta != null && !idOfferta.equals("")) {
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_ID_OFFERTA, idOfferta);
		}
		if(lavorazione != null && !lavorazione.equals("")) {
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_LAVORAZIONE, lavorazione);
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaDacOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public VerificaDacOutputDTO getSLADac(String dac, String lavorazione, String idOfferta, String flagNP, String sottolavorazione, String tipoProfilo) throws IntegrationLayerException {
	    
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authslaServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authslaServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(slaServiceContextPath).path(dac).path(lavorazione).path(idOfferta);
		try {
		    if (flagNP != null) {
	            webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_FLAG_NP, flagNP);
		    }
		    if (!StringUtils.isEmpty(sottolavorazione) && sottolavorazione != null) {
		    	webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_SOTTOLAVORAZIONE, sottolavorazione);
		    }
	        Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaDacOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
