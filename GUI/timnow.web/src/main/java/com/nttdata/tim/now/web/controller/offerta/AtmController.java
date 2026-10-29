package com.nttdata.tim.now.web.controller.offerta;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.offerta.AtmManagerBL;
import com.nttdata.tim.now.data.bean.atm.KitAtmOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atms")
public class AtmController extends GenericController {
    
    @Autowired
    private AtmManagerBL atmManagerBL;

	// Visualizzazione Kit Atm -> Visualizzazione Kit Atm
	@JsonGetMapping
	public GenericListBean<KitAtmOutputBean> getKitAtm(HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session); 
		GenericListBean<KitAtmOutputBean> bean = atmManagerBL.getKitAtm(user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Ricerca Avanzata
	@JsonPostMapping("/search")
	public GenericListBean<KitAtmOutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session); 
		GenericListBean<KitAtmOutputBean> bean = atmManagerBL.advancedSearch(body, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

}
