package com.nttdata.tim.now.web.controller.asset;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.asset.AssetRaccoltaManagerBL;
import com.nttdata.tim.now.data.bean.asset.AssetRaccoltaWrapperOutputBean;
import com.nttdata.tim.now.data.bean.asset.DettaglioAssetRaccoltaWrapperOutputBean;
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

//RU_1188
@RestController
@RequestMapping("/assetsRaccolta")
public class AssetRaccoltaController extends GenericController {

	@Autowired
	private AssetRaccoltaManagerBL assetRaccoltaManagerBL;
	
	//Asset -> Dettaglio Asset
	@JsonGetMapping("/{idAsset}")
	public DettaglioAssetRaccoltaWrapperOutputBean getAsset(@PathVariable String idAsset, HttpSession session ) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		DettaglioAssetRaccoltaWrapperOutputBean bean = assetRaccoltaManagerBL.getAsset(idAsset, user.getCodiceProfilo());
		bean = ensureBeanResult(bean, DettaglioAssetRaccoltaWrapperOutputBean.class);
		return bean;
	}

	
	// Asset -> Lista Asset
	//Lista semplice senza filtri
	@JsonGetMapping
	public AssetRaccoltaWrapperOutputBean getAssetsRaccolta(HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		AssetRaccoltaWrapperOutputBean bean = assetRaccoltaManagerBL.getAssetsRaccolta(user.getCodificaOloAgcom(), user.getCodiceProfilo(), user.getUserId());
		return bean;
	}

	// Ricerca Avanzata export
	@JsonPostMapping("/export")
	public AssetRaccoltaWrapperOutputBean requestExport(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);

		AssetRaccoltaWrapperOutputBean bean = assetRaccoltaManagerBL.requestExport(body, user.getCodificaOloAgcom(),user.getCodiceProfilo(), user.getUserId());

		if (bean != null) {
			logger.debug("Research found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("Research NOT found");
			bean = new AssetRaccoltaWrapperOutputBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}

	// Ricerca Avanzata export
	@JsonPostMapping("/search")
	public AssetRaccoltaWrapperOutputBean search(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		AssetRaccoltaWrapperOutputBean bean = assetRaccoltaManagerBL.advancedSearch(body, user.getCodificaOloAgcom(),	user.getCodiceProfilo(), user.getUserId());
		return bean;
	}
}
