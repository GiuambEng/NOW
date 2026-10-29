package com.nttdata.tim.now.web.listener;

import com.nttdata.tim.now.core.service.utente.TrackManagerBL;
import com.nttdata.tim.now.data.bean.track.TrackBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.enumeration.TrackingEvent;
import com.nttdata.tim.now.data.enumeration.TrackingOperationType;
import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.util.data.DozerHelper;
import com.nttdata.tim.now.web.event.UserLoginEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationListener {

	protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TrackManagerBL trackManagerBL;

	@Autowired
	private DozerHelper mapper;

	@EventListener
	public void onUserLogin(UserLoginEvent event) {
		try {
			UserBean user = event.getUser();

			TrackBean trackBean = mapper.translate(user.getRequestInfo(), TrackBean.class);
			trackBean.setApplicazioneClient(Constants.APPLICATION_NAME);
			trackBean.setTipoOperazione(TrackingOperationType.LOGIN.getOperationType());
			trackBean.setParametriOperazione("");
			trackBean.setUserId(user.getUserId());
			trackBean.setDescrizioneProfilo(user.getCodiceProfilo());
			trackBean.setDescrizioneFunzione(TrackingEvent.LOGIN.getDescription());
			//trackBean.setTimestampInserimento(new Date(event.getTimestamp()));

			trackManagerBL.trackAccess(trackBean);
		} catch (Exception e) {
			logger.error("Errore durante il tracciamento evento", e);
		}
	}
	
	
// La parte di logout e' implementata su UserLogoutListener
//	in modo da isolare il comportamento con un listener dedicato 
//  ed evitare il comportamento del doppio evento logout

}