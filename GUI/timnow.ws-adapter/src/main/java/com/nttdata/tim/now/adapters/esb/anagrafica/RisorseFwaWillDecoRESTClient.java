package com.nttdata.tim.now.adapters.esb.anagrafica;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.anagraficafwawilldeco.DettaglioRisorsaFwaWillDecoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.anagraficafwawilldeco.ModificaRisorsaFwaWillDecoInputDTO;
import com.nttdata.tim.now.data.dto.anagraficafwawilldeco.NuovaRisorsaFwaWillDecoInputDTO;
import com.nttdata.tim.now.data.dto.anagraficafwawilldeco.RisorseFwaWillDecoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1335
@Component
public class RisorseFwaWillDecoRESTClient extends RestClientFacade {

	@Value("${rest.integration.anagrafica.risorse_fwa.list.contextpath}")
	private String listServiceContextPath;
	
	@Value("${auth.rest.integration.anagrafica.risorse_fwa.list.contextpath}")
	private String authListServiceContextPath;
	
	@Value("${rest.integration.anagrafica.risorse_fwa.details.contextpath}")
	private String detailsServiceContextPath;
	
	@Value("${auth.rest.integration.anagrafica.risorse_fwa.details.contextpath}")
	private String authDetailsServiceContextPath;
	
	@Value("${rest.integration.anagrafica.risorse_fwa.create.contextpath}")
	private String createServiceContextPath;
	
	@Value("${auth.rest.integration.anagrafica.risorse_fwa.create.contextpath}")
	private String authCreateServiceContextPath;
	
	@Value("${rest.integration.anagrafica.risorse_fwa.edit.contextpath}")
	private String editServiceContextPath;
	
	@Value("${auth.rest.integration.anagrafica.risorse_fwa.edit.contextpath}")
	private String authEditServiceContextPath;	
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	private static final String VALUE_QUERYPARAMETER_IDRISORSA = "idRisorsa";
	
	public RisorseFwaWillDecoWrapperOutputDTO list(String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authListServiceContextPath)) && (!isAuthorizedService(tipoProfilo,
				authListServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(listServiceContextPath);
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RisorseFwaWillDecoWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public EsitoDTO create(NuovaRisorsaFwaWillDecoInputDTO inputDto, String tipoProfilo) throws IntegrationLayerException {
        //call method for check authorization services 
		if ((StringUtils.isNotEmpty(authCreateServiceContextPath)) && (!isAuthorizedService(tipoProfilo, authCreateServiceContextPath, checkAuthorizationContextPath))){
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
		}
	    // endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(createServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public EsitoDTO edit(ModificaRisorsaFwaWillDecoInputDTO inputDto, String tipoProfilo) throws IntegrationLayerException {
        //call method for check authorization services 
		if ((StringUtils.isNotEmpty(authEditServiceContextPath)) && (!isAuthorizedService(tipoProfilo, authEditServiceContextPath, checkAuthorizationContextPath))){
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
		}
	    // endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(editServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public DettaglioRisorsaFwaWillDecoWrapperOutputDTO details(String idRisorsa, String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authDetailsServiceContextPath)) && (!isAuthorizedService(tipoProfilo, authDetailsServiceContextPath, checkAuthorizationContextPath))){
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
		}
		
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(detailsServiceContextPath).queryParam(VALUE_QUERYPARAMETER_IDRISORSA, idRisorsa);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(DettaglioRisorsaFwaWillDecoWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
