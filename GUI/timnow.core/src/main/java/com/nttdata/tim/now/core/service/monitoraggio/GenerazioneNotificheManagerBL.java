package com.nttdata.tim.now.core.service.monitoraggio;

import java.util.List;

import com.nttdata.tim.now.adapters.esb.monitoraggio.NotificationGenerationRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.GeneraNotificheInputBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.GeneraNotificheOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.OloBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.RichiestaOloOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.TipologiaNotificheAtteseInputBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.TipologiaNotificheAtteseOutputBean;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.GeneraNotificheInputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.ListaGeneraNotificheOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.ListaOloOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.ListaRichiesteOloOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.ListaTipologiaNotificheAtteseInputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.ListaTipologiaNotificheAtteseOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.RichiestaGeneraNotificheInputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.TipologiaNotificheAtteseInputDTO;
import com.nttdata.tim.now.data.dto.olo.encoding.CodificaOloDTO;
import com.nttdata.tim.now.util.date.DateHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenerazioneNotificheManagerBL extends AbstractBL {

    @Autowired
    private NotificationGenerationRESTClient notificationGenerationRESTClient;

	public GenericListBean<TipologiaNotificheAtteseOutputBean> pendingNotification(List<TipologiaNotificheAtteseInputBean> body, String tipoProfilo)
			throws BusinessLayerException {
		GenericListBean<TipologiaNotificheAtteseOutputBean> bean = new GenericListBean<>();
		try {
			ListaTipologiaNotificheAtteseInputDTO inputDto = new ListaTipologiaNotificheAtteseInputDTO();
			inputDto.setNotifications(mapper.translateList(body, TipologiaNotificheAtteseInputDTO.class));
			ListaTipologiaNotificheAtteseOutputDTO dto = notificationGenerationRESTClient.pendingNotification(inputDto, tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getNotifications(), TipologiaNotificheAtteseOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<GeneraNotificheOutputBean> notificationGeneration(GeneraNotificheInputBean body, String matricolaOperatoreDaGui, String tipoProfilo)
			throws BusinessLayerException {
		GenericListBean<GeneraNotificheOutputBean> bean = new GenericListBean<>();
		try {
			GeneraNotificheInputDTO inputDto = mapper.translate(body, GeneraNotificheInputDTO.class);
			if (inputDto.getListaRichieste()!=null&&inputDto.getListaRichieste().size()>0){
			    for (RichiestaGeneraNotificheInputDTO elem : inputDto.getListaRichieste()) {
                  elem.setMatricolaOperatoreDaGUI(matricolaOperatoreDaGui);  
                } 
			}
			ListaGeneraNotificheOutputDTO dto = notificationGenerationRESTClient.notificationGeneration(inputDto, tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getNotifications(), GeneraNotificheOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<OloBean> getOlos(String tipoProfilo) throws BusinessLayerException {
		GenericListBean<OloBean> bean = new GenericListBean<>();
		try {
			ListaOloOutputDTO dto = notificationGenerationRESTClient.getOlos(tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getOlos(), OloBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<RichiestaOloOutputBean> getOloRequests(String codOloAgcom, String codOloNow, String dataCreazioneRichiesta, String tipoProfilo)
			throws BusinessLayerException {
		GenericListBean<RichiestaOloOutputBean> bean = new GenericListBean<>();
		try {
			CodificaOloDTO inputDto = new CodificaOloDTO();
			inputDto.setCodificaOloAgcom(codOloAgcom);
			inputDto.setCodificaOloNow(codOloNow);
			inputDto.setDataInvioRichiesta(DateHelper.convertFromFE(dataCreazioneRichiesta));
			ListaRichiesteOloOutputDTO outputDto = notificationGenerationRESTClient.getOloRequests(inputDto, tipoProfilo);
			validateResponseResult(outputDto);
			bean.setData(mapper.translateList(outputDto.getOloRequests(), RichiestaOloOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
