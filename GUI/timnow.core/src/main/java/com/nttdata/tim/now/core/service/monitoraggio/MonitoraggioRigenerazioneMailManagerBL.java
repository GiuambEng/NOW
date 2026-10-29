package com.nttdata.tim.now.core.service.monitoraggio;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.monitoraggio.MonitoraggioRigenerazioneMailRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.codice.CodiceOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.rigenerazionemail.ListaRichiesteMonitoraggioRigenerazioneMailOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.rigenerazionemail.NotificheMonitoraggioRigenerazioneMailOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.rigenerazionemail.RinvioNotificheMonitoraggioRigenerazioneMailListInputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.codice.ListaCodiceOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.rigenerazionemail.ListaNotificheMonitoraggioRigenerazioneMailOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.rigenerazionemail.ListaRichiesteMonitoraggioRigenerazioneMailOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.rigenerazionemail.RinvioNotificheMonitoraggioRigenerazioneMailListInputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MonitoraggioRigenerazioneMailManagerBL extends AbstractBL {

    @Autowired
    private MonitoraggioRigenerazioneMailRESTClient monitoraggioRigenerazioneMailRESTClient;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

    
	public ListaRichiesteMonitoraggioRigenerazioneMailOutputBean advancedSearch(RicercaAvanzataInputBean body, String tipoProfilo, String userId)
			throws BusinessLayerException {
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(body.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata MonitoraggioRigenerazioneMailManager");
    	}
		
		ListaRichiesteMonitoraggioRigenerazioneMailOutputBean bean = null;
		try {
			AdvancedResearchInputDTO dto = mapper.translate(body, AdvancedResearchInputDTO.class);
			ListaRichiesteMonitoraggioRigenerazioneMailOutputDTO outputDto = monitoraggioRigenerazioneMailRESTClient.advancedSearch(dto, tipoProfilo, userId);
			validateResponseResult(outputDto);
			bean = mapper.translate(outputDto, ListaRichiesteMonitoraggioRigenerazioneMailOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}


	public GenericListBean<NotificheMonitoraggioRigenerazioneMailOutputBean> getListaNotifiche(String idRichiestaOlo, String tipoProfilo, String userId)
			throws BusinessLayerException {
		GenericListBean<NotificheMonitoraggioRigenerazioneMailOutputBean> bean = new GenericListBean<>();
		try {
			ListaNotificheMonitoraggioRigenerazioneMailOutputDTO outputDto = monitoraggioRigenerazioneMailRESTClient.getListaNotifiche(idRichiestaOlo, tipoProfilo, userId);
			validateResponseResult(outputDto);
			bean.setData(mapper.translateList(outputDto.getNotifiche(), NotificheMonitoraggioRigenerazioneMailOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}


	public GenericListBean<CodiceOutputBean> invioNotifiche(RinvioNotificheMonitoraggioRigenerazioneMailListInputBean input, String tipoProfilo)  throws BusinessLayerException {
		GenericListBean<CodiceOutputBean> bean = new GenericListBean<>();
		try {
			RinvioNotificheMonitoraggioRigenerazioneMailListInputDTO inputDto = mapper.translate(input, RinvioNotificheMonitoraggioRigenerazioneMailListInputDTO.class);
			ListaCodiceOutputDTO dto = monitoraggioRigenerazioneMailRESTClient.invioNotifiche(inputDto, tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getCodes(), CodiceOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
}
