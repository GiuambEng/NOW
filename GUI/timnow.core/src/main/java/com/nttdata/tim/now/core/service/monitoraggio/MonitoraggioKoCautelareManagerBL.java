package com.nttdata.tim.now.core.service.monitoraggio;

import com.nttdata.tim.now.adapters.esb.monitoraggio.MonitoraggioKoCautelareRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListExportBean;
import com.nttdata.tim.now.data.bean.monitoring.kocautelare.DettaglioMonitoraggioKoCautelareOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.kocautelare.MonitoraggioKoCautelareOutputBean;
import com.nttdata.tim.now.data.dto.monitoring.kocautelare.ListaDettagliMonitoraggioKoCautelareDTO;
import com.nttdata.tim.now.data.dto.monitoring.kocautelare.ListaMonitoraggiKoCautelareDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoraggioKoCautelareManagerBL extends AbstractBL {

    @Autowired
    private MonitoraggioKoCautelareRESTClient monitoringKoPrecautionaryRESTClient;

    public GenericListExportBean<MonitoraggioKoCautelareOutputBean> getList(boolean flagExport, String tipoProfilo, String userId) throws BusinessLayerException {
        GenericListExportBean<MonitoraggioKoCautelareOutputBean> bean = new GenericListExportBean<>();
        try {
            ListaMonitoraggiKoCautelareDTO outputDto = monitoringKoPrecautionaryRESTClient.getList(flagExport, tipoProfilo, userId);
            validateResponseResult(outputDto);
            bean.setData(mapper.translateList(outputDto.getMonitorings(), MonitoraggioKoCautelareOutputBean.class));
            bean.setEsitoExport(outputDto.getEsitoExport());
            bean.setIdFile(outputDto.getIdFile());
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

    public GenericListExportBean<DettaglioMonitoraggioKoCautelareOutputBean> getDetail(String codiceErrore, String offerta, String tipoProfilo) throws BusinessLayerException {
        GenericListExportBean<DettaglioMonitoraggioKoCautelareOutputBean> bean = new GenericListExportBean<>();
        try {
            ListaDettagliMonitoraggioKoCautelareDTO outputDto = monitoringKoPrecautionaryRESTClient.getDetail(codiceErrore, offerta, tipoProfilo);
            validateResponseResult(outputDto);
            bean.setData(mapper.translateList(outputDto.getMonitorings(), DettaglioMonitoraggioKoCautelareOutputBean.class));
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }
}
