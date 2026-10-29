package com.nttdata.tim.now.web.controller.offerta;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.offerta.VpManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.bean.vp.CodiceVpOutputBean;
import com.nttdata.tim.now.data.bean.vp.MaxVCVPInputBean;
import com.nttdata.tim.now.data.bean.vp.MaxVCVPOutputBean;
import com.nttdata.tim.now.data.bean.vp.VpOutputBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Visualizzazione VP -> Visualizzazione VP 
@RestController
@RequestMapping("/vps")
public class VpController extends GenericController {

    @Autowired
    private VpManagerBL vpManagerBL;
    
	// Visualizzazione VP
	@JsonGetMapping
	public GenericListBean<VpOutputBean> getVps(HttpSession session) throws BusinessLayerException {
		logger.info("get VPs");
		UserBean user  = getCurrentUser(session);
		GenericListBean<VpOutputBean> bean = vpManagerBL.getVps(user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Visualizza Codice VP
	@JsonGetMapping("/code/{idOfferta}/{codOlo:[0-9a-zA-Z]+}")
	public GenericListBean<CodiceVpOutputBean> getVpCode(@PathVariable String codOlo, @PathVariable String idOfferta, HttpSession session) throws BusinessLayerException {
		UserBean user  = getCurrentUser(session);
		GenericListBean<CodiceVpOutputBean> bean = vpManagerBL.getVpCodeList(codOlo, idOfferta, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	@JsonPostMapping("/checkMaxVcVp")
	public MaxVCVPOutputBean getMaxVcVp(@RequestBody MaxVCVPInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user  = getCurrentUser(session);

		MaxVCVPOutputBean bean = vpManagerBL.getMaxVcVp(body, user.getCodiceProfilo());

		if (bean != null) {
			logger.debug("check max vc x vp done");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("check max vc x vp not completed");
			bean = new MaxVCVPOutputBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}

	// Ricerca Avanzata
	@JsonPostMapping("/search")
	public GenericListBean<VpOutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user  = getCurrentUser(session);
		GenericListBean<VpOutputBean> bean = vpManagerBL.advancedSearch(body, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

}
