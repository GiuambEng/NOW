package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.RinvioMailManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.codice.CodiceOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.reinviomail.RinvioMailListInputBean;
import com.nttdata.tim.now.data.bean.monitoring.reinviomail.RinvioMailOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitoraggio-rinvio-email")
public class RinvioEmailController extends GenericController {
    
    @Autowired
    private RinvioMailManagerBL mailResendManagerBL;

	@JsonPostMapping("/search")
	public GenericListBean<RinvioMailOutputBean> search(@RequestBody RicercaAvanzataInputBean searchBean, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<RinvioMailOutputBean> bean = mailResendManagerBL.advancedSearch(searchBean, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	@JsonPostMapping("/send")
	public GenericListBean<CodiceOutputBean> sendEmail(@RequestBody RinvioMailListInputBean input, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<CodiceOutputBean> bean = mailResendManagerBL.invioMail(input, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}
	
}
