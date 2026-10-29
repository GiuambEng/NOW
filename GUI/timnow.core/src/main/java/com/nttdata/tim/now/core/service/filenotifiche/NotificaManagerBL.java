package com.nttdata.tim.now.core.service.filenotifiche;

import com.nttdata.tim.now.adapters.esb.filenotifiche.NotificaRESTClient;
import com.nttdata.tim.now.adapters.esb.pps.NotificationResendRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.OloBean;
import com.nttdata.tim.now.data.bean.monitoring.generanotifiche.RichiesaOloOutputBean;
import com.nttdata.tim.now.data.bean.notifica.FileNotificheOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.generanotifiche.ListaOloOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.reinvionotifica.RichiestaRinvioNotificaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.notifica.ListaFileNotificheOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificaManagerBL extends AbstractBL {

    @Autowired
    private NotificaRESTClient notificationRESTClient;
    
    @Autowired
    private NotificationResendRESTClient notificationResendRESTClient;


	public GenericListBean<FileNotificheOutputBean> getNotifications(String orderCode, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<FileNotificheOutputBean> list = new GenericListBean<>();
		try {
			ListaFileNotificheOutputDTO dto = notificationRESTClient.getNotifications(orderCode, tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getNotificationFiles(), FileNotificheOutputBean.class));
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public GenericListBean<FileNotificheOutputBean> getAllNotificationFiles(String codOloAgcom, String tipoProfilo, String userId)
			throws BusinessLayerException {
		GenericListBean<FileNotificheOutputBean> list = new GenericListBean<>();
        boolean isLimited;
		//Gestione lista limitata
		try {
			ListaFileNotificheOutputDTO dto = notificationRESTClient.getAllNotificationFiles(codOloAgcom, tipoProfilo, userId);
			isLimited = validateResponseResult(dto);
			if (dto != null && dto.getNotificationFiles() != null) {
				list.setData(mapper.translateList(dto.getNotificationFiles(), FileNotificheOutputBean.class));
				list.setIsLimitedList(isLimited);
			}
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public GenericListBean<RichiesaOloOutputBean> resendNotificationRequests(String codOloAgcom, String codOloNow, String tipoProfilo)
			throws BusinessLayerException {
		GenericListBean<RichiesaOloOutputBean> bean = new GenericListBean<>();
		try {
			RichiestaRinvioNotificaWrapperOutputDTO dto = notificationResendRESTClient.resendNotificationRequests(codOloAgcom, codOloNow, tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getOloRequests(), RichiesaOloOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<OloBean> getNotificationResend(String tipoProfilo) throws BusinessLayerException {
		GenericListBean<OloBean> bean = new GenericListBean<>();
		try {
			ListaOloOutputDTO dto = notificationResendRESTClient.getNotificationResend(tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getOlos(), OloBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}


    public GenericListBean<FileNotificheOutputBean> fileDiNotificheAdvanceResearch(RicercaAvanzataInputBean body, String codOloAgcom,
            String tipoProfilo, String userId) throws BusinessLayerException {
        GenericListBean<FileNotificheOutputBean> bean = new GenericListBean<>();
        boolean isLimited;
		//Gestione lista limitata
        try {
            AdvancedResearchInputDTO inputDto = mapper.translate(body, AdvancedResearchInputDTO.class);
            ListaFileNotificheOutputDTO dto = notificationRESTClient.fileDiNotificheAdvanceResearch(inputDto, codOloAgcom, tipoProfilo, userId);
            isLimited = validateResponseResult(dto);
            bean.setData(mapper.translateList(dto.getNotificationFiles(), FileNotificheOutputBean.class));
            bean.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }

	public ExportableDataOutputBean requestExport(RicercaAvanzataInputBean inputBean, String codOloAgcom,
            String tipoProfilo, String userId) throws BusinessLayerException {
        ExportableDataOutputBean bean = new ExportableDataOutputBean();
        try {
            AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
            ExportableDataOutputDTO dto = notificationRESTClient.fileDiNotificheAdvanceResearch(inputDto, codOloAgcom, tipoProfilo, userId);
            validateResponseResult(dto);
            bean = mapper.translate(dto, ExportableDataOutputBean.class);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return bean;
    }



}
