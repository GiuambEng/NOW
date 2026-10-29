package com.nttdata.tim.now.web.controller.anagrafica;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.anagrafica.ContattoManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.contatto.ContattoOutputBean;
import com.nttdata.tim.now.data.bean.contatto.RiferimentiContattoOutputBean;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
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
@RequestMapping("/contacts")
public class ContattoController extends GenericController {

    @Autowired
    private ContattoManagerBL contattoManagerBL;
    
	// Contatto -> Lista Contatti
	@JsonGetMapping
	public GenericListBean<ContattoOutputBean> getContacts(HttpSession session) throws BusinessLayerException {
		logger.info("get contacts");
		UserBean user = getCurrentUser(session);
		GenericListBean<ContattoOutputBean> bean = contattoManagerBL.getContacts(user.getCodificaOloAgcom(), user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Contatto -> Riferimenti Contatti
	@JsonGetMapping("/{idContact:[A-Za-z0-9]+}/references")
	public GenericListBean<RiferimentiContattoOutputBean> getReferences(@PathVariable String idContact, HttpSession session) throws BusinessLayerException {
		logger.info("get references");
		UserBean user = getCurrentUser(session);
		GenericListBean<RiferimentiContattoOutputBean> bean = contattoManagerBL.getReferences(idContact, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Ricerca Avanzata export
	@JsonPostMapping("/export")
	public ExportableDataOutputBean requestExport(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);

		ExportableDataOutputBean bean = contattoManagerBL.requestExport(body, user.getCodificaOloAgcom(), user.getCodiceProfilo(), user.getUserId());

		if (bean != null) {
			logger.debug("Research found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("Research NOT found");
			bean = new ExportableDataOutputBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}

	// Ricerca Avanzata
	@JsonPostMapping("/search")
	public GenericListBean<ContattoOutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<ContattoOutputBean> bean = contattoManagerBL.advancedSearch(body, user.getCodificaOloAgcom(), user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}
	
}
