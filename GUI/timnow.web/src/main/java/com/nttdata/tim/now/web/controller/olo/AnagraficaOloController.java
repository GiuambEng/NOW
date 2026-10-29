package com.nttdata.tim.now.web.controller.olo;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.olo.AnagraficaOloManagerBL;
import com.nttdata.tim.now.data.bean.anagraficaolo.AnagraficaCodiceOloOutputBean;
import com.nttdata.tim.now.data.bean.anagraficaolo.AnagraficaOloOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/srolos")
public class AnagraficaOloController extends GenericController {

	@Autowired
	private AnagraficaOloManagerBL anagraficaOloManagerBL;

	// Cliente -> Visualizza Anagrafica OLO
	@JsonGetMapping
	public GenericListBean<AnagraficaOloOutputBean> getOLOs(HttpSession session, @RequestParam(value = "noDiffida") boolean noDiffida) throws BusinessLayerException {
		logger.info("get staging registry olos");
		UserBean user = getCurrentUser(session);
		GenericListBean<AnagraficaOloOutputBean> bean = anagraficaOloManagerBL.getRegistryOloList(user.getCodiceProfilo(), user.getCodificaOloAgcom(), noDiffida);
		bean = ensureListBeanResult(bean);
		return bean;
	}

	@JsonGetMapping("/all")
	public GenericListBean<AnagraficaOloOutputBean> getAllOLOs() throws BusinessLayerException {
		logger.info("get all olos");
		GenericListBean<AnagraficaOloOutputBean> bean = anagraficaOloManagerBL.getRegistryOloList(Constants.DG_PROFILE, Constants.DEFAULT_OLO, false);
		bean = ensureListBeanResult(bean);
		return bean;
	}
	
	//RU_716 NUOVO CONTRATTO
	@JsonGetMapping("/getCodOloNumerico/{codOlo}")
	public AnagraficaCodiceOloOutputBean getCodOloNumerico(@PathVariable String codOlo) throws BusinessLayerException {
		logger.info("get codice olo numerico  by codifica olo agcom");
		AnagraficaCodiceOloOutputBean bean = anagraficaOloManagerBL.getCodiceNumericoOlo(codOlo);
		bean = ensureBeanResult(bean, AnagraficaCodiceOloOutputBean.class);
		return bean;
	}
	
}
