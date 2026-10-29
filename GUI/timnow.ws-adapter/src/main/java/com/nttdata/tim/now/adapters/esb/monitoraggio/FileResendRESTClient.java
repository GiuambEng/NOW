package com.nttdata.tim.now.adapters.esb.monitoraggio;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.codice.ListaCodiceOutputDTO;
import com.nttdata.tim.now.data.dto.file.ListaFileDTO;
import com.nttdata.tim.now.data.dto.file.ListaFileScaricatiDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileResendRESTClient extends RestClientFacade {

	@Value("${rest.pps.reinviofile.contextpath}")
	private String resendServiceContextPath;
	
	@Value("${rest.pps.reinviofile.listafile.contextpath}")
	private String listServiceContextPath;

	@Value("${auth.rest.pps.reinviofile.contextpath}")
	private String authresendServiceContextPath;
	
	@Value("${auth.rest.pps.reinviofile.listafile.contextpath}")
	private String authlistServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public ListaCodiceOutputDTO requestResendFile(ListaFileScaricatiDTO body, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authresendServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authresendServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(resendServiceContextPath);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaCodiceOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaFileDTO advancedSearch(AdvancedResearchInputDTO dto, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authlistServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authlistServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(listServiceContextPath);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(dto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaFileDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
