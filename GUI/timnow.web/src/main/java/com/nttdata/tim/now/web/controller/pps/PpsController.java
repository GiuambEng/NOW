package com.nttdata.tim.now.web.controller.pps;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.pps.PpsManagerBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.pps.AmbitoMonitoraggioOutputBean;
import com.nttdata.tim.now.data.bean.pps.AmministrazioneDatiOutputBean;
import com.nttdata.tim.now.data.bean.pps.DettaglioAmministrazioneDatiOutputBean;
import com.nttdata.tim.now.data.bean.pps.SogliaInputBean;
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
@RequestMapping("/ppsmonitorings")
public class PpsController extends GenericController {

    @Autowired
    private PpsManagerBL ppsManagerBL;
    
	// GUI_AmministrazioneDati
	@JsonGetMapping("/{ambito:[A-Za-z0-9:_\\. ]+}")
	public GenericListBean<AmministrazioneDatiOutputBean> getResearch(@PathVariable String ambito, HttpSession session) throws BusinessLayerException {
		logger.info("get research");
		UserBean user = getCurrentUser(session);
		GenericListBean<AmministrazioneDatiOutputBean> bean = ppsManagerBL.getReportTypes(ambito, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// GUI AmministrazioneDati -> VisualizzazioneDettaglio
	@JsonGetMapping("/{ambito:[A-Za-z0-9:_\\. ]+}/{report:[A-Za-z0-9:_\\. ]+}")
	public GenericListBean<DettaglioAmministrazioneDatiOutputBean> getDetail(@PathVariable String ambito, @PathVariable String report, HttpSession session)
			throws BusinessLayerException {
		logger.info("get detail");
		UserBean user = getCurrentUser(session);
		GenericListBean<DettaglioAmministrazioneDatiOutputBean> bean = ppsManagerBL.getPPSParameters(ambito, report, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// GUI AmministrazioneDati -> Editing
	//change for RU_532 from put to post 
	@JsonPostMapping
	public EmptyBean edit(@RequestBody SogliaInputBean body, HttpSession session) throws BusinessLayerException {
		logger.info("edit");
		UserBean user = getCurrentUser(session);
		ppsManagerBL.edit(body, user.getCodiceProfilo());
		return getSuccessEmptyBean();
	}

	// Visualizzazione_AmbitoMonitoraggio
	@JsonGetMapping("/scopes")
	public GenericListBean<AmbitoMonitoraggioOutputBean> getScopes(HttpSession session) throws BusinessLayerException {
		logger.info("get scopes");
		UserBean user = getCurrentUser(session);
		GenericListBean<AmbitoMonitoraggioOutputBean> bean = ppsManagerBL.getScopes(user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

}
