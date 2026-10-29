package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.MonitoraggioKoWarningManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListExportBean;
import com.nttdata.tim.now.data.bean.monitoring.warning.DettaglioMonitoraggioKoWarningOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.warning.MonitoraggioKoWarningOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.warning.RichiestaMonitoraggioKoWarningOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitorings/warningKo")
public class KoWarningController extends GenericController {

    @Autowired
    private MonitoraggioKoWarningManagerBL monitoringKoWarningManagerBL;

    
	// MonitoraggioKOWarning
	@JsonGetMapping("/level0")
	public GenericListExportBean<MonitoraggioKoWarningOutputBean> getKoWarningMonitoringLevel0(
			@RequestParam(value = "flagExport") boolean flagExport, HttpSession session) throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
		GenericListExportBean<MonitoraggioKoWarningOutputBean> bean = monitoringKoWarningManagerBL.getKoWarningMonitoringLevel0(flagExport, user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// MonitoraggioKOWarning
	@JsonGetMapping("/level1")
	public GenericListExportBean<DettaglioMonitoraggioKoWarningOutputBean> getKoWarningMonitoringLevel1(
			@RequestParam(value = "dataOperazione") String dataOperazione,
			@RequestParam(value = "causale") String causale,
			@RequestParam(value = "flagExport") boolean flagExport, HttpSession session) throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
		GenericListExportBean<DettaglioMonitoraggioKoWarningOutputBean> bean = monitoringKoWarningManagerBL.getKoWarningMonitoringLevel1(dataOperazione, causale, flagExport, user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// MonitoraggioKOWarning
	@JsonGetMapping("/level2")
	public GenericListExportBean<RichiestaMonitoraggioKoWarningOutputBean> getKoWarningMonitoringLevel2(
			@RequestParam(value = "dataAggiornamento") String dataAggiornamento,
			@RequestParam(value = "codCausaleOLO") String codCausaleOLO,
			@RequestParam(value = "tipoErrore") String tipoErrore, HttpSession session) throws BusinessLayerException {
        UserBean user= getCurrentUser(session);
 		GenericListExportBean<RichiestaMonitoraggioKoWarningOutputBean> bean = monitoringKoWarningManagerBL.getKoWarningMonitoringLevel2(dataAggiornamento, codCausaleOLO,
				tipoErrore, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);

		return bean;
	}

}
