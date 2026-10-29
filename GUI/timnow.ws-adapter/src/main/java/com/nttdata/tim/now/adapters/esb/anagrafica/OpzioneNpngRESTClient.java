package com.nttdata.tim.now.adapters.esb.anagrafica;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.anagraficanpng.CampiAnagraficaNpngWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.anagraficanpng.ModificaOpzioneTrafficoInputDTO;
import com.nttdata.tim.now.data.dto.anagraficanpng.ModificaOpzioneTrafficoOutputDTO;
import com.nttdata.tim.now.data.dto.anagraficanpng.OpzioneTrafficoNpngWrapperOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1203
@Component
public class OpzioneNpngRESTClient extends RestClientFacade {

	@Value("${rest.integration.npng.lista.contextpath}")
	private String listaOpzioniTrafficoContextPath;
	
	@Value("${rest.integration.npng.modifica.contextpath}")
	private String modificaOpzioneTrafficoContextPath;
	
	@Value("${rest.integration.npng.recupero_campi.contextpath}")
	private String recuperoCampiContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	@Value("${auth.rest.integration.npng.lista.contextpath}")
	private String authListaOpzioniTrafficoContextPath;
	
	@Value("${auth.rest.integration.npng.modifica.contextpath}")
	private String authModificaOpzioneTrafficoContextPath;
	
	@Value("${auth.rest.integration.npng.recupero_campi.contextpath}")
	private String authRecuperoCampiContextPath;	
	
	
	public OpzioneTrafficoNpngWrapperOutputDTO lista(String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authListaOpzioniTrafficoContextPath))
				&& (!isAuthorizedService(tipoProfilo, authListaOpzioniTrafficoContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(listaOpzioniTrafficoContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(OpzioneTrafficoNpngWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public ModificaOpzioneTrafficoOutputDTO modifica(ModificaOpzioneTrafficoInputDTO inputDto, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authModificaOpzioneTrafficoContextPath))
				&& (!isAuthorizedService(tipoProfilo, authModificaOpzioneTrafficoContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(modificaOpzioneTrafficoContextPath);
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ModificaOpzioneTrafficoOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public CampiAnagraficaNpngWrapperOutputDTO recuperoCampi(String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authRecuperoCampiContextPath))
				&& (!isAuthorizedService(tipoProfilo, authRecuperoCampiContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(recuperoCampiContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(CampiAnagraficaNpngWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
