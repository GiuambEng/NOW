package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.MonitoraggioKoCautelareManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.base.GenericListExportBean;
import com.nttdata.tim.now.data.bean.monitoring.kocautelare.DettaglioMonitoraggioKoCautelareOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.kocautelare.MonitoraggioKoCautelareOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitorings/precautionaryKo")
public class KoCautelareController extends GenericController {

    
    @Autowired
    private MonitoraggioKoCautelareManagerBL monitoringKoCautelareManagerBL;

    // MonitoraggioKOCautelare -> MonitoraggioKOCautelare
    @JsonGetMapping("/level0")
    public GenericListBean<MonitoraggioKoCautelareOutputBean> getList(@RequestParam(value = "flagExport", required = false) boolean flagExport, HttpSession session)
            throws BusinessLayerException {
        UserBean user =  getCurrentUser(session);
        GenericListExportBean<MonitoraggioKoCautelareOutputBean> bean = monitoringKoCautelareManagerBL.getList(flagExport, user.getCodiceProfilo(), user.getUserId());
        bean = ensureListBeanResult(bean);
        return bean;
    }

    // MonitoraggioKOCautelare -> DettaglioMonitoraggioKOCautelare
    @JsonGetMapping("/level1")
    public GenericListExportBean<DettaglioMonitoraggioKoCautelareOutputBean> getDetail(
            @RequestParam(value = "codiceErrore") String codiceErrore,
            @RequestParam(value = "offerta") String offerta, HttpSession session) throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
        GenericListExportBean<DettaglioMonitoraggioKoCautelareOutputBean> bean = monitoringKoCautelareManagerBL.getDetail(codiceErrore, offerta, user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
    }
}
