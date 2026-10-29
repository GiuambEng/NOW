package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.MonitoraggioKoDelibera103ManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.monitoring.kodel103.MonitoraggioKoDel103OutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Change Request #42013
@RestController
@RequestMapping("/monitorings_delibera103Ko")
public class KoDelibera103Controller extends GenericController {

	@Autowired
	private MonitoraggioKoDelibera103ManagerBL monitoringKoDelibera103ManagerBL;

	// Ricerca Avanzata
	@JsonPostMapping("/search")
	public GenericListBean<MonitoraggioKoDel103OutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<MonitoraggioKoDel103OutputBean> bean = monitoringKoDelibera103ManagerBL.advancedSearch(body, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}
}
