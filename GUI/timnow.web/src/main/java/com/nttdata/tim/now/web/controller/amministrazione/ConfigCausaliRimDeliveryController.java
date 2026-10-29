package com.nttdata.tim.now.web.controller.amministrazione;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.amministrazione.ConfigCausaliRimDeliveryManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.configcausali.ConfigCausaliRimDeliveryOutputBean;
import com.nttdata.tim.now.data.bean.configcausali.ListaModificaConfigCausaliRimDeliveryInputBean;
import com.nttdata.tim.now.data.bean.configcausali.ModificaConfigCausaliRimDeliveryOutputBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPutMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configcausalirimdelivery")
public class ConfigCausaliRimDeliveryController extends GenericController {

	@Autowired
	private ConfigCausaliRimDeliveryManagerBL configCausaliRimDeliveryManagerBL;

	@JsonGetMapping("/lista/{flagEsplicita}")
	public GenericListBean<ConfigCausaliRimDeliveryOutputBean> getLista(@PathVariable String flagEsplicita, HttpSession session)
			throws BusinessLayerException {
		GenericListBean<ConfigCausaliRimDeliveryOutputBean> bean = new GenericListBean<>();
		try {
			bean = configCausaliRimDeliveryManagerBL.getLista(flagEsplicita, getCurrentUser(session).getCodiceProfilo());
		} catch (Exception e) {
			logger.info("Richiesta get lista causali rim delivery fallita", e);
			throw e;
		}
		return ensureListBeanResult(bean);
	}

	@JsonPostMapping("/modifica")
	public GenericListBean<ModificaConfigCausaliRimDeliveryOutputBean> modificaLista(
			@RequestBody ListaModificaConfigCausaliRimDeliveryInputBean inputBean, HttpSession session)
			throws BusinessLayerException {
		GenericListBean<ModificaConfigCausaliRimDeliveryOutputBean> bean = new GenericListBean<>();
		try {
			bean = configCausaliRimDeliveryManagerBL.modificaLista(inputBean, getCurrentUser(session).getCodiceProfilo());
		} catch (Exception e) {
			logger.info("Richiesta di modifica lista causali rim delivery fallita", e);
			throw e;
		}
		return ensureListBeanResult(bean);
	}

	@JsonPutMapping("/delete")
	public GenericListBean<ModificaConfigCausaliRimDeliveryOutputBean> deleteLista(
			@RequestBody ListaModificaConfigCausaliRimDeliveryInputBean inputBean, HttpSession session)
			throws BusinessLayerException {
		GenericListBean<ModificaConfigCausaliRimDeliveryOutputBean> bean = new GenericListBean<>();
		try {
			bean = configCausaliRimDeliveryManagerBL.deleteLista(inputBean, getCurrentUser(session).getCodiceProfilo());
		} catch (Exception e) {
			logger.info("Richiesta di delete lista causali rim delivery fallita", e);
			throw e;
		}
		return ensureListBeanResult(bean);
	}

}
