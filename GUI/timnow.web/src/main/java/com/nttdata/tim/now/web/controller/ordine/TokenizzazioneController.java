package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.TokenizzazioneManagerBL;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.TokenizzazioneReferentiInputBean;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.TokenizzazioneReferentiWrapperOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RU_1084
@RestController
@RequestMapping("/tokenizzazione")
public class TokenizzazioneController extends GenericController {

	@Autowired
	private TokenizzazioneManagerBL tokenizzazioneManagerBL;
	
	// Referenti
	@JsonPostMapping("/referenti")
	public TokenizzazioneReferentiWrapperOutputBean tokenizzazioneReferenti(@RequestBody TokenizzazioneReferentiInputBean input, HttpSession session) throws BusinessLayerException {
		logger.info("Post tokenizzazione referenti");
		UserBean user = getCurrentUser(session);
		TokenizzazioneReferentiWrapperOutputBean output = tokenizzazioneManagerBL.tokenizzazioneReferenti(input, user);
		return output;
	}
		
}
