package com.nttdata.tim.now.core.service.monitoraggio;

import com.nttdata.tim.now.adapters.esb.monitoraggio.MonitoraggioFileRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.monitoring.file.ContatoreMonitoraggioFileInputBean;
import com.nttdata.tim.now.data.bean.monitoring.file.ContatoreMonitoraggioFileOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.file.DettaglioMonitoraggioFileOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.file.ListaContatoriMonitoraggioFileOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.file.MonitoraggioFileOutputBean;
import com.nttdata.tim.now.data.dto.monitoring.file.ContatoreMonitoraggioFileInputDTO;
import com.nttdata.tim.now.data.dto.monitoring.file.DettaglioMonitoraggioFileOutputWrapperDTO;
import com.nttdata.tim.now.data.dto.monitoring.file.ListaContatoriMonitoraggioFileOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.file.MonitoraggioFileOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoraggioFileManagerBL extends AbstractBL {

    @Autowired
    private MonitoraggioFileRESTClient monitoraggioFileRESTClient;


	public MonitoraggioFileOutputBean getLista(boolean flagExport, String tipoProfilo, String userId) throws BusinessLayerException {
		MonitoraggioFileOutputBean bean = null;
		try {
			MonitoraggioFileOutputDTO dto = monitoraggioFileRESTClient.getLista(flagExport, tipoProfilo, userId);
			validateResponseResult(dto);
			bean = mapper.translate(dto, MonitoraggioFileOutputBean.class);
		} catch (IntegrationLayerException e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public ListaContatoriMonitoraggioFileOutputBean getContatori(ContatoreMonitoraggioFileInputBean body, String tipoProfilo, String userId)
			throws BusinessLayerException {
	    ListaContatoriMonitoraggioFileOutputBean bean = new ListaContatoriMonitoraggioFileOutputBean();
		try {
			ListaContatoriMonitoraggioFileOutputDTO dto = monitoraggioFileRESTClient.getContatori(mapper.translate(body, ContatoreMonitoraggioFileInputDTO.class), tipoProfilo, userId);
			validateResponseResult(dto);
            bean.setMonitorings(mapper.translateList(dto.getMonitorings(), ContatoreMonitoraggioFileOutputBean.class));
            bean.setIdFile(dto.getIdFile());
		} catch (IntegrationLayerException e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public DettaglioMonitoraggioFileOutputBean getDettaglio(String idFileProcessato, String tipoContatore, String tipoProfilo)
			throws BusinessLayerException {
		DettaglioMonitoraggioFileOutputBean bean = null;
		try {
			DettaglioMonitoraggioFileOutputWrapperDTO dto = monitoraggioFileRESTClient.getDettaglio(idFileProcessato, tipoContatore, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto.getMonitoring(), DettaglioMonitoraggioFileOutputBean.class);
		} catch (IntegrationLayerException e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

}
