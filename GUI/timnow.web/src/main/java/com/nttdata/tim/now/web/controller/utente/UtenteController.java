package com.nttdata.tim.now.web.controller.utente;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.utente.UtenteManagerBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currentuser")
public class UtenteController extends GenericController {

	@Autowired
	private UtenteManagerBL utenteManagerBL;

	@JsonGetMapping("/quit")
	public EmptyBean closeSession(HttpServletRequest request, HttpSession session) throws BusinessLayerException {
		try {
			logger.info("user logout...");
			session.invalidate();
			this.invalidateCookie(request.getCookies());
			/*
			 * utilizzare l'evento pubblicato con UserLogoutListener
			 * HttpSessionInvalidationListener interviene sul session.invalidate
			 */
			// eventDispatcher.publishEvent(new UserLogoutEvent(sessionUser));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return getSuccessEmptyBean();
	}

	// Profilazione -> Dettaglio Utente
	@JsonGetMapping("/{userId:[A-Za-z0-9]+}")
	public UserBean getUser(@PathVariable String userId) throws BusinessLayerException {
		UserBean user = utenteManagerBL.getUser(userId);
		user.setResult(getSuccessResult());
		return user;
	}

	private void invalidateCookie(Cookie[] cookies) {
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
			}
		}
	}

}
