package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.MonitoraggioFatturazioneManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.base.GenericListExportBean;
import com.nttdata.tim.now.data.bean.monitoring.fatturazione.MonitoraggioFatturazioneContatoreOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.fatturazione.MonitoraggioFatturazioneDettaglioOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.fatturazione.MonitoraggioFatturazioneWrapperOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitorings/fatturazione")
public class MonitoraggioFatturazioneController extends GenericController {

    @Autowired
    private MonitoraggioFatturazioneManagerBL monitoraggioFatturazioneManagerBL;

    
	//Monitoraggio Fatturazione -> Testata (Liv 0)
	@JsonGetMapping
	public MonitoraggioFatturazioneWrapperOutputBean getLista(@RequestParam(value = "flagExport", required = false) boolean flagExport, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		MonitoraggioFatturazioneWrapperOutputBean bean = monitoraggioFatturazioneManagerBL.getLista(flagExport, user.getCodiceProfilo(), user.getUserId());
		bean = ensureBeanResult(bean, MonitoraggioFatturazioneWrapperOutputBean.class);
		return bean;
	}

	//Monitoraggio Fatturazione -> Drill Down (Liv 1)
	@JsonGetMapping("/contatore")
	public GenericListExportBean<MonitoraggioFatturazioneContatoreOutputBean> getContatore(
			@RequestParam("dataEstrazione") String dataEstrazione,
			@RequestParam("statoRichiestaNow") String statoRichiestaNow,
			@RequestParam("descrizioneFamigliaOfferta") String descrizioneFamigliaOfferta,
			@RequestParam(value = "flagExport", required = false) boolean flagExport, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListExportBean<MonitoraggioFatturazioneContatoreOutputBean> bean = monitoraggioFatturazioneManagerBL.getContatore(dataEstrazione, statoRichiestaNow, descrizioneFamigliaOfferta, flagExport, user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	//Monitoraggio Fatturazione -> Drill Down (Liv 2)
	@JsonGetMapping("/dettaglio/{codiceOrdineTI}")
	public GenericListBean<MonitoraggioFatturazioneDettaglioOutputBean> getDettaglio(@PathVariable String codiceOrdineTI, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<MonitoraggioFatturazioneDettaglioOutputBean> bean = monitoraggioFatturazioneManagerBL.getDettaglio(codiceOrdineTI, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

}
