package com.nttdata.tim.now.web.controller.anagrafica;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.anagrafica.ClienteManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.cliente.ClienteOutputBean;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
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
@RequestMapping("/customers")
public class ClienteController extends GenericController {

    @Autowired
    private ClienteManagerBL clienteManagerBL;
    
	// Cliente Anagrafiche -> Lista Anagrafica Cliente
    @JsonGetMapping
	public GenericListBean<ClienteOutputBean> getCustomers(HttpSession session) throws BusinessLayerException {
		logger.debug("getCustomers");
		UserBean user = getCurrentUser(session);
		GenericListBean<ClienteOutputBean> bean = clienteManagerBL.getCustomers(user.getCodificaOloAgcom(), user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Ricerca Avanzata export
	@JsonPostMapping("/export")
	public ExportableDataOutputBean requestExport(@RequestBody RicercaAvanzataInputBean body, HttpSession session)	throws BusinessLayerException {
		UserBean user = getCurrentUser(session);

		ExportableDataOutputBean bean = clienteManagerBL.requestExport(body, user.getCodificaOloAgcom(), user.getCodiceProfilo(), user.getUserId());

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
	public GenericListBean<ClienteOutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<ClienteOutputBean> bean = clienteManagerBL.advancedSearch(body, user.getCodificaOloAgcom(), user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}
}
