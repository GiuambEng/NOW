package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.MonitoraggioTempiAttraversamentoManagerBL;
import com.nttdata.tim.now.data.bean.monitoring.tempiattraversamento.TempiAttraversamentoOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitorings/times")
public class TempiAttraversamentoController extends GenericController {

    @Autowired
    private MonitoraggioTempiAttraversamentoManagerBL monitoringCrossingTimesManagerBL;

    // MonitoraggioTempiAttraversamento -> Livello 0
	@JsonGetMapping("/level0")
	public TempiAttraversamentoOutputBean getCrossingTimesMonitoringLevel0(
			@RequestParam(value = "flagExport", required = false) boolean flagExport,
			@RequestParam(value = "tipoLista", required = false) String tipoLista, HttpSession session) throws BusinessLayerException {

		UserBean user = getCurrentUser(session);
		TempiAttraversamentoOutputBean bean = monitoringCrossingTimesManagerBL.getCrossingTimesMonitoringLevel0(flagExport, tipoLista, user.getCodiceProfilo(), user.getUserId());

		if (bean != null) {
			logger.debug("Crossing Times Monitoring found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("Crossing Times Monitoring NOT found");
			bean = new TempiAttraversamentoOutputBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}

	// MonitoraggioTempiAttraversamento -> Livello 1
	@JsonGetMapping("/level1")
	public TempiAttraversamentoOutputBean getCrossingTimesMonitoringLevel1(
			@RequestParam(value = "flagExport", required = false) boolean flagExport,
			@RequestParam(value = "idTempiAttraversamento") String idTempiAttraversamento, HttpSession session)
			throws BusinessLayerException {

		UserBean user = getCurrentUser(session);
		TempiAttraversamentoOutputBean bean = monitoringCrossingTimesManagerBL.getCrossingTimesMonitoringLevel1(flagExport, idTempiAttraversamento, user.getCodiceProfilo(), user.getUserId());

		if (bean != null) {
			logger.debug("Crossing Times Monitoring found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("Crossing Times Monitoring NOT found");
			bean = new TempiAttraversamentoOutputBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}
}
