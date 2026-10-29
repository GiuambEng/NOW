package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.SlaManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.sla.SlaTimeOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Amministrazione -> Visualizzazione SLA Time 
@RestController
@RequestMapping("/slas")
public class SlaController extends GenericController {

    @Autowired
    private SlaManagerBL slaManagerBL;
    
	@JsonGetMapping
	public GenericListBean<SlaTimeOutputBean> getSlaTime(HttpSession session) throws BusinessLayerException {
		logger.info("get sla time");
		UserBean user = getCurrentUser(session);
		GenericListBean<SlaTimeOutputBean> bean = slaManagerBL.getSlaTime(user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Ricerca Avanzata
	@JsonPostMapping("/search")
	public GenericListBean<SlaTimeOutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<SlaTimeOutputBean> bean = slaManagerBL.advancedSearch(body, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

}
