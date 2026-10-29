package com.nttdata.tim.now.web.listener;

import com.nttdata.tim.now.core.service.utente.TrackManagerBL;
import com.nttdata.tim.now.data.bean.track.TrackBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.enumeration.TrackingEvent;
import com.nttdata.tim.now.data.enumeration.TrackingOperationType;
import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.util.data.DozerHelper;
import com.nttdata.tim.now.web.event.UserLogoutEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;


public class UserLogoutListener implements ApplicationListener<UserLogoutEvent> {
	
	/*
	 * 
	 * Implementa il listener per il solo logout non automatico a fine sessione
	 * Si utilizza il sistema degli eventi di Spring
	 * 
	 * */

	protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TrackManagerBL trackManagerBL;

	@Autowired
	private DozerHelper mapper;

	
	public void onUserLogout(UserLogoutEvent event) {
		try {
			UserBean user = event.getUser();
			logger.info("on user logout listener...");
			TrackBean trackBean = mapper.translate(user.getRequestInfo(), TrackBean.class);
			trackBean.setApplicazioneClient(Constants.APPLICATION_NAME);
			trackBean.setTipoOperazione(TrackingOperationType.LOGOUT.getOperationType());
			trackBean.setParametriOperazione("");
			trackBean.setUserId(user.getUserId());
			trackBean.setDescrizioneProfilo(user.getCodiceProfilo());
			trackBean.setDescrizioneFunzione(TrackingEvent.LOGOUT.getDescription());
			//trackBean.setTimestampInserimento(new Date(event.getTimestamp()));

			trackManagerBL.trackAccess(trackBean);
		} catch (Exception e) {
			logger.error("Errore durante il tracciamento evento", e);
		}
	}


	@Override
	public void onApplicationEvent(UserLogoutEvent event) {
		onUserLogout(event);
		
	}

}