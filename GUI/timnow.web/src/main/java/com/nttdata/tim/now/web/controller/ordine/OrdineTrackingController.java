package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.DataRecoveryManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ordine.tracking.OrderTrackingInputBean;
import com.nttdata.tim.now.data.bean.ordine.tracking.OrderTrackingOutputBean;
import com.nttdata.tim.now.data.bean.ordine.tracking.OrderTrackingOutputLevel2Bean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordertracking")
public class OrdineTrackingController extends GenericController {

    @Autowired
    private DataRecoveryManagerBL dataRecoveryManagerBL;
    
	// Recupero Dati OT DB Now
	@JsonGetMapping("/{idRichiestaOlo}")
	public GenericListBean<OrderTrackingOutputBean> orderTracking(@PathVariable String idRichiestaOlo, HttpSession session ) throws BusinessLayerException {
		logger.info("recuper dati OT DB Now request");
		String tipoProfilo = getCurrentUser(session).getCodiceProfilo();
		GenericListBean<OrderTrackingOutputBean> bean = dataRecoveryManagerBL.getOrderTracking(idRichiestaOlo, tipoProfilo);
		bean = ensureListBeanResult(bean);
		return bean;
	}

	
	@JsonGetMapping("/{idRichiestaOlo}/{inizioTracciamento}/{fineTracciamento}")
	public GenericListBean<OrderTrackingOutputLevel2Bean> getOrderTrackingLevel2(
			@PathVariable String idRichiestaOlo, @PathVariable String inizioTracciamento ,@PathVariable String fineTracciamento, HttpSession session  ) throws BusinessLayerException {
		
		OrderTrackingInputBean inputBean= new OrderTrackingInputBean();
		logger.info("recuper dati OT DB Now request");
		UserBean user = getCurrentUser(session);
		String tipoProfilo = user.getCodiceProfilo();
		String codOloAgcom = user.getCodificaOloAgcom();
		inputBean.setCodOloAgcomUtente(codOloAgcom);
		inputBean.setProfiloUtente(tipoProfilo);
		inputBean.setIdRichiestaOlo(idRichiestaOlo);
		inputBean.setInizioTracciamento(inizioTracciamento);
		inputBean.setFineTracciamento(fineTracciamento);
		GenericListBean<OrderTrackingOutputLevel2Bean> bean = dataRecoveryManagerBL.getOrderTrackingLevel2(inputBean);
		bean = ensureListBeanResult(bean);
		return bean;
	}

	
}
