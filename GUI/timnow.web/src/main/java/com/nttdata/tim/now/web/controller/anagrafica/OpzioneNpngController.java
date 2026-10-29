package com.nttdata.tim.now.web.controller.anagrafica;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.anagrafica.OpzioneNpngManagerBL;
import com.nttdata.tim.now.data.bean.anagraficanpng.CampiAnagraficaNpngWrapperOutputBean;
import com.nttdata.tim.now.data.bean.anagraficanpng.ModificaOpzioneTrafficoInputBean;
import com.nttdata.tim.now.data.bean.anagraficanpng.ModificaOpzioneTrafficoOutputBean;
import com.nttdata.tim.now.data.bean.anagraficanpng.OpzioneTrafficoNpngWrapperOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

//RU_1203
//@RestController
//@RequestMapping("/opzioneNpng")
public class OpzioneNpngController extends GenericController {
	
	@Autowired
	private OpzioneNpngManagerBL opzioneNpngManagerBL;

	//RU_1394
	//@JsonGetMapping("/lista")
	public OpzioneTrafficoNpngWrapperOutputBean lista(HttpSession session)
			throws BusinessLayerException {
		logger.info("list NPNG options");
		UserBean currentUser = getCurrentUser(session);
		OpzioneTrafficoNpngWrapperOutputBean bean = opzioneNpngManagerBL.lista(currentUser.getCodiceProfilo());
		return bean;
	}
	
	//RU_1394
	//@JsonPostMapping("/modifica")
	public ModificaOpzioneTrafficoOutputBean modifica(@RequestBody ModificaOpzioneTrafficoInputBean input, HttpSession session)
			throws BusinessLayerException {
		logger.info("update NPNG option");
		UserBean currentUser = getCurrentUser(session);
		ModificaOpzioneTrafficoOutputBean bean = opzioneNpngManagerBL.modifica(input, currentUser.getUserId(), currentUser.getCodiceProfilo());
		return bean;
	}
	
	//RU_1394
	//@JsonGetMapping("/campiAnagrafica")
	public CampiAnagraficaNpngWrapperOutputBean campiAnagrafica(HttpSession session)
			throws BusinessLayerException {
		logger.info("get campi anagrafica NPNG option");
		UserBean currentUser = getCurrentUser(session);
		CampiAnagraficaNpngWrapperOutputBean bean = opzioneNpngManagerBL.recuperoCampi(currentUser.getCodiceProfilo());
		return bean;
	}
}
