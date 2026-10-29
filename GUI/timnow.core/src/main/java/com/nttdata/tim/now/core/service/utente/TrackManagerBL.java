package com.nttdata.tim.now.core.service.utente;

import java.util.Date;

import com.nttdata.tim.now.adapters.esb.utente.TrackAccessRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;
import com.nttdata.tim.now.data.bean.track.TrackBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;
import com.nttdata.tim.now.data.dto.track.TrackDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackManagerBL extends AbstractBL {

    @Autowired
    private TrackAccessRESTClient trackAccessRESTClient;

	public EsitoOutputBean trackAccess(TrackBean inputBean) throws BusinessLayerException {
		EsitoOutputBean outputBean = null;
		try {
			TrackDTO inputDto = mapper.translate(inputBean, TrackDTO.class);
			EsitoDTO outputDto = trackAccessRESTClient.trackAccess(inputDto);
			validateResponseResult(outputDto);
			outputBean = mapper.translate(outputDto, EsitoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return outputBean;
	}
	
	
	public EsitoOutputBean trackFileOperation(TrackBean inputBean, UserBean user) throws BusinessLayerException {
		EsitoOutputBean outputBean = null;
		try {			
			inputBean.setTimestampInserimento(new Date());	
			inputBean.setApplicazioneClient(user.getRequestInfo().getApplicazioneClient());
			inputBean.setHostnameClient(user.getRequestInfo().getHostnameClient());
			inputBean.setIpClient(user.getRequestInfo().getIpClient());
			inputBean.setIpServer(user.getRequestInfo().getIpServer());
			inputBean.setOsUser(user.getRequestInfo().getOsUser());
			inputBean.setServerName(user.getRequestInfo().getServerName());
			inputBean.setSessionId(user.getRequestInfo().getSessionId());	
			
			inputBean.setUserId(user.getUserId());
			inputBean.setDescrizioneProfilo(user.getCodiceProfilo());
			
			TrackDTO inputDto = mapper.translate(inputBean, TrackDTO.class);
			EsitoDTO outputDto = trackAccessRESTClient.trackAccess(inputDto);
			validateResponseResult(outputDto);
			outputBean = mapper.translate(outputDto, EsitoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return outputBean;
	}
	

}
