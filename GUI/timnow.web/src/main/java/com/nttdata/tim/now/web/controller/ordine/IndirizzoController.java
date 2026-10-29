package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.IndirizzoManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;
import com.nttdata.tim.now.data.bean.indirizzo.CittaOutputBean;
import com.nttdata.tim.now.data.bean.indirizzo.IndirizzoOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class IndirizzoController extends GenericController {

    @Autowired
    private IndirizzoManagerBL indirizzomanagerBL;
    
	@JsonGetMapping("/provinces")
	public IndirizzoOutputBean getProvinces(HttpSession session) throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
		IndirizzoOutputBean bean = indirizzomanagerBL.getProvinces(user.getCodiceProfilo());

		if (bean != null) {
			logger.debug("Provinces found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("Provinces NOT found");
			bean = new IndirizzoOutputBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}

	// Recupero Comune Provincia
	@JsonGetMapping("/cities")
	public GenericListBean<CittaOutputBean> getCities(@RequestParam(value = "provincia", required = false) String provincia, HttpSession session) throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
		GenericListBean<CittaOutputBean> bean = indirizzomanagerBL.getCities(provincia, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Utility -> Autocompletamento Dati Sede
	@JsonGetMapping
	public IndirizzoOutputBean getAddressItem(@RequestParam(value = "query", required = false) String query,
			@RequestParam(value = "selectedProvince") String selectedProvince,
			@RequestParam(value = "selectedCity", required = false) String selectedCity,
			@RequestParam(value = "selectedParticle", required = false) String selectedParticle,
			@RequestParam(value = "selectedAddress", required = false) String selectedAddress, HttpSession session)
			throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
		IndirizzoOutputBean bean = indirizzomanagerBL.getAddressItems(selectedProvince, selectedCity, selectedParticle,
				selectedAddress, query, user.getCodiceProfilo());

		if (bean != null) {
			logger.debug("Address found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("Address NOT found");
			bean = new IndirizzoOutputBean();
			bean.setResult(getResultNotFound());
		}
		return bean;
	}
	
	
	//Controllo Recupero Distretto
	//RU_716
	@JsonGetMapping("/controllorecuperadistretto")
	public EsitoOutputBean controlloRecuperaDistretto(@RequestParam(value = "provincia", required = true) String provincia, @RequestParam(value = "comune", required = true) String comune, @RequestParam(value = "toponomastica", required = true) String toponomastica, @RequestParam(value = "indirizzo", required = true) String indirizzo, @RequestParam(value = "civico", required = true) String civico, @RequestParam(value = "lavorazione", required = true) String lavorazione, HttpSession session) throws BusinessLayerException {
		EsitoOutputBean bean = new EsitoOutputBean();
		try {
			bean = indirizzomanagerBL.controlloRecuperaDistretto(provincia,comune, toponomastica, indirizzo, civico, lavorazione);
			bean = ensureBeanResult(bean, EsitoOutputBean.class);
		} catch(Exception e){
            logger.info("Richiesta di verifica controllo distretto fallita", e);
            throw e;
        }
        return bean;
	}
}
