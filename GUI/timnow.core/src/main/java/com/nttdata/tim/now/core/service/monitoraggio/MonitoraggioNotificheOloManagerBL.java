package com.nttdata.tim.now.core.service.monitoraggio;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.monitoraggio.MonitoraggioNotificheOloRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.notificheolo.ListaDettagliMonitoraggioNotificheOloOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.notificheolo.MonitoraggioNotificheOloOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.notificheolo.RichiestaMonitoraggioNotificheOloOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.notificheolo.ListaDettagliMonitoraggioNotificheOloOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.notificheolo.ListaMonitoraggioNotificheOloOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.notificheolo.ListaRichiesteMonitoraggioNotificheOloOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MonitoraggioNotificheOloManagerBL extends AbstractBL {

    @Autowired
    private MonitoraggioNotificheOloRESTClient monitoringOloNotificationRESTClient;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	public RichiestaMonitoraggioNotificheOloOutputBean getRequestOloDetail(String cordiceOrdineTi, String tipoProfilo) throws BusinessLayerException {
		RichiestaMonitoraggioNotificheOloOutputBean bean = null;
		try {
			ListaRichiesteMonitoraggioNotificheOloOutputDTO outputDto = monitoringOloNotificationRESTClient.getOloNotificationMonitoringLevel1(cordiceOrdineTi, tipoProfilo);
			validateResponseResult(outputDto);
			if(outputDto != null && outputDto.getMonitorings() != null && !outputDto.getMonitorings().isEmpty()){
				bean = mapper.translate(outputDto.getMonitorings().get(0), RichiestaMonitoraggioNotificheOloOutputBean.class);
			}
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public ExportableDataOutputBean requestExport(RicercaAvanzataInputBean inputBean, String tipoProfilo, String userId) throws BusinessLayerException {
		ExportableDataOutputBean bean = new ExportableDataOutputBean();
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			ExportableDataOutputDTO dto = monitoringOloNotificationRESTClient.advancedSearch(inputDto, tipoProfilo, userId);
			validateResponseResult(dto);
			bean = mapper.translate(dto, ExportableDataOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	public ListaDettagliMonitoraggioNotificheOloOutputBean advancedSearch(RicercaAvanzataInputBean body, String tipoProfilo, String userId)
			throws BusinessLayerException {
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(body.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata MonitoraggioNotificheOLOManager");
    	}

		ListaDettagliMonitoraggioNotificheOloOutputBean bean = null;
		try {
			AdvancedResearchInputDTO dto = mapper.translate(body, AdvancedResearchInputDTO.class);
			ListaDettagliMonitoraggioNotificheOloOutputDTO outputDto = monitoringOloNotificationRESTClient.advancedSearch(dto, tipoProfilo, userId);
			validateResponseResult(outputDto);
			bean = mapper.translate(outputDto, ListaDettagliMonitoraggioNotificheOloOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<MonitoraggioNotificheOloOutputBean> getOloNotificationMonitoringLevel0(String tipoProfilo, String userId)
			throws BusinessLayerException {
		GenericListBean<MonitoraggioNotificheOloOutputBean> bean = new GenericListBean<>();
		try {
			ListaMonitoraggioNotificheOloOutputDTO outputDto = monitoringOloNotificationRESTClient.getOloNotificationMonitoringLevel0(tipoProfilo, userId);
			validateResponseResult(outputDto);
			bean.setData(mapper.translateList(outputDto.getMonitorings(), MonitoraggioNotificheOloOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
