package com.nttdata.tim.now.web.event;

import com.nttdata.tim.now.data.bean.utente.UserBean;

import org.springframework.context.ApplicationEvent;

public class UserLogoutEvent extends ApplicationEvent implements UserAwareEvent {

	private static final long serialVersionUID = -4609643493645759514L;

	public UserLogoutEvent(UserBean source) {
		super(source);
	}

	public UserBean getUser() {
		return (UserBean) getSource();
	}
	
}
