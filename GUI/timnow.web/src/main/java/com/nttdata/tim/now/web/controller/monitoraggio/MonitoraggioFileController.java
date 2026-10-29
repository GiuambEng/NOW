package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.MonitoraggioFileManagerBL;
import com.nttdata.tim.now.data.bean.monitoring.file.ContatoreMonitoraggioFileInputBean;
import com.nttdata.tim.now.data.bean.monitoring.file.DettaglioMonitoraggioFileOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.file.ListaContatoriMonitoraggioFileOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.file.MonitoraggioFileOutputBean;
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
@RequestMapping("/monitorings/file")
public class MonitoraggioFileController extends GenericController {

    @Autowired
    private MonitoraggioFileManagerBL monitoraggioFileManagerBL;
    
	// Monitoraggio File (Livello 0)
	@JsonGetMapping
	public MonitoraggioFileOutputBean getLista(
			@RequestParam(value = "flagExport", required = false) boolean flagExport, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		MonitoraggioFileOutputBean bean = monitoraggioFileManagerBL.getLista(flagExport, user.getCodiceProfilo(), user.getUserId());
		bean = ensureBeanResult(bean, MonitoraggioFileOutputBean.class);
		return bean;
	}

	// Monitoraggio File (Livello 1)
	@JsonPostMapping("/contatore")
	public ListaContatoriMonitoraggioFileOutputBean getContatori(
			@RequestBody ContatoreMonitoraggioFileInputBean body, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
	    ListaContatoriMonitoraggioFileOutputBean bean = monitoraggioFileManagerBL.getContatori(body, user.getCodiceProfilo(), user.getUserId());
        bean = ensureBeanResult(bean, ListaContatoriMonitoraggioFileOutputBean.class);
		return bean;
	}
	

	// Monitoraggio File (Livello 2)
	@JsonGetMapping("/dettaglio")
	public DettaglioMonitoraggioFileOutputBean getDettaglio(@RequestParam("idFileProcessato") String idFileProcessato,
			@RequestParam("tipoContatore") String tipoContatore, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
        DettaglioMonitoraggioFileOutputBean bean = monitoraggioFileManagerBL.getDettaglio(idFileProcessato, tipoContatore, user.getCodiceProfilo());
		bean = ensureBeanResult(bean, DettaglioMonitoraggioFileOutputBean.class);
		return bean;
	}

}
