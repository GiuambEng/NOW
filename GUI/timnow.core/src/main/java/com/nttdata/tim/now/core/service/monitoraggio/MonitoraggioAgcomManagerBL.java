package com.nttdata.tim.now.core.service.monitoraggio;

import com.nttdata.tim.now.adapters.esb.monitoraggio.MonitoraggioAgcomRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListExportBean;
import com.nttdata.tim.now.data.bean.monitoring.agcom.MonitoraggioAgcomT1Bean;
import com.nttdata.tim.now.data.bean.monitoring.agcom.MonitoraggioAgcomT2Bean;
import com.nttdata.tim.now.data.bean.monitoring.agcom.MonitoraggioAgcomT3Bean;
import com.nttdata.tim.now.data.bean.monitoring.agcom.MonitoraggioAgcomT4Bean;
import com.nttdata.tim.now.data.bean.monitoring.agcom.MonitoraggioAgcomT5Bean;
import com.nttdata.tim.now.data.dto.monitoring.agcom.MonitoraggioAgcomT1OutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.agcom.MonitoraggioAgcomT2OutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.agcom.MonitoraggioAgcomT3OutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.agcom.MonitoraggioAgcomT4OutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.agcom.MonitoraggioAgcomT5OutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;
import com.nttdata.tim.now.util.date.DateHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoraggioAgcomManagerBL extends AbstractBL {

    @Autowired
    private MonitoraggioAgcomRESTClient monitoraggioAgcomRESTClient;


	public GenericListExportBean<MonitoraggioAgcomT1Bean> getListaT1(String flagDettaglio, String dataEstrazione, boolean flagExport, String tipoProfilo, String userId) throws BusinessLayerException {
		GenericListExportBean<MonitoraggioAgcomT1Bean> bean = new GenericListExportBean<>();
		
		Boolean flag = mapper.translate(flagDettaglio, Boolean.class);
		flag.booleanValue();
		String flagDettaglioToSend = mapper.translate(flag, String.class);
		
		String dateToBe = DateHelper.convertFromFE(dataEstrazione, DateHelper.DATE_FORMAT_A);
		
		try {
			MonitoraggioAgcomT1OutputDTO dto = monitoraggioAgcomRESTClient.getDettaglioT1(flagDettaglioToSend, dateToBe, flagExport, tipoProfilo, userId);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getMonitorings(), MonitoraggioAgcomT1Bean.class));
			bean.setEsitoExport(dto.getEsitoExport());
			bean.setIdFile(dto.getIdFile());
		} catch (IntegrationLayerException e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}


	public GenericListExportBean<MonitoraggioAgcomT2Bean> getListaT2(String flagDettaglio, String dataEstrazione, boolean flagExport, String tipoProfilo, String userId) throws BusinessLayerException {
		GenericListExportBean<MonitoraggioAgcomT2Bean> bean = new GenericListExportBean<>();
		
		Boolean flag = mapper.translate(flagDettaglio, Boolean.class);
		flag.booleanValue();
		String flagDettaglioToSend = mapper.translate(flag, String.class);
		
		String dateToBe = DateHelper.convertFromFE(dataEstrazione, DateHelper.DATE_FORMAT_A);
		
		try {
			MonitoraggioAgcomT2OutputDTO dto = monitoraggioAgcomRESTClient.getDettaglioT2(flagDettaglioToSend, dateToBe, flagExport, tipoProfilo, userId);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getMonitorings(), MonitoraggioAgcomT2Bean.class));
	        bean.setEsitoExport(dto.getEsitoExport());
	        bean.setIdFile(dto.getIdFile());
		} catch (IntegrationLayerException e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}


	public GenericListExportBean<MonitoraggioAgcomT3Bean> getListaT3(String dataEstrazione, boolean flagExport, String tipoProfilo, String userId) throws BusinessLayerException {
		GenericListExportBean<MonitoraggioAgcomT3Bean> bean = new GenericListExportBean<>();
		
		String dateToBe = DateHelper.convertFromFE(dataEstrazione, DateHelper.DATE_FORMAT_A);
		
		try {
			MonitoraggioAgcomT3OutputDTO dto = monitoraggioAgcomRESTClient.getDettaglioT3(dateToBe, flagExport, tipoProfilo, userId);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getMonitorings(), MonitoraggioAgcomT3Bean.class));
	        bean.setEsitoExport(dto.getEsitoExport());
	        bean.setIdFile(dto.getIdFile());
		} catch (IntegrationLayerException e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}


	public GenericListExportBean<MonitoraggioAgcomT4Bean> getListaT4(String dataEstrazione, boolean flagExport, String tipoProfilo, String userId) throws BusinessLayerException {
		GenericListExportBean<MonitoraggioAgcomT4Bean> bean = new GenericListExportBean<>();
		
		String dateToBe = DateHelper.convertFromFE(dataEstrazione, DateHelper.DATE_FORMAT_A);
		
		try {
			MonitoraggioAgcomT4OutputDTO dto = monitoraggioAgcomRESTClient.getDettaglioT4(dateToBe, flagExport, tipoProfilo, userId);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getMonitorings(), MonitoraggioAgcomT4Bean.class));
	        bean.setEsitoExport(dto.getEsitoExport());
	        bean.setIdFile(dto.getIdFile());
		} catch (IntegrationLayerException e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	public GenericListExportBean<MonitoraggioAgcomT5Bean> getListaT5(String dataEstrazione, boolean flagExport, String tipoProfilo, String userId) throws BusinessLayerException {
		GenericListExportBean<MonitoraggioAgcomT5Bean> bean = new GenericListExportBean<>();
		
		String dateToBe = DateHelper.convertFromFE(dataEstrazione, DateHelper.DATE_FORMAT_A);
		
		try {
			MonitoraggioAgcomT5OutputDTO dto = monitoraggioAgcomRESTClient.getDettaglioT5(dateToBe, flagExport, tipoProfilo, userId);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getMonitorings(), MonitoraggioAgcomT5Bean.class));
	        bean.setEsitoExport(dto.getEsitoExport());
	        bean.setIdFile(dto.getIdFile());
		} catch (IntegrationLayerException e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

}
