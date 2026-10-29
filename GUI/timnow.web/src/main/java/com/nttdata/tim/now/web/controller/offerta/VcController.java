package com.nttdata.tim.now.web.controller.offerta;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.offerta.VcManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.bean.vc.MaxVcKitInputBean;
import com.nttdata.tim.now.data.bean.vc.ProfiloVcOutputBean;
import com.nttdata.tim.now.data.bean.vp.MaxVCVPOutputBean;
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
@RequestMapping("/vcs")
public class VcController extends GenericController {

    @Autowired
    private VcManagerBL vcManagerBl;
    
	// ProfiliVc
	@JsonGetMapping
	public GenericListBean<ProfiloVcOutputBean> getProfilesVc(HttpSession session) throws BusinessLayerException {
		logger.info("get Profiles VC");
		UserBean user  = getCurrentUser(session);
		GenericListBean<ProfiloVcOutputBean> bean = vcManagerBl.getProfilesVc(user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	@JsonGetMapping("/viewProfilesVC/{profilo:[A-Za-z0-9:_]+}/{idOfferta:[A-Za-z0-9:_]+}")
	public GenericListBean<ProfiloVcOutputBean> viewProfilesVC(@PathVariable String profilo, @PathVariable String idOfferta,
			HttpSession session, @RequestParam(value = "protocollo", required = false) String protocollo,
			@RequestParam(value = "profilotecnicolinea", required = false) String profilotecnicolinea,
			@RequestParam(value = "caratteristica", required = false) String caratteristica) throws BusinessLayerException {
		logger.info("get Profiles VC");
		UserBean user = getCurrentUser(session);
		GenericListBean<ProfiloVcOutputBean> bean = vcManagerBl.viewProfilesVC(user.getCodiceProfilo(), idOfferta, profilo, protocollo,profilotecnicolinea,caratteristica);
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Ricerca Avanzata
	@JsonPostMapping("/search")
	public GenericListBean<ProfiloVcOutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user  = getCurrentUser(session);
		GenericListBean<ProfiloVcOutputBean> bean = vcManagerBl.advancedSearch(body, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// VerificaMaxVCperKit
	@JsonPostMapping("/checkMaxVcKit")
	public MaxVCVPOutputBean checkMaxVcPerKit(@RequestBody MaxVcKitInputBean body, HttpSession session) throws BusinessLayerException {

		UserBean user  = getCurrentUser(session);
		MaxVCVPOutputBean bean = vcManagerBl.checkMaxVcPerKit(body, user.getCodiceProfilo());

		if (bean != null) {
			logger.debug("check max vc per kit done");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("check max vc per kit NOT done");
			bean = new MaxVCVPOutputBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}

}
