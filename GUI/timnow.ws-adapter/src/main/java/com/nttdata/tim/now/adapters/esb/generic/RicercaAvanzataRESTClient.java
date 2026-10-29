package com.nttdata.tim.now.adapters.esb.generic;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.ricerca.FieldsResearchListDTO;
import com.nttdata.tim.now.data.dto.save.SaveResearchGetOutputDTO;
import com.nttdata.tim.now.data.dto.save.SaveResearchListDTO;
import com.nttdata.tim.now.data.dto.save.SaveResearchPostInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RicercaAvanzataRESTClient extends RestClientFacade {

    @Value("${rest.integration.save.contextpath}")
    private String searchContextPath;

    @Value("${rest.integration.delete.contextpath}")
    private String deleteSearchContextPath;
    
    @Value("${rest.integration.research.contextpath}")
    private String fieldSearchContextPath;
    
    private final String FLAG_HASHING_QUERY_PARAM = "flagHashing";

    //R1F-21-0411
    public FieldsResearchListDTO getFieldsResearch(String tipoLista, String codiceProfilo, String flagHashing) throws IntegrationLayerException {
        WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(fieldSearchContextPath).path(tipoLista).path(codiceProfilo);
        try {
        	
        	//R1F-21-0411
        	if(flagHashing != null && flagHashing != "") {
        		webTarget = webTarget.queryParam(FLAG_HASHING_QUERY_PARAM, flagHashing);
        	}
        	
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(FieldsResearchListDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    public SaveResearchGetOutputDTO getSaveResearch(String userId, String codFunzione) throws IntegrationLayerException {
        WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(searchContextPath).path(userId).path(codFunzione);
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(SaveResearchGetOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    public ESBResultDTO createSaveResearch(SaveResearchListDTO dtoInput, String userId, String codFunzione) throws IntegrationLayerException {
        WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(searchContextPath).path(userId).path(codFunzione);
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(dtoInput, MediaType.APPLICATION_JSON_TYPE));
            checkStatus(response);
            return response.readEntity(ESBResultDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    public ESBResultDTO createSaveResearch(SaveResearchPostInputDTO dtoInput, String userId, String codFunzione) throws IntegrationLayerException {
        WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(searchContextPath).path(userId).path(codFunzione);
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(dtoInput, MediaType.APPLICATION_JSON_TYPE));
            checkStatus(response);
            return response.readEntity(ESBResultDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    //change for RU 532 from delete to get e invertito ordine userid e codfunzione
    public ESBResultDTO deleteSaveResearch(String userId, String codFunzione, String nomeFiltro) throws IntegrationLayerException {
        WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(deleteSearchContextPath).path(codFunzione).path(userId).queryParam("nome_filtro",
                nomeFiltro);
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(ESBResultDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }
}
