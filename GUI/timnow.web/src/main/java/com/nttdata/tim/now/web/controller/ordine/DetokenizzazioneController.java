package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.DetokenizzazioneManagerBL;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.DetokenizzaXmlInputBean;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.DetokenizzazioneNotificaInputBean;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.DetokenizzazioneNotificaWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.DetokenizzazioneReferentiInputBean;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.DetokenizzazioneReferentiWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.tokenizzazione.DetokenizzazioneXmlOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RU_1084
@RestController
@RequestMapping("/detokenizzazione")
public class DetokenizzazioneController extends GenericController {

	@Autowired
	private DetokenizzazioneManagerBL detokenizzazioneManagerBL;
	
	// Referenti
	@JsonPostMapping("/referenti")
	public DetokenizzazioneReferentiWrapperOutputBean detokenizzazioneReferenti(@RequestBody DetokenizzazioneReferentiInputBean input, HttpSession session) throws BusinessLayerException {
		logger.info("Post detokenizzazione referenti");
		UserBean user = getCurrentUser(session);
		DetokenizzazioneReferentiWrapperOutputBean output = detokenizzazioneManagerBL.detokenizzazioneReferenti(input, user);
		return output;
	}
		
	// SM_9686
	//SM_10516
	@JsonPostMapping("/xml")
	public DetokenizzazioneXmlOutputBean detokenizzazioneXml(@RequestBody DetokenizzaXmlInputBean input, HttpSession session) throws BusinessLayerException {
		logger.info("Post detokenizzazione xml");
		UserBean user = getCurrentUser(session);
		DetokenizzazioneXmlOutputBean output = detokenizzazioneManagerBL.detokenizzazioneXml(input, user);
		return output;
	}
	
	//SM_9693
	@JsonPostMapping("/notifica")
	public DetokenizzazioneNotificaWrapperOutputBean detokenizzazioneNotifica(@RequestBody DetokenizzazioneNotificaInputBean input, HttpSession session) throws BusinessLayerException {
		logger.info("Post detokenizzazione notifica");
		UserBean user = getCurrentUser(session);
		DetokenizzazioneNotificaWrapperOutputBean output = detokenizzazioneManagerBL.detokenizzazioneNotifica(input, user);
		return output;
	}
}
