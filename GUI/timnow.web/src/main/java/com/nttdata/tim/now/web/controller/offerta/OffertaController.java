package com.nttdata.tim.now.web.controller.offerta;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.offerta.OffertaManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.offerta.DettaglioOffertaWrapperOutputBean;
import com.nttdata.tim.now.data.bean.offerta.DisambiguazioneOffertaOutputBean;
import com.nttdata.tim.now.data.bean.offerta.OffertaOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offers")
public class OffertaController extends GenericController {

    @Autowired
    private OffertaManagerBL offertaManageBL;
    
	// Catalogo -> Scelta Offerta
    //RU_1180
	@JsonGetMapping
	public GenericListBean<OffertaOutputBean> getOffers(
			@RequestParam(value = "azione") String  azione,
			@RequestParam(value = "contratto") String contratto,
			@RequestParam(value = "flagMulticast", required = false) String flagMulticast,
			HttpSession session) throws BusinessLayerException {
		logger.info("get Offers");
		UserBean user = getCurrentUser(session); 
		GenericListBean<OffertaOutputBean> bean = offertaManageBL.getOffers(contratto,azione, user.getCodiceProfilo(), flagMulticast);
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Catalogo -> Offerta
	@JsonGetMapping("/{idOfferta:[A-Za-z0-9_]+}")
	public DettaglioOffertaWrapperOutputBean getOffer(@PathVariable String idOfferta, HttpSession session) throws BusinessLayerException {
		logger.info("get offer");
		UserBean user = getCurrentUser(session); 
		DettaglioOffertaWrapperOutputBean bean = offertaManageBL.getOffer(idOfferta, user.getCodiceProfilo());

		if (bean != null) {
			logger.debug("Offer found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("Offer NOT found");
			bean = new DettaglioOffertaWrapperOutputBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}

	// Disambiguazione -> Servizio
	//@JsonGetMapping("/disambiguation/{tplg_lavrz}")
	public  GenericListBean<DisambiguazioneOffertaOutputBean> getDisambiguazioneOffers(@PathVariable String tplg_lavrz, HttpSession session) throws BusinessLayerException {
		logger.info("get Offers for disambiguation");
		UserBean user = getCurrentUser(session); 
		GenericListBean<DisambiguazioneOffertaOutputBean> bean = offertaManageBL.getDisambiguationOffers(tplg_lavrz, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

}
