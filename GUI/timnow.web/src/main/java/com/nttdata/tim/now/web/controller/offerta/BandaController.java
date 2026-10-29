package com.nttdata.tim.now.web.controller.offerta;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.offerta.BandaManagerBL;
import com.nttdata.tim.now.data.bean.banda.BandaDedicataOutputBean;
import com.nttdata.tim.now.data.bean.banda.BandaPiccoOutputBean;
import com.nttdata.tim.now.data.bean.banda.ControlloValoriBandaPiccoOutputBean;
import com.nttdata.tim.now.data.bean.banda.ListaControlloValoriBandaPiccoInputBean;
import com.nttdata.tim.now.data.bean.banda.TipoBandaOutputBean;
import com.nttdata.tim.now.data.bean.banda.VerificaCoppiaBandePiccoInputBean;
import com.nttdata.tim.now.data.bean.banda.VerificaCoppiaBandePiccoOutputBean;
import com.nttdata.tim.now.data.bean.banda.VerificaSommaBandePiccoInputBean;
import com.nttdata.tim.now.data.bean.banda.VerificaSommaBandePiccoOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
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
@RequestMapping("/bands")
public class BandaController extends GenericController {

    @Autowired
    private BandaManagerBL bandaManagerBL;
    
	// Visualizzazione Lista Band Picco
	@JsonGetMapping
	public GenericListBean<BandaPiccoOutputBean> getBands(@RequestParam(value = "tipoCos", required = false) String tipoCos,
			                                              @RequestParam(value = "codiceLan", required = false) String codiceLan,
			                                              @RequestParam(value = "idOfferta", required = false) String idOfferta,
			                                              @RequestParam(value = "profTecnicoLinea", required = false) String profTecnicoLinea,
			                                              HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session); 
        GenericListBean<BandaPiccoOutputBean> bean = bandaManagerBL.getBands(tipoCos, codiceLan, idOfferta, profTecnicoLinea, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Visualizzazione Lista Band Picco
	@JsonGetMapping("/newOrder")
	public GenericListBean<BandaPiccoOutputBean> getBandsNewOrder(@RequestParam(value = "tipoCos", required = false) String tipoCos,
			@RequestParam(value = "codiceLan", required = false) String codiceLan,
			@RequestParam(value = "idOfferta", required = false) String idOfferta,
			@RequestParam(value = "profTecnicoLinea", required = false) String profTecnicoLinea,
			HttpSession session)
					throws BusinessLayerException {
		UserBean user = getCurrentUser(session); 
		GenericListBean<BandaPiccoOutputBean> bean = bandaManagerBL.getBandsNewOrder(tipoCos, codiceLan, idOfferta, profTecnicoLinea, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Nuovo ordine - Verifica somma bande picco
	@JsonPostMapping("/check")
	public VerificaSommaBandePiccoOutputBean check(@RequestBody VerificaSommaBandePiccoInputBean bands, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session); 
        VerificaSommaBandePiccoOutputBean bean = bandaManagerBL.checkBand(bands, user.getCodiceProfilo());
		if (bean != null) {
			logger.debug("System Locator found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("System Locator NOT found");
			bean = new VerificaSommaBandePiccoOutputBean();
			bean.setResult(getResultNotFound());
		}
		return bean;
	}

	// Verifica coppia banda picco
	@JsonPostMapping("/checkCouple")
	public GenericListBean<VerificaCoppiaBandePiccoOutputBean> checkCouple(@RequestBody VerificaCoppiaBandePiccoInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session); 
        GenericListBean<VerificaCoppiaBandePiccoOutputBean> bean = bandaManagerBL.checkCouple(body, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	@JsonGetMapping("/viewDedicatedBand/{idOfferta}")
	public GenericListBean<BandaDedicataOutputBean> viewDedicatedBand(@PathVariable String idOfferta, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session); 
        GenericListBean<BandaDedicataOutputBean> bean = bandaManagerBL.viewDedicatedBand(idOfferta, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	@JsonGetMapping("/viewTypeBand/{codVlanSvlan}")
	public GenericListBean<TipoBandaOutputBean> viewTypeBand(@PathVariable String codVlanSvlan, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session); 
		GenericListBean<TipoBandaOutputBean> bean = bandaManagerBL.viewTypeBand(codVlanSvlan, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}
	
	// Ricerca Avanzata
	@JsonPostMapping("/search")
	public GenericListBean<BandaPiccoOutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session); 
        GenericListBean<BandaPiccoOutputBean> bean = bandaManagerBL.advancedSearch(body, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}
	
	// Nuovo ordine - Controllo valori banda picco
	@JsonPostMapping("/checkvalues")
	public ControlloValoriBandaPiccoOutputBean checkValues(@RequestBody ListaControlloValoriBandaPiccoInputBean values, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session); 
        ControlloValoriBandaPiccoOutputBean bean = bandaManagerBL.checkValues(values, user.getCodiceProfilo());
		if (bean != null) {
			logger.debug("Checking values banda picco");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("Error checking values banda picco");
			bean = new ControlloValoriBandaPiccoOutputBean();
			bean.setResult(getResultNotFound());
		}
		return bean;
	}

}
