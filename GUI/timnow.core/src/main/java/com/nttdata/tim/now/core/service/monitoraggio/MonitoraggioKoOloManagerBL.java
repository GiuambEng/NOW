package com.nttdata.tim.now.core.service.monitoraggio;

import com.nttdata.tim.now.adapters.esb.monitoraggio.MonitoraggioKoOloRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.base.GenericListExportBean;
import com.nttdata.tim.now.data.bean.monitoring.koolo.DettaglioMonitoraggioKoOloOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.koolo.MonitoraggioKoOloOutputBean;
import com.nttdata.tim.now.data.dto.monitoring.koolo.ListaDettaglioMonitoraggioKoOloOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.koolo.ListaMonitoraggiiKoOloOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoraggioKoOloManagerBL extends AbstractBL {

    @Autowired
    private MonitoraggioKoOloRESTClient monitoringKoOloRESTClient;

	public GenericListExportBean<MonitoraggioKoOloOutputBean> getKoOloMonitoringLevel0(boolean flagExport, String tipoProfilo, String userId)
			throws BusinessLayerException {
		GenericListExportBean<MonitoraggioKoOloOutputBean> bean = new GenericListExportBean<>();
		try {
			ListaMonitoraggiiKoOloOutputDTO outputDto = monitoringKoOloRESTClient.getKoOloMonitoringLevel0(flagExport, tipoProfilo, userId);
			validateResponseResult(outputDto);
			bean.setData(mapper.translateList(outputDto.getMonitorings(), MonitoraggioKoOloOutputBean.class));
			bean.setEsitoExport(outputDto.getEsitoExport());
			bean.setIdFile(outputDto.getIdFile());
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<DettaglioMonitoraggioKoOloOutputBean> getKoOloMonitoringLevel1(String famiglia, String causale,
			String dataTotale, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<DettaglioMonitoraggioKoOloOutputBean> bean = new GenericListBean<>();
		try {
			ListaDettaglioMonitoraggioKoOloOutputDTO outputDto = monitoringKoOloRESTClient.getKoOloMonitoringLevel1(famiglia, causale,
					dataTotale, tipoProfilo);
			validateResponseResult(outputDto);
			bean.setData(mapper.translateList(outputDto.getMonitorings(), DettaglioMonitoraggioKoOloOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
