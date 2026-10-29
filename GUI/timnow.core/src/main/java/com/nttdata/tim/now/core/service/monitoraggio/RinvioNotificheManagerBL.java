package com.nttdata.tim.now.core.service.monitoraggio;

import java.util.List;

import com.nttdata.tim.now.adapters.esb.pps.NotificationResendRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.GeneraNotificheInputBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.GeneraNotificheOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.reinvionotifiche.RinvioNotificheOutputBean;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.CodiceRichiestaDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.ListaGeneraNotificheOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.NotificationRequestListDTO;
import com.nttdata.tim.now.data.dto.monitoring.reinvionotifica.ListaRinvioNotificheOutputDTO;
import com.nttdata.tim.now.data.dto.olo.template.OloRequestListDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RinvioNotificheManagerBL extends AbstractBL {

    @Autowired
    private NotificationResendRESTClient notificationResendRESTClient;

	public GenericListBean<RinvioNotificheOutputBean> resendNotificationLevel1(List<String> body, String tipoProfilo)
			throws BusinessLayerException {
		GenericListBean<RinvioNotificheOutputBean> bean = new GenericListBean<>();
		try {
			OloRequestListDTO inputDto = new OloRequestListDTO();
			inputDto.setIds(body);
			ListaRinvioNotificheOutputDTO dto = notificationResendRESTClient.resendNotificationLevel1(inputDto, tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getNotifications(), RinvioNotificheOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	
	public GenericListBean<GeneraNotificheOutputBean> resendNotificationLevel2(GeneraNotificheInputBean body, String userId, String tipoProfilo)
			throws BusinessLayerException {
		GenericListBean<GeneraNotificheOutputBean> bean = new GenericListBean<>();
		try {
			NotificationRequestListDTO inputDto = mapper.translate(body, NotificationRequestListDTO.class);
            if (inputDto.getListaRichieste()!=null&&inputDto.getListaRichieste().size()>0){
                for (CodiceRichiestaDTO elem : inputDto.getListaRichieste()) {
                	//cambio specifiche per S6 SM_2458 TIIT_NCW_SPF_SISTEMA_NOW_Ord_Tra_e_Monitoraggi_per_S6_v1.4.docx
                	//stato richiesto di passare UserId al posto della matricola
                  elem.setMatricolaOperatoreDaGui(userId);  
                } 
            }
			ListaGeneraNotificheOutputDTO dto = notificationResendRESTClient.resendNotificationLevel2(inputDto, tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getNotifications(), GeneraNotificheOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
