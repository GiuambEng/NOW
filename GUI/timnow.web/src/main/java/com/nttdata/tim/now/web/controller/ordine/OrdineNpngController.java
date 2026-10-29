package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.OrdineNpngManagerBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.ordine.npng.CambioOloNpngInputBean;
import com.nttdata.tim.now.data.bean.ordine.npng.CambioOloNpngOutputBean;
import com.nttdata.tim.now.data.bean.ordine.npng.DettaglioAssetNpngWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.npng.DettaglioOrdineNpngWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.npng.LavorazioneManualeOrdineNpngInputBean;
import com.nttdata.tim.now.data.bean.ordine.npng.RicercaOrdiniNpngInputBean;
import com.nttdata.tim.now.data.bean.ordine.npng.RicercaOrdiniNpngWrapperOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

//RU_1394s
//@RestController
//@RequestMapping("/npng")
public class OrdineNpngController extends GenericController{

	@Autowired
	private OrdineNpngManagerBL ordineNpngManagerBL;

	//RU_1394
	//@JsonPostMapping("/ricercaOrdini")
	public RicercaOrdiniNpngWrapperOutputBean ricercaOrdini(@RequestBody RicercaOrdiniNpngInputBean input, HttpSession session)
			throws BusinessLayerException {
		logger.info("search NPNG orders");
		UserBean currentUser = getCurrentUser(session);
		RicercaOrdiniNpngWrapperOutputBean bean = ordineNpngManagerBL.ricercaOrdini(input, currentUser.getCodiceProfilo());
		return bean;
	}
	
	//RU_1394
	//@JsonGetMapping("/dettaglioOrdine")
	public DettaglioOrdineNpngWrapperOutputBean dettaglioOrdine(@RequestParam(required = true, name = "idOrdine") String idOrdine, HttpSession session)
			throws BusinessLayerException {
		logger.info("search NPNG order details");
		UserBean currentUser = getCurrentUser(session);
		DettaglioOrdineNpngWrapperOutputBean bean = ordineNpngManagerBL.dettaglioOrdine(idOrdine, currentUser.getCodiceProfilo());
		return bean;
	}
	
	//@JsonPostMapping("/lavorazioneManualeOrdine")
	public EmptyBean lavorazioneManualeOrdine(@RequestBody LavorazioneManualeOrdineNpngInputBean input, HttpSession session)
			throws BusinessLayerException {
		logger.info("update NPNG order");
		UserBean currentUser = getCurrentUser(session);
		EmptyBean bean = ordineNpngManagerBL.lavorazioneManualeOrdine(input, currentUser.getUserId(), currentUser.getCodiceProfilo());
		return bean;
	}
	
	//@JsonGetMapping("/ricercaAsset")
	public RicercaOrdiniNpngWrapperOutputBean ricercaAsset(@RequestParam(required = true, name = "dn") String dn, HttpSession session)
			throws BusinessLayerException {
		logger.info("search NPNG assets");
		UserBean currentUser = getCurrentUser(session);
		RicercaOrdiniNpngWrapperOutputBean bean = ordineNpngManagerBL.ricercaAsset(dn, currentUser.getCodiceProfilo());
		return bean;
	}
	
	//@JsonGetMapping("/dettaglioAsset")
	public DettaglioAssetNpngWrapperOutputBean dettaglioAsset(@RequestParam(required = true, name = "idAsset") String idAsset, HttpSession session)
			throws BusinessLayerException {
		logger.info("search NPNG asset details");
		UserBean currentUser = getCurrentUser(session);
		DettaglioAssetNpngWrapperOutputBean bean = ordineNpngManagerBL.dettaglioAsset(idAsset, currentUser.getCodiceProfilo());
		return bean;
	}
	
	//RU_1394
	//@JsonPostMapping("/cambioOlo")
	public CambioOloNpngOutputBean cambioOlo(@RequestBody CambioOloNpngInputBean input, HttpSession session)
			throws BusinessLayerException {
		logger.info("change OLO");
		UserBean currentUser = getCurrentUser(session);
		CambioOloNpngOutputBean bean = ordineNpngManagerBL.cambioOlo(input, currentUser.getUserId(), currentUser.getCodiceProfilo());
		return bean;
	}
}
