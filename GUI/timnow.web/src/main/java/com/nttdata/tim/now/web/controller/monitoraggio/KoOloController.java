package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.MonitoraggioKoOloManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.base.GenericListExportBean;
import com.nttdata.tim.now.data.bean.monitoring.koolo.DettaglioMonitoraggioKoOloOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.koolo.MonitoraggioKoOloOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitorings/oloKo")
public class KoOloController extends GenericController {

    @Autowired
    private MonitoraggioKoOloManagerBL monitoringKoOloManagerBL;
    
	// MonitoraggioKOOLO -> MonitoraggioKOOlo
	@JsonGetMapping("/level0")
	public GenericListExportBean<MonitoraggioKoOloOutputBean> getKoOloMonitoringLevel0(
			@RequestParam(value = "flagExport") boolean flagExport, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListExportBean<MonitoraggioKoOloOutputBean> bean = monitoringKoOloManagerBL.getKoOloMonitoringLevel0(flagExport, user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// MonitoraggioKOOLO -> DettaglioMonitoraggioKOOLO
	@JsonGetMapping("/level1")
	public GenericListBean<DettaglioMonitoraggioKoOloOutputBean> getKoOloMonitoringLevel1(
			@RequestParam(value = "famiglia") String famiglia,
			@RequestParam(value = "causale") String causale,
			@RequestParam(value = "dataTotale") String dataTotale, HttpSession session) throws BusinessLayerException {

		UserBean user = getCurrentUser(session);
		GenericListBean<DettaglioMonitoraggioKoOloOutputBean> bean = monitoringKoOloManagerBL.getKoOloMonitoringLevel1(famiglia, causale,
				dataTotale, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}
}
