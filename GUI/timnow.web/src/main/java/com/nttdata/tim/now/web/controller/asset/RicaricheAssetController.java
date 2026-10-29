package com.nttdata.tim.now.web.controller.asset;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.asset.RicaricaAssetManagerBL;
import com.nttdata.tim.now.data.bean.asset.ListaRicaricheAssetOutputBean;
import com.nttdata.tim.now.data.bean.asset.NuovaRicaricaInputBean;
import com.nttdata.tim.now.data.bean.asset.NuovaRicaricaOutputBean;
import com.nttdata.tim.now.data.bean.asset.TaglioRicaricaOutputBean;
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
@RequestMapping("/listaRicaricheAssets")
public class RicaricheAssetController extends GenericController {

	@Autowired
	private RicaricaAssetManagerBL ricaricaAssetManagerBL;


	// Ricerca Avanzata export
	@JsonPostMapping("/search")
	public ListaRicaricheAssetOutputBean search(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		ListaRicaricheAssetOutputBean bean = ricaricaAssetManagerBL.advancedSearch(body, user.getCodificaOloAgcom(),
				user.getCodiceProfilo(), user.getUserId());
		bean = ensureBeanResult(bean, ListaRicaricheAssetOutputBean.class);
		return bean;
	}


	// Ricerca Avanzata export
	@JsonPostMapping("/export")
	public ExportableDataOutputBean requestExport(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);

		ExportableDataOutputBean bean = ricaricaAssetManagerBL.requestExport(body, user.getCodificaOloAgcom(),
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
	
	
	// /nuovaricarica
	@JsonPostMapping("/nuovaricarica")
	public NuovaRicaricaOutputBean nuovaRicarica(@RequestBody NuovaRicaricaInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		body.setOperatore(user.getUserId());
		NuovaRicaricaOutputBean bean = ricaricaAssetManagerBL.nuovaRicarica(body, user.getCodiceProfilo());
		bean = ensureBeanResult(bean, NuovaRicaricaOutputBean.class);
		return bean;
	}
	
	
	// lista taglio Ricarica
    @JsonGetMapping("/taglioricarica")
	public GenericListBean<TaglioRicaricaOutputBean> getTaglioRicarica(@RequestParam(value = "offerta") String offerta, HttpSession session) throws BusinessLayerException {
		logger.debug("getTaglioRicarica");
		UserBean user = getCurrentUser(session);
		GenericListBean<TaglioRicaricaOutputBean> bean = ricaricaAssetManagerBL.getTaglioRicarica(offerta, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

}
