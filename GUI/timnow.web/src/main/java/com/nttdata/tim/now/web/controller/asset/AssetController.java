package com.nttdata.tim.now.web.controller.asset;

import javax.servlet.http.HttpSession;
import javax.ws.rs.QueryParam;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.asset.AssetManagerBL;
import com.nttdata.tim.now.data.bean.asset.AssetOutputBean;
import com.nttdata.tim.now.data.bean.asset.DettaglioAssetOutputBean;
import com.nttdata.tim.now.data.bean.asset.ListaFeederOutputBean;
import com.nttdata.tim.now.data.bean.asset.ListaSediOltOutputBean;
import com.nttdata.tim.now.data.bean.asset.RecuperoAssetListOutputBean;
import com.nttdata.tim.now.data.bean.asset.VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assets")
public class AssetController extends GenericController {

	@Autowired
	private AssetManagerBL assetManagerBL;

	// Asset -> Dettaglio Asset (C11M08F38)
	@JsonGetMapping("/{paramName}/{id}")
	public DettaglioAssetOutputBean getAsset(@PathVariable String paramName, @PathVariable String id,
			@QueryParam(value = "N") String consistenza, @RequestParam(value = "codDonating", required = false) String codDonating, HttpSession session ) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		DettaglioAssetOutputBean bean = assetManagerBL.getAsset(paramName, id, consistenza, codDonating, user.getCodiceProfilo());
		bean = ensureBeanResult(bean, DettaglioAssetOutputBean.class);
		return bean;
	}

	// Asset -> Lista Asset
	@JsonGetMapping
	public GenericListBean<AssetOutputBean> getAssets(HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<AssetOutputBean> bean = assetManagerBL.getAssets(user.getCodificaOloAgcom(),
				user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Ricerca Avanzata export
	@JsonPostMapping("/export")
	public ExportableDataOutputBean requestExport(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);

		ExportableDataOutputBean bean = assetManagerBL.requestExport(body, user.getCodificaOloAgcom(),
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

	// Ricerca Avanzata export
	@JsonPostMapping("/search")
	public GenericListBean<AssetOutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<AssetOutputBean> bean = assetManagerBL.advancedSearch(body, user.getCodificaOloAgcom(),
				user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}
	
	// Recupero Asset (C11M08F37)
	//RU_1058
	@JsonGetMapping("recupero/{codAgcom}")
	public RecuperoAssetListOutputBean recuperoasset(@PathVariable String codAgcom, 
													 @RequestParam String idRisorsa, 
													 @RequestParam String azione,
													 HttpSession session ) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
        RecuperoAssetListOutputBean bean = assetManagerBL.recuperoasset(codAgcom, idRisorsa, azione, user.getCodiceProfilo());
		//ensureBeanResult(bean, RecuperoAssetListOutputBean.class); RU_833 FIX MEX CESSAZIONE FWA
		return bean;
	}
	
	// Verifica Stato Asset per Abilitazione/Disabilitazione (C11M08F85)
	//RU_1184
	@JsonGetMapping("/verificaStatoAssetAbilitazioneDisabilitazione")
	public VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputBean verificaStatoAssetAbilitazioneDisabilitazione(
													 @RequestParam String idAsset, 
													 @RequestParam String disabilitazione,
													 HttpSession session ) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputBean bean = assetManagerBL.verificaStatoAssetAbilitazioneDisabilitazione(idAsset, disabilitazione, user.getCodiceProfilo());
		return bean;
	}

	// Lista sedi OLT per asset
	//R1I-21-0203
	@JsonGetMapping("/listaSediOlt")
	public ListaSediOltOutputBean listaSediOlt(
												@RequestParam String idAsset,
												HttpSession session ) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		ListaSediOltOutputBean bean = assetManagerBL.listaSediOlt(idAsset, user.getCodiceProfilo());
		return bean;
	}
	
	// Lista sedi OLT per asset
	//R1I-21-0203
	@JsonGetMapping("/listaFeeders")
	public ListaFeederOutputBean listaFeeder(
												@RequestParam String idAsset,
												HttpSession session ) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		ListaFeederOutputBean bean = assetManagerBL.listaFeeder(idAsset, user.getCodiceProfilo());
		return bean;
	}
}
