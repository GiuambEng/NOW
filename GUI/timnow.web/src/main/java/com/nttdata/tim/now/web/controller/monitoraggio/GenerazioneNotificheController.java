package com.nttdata.tim.now.web.controller.monitoraggio;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.GenerazioneNotificheManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.GeneraNotificheInputBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.GeneraNotificheOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.OloBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.RichiestaOloOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.TipologiaNotificheAtteseInputBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.TipologiaNotificheAtteseOutputBean;
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
@RequestMapping("/generazione-notifiche")
public class GenerazioneNotificheController extends GenericController {

    @Autowired
    private GenerazioneNotificheManagerBL generazioneNotificheManagerBL;
	// GenarazioneNotificheDaTemplate_LISTA_OLO -> ListaTipologiaNotificheAttese
	@JsonPostMapping("/notificheAttese")
	public GenericListBean<TipologiaNotificheAtteseOutputBean> pendingNotification(@RequestBody List<TipologiaNotificheAtteseInputBean> body, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<TipologiaNotificheAtteseOutputBean> bean = generazioneNotificheManagerBL.pendingNotification(body, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// GenarazioneNotificheDaTemplate_LISTA_OLO -> GeneraNotifiche
	@JsonPostMapping
	public GenericListBean<GeneraNotificheOutputBean> notificationGeneration(
			@RequestBody GeneraNotificheInputBean body , HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		String matricolaOperatoreDaGui = user.getMatricola();
		GenericListBean<GeneraNotificheOutputBean> bean = generazioneNotificheManagerBL.notificationGeneration(body, matricolaOperatoreDaGui, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// GenarazioneNotificheDaTemplate_LISTA_OLO -> LISTA_OLO
	@JsonGetMapping
	public GenericListBean<OloBean> getOlos(HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<OloBean> bean = generazioneNotificheManagerBL.getOlos(user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// GenarazioneNotificheDaTemplate_LISTA_OLO -> ListaRichiesteOlo
	@JsonGetMapping("/{codOloAgcom:[A-Za-z0-9_: ]+}/{codOloNow:[A-Za-z0-9_: ]+}")
	public GenericListBean<RichiestaOloOutputBean> getOloRequests(@PathVariable String codOloAgcom,
			@PathVariable String codOloNow, @RequestParam(value = "dataCreazione") String dataCreazione, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<RichiestaOloOutputBean> bean = generazioneNotificheManagerBL.getOloRequests(codOloAgcom, codOloNow, dataCreazione, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}
}
