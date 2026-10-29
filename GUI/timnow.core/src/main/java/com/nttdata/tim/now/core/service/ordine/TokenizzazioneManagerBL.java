package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.TokenizzazioneRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.TokenizzazioneReferentiInputBean;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.TokenizzazioneReferentiWrapperOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.TokenizzazioneReferentiInputDTO;
import com.nttdata.tim.now.data.dto.ordine.tokenizzazione.TokenizzazioneReferentiWrapperOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1084
@Service
public class TokenizzazioneManagerBL extends AbstractBL {
	
	@Autowired
	private TokenizzazioneRESTClient tokenizzazioneRestClient;

	public TokenizzazioneReferentiWrapperOutputBean tokenizzazioneReferenti(TokenizzazioneReferentiInputBean input, UserBean user) throws BusinessLayerException {
		TokenizzazioneReferentiWrapperOutputBean output = new TokenizzazioneReferentiWrapperOutputBean();
		try {			
			TokenizzazioneReferentiWrapperOutputDTO outputDTO = new TokenizzazioneReferentiWrapperOutputDTO();
			
			//Valorizzazione dell' IP client
			if(user != null && user.getRequestInfo() != null && user.getRequestInfo().getIpClient() != null) {
				input.setIpClient(user.getRequestInfo().getIpClient());
				input.setOperatore(user.getUserId());
			}		
			TokenizzazioneReferentiInputDTO inputDTO = mapper.translate(input, TokenizzazioneReferentiInputDTO.class);
			outputDTO = tokenizzazioneRestClient.tokenizzazioneReferenti(inputDTO);			
			output = mapper.translate(outputDTO, TokenizzazioneReferentiWrapperOutputBean.class);
			
		} catch (IntegrationLayerException e) {
            logger.error("Error tokenizzazione referenti", e);
            throw new BusinessLayerException(e);
		}
		
		return output;
	}

}
