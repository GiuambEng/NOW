package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.MonitoraggioAgcomManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListExportBean;
import com.nttdata.tim.now.data.bean.monitoring.agcom.MonitoraggioAgcomT1Bean;
import com.nttdata.tim.now.data.bean.monitoring.agcom.MonitoraggioAgcomT2Bean;
import com.nttdata.tim.now.data.bean.monitoring.agcom.MonitoraggioAgcomT3Bean;
import com.nttdata.tim.now.data.bean.monitoring.agcom.MonitoraggioAgcomT4Bean;
import com.nttdata.tim.now.data.bean.monitoring.agcom.MonitoraggioAgcomT5Bean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitorings/agcom")
public class MonitoraggioAgcomController extends GenericController {

    @Autowired
    private MonitoraggioAgcomManagerBL monitoraggioAgcomManagerBL;

    // Monitoraggio Agcom (Livello 1)
    @JsonGetMapping("/livello1/{flagDettaglio}")
    public GenericListExportBean<MonitoraggioAgcomT1Bean> getListaT1(
            @PathVariable String flagDettaglio, @RequestParam(value = "dataEstrazione", required = true) String dataEstrazione,
            @RequestParam(value = "flagExport", required = false) boolean flagExport, HttpSession session) throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
    	GenericListExportBean<MonitoraggioAgcomT1Bean> bean = monitoraggioAgcomManagerBL.getListaT1(flagDettaglio, dataEstrazione, flagExport, user.getCodiceProfilo(), user.getUserId());
        bean = ensureListBeanResult(bean);
        return bean;
    }

    // Monitoraggio Agcom (Livello 2)
    @JsonGetMapping("/livello2/{flagDettaglio}")
    public GenericListExportBean<MonitoraggioAgcomT2Bean> getListaT2(
            @PathVariable String flagDettaglio, @RequestParam(value = "dataEstrazione", required = true) String dataEstrazione,
            @RequestParam(value = "flagExport", required = false) boolean flagExport, HttpSession session) throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
        GenericListExportBean<MonitoraggioAgcomT2Bean> bean = monitoraggioAgcomManagerBL.getListaT2(flagDettaglio, dataEstrazione, flagExport, user.getCodiceProfilo(), user.getUserId());
        bean = ensureListBeanResult(bean);
        return bean;
    }

    // Monitoraggio Agcom (Livello 3)
    @JsonGetMapping("/livello3")
    public GenericListExportBean<MonitoraggioAgcomT3Bean> getListaT3(
            @RequestParam(value = "dataEstrazione", required = true) String dataEstrazione,
            @RequestParam(value = "flagExport", required = false) boolean flagExport, HttpSession session) throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
        GenericListExportBean<MonitoraggioAgcomT3Bean> bean = monitoraggioAgcomManagerBL.getListaT3(dataEstrazione, flagExport, user.getCodiceProfilo(), user.getUserId());
        bean = ensureListBeanResult(bean);
        return bean;
    }

    // Monitoraggio Agcom (Livello 4)
    @JsonGetMapping("/livello4")
    public GenericListExportBean<MonitoraggioAgcomT4Bean> getListaT4(
            @RequestParam(value = "dataEstrazione", required = true) String dataEstrazione,
            @RequestParam(value = "flagExport", required = false) boolean flagExport, HttpSession session) throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
        GenericListExportBean<MonitoraggioAgcomT4Bean> bean = monitoraggioAgcomManagerBL.getListaT4(dataEstrazione, flagExport, user.getCodiceProfilo(), user.getUserId());
        bean = ensureListBeanResult(bean);
        return bean;
    }

    // Monitoraggio Agcom (Livello 5)
    @JsonGetMapping("/livello5")
    public GenericListExportBean<MonitoraggioAgcomT5Bean> getListaT5(
            @RequestParam(value = "dataEstrazione", required = true) String dataEstrazione,
            @RequestParam(value = "flagExport", required = false) boolean flagExport, HttpSession session) throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
        GenericListExportBean<MonitoraggioAgcomT5Bean> bean = monitoraggioAgcomManagerBL.getListaT5(dataEstrazione, flagExport, user.getCodiceProfilo(), user.getUserId());
        bean = ensureListBeanResult(bean);
        return bean;
    }

}
