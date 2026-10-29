package com.nttdata.tim.now.web.event;

import com.nttdata.tim.now.data.bean.utente.UserBean;

public interface UserAwareEvent {

	public UserBean getUser();
	
}
