package com.nttdata.tim.now.web.controller.monitoraggio;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.filenotifiche.NotificaManagerBL;
import com.nttdata.tim.now.core.service.monitoraggio.RinvioNotificheManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.GeneraNotificheInputBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.GeneraNotificheOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.OloBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.RichiesaOloOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.reinvionotifiche.RinvioNotificheOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPutMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitoraggio-rinvio-notifiche")
public class RinvioNotificheController extends GenericController {

    @Autowired
    private NotificaManagerBL notificationManagerBL;
    
    @Autowired
    private RinvioNotificheManagerBL notificationResendManagerBL;

	// RinvioNotifica (GET) - elenco OLO
	@JsonGetMapping("/olo")
	public GenericListBean<OloBean> getOLOs(HttpSession session) throws BusinessLayerException {
		logger.info("get notification resend");
		UserBean currentUser = getCurrentUser(session);
		GenericListBean<OloBean> bean = notificationManagerBL.getNotificationResend(currentUser.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// RinvioNotifica - Elenco Richieste per OLO- (GET)
	@JsonGetMapping("/{codOloAgcom:[A-Za-z0-9_: ]+}/{codOloNow}")
	public GenericListBean<RichiesaOloOutputBean> getOloRequests(@PathVariable String codOloAgcom,
			@PathVariable String codOloNow, HttpSession session) throws BusinessLayerException {
		UserBean currentUser = getCurrentUser(session);
		GenericListBean<RichiesaOloOutputBean> bean = notificationManagerBL.resendNotificationRequests(codOloAgcom, codOloNow, currentUser.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// RinvioNotifica -Notifiche- (POST)
	@JsonPutMapping("/send/level1")
	public GenericListBean<RinvioNotificheOutputBean> resendNotificationLevel1(@RequestBody List<String> body, HttpSession session)
			throws BusinessLayerException {
		UserBean currentUser = getCurrentUser(session);
		GenericListBean<RinvioNotificheOutputBean> bean = notificationResendManagerBL.resendNotificationLevel1(body, currentUser.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// RinvioNotifica -Rinvio Notifiche - (POST)
	@JsonPutMapping("/send/level2")
	public GenericListBean<GeneraNotificheOutputBean> resendNotificationLevel2(@RequestBody GeneraNotificheInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean currentUser = getCurrentUser(session);
        String userId = currentUser.getUserId();
    	//cambio specifiche per S6 SM_2458 TIIT_NCW_SPF_SISTEMA_NOW_Ord_Tra_e_Monitoraggi_per_S6_v1.4.docx
    	//stato richiesto di passare UserId al posto della matricola
		GenericListBean<GeneraNotificheOutputBean> bean = notificationResendManagerBL.resendNotificationLevel2(body, userId, currentUser.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}
}
