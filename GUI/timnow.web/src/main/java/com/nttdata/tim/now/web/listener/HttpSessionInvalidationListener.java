package com.nttdata.tim.now.web.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.nttdata.tim.now.core.service.utente.TrackManagerBL;
import com.nttdata.tim.now.data.bean.track.TrackBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.enumeration.TrackingEvent;
import com.nttdata.tim.now.data.enumeration.TrackingOperationType;
import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.web.utils.WebAttributes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class HttpSessionInvalidationListener implements HttpSessionListener, ApplicationEventPublisherAware {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@SuppressWarnings("unused")
	private ApplicationEventPublisher publisher;
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// do nothing
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		logger.info("session invalidated");
		// - verifico che la sessione contenga le informazioni utente; se non le
		// contiene non faccio nulla.
		// - recupero dalla sessione i dati (client ip, client port etc) che avevo
		// messo in sessione durante la login
		// - faccio la chiamata al tracciamento eventi per il logout
		// Se ci sono problemi con la DI posso recuperare il bean con:
		// FacadeBL facadeBL = (FacadeBL) SpringHelper.getBean("facadeBL");
		//UserBean destination = new UserBean();
		UserBean source = (UserBean) event.getSession().getAttribute(WebAttributes.SESSION_CURRENT_USER);
		if(source == null){
			logger.info("session invalidated - dirty session");
		}
		else{
			//destination.setRequestInfo(source.getRequestInfo());
			//destination.setUserId(source.getUserId());
			//destination.setCodiceProfilo(source.getCodiceProfilo());
			
			//prelevo la sessione
			HttpSession session = event.getSession();
			//prelevo il context
	        ApplicationContext ctx =WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
	        //prelevo il manager
	        TrackManagerBL trackManagerBL = (TrackManagerBL) ctx.getBean("trackManagerBL");
	        //preparo TrackBean
	        TrackBean trackBean = riempiTrackBean(source);
		
			try{
				trackManagerBL.trackAccess(trackBean);
			} catch (Exception e) {
				logger.error("Errore durante il tracciamento evento", e);
			}
			//publisher.publishEvent(new UserLogoutEvent(destination));
		}
	}

	private TrackBean riempiTrackBean(UserBean source) {
		TrackBean trackBean = new TrackBean();
        
        trackBean.setTimestampInserimento(source.getRequestInfo().getTimestampInserimento());
        trackBean.setSessionId(source.getRequestInfo().getSessionId());
        trackBean.setServerName(source.getRequestInfo().getServerName());
        trackBean.setOsUser(source.getRequestInfo().getOsUser());
        trackBean.setIpServer(source.getRequestInfo().getIpServer());
        trackBean.setIpClient(source.getRequestInfo().getIpClient());
        trackBean.setHostnameClient(source.getRequestInfo().getHostnameClient());

		trackBean.setApplicazioneClient(Constants.APPLICATION_NAME);
		trackBean.setTipoOperazione(TrackingOperationType.LOGOUT.getOperationType());
		trackBean.setParametriOperazione("");
		trackBean.setUserId(source.getUserId());
		trackBean.setDescrizioneProfilo(source.getCodiceProfilo());
		trackBean.setDescrizioneFunzione(TrackingEvent.LOGOUT.getDescription());
		return trackBean;
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}

}
