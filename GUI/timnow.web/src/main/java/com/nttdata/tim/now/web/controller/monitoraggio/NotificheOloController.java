package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.MonitoraggioNotificheOloManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.notificheolo.ListaDettagliMonitoraggioNotificheOloOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.notificheolo.MonitoraggioNotificheOloOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.notificheolo.RichiestaMonitoraggioNotificheOloOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitoraggio-notifiche-olo")
public class NotificheOloController extends GenericController {
    
    @Autowired
    private MonitoraggioNotificheOloManagerBL monitoringOloNotificationManagerBL;

	// Monitoraggionotifiche_OLO
	@JsonPostMapping("/search")
	public ListaDettagliMonitoraggioNotificheOloOutputBean createOloNotificationMonitoring(@RequestBody RicercaAvanzataInputBean body, HttpSession session) throws BusinessLayerException {
		logger.info("create Olo Notification Monitoring");
		UserBean user = getCurrentUser(session);
		ListaDettagliMonitoraggioNotificheOloOutputBean bean = monitoringOloNotificationManagerBL.advancedSearch(body, user.getCodiceProfilo(), user.getUserId());
		if (bean != null) {
			logger.debug("Olo Notifications found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("Olo Notifications NOT found");
			bean = new ListaDettagliMonitoraggioNotificheOloOutputBean();
			bean.setResult(getResultNotFound());
		}
		return bean;
	}

	@JsonPostMapping("/export")
	public ExportableDataOutputBean requestExport(@RequestBody RicercaAvanzataInputBean input, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		ExportableDataOutputBean bean = monitoringOloNotificationManagerBL.requestExport(input, user.getCodiceProfilo(), user.getUserId());

		if (bean != null) {
			logger.debug("Research found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("Research NOT found");
			bean = new ExportableDataOutputBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}

	// Monitoraggionotifiche_OLO -> dettaglio richiesta
	@JsonGetMapping("/request-detail")
	public RichiestaMonitoraggioNotificheOloOutputBean getOloNotificationMonitoringLevel1(@RequestParam(value = "cordiceOrdineTi") String cordiceOrdineTi, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		RichiestaMonitoraggioNotificheOloOutputBean bean = monitoringOloNotificationManagerBL.getRequestOloDetail(cordiceOrdineTi, user.getCodiceProfilo());
		if (bean != null) {
			logger.debug("RequestOLO found");
			bean.setResult(getSuccessResult());
		} else {
			bean = new RichiestaMonitoraggioNotificheOloOutputBean();
			bean.setResult(getResultNotFound());
		}
		return bean;
	}

	// Monitoraggionotifiche_OLO -> monitoraggionotifiche_olo
	@JsonGetMapping
	public GenericListBean<MonitoraggioNotificheOloOutputBean> getOloNotificationMonitoringLevel0(HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<MonitoraggioNotificheOloOutputBean> bean = monitoringOloNotificationManagerBL.getOloNotificationMonitoringLevel0(user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}
	
}
