package com.nttdata.tim.now.adapters.esb.anagrafica;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.radius.ListaRadiusOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

@Component
public class RadiusRESTClient extends RestClientFacade {
	
	@Value("${rest.integration.radius.contextpath}")
	private String anagraficaRadiusServiceContextPath;

	@Value("${auth.rest.integration.radius.contextpath}")
	private String authAnagraficaRadiusServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	private static final String VALUE_QUERYPARAMETER_USERID = "userId";

	public ListaRadiusOutputDTO getRadiusList(String codOloAgcom, String tipoProfilo, String userId) throws IntegrationLayerException {
		try {
			checkAuthorizationService(authAnagraficaRadiusServiceContextPath, checkAuthorizationContextPath, tipoProfilo);
			
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(anagraficaRadiusServiceContextPath).path(codOloAgcom).path(tipoProfilo);
			if (userId!=null & !userId.isEmpty()) {
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaRadiusOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
    public ListaRadiusOutputDTO advancedSearch(AdvancedResearchInputDTO body, String codOloAgcom, String tipoProfilo, String userId) throws IntegrationLayerException {
	     try {
	    	 checkAuthorizationService(authAnagraficaRadiusServiceContextPath, checkAuthorizationContextPath, tipoProfilo);
	    	 WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(anagraficaRadiusServiceContextPath).path(codOloAgcom).path(tipoProfilo);
	    	 if (userId!=null) {
			    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
	    	 }
	         Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
	         checkStatus(response);
	         return response.readEntity(ListaRadiusOutputDTO.class);
	     } catch (Exception e) {
	         throw new IntegrationLayerException(e);
	     }
    }	
}
