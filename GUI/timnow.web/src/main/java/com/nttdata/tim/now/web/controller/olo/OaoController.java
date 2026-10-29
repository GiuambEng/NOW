package com.nttdata.tim.now.web.controller.olo;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.olo.OaoManagerBL;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oaos")
public class OaoController extends GenericController {

    
    @Autowired
    private OaoManagerBL oaoManager;
    
	// VerificaOAOperAttivazione
	@JsonGetMapping("/checkActivationOao/{codOlo}/{offer}")
	public EsitoOutputBean checkActivationOao(@RequestParam(value = "idContratto", required = false) String idContratto,
			@PathVariable String codOlo, @PathVariable String offer, HttpSession session) throws BusinessLayerException {
		logger.info("check activation Oao");
		UserBean user = getCurrentUser(session);
		EsitoOutputBean bean = oaoManager.checkActivationOao(codOlo, offer, idContratto, user.getCodiceProfilo());
		return bean;
	}

	// VerificaOAOperCessazione
	@JsonGetMapping("/checkCessationOao/{codOlo}/{idResource}")
	public EsitoOutputBean checkCessationOao(@PathVariable String codOlo, @PathVariable String idResource, HttpSession session)
			throws BusinessLayerException {
		logger.info("check cessation Oao");
		UserBean user = getCurrentUser(session);
		EsitoOutputBean bean = oaoManager.checkCessationOao(codOlo, idResource, user.getCodiceProfilo());
		return bean;
	}

}
