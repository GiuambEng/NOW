package com.nttdata.tim.now.web.controller.filenotifiche;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.filenotifiche.NotificaManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
import com.nttdata.tim.now.data.bean.notifica.FileNotificheOutputBean;
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
@RequestMapping("/notifications")
public class FileDiNotificheController extends GenericController {

    @Autowired
    private NotificaManagerBL notificationManagerBL;

	// File -> File di Notifiche
	@JsonGetMapping
	public GenericListBean<FileNotificheOutputBean> getAllNotificationFiles(HttpSession session)
			throws BusinessLayerException {
		logger.info("get notifications");
		UserBean currentUser = getCurrentUser(session);
		GenericListBean<FileNotificheOutputBean> bean = notificationManagerBL.getAllNotificationFiles(currentUser.getCodificaOloAgcom(),
				currentUser.getCodiceProfilo(), currentUser.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Ordine -> Visualizza File Notifiche
	@JsonGetMapping("/{orderNumber:[A-Za-z0-9_:]+}")
	public GenericListBean<FileNotificheOutputBean> getNotifications(@PathVariable String orderNumber, HttpSession session)
			throws BusinessLayerException {
		logger.info("get notifications");
		UserBean user = getCurrentUser(session);
		GenericListBean<FileNotificheOutputBean> bean = notificationManagerBL.getNotifications(orderNumber, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

    // Ricerca Avanzata export
    @JsonPostMapping("/search")
    public GenericListBean<FileNotificheOutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session) throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
        GenericListBean<FileNotificheOutputBean> bean = notificationManagerBL.fileDiNotificheAdvanceResearch(body, user.getCodificaOloAgcom(), user.getCodiceProfilo(), user.getUserId());
        bean = ensureListBeanResult(bean);
        return bean;
    }


	// Ricerca Avanzata export
	@JsonPostMapping("/export")
	public ExportableDataOutputBean requestExport(@RequestBody RicercaAvanzataInputBean body, @RequestParam(value = "selectedOLO", required = false) String selectedOLO, HttpSession session) throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
        ExportableDataOutputBean bean = notificationManagerBL.requestExport(body, user.getCodificaOloAgcom(), user.getCodiceProfilo(), user.getUserId());
		ensureBeanResult(bean, ExportableDataOutputBean.class);
        return bean;
	}

}
