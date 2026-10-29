package com.nttdata.tim.now.core.service.monitoraggio;

import com.nttdata.tim.now.adapters.esb.monitoraggio.MonitoraggioTempiAttraversamentoRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.monitoring.tempiattraversamento.TempiAttraversamentoOutputBean;
import com.nttdata.tim.now.data.dto.monitoring.tempiattraversamento.TempiAttraversamentoOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoraggioTempiAttraversamentoManagerBL extends AbstractBL {

    @Autowired
    private MonitoraggioTempiAttraversamentoRESTClient monitoringCrossingTimesRESTClient;

	public TempiAttraversamentoOutputBean getCrossingTimesMonitoringLevel0(boolean flagExport, String tipoLista, String tipoProfilo, String userId) throws BusinessLayerException {
		TempiAttraversamentoOutputBean bean = null;
		try {
			TempiAttraversamentoOutputDTO outputDto = monitoringCrossingTimesRESTClient.getCrossingTimesMonitoringLevel0(flagExport, tipoLista, tipoProfilo, userId);
			validateResponseResult(outputDto);
			bean = mapper.translate(outputDto, TempiAttraversamentoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public TempiAttraversamentoOutputBean getCrossingTimesMonitoringLevel1(boolean flagExport, String idTempiAttraversamento, String tipoProfilo, String userId) throws BusinessLayerException {
		TempiAttraversamentoOutputBean bean = null;
		try {
			TempiAttraversamentoOutputDTO outputDto = monitoringCrossingTimesRESTClient.getCrossingTimesMonitoringLevel1(flagExport, idTempiAttraversamento, tipoProfilo, userId);
			validateResponseResult(outputDto);
			bean = mapper.translate(outputDto, TempiAttraversamentoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
}
