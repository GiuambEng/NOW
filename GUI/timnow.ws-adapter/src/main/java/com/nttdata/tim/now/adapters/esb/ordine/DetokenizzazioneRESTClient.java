package com.nttdata.tim.now.adapters.esb.ordine;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.DetokenizzaXmlInputDTO;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.DetokenizzazioneNotificaInputDTO;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.DetokenizzazioneNotificaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.DetokenizzazioneReferentiInputDTO;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.DetokenizzazioneReferentiWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.DetokenizzazioneXmlOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1084
@Component
public class DetokenizzazioneRESTClient extends RestClientFacade {
    
	@Value("${rest.order.detokenizzazione.referenti.contextpath}")
	private String detokenizzazioneReferentiContextPath;
	
	//SM_9651
	@Value("${rest.order.detokenizzazione.notifiche.contextpath}")
	private String detokenizzazioneNotificheContextPath;
	
	//SM_9686
	@Value("${rest.order.detokenizzazione.xml.contextpath}")
	private String detokenizzazioneXmlContextPath;
	
	public DetokenizzazioneReferentiWrapperOutputDTO detokenizzazioneReferenti(DetokenizzazioneReferentiInputDTO inputDTO) throws IntegrationLayerException {
	    
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(detokenizzazioneReferentiContextPath);	
		
		try {
	        Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDTO, MediaType.APPLICATION_JSON_TYPE));			
			return response.readEntity(DetokenizzazioneReferentiWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//SM_9686
	//SM_10516
	public DetokenizzazioneXmlOutputDTO detokenizzazioneXml(DetokenizzaXmlInputDTO inputDTO) throws IntegrationLayerException {
	    
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(detokenizzazioneXmlContextPath);
			
		try {
	        Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDTO, MediaType.APPLICATION_JSON_TYPE));			
			return response.readEntity(DetokenizzazioneXmlOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//SM_9693
	public DetokenizzazioneNotificaWrapperOutputDTO detokenizzazioneNotifica(DetokenizzazioneNotificaInputDTO inputDTO) throws IntegrationLayerException {
	    
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(detokenizzazioneNotificheContextPath);		
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDTO, MediaType.APPLICATION_JSON_TYPE));				
			return response.readEntity(DetokenizzazioneNotificaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
