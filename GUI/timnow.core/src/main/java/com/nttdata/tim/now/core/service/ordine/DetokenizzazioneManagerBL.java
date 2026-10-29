package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.DetokenizzazioneRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.DetokenizzaXmlInputBean;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.DetokenizzazioneNotificaInputBean;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.DetokenizzazioneNotificaWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.DetokenizzazioneReferentiInputBean;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.DetokenizzazioneReferentiWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.DetokenizzazioneXmlOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.DetokenizzaXmlInputDTO;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.DetokenizzazioneNotificaInputDTO;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.DetokenizzazioneNotificaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.DetokenizzazioneReferentiInputDTO;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.DetokenizzazioneReferentiWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.DetokenizzazioneXmlOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1084
@Service
public class DetokenizzazioneManagerBL extends AbstractBL {
	
	@Autowired
	private DetokenizzazioneRESTClient detokenizzazioneRestClient;

	public DetokenizzazioneReferentiWrapperOutputBean detokenizzazioneReferenti(DetokenizzazioneReferentiInputBean input, UserBean user) throws BusinessLayerException {
		DetokenizzazioneReferentiWrapperOutputBean output = new DetokenizzazioneReferentiWrapperOutputBean();
		try {			
			DetokenizzazioneReferentiWrapperOutputDTO outputDTO = new DetokenizzazioneReferentiWrapperOutputDTO();
			
			//Valorizzazione dell' IP client
			if(user != null && user.getRequestInfo() != null && user.getRequestInfo().getIpClient() != null) {
				input.setIpClient(user.getRequestInfo().getIpClient());
				input.setOperatore(user.getUserId());
			}		
			DetokenizzazioneReferentiInputDTO inputDTO = mapper.translate(input, DetokenizzazioneReferentiInputDTO.class);
			outputDTO = detokenizzazioneRestClient.detokenizzazioneReferenti(inputDTO);			
			output = mapper.translate(outputDTO, DetokenizzazioneReferentiWrapperOutputBean.class);
			
		} catch (IntegrationLayerException e) {
            logger.error("Error detokenizzazione referenti", e);
            throw new BusinessLayerException(e);
		}
		
		return output;
	}
	
	//SM_9686
	//SM_10516
	public DetokenizzazioneXmlOutputBean detokenizzazioneXml(DetokenizzaXmlInputBean input, UserBean user) throws BusinessLayerException {
		DetokenizzazioneXmlOutputBean output = new DetokenizzazioneXmlOutputBean();
		try {			
			DetokenizzazioneXmlOutputDTO outputDTO = new DetokenizzazioneXmlOutputDTO();
			
			//Valorizzazione dell' IP client
			if(user != null && user.getRequestInfo() != null && user.getRequestInfo().getIpClient() != null) {
				input.setIpClient(user.getRequestInfo().getIpClient());
				input.setOperatore(user.getUserId());
			}		
			DetokenizzaXmlInputDTO inputDTO = mapper.translate(input, DetokenizzaXmlInputDTO.class);
			outputDTO = detokenizzazioneRestClient.detokenizzazioneXml(inputDTO);			
			output = mapper.translate(outputDTO, DetokenizzazioneXmlOutputBean.class);
			
		} catch (IntegrationLayerException e) {
            logger.error("Error detokenizzazione xml", e);
            throw new BusinessLayerException(e);
		}
		
		return output;
	}
	
	//SM_9693
	public DetokenizzazioneNotificaWrapperOutputBean detokenizzazioneNotifica(DetokenizzazioneNotificaInputBean input, UserBean user) throws BusinessLayerException {
		DetokenizzazioneNotificaWrapperOutputBean output = new DetokenizzazioneNotificaWrapperOutputBean();
		try {			
			DetokenizzazioneNotificaWrapperOutputDTO outputDTO = new DetokenizzazioneNotificaWrapperOutputDTO();
			
			//Valorizzazione dell' IP client
			if(user != null && user.getRequestInfo() != null && user.getRequestInfo().getIpClient() != null) {
				input.setIpClient(user.getRequestInfo().getIpClient());
				input.setOperatore(user.getUserId());
			}		
			DetokenizzazioneNotificaInputDTO inputDTO = mapper.translate(input, DetokenizzazioneNotificaInputDTO.class);	
			outputDTO = detokenizzazioneRestClient.detokenizzazioneNotifica(inputDTO);			
			output = mapper.translate(outputDTO, DetokenizzazioneNotificaWrapperOutputBean.class);
			
		} catch (IntegrationLayerException e) {
            logger.error("Error detokenizzazione notifica", e);
            throw new BusinessLayerException(e);
		}		
		return output;
	}

}
