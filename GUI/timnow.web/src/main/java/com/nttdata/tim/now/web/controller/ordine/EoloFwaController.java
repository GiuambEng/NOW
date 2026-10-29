package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.EoloFwaManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.indirizzo.CittaOutputBean;
import com.nttdata.tim.now.data.bean.indirizzo.IndirizzoOutputBean;
import com.nttdata.tim.now.data.bean.ordine.eolo.CodiceVlanEoloFwaInputBean;
import com.nttdata.tim.now.data.bean.ordine.eolo.CodiceVlanEoloFwaOutputBean;
import com.nttdata.tim.now.data.bean.ordine.eolo.VerificaCoppiaIdVlanCvlanInputBean;
import com.nttdata.tim.now.data.bean.ordine.eolo.VerificaCoppiaIdVlanCvlanOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//RU_1475
@RestController
@RequestMapping("/eoloFwa")
public class EoloFwaController extends GenericController {

    @Autowired
    private EoloFwaManagerBL eoloFwaManagerBL;

    // Visualizzazione Codice VLAN
    @JsonPostMapping("/searchVlan")
    public GenericListBean<CodiceVlanEoloFwaOutputBean> getVlanEoloFwa(@RequestBody CodiceVlanEoloFwaInputBean inputBean, HttpSession session) throws BusinessLayerException {
        logger.info("get Eolo FWA VLAN");
		UserBean user = getCurrentUser(session); 
        GenericListBean<CodiceVlanEoloFwaOutputBean> bean = eoloFwaManagerBL.getVlanEoloFwa(inputBean, user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
    }
    
    @JsonGetMapping("/address/provinces")
	public IndirizzoOutputBean getProvinces(HttpSession session) throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
		IndirizzoOutputBean bean = eoloFwaManagerBL.getProvinces(user.getCodiceProfilo());

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
	@JsonGetMapping("/address/cities")
	public GenericListBean<CittaOutputBean> getCities(@RequestParam(value = "provincia", required = false) String provincia, HttpSession session) throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
		GenericListBean<CittaOutputBean> bean = eoloFwaManagerBL.getCities(provincia, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Utility -> Autocompletamento Dati Sede
	@JsonGetMapping("/address")
	public IndirizzoOutputBean getAddressItem(@RequestParam(value = "query", required = false) String query,
			@RequestParam(value = "selectedProvince") String selectedProvince,
			@RequestParam(value = "selectedCity", required = false) String selectedCity,
			@RequestParam(value = "selectedParticle", required = false) String selectedParticle,
			@RequestParam(value = "selectedAddress", required = false) String selectedAddress, HttpSession session)
			throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
		IndirizzoOutputBean bean = eoloFwaManagerBL.getAddressItems(selectedProvince, selectedCity, selectedParticle,
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
	
	//C04M01F513 - Verifica coppia IDVLAN - CVLAN
	@JsonPostMapping("/verificaCoppiaIdVlanCvlan")
	public VerificaCoppiaIdVlanCvlanOutputBean verificaCoppiaIdVlanCvlan(@RequestBody VerificaCoppiaIdVlanCvlanInputBean input, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		VerificaCoppiaIdVlanCvlanOutputBean bean = eoloFwaManagerBL.verificaCoppiaIdVlanCvlan(input, user.getCodiceProfilo());
		bean = ensureBeanResult(bean, VerificaCoppiaIdVlanCvlanOutputBean.class);
		return bean;
	}
}
