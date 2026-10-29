package com.nttdata.tim.now.core.service.monitoraggio;

import com.nttdata.tim.now.adapters.esb.monitoraggio.MonitoraggioKoWarningRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListExportBean;
import com.nttdata.tim.now.data.bean.monitoring.warning.DettaglioMonitoraggioKoWarningOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.warning.MonitoraggioKoWarningOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.warning.RichiestaMonitoraggioKoWarningOutputBean;
import com.nttdata.tim.now.data.dto.monitoring.warning.ListaDettagliMonitoraggioKoWarningOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.warning.ListaMonitoraggiKoWarningOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.warning.ListaRichiesteMonitoraggioKoWarningOutputDTO;
import com.nttdata.tim.now.util.date.DateHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoraggioKoWarningManagerBL extends AbstractBL {

    @Autowired
    private MonitoraggioKoWarningRESTClient monitoringKoWarningRESTClient;

	public GenericListExportBean<MonitoraggioKoWarningOutputBean> getKoWarningMonitoringLevel0(boolean flagExport, String tipoProfilo, String userId)
			throws BusinessLayerException {
		GenericListExportBean<MonitoraggioKoWarningOutputBean> bean = new GenericListExportBean<>();
		try {
			ListaMonitoraggiKoWarningOutputDTO dto = monitoringKoWarningRESTClient.getKoWarningMonitoringLevel0(flagExport, tipoProfilo, userId);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getMonitorings(), MonitoraggioKoWarningOutputBean.class));
			bean.setEsitoExport(dto.getEsitoExport());
			bean.setIdFile(dto.getIdFile());
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListExportBean<DettaglioMonitoraggioKoWarningOutputBean> getKoWarningMonitoringLevel1(String dataOperazione,
			String causale, boolean flagExport, String tipoProfilo, String userId) throws BusinessLayerException {
		GenericListExportBean<DettaglioMonitoraggioKoWarningOutputBean> bean = new GenericListExportBean<>();
		try {
			ListaDettagliMonitoraggioKoWarningOutputDTO dto = monitoringKoWarningRESTClient.getKoWarningMonitoringLevel1(DateHelper.convertFromFE(dataOperazione), causale,
					flagExport, tipoProfilo, userId);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getMonitorings(), DettaglioMonitoraggioKoWarningOutputBean.class));
			bean.setEsitoExport(dto.getEsitoExport());
			bean.setIdFile(dto.getIdFile());
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListExportBean<RichiestaMonitoraggioKoWarningOutputBean> getKoWarningMonitoringLevel2(String dataAggiornamento, String codCausaleOLO,
			String tipoErrore, String tipoProfilo) throws BusinessLayerException {
		GenericListExportBean<RichiestaMonitoraggioKoWarningOutputBean> bean = new GenericListExportBean<>();
		try {
			ListaRichiesteMonitoraggioKoWarningOutputDTO outputDto = monitoringKoWarningRESTClient.getKoWarningMonitoringLevel2(DateHelper.convertFromFE(dataAggiornamento), codCausaleOLO, tipoErrore, tipoProfilo);
			validateResponseResult(outputDto);
			bean.setData(mapper.translateList(outputDto.getMonitoring(), RichiestaMonitoraggioKoWarningOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
