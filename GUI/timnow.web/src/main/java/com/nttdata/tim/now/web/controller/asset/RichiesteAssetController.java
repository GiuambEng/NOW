package com.nttdata.tim.now.web.controller.asset;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.asset.RichiestaAssetManagerBL;
import com.nttdata.tim.now.data.bean.asset.ListaCodiciRifiutoOutputBean;
import com.nttdata.tim.now.data.bean.asset.RichiesteAssetOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listaRichiesteAssets")
public class RichiesteAssetController extends GenericController {

	@Autowired
	private RichiestaAssetManagerBL richiestaAssetManagerBL;

	// Ricerca Avanzata export
	@JsonPostMapping("/search")
	public GenericListBean<RichiesteAssetOutputBean> search(@RequestBody RicercaAvanzataInputBean body,
			HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<RichiesteAssetOutputBean> bean = richiestaAssetManagerBL.advancedSearch(body,
				user.getCodificaOloAgcom(), user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Ricerca Avanzata export
	@JsonPostMapping("/export")
	public ExportableDataOutputBean requestExport(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);

		ExportableDataOutputBean bean = richiestaAssetManagerBL.requestExport(body, user.getCodificaOloAgcom(),
				user.getCodiceProfilo(), user.getUserId());

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

	// listaCodiciRifiuto
	@JsonGetMapping("/visualizzacodicirifiuto")
	public ListaCodiciRifiutoOutputBean visualizzacodicirifiuto(
             @RequestParam(value = "ambitoServizioRecipient") String ambitoServizioRecipient,
	         @RequestParam(value = "ambitoServizioDonating")  String ambitoServizioDonating, 
	         HttpSession session)throws BusinessLayerException	{
		logger.debug("visualizzacodicirifiuto");
		UserBean user = getCurrentUser(session);
		ListaCodiciRifiutoOutputBean bean = richiestaAssetManagerBL.visualizzacodicirifiuto(ambitoServizioRecipient,
				ambitoServizioDonating, user.getCodiceProfilo());
		bean = ensureBeanResult(bean, ListaCodiciRifiutoOutputBean.class);
		return bean;
	}

}
