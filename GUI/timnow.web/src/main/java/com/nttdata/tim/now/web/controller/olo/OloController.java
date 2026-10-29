package com.nttdata.tim.now.web.controller.olo;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.olo.OloManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.carrier.VerificaCarrierOloCPSInputBean;
import com.nttdata.tim.now.data.bean.carrier.VerificaCarrierOloCPSWrapperOutputBean;
import com.nttdata.tim.now.data.bean.olo.VerificaOloNumericoOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaContrattoInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaContrattoWrapperOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/olos")
public class OloController extends GenericController {

    @Autowired
    private OloManagerBL oloManagerBL;
    
	// VerificaCodice_OLO_numerico
	@JsonGetMapping("/checkNumeric/{codOlo:[A-Za-z0-9_]+}")
	public VerificaOloNumericoOutputBean verificaOloNumerico(@PathVariable String codOlo, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		VerificaOloNumericoOutputBean bean = oloManagerBL.verificaOloNumerico(codOlo, user.getCodiceProfilo());
		bean = ensureBeanResult(bean, VerificaOloNumericoOutputBean.class);
		return bean;
	}

	// Check_COD_OLO_UNIVOCO
	@JsonGetMapping("/checkUnivocal")
	public GenericListBean<String> checkUnivocalOlo(HttpSession session) throws BusinessLayerException {
		logger.info("check univocal Olo");
		UserBean user = getCurrentUser(session);
		GenericListBean<String> bean = oloManagerBL.checkUnivocalOlo(user.getCodificaOloAgcom(), user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}
	
	//RU_915
	// VerificaCarrierOloCPS
	@JsonPostMapping("/checkCarrierOloCps")
	public VerificaCarrierOloCPSWrapperOutputBean checkCarrierOloCps(@RequestBody VerificaCarrierOloCPSInputBean request, HttpSession session) throws BusinessLayerException {
		logger.info("check carrier Olo CPS");
		UserBean user = getCurrentUser(session);
		VerificaCarrierOloCPSWrapperOutputBean bean = oloManagerBL.checkCarrierOloCps(user.getCodiceProfilo(), request);
		bean = ensureBeanResult(bean, VerificaCarrierOloCPSWrapperOutputBean.class);
		return bean;
	}
	
	//RU_915
	// VerificaContratto
	@JsonPostMapping("/checkContract")
	public VerificaContrattoWrapperOutputBean checkContract(@RequestBody VerificaContrattoInputBean request, HttpSession session) throws BusinessLayerException {
		logger.info("check carrier Olo CPS");
		UserBean user = getCurrentUser(session);
		VerificaContrattoWrapperOutputBean bean = oloManagerBL.checkContract(user.getCodiceProfilo(), request);
		bean = ensureBeanResult(bean, VerificaContrattoWrapperOutputBean.class);
		return bean;
	}
}
