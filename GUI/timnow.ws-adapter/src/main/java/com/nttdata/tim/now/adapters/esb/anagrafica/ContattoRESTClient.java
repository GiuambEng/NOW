package com.nttdata.tim.now.adapters.esb.anagrafica;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.contatto.ListaContattiOutputDTO;
import com.nttdata.tim.now.data.dto.contatto.ListaRiferimentiContattoOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ContattoRESTClient extends RestClientFacade {

    @Value("${rest.order.contact_list.contextpath}")
    private String contactListServiceContextPath;

    @Value("${rest.order.contact_references.contextpath}")
    private String contactReferencesServiceContextPath;

    @Value("${auth.rest.order.contact_list.contextpath}")
    private String authcontactListServiceContextPath;
    
    @Value("${auth.rest.order.contact_references.contextpath}")
    private String authcontactReferencesServiceContextPath;

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	private static final String VALUE_QUERYPARAMETER_USERID = "userId";

    public ListaContattiOutputDTO getContacts(String codOlo, String tipoProfilo, String userId) throws IntegrationLayerException {
	       //call method for check authorization services 
			if ((StringUtils.isNotEmpty(authcontactListServiceContextPath))&&(!isAuthorizedService(tipoProfilo, authcontactListServiceContextPath, checkAuthorizationContextPath))){
				throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
			}
	        // endCheck
        WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(contactListServiceContextPath).path(codOlo).path(tipoProfilo);
		if (userId!=null){
		    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
		}
       try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(ListaContattiOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    public ListaRiferimentiContattoOutputDTO getReferences(String idContact, String tipoProfilo) throws IntegrationLayerException {
	       //call method for check authorization services 
			if ((StringUtils.isNotEmpty(authcontactReferencesServiceContextPath))&&(!isAuthorizedService(tipoProfilo, authcontactReferencesServiceContextPath, checkAuthorizationContextPath))){
				throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
			}
	        // endCheck
        WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(contactReferencesServiceContextPath).path(idContact);
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(ListaRiferimentiContattoOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    public ListaContattiOutputDTO advancedSearch(AdvancedResearchInputDTO body, String codOloAgcom, String tipoProfilo, String userId) throws IntegrationLayerException {
	       //call method for check authorization services 
			if ((StringUtils.isNotEmpty(authcontactListServiceContextPath))&&(!isAuthorizedService(tipoProfilo, authcontactListServiceContextPath, checkAuthorizationContextPath))){
				throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
			}
	        // endCheck
        WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(contactListServiceContextPath).path(codOloAgcom).path(tipoProfilo);
		if (userId!=null){
		    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
		}
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
            checkStatus(response);
            return response.readEntity(ListaContattiOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }
}
