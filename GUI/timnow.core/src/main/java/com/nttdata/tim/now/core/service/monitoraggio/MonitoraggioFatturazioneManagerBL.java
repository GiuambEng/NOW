package com.nttdata.tim.now.core.service.monitoraggio;

import com.nttdata.tim.now.adapters.esb.monitoraggio.MonitoraggioFatturazioneRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.base.GenericListExportBean;
import com.nttdata.tim.now.data.bean.monitoring.fatturazione.MonitoraggioFatturazioneContatoreOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.fatturazione.MonitoraggioFatturazioneDettaglioOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.fatturazione.MonitoraggioFatturazioneWrapperOutputBean;
import com.nttdata.tim.now.data.dto.monitoring.fatturazione.MonitoraggioFatturazioneContatoreListOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.fatturazione.MonitoraggioFatturazioneDettaglioListOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.fatturazione.MonitoraggioFatturazioneWrapperOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoraggioFatturazioneManagerBL extends AbstractBL {

    @Autowired
    private MonitoraggioFatturazioneRESTClient monitoraggioFatturazioneRESTClient;

	public MonitoraggioFatturazioneWrapperOutputBean getLista(boolean flagExport, String tipoProfilo, String userId) throws BusinessLayerException {
		MonitoraggioFatturazioneWrapperOutputBean bean = null;
		try {
			MonitoraggioFatturazioneWrapperOutputDTO dto = monitoraggioFatturazioneRESTClient.getList(flagExport, tipoProfilo, userId);
			validateResponseResult(dto);
			bean = mapper.translate(dto, MonitoraggioFatturazioneWrapperOutputBean.class);
		} catch (IntegrationLayerException e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListExportBean<MonitoraggioFatturazioneContatoreOutputBean> getContatore(String dataEstrazione,
			String statoRichiestaNow, String descrizioneFamigliaOfferta, boolean flagExport, String tipoProfilo, String userId)
			throws BusinessLayerException {
		GenericListExportBean<MonitoraggioFatturazioneContatoreOutputBean> bean = new GenericListExportBean<>();
		try {
			MonitoraggioFatturazioneContatoreListOutputDTO dto = monitoraggioFatturazioneRESTClient.getContatore(dataEstrazione, statoRichiestaNow, descrizioneFamigliaOfferta, flagExport, tipoProfilo, userId);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getList(), MonitoraggioFatturazioneContatoreOutputBean.class));
			bean.setEsitoExport(dto.getEsitoExport());
			bean.setIdFile(dto.getIdFile());
		} catch (IntegrationLayerException e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<MonitoraggioFatturazioneDettaglioOutputBean> getDettaglio(String codiceOrdineTI, String tipoProfilo)
			throws BusinessLayerException {
		GenericListBean<MonitoraggioFatturazioneDettaglioOutputBean> bean = new GenericListBean<>();
		try {
			MonitoraggioFatturazioneDettaglioListOutputDTO dto = monitoraggioFatturazioneRESTClient.getDetail(codiceOrdineTI, tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getList(), MonitoraggioFatturazioneDettaglioOutputBean.class));
		} catch (IntegrationLayerException e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

}
