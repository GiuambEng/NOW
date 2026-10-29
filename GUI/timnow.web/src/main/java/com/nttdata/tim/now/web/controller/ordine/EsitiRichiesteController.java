package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.EsitiRichiesteManagerBL;
import com.nttdata.tim.now.data.bean.richiesta.EsitiRichiesteInputBean;
import com.nttdata.tim.now.data.bean.richiesta.EsitiRichiesteOutputBean;
import com.nttdata.tim.now.data.bean.richiesta.RecuperaNotificheRichiestaWrapperOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requests")
public class EsitiRichiesteController extends GenericController {

    @Autowired
    private EsitiRichiesteManagerBL esitiRichiesteManagerBL;
    
	// Ordine -> Visualizzazione Esiti Richieste
	@JsonGetMapping("/{idRichiesta:[A-Za-z0-9:_]+}")
	public EsitiRichiesteOutputBean getOutcomesRequests(@PathVariable String idRichiesta, HttpSession session)
			throws BusinessLayerException {
		logger.info("get outcomes requests");
		UserBean user = getCurrentUser(session);

		EsitiRichiesteOutputBean bean = esitiRichiesteManagerBL.getOutcomesRequets(idRichiesta, user.getCodiceProfilo(),user.getCodificaOloAgcom());
		bean = ensureBeanResult(bean, EsitiRichiesteOutputBean.class);

		return bean;
	}
	
	//RU_888
	// Ordine -> Visualizzazione notifiche richiesta
	@JsonGetMapping("/recuperanotificherichiesta/{idRichiesta:[A-Za-z0-9:_]+}")
	public RecuperaNotificheRichiestaWrapperOutputBean getNotificheRichiesta(@PathVariable String idRichiesta, HttpSession session)
			throws BusinessLayerException {
		logger.info("getNotificheRichiesta controller");
		UserBean user = getCurrentUser(session);

		RecuperaNotificheRichiestaWrapperOutputBean bean = esitiRichiesteManagerBL.getNotificheRichiesta(idRichiesta, user.getCodiceProfilo(),user.getCodificaOloAgcom());
		bean = ensureBeanResult(bean, RecuperaNotificheRichiestaWrapperOutputBean.class);

		return bean;
	}
	
	//SM_9693
	// Ordine -> Visualizzazione Esiti Richieste
	@JsonPostMapping("")
	public EsitiRichiesteOutputBean recuperaEsitiERichieste(@RequestBody EsitiRichiesteInputBean input, HttpSession session)
			throws BusinessLayerException {
		logger.info("get outcomes requests");
		UserBean user = getCurrentUser(session);

		EsitiRichiesteOutputBean bean = esitiRichiesteManagerBL.recuperaEsitiERichieste(input, user);
		bean = ensureBeanResult(bean, EsitiRichiesteOutputBean.class);

		return bean;
	}
	
}
