package com.nttdata.tim.now.web.controller.amministrazione;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.amministrazione.HelpManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.help.HelpBean;
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
@RequestMapping("/helps")
public class HelpController extends GenericController {

    @Autowired
    private HelpManagerBL helpManagerBL;
    
	@JsonGetMapping
	public GenericListBean<HelpBean> getIhelp(HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<HelpBean> bean = helpManagerBL.getIhelp(user.getCodiceProfilo());
		return ensureListBeanResult(bean);
	}

	@JsonPostMapping
	public GenericListBean<HelpBean> createIhelp(@RequestBody HelpBean help, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<HelpBean> bean = helpManagerBL.createIhelp(help, user);
		return ensureListBeanResult(bean);
	}

	// change from put to post for RU_532
	@JsonPostMapping("/{idHelp:[A-Za-z0-9]+}")
	public GenericListBean<HelpBean> updateIhelp(@RequestBody HelpBean help, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<HelpBean> bean = helpManagerBL.updateIhelp(help, user);
		return ensureListBeanResult(bean);
	}

	// change from delete to get for RU_532
	@JsonGetMapping("/{idHelp:[A-Za-z0-9]+}")
	public GenericListBean<HelpBean> deleteIhelp(@PathVariable String idHelp, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<HelpBean> bean = helpManagerBL.deleteIhelp(idHelp, user.getCodiceProfilo());
		return ensureListBeanResult(bean);
	}

	@JsonGetMapping("/visible/{idAmbito:[A-Za-z0-9]+}")
	public GenericListBean<HelpBean> getVisibleFAQs(@PathVariable String idAmbito, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<HelpBean> bean = helpManagerBL.getVisibleIhelpByAmbito(idAmbito, user.getCodiceProfilo());
		return ensureListBeanResult(bean);
	}
	
}
