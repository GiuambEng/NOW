package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.LavorazioneManualeManagerBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//RU_1492
@RestController
@RequestMapping("/lavorazioneManuale")
public class LavorazioneManualeController extends GenericController {

	@Autowired
	private LavorazioneManualeManagerBL lavorazioneManualeManagerBL;

	@JsonGetMapping("/scarta")
	public EmptyBean scarta(@RequestParam String idRichiestaOlo, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		EmptyBean bean = lavorazioneManualeManagerBL.scarta(user.getCodiceProfilo(), idRichiestaOlo);
		return bean;
	}

	@JsonGetMapping("/risottometti")
	public EmptyBean risottometti(@RequestParam String idRichiestaOlo, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		EmptyBean bean = lavorazioneManualeManagerBL.risottometti(user.getCodiceProfilo(), idRichiestaOlo);
		return bean;
	}

	@JsonGetMapping("/modifica")
	public EmptyBean modifica(@RequestParam String idRichiestaOlo, @RequestParam(required = false) String idBuilding, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		EmptyBean bean = lavorazioneManualeManagerBL.modifica(user.getCodiceProfilo(), idRichiestaOlo, idBuilding);		
		return bean;
	}
}
