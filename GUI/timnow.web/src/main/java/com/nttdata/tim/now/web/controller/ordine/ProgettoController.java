package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.pps.ProgettoManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.progetto.ProgettoOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProgettoController extends GenericController {

    
    @Autowired
    private ProgettoManagerBL progettoManagerBL;
    
	// Utility -> Codice Progetto
	@JsonGetMapping("/{codOLO:[A-Za-z0-9_]+}")
	public GenericListBean<ProgettoOutputBean> getProjectsByAgcom(@PathVariable String codOLO, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<ProgettoOutputBean> bean = progettoManagerBL.getProjects(codOLO, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

}
