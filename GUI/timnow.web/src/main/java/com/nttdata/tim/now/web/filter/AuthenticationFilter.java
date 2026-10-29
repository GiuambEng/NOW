package com.nttdata.tim.now.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.utente.UtenteManagerBL;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.event.UserLoginEvent;
import com.nttdata.tim.now.web.exception.AuthenticationException;
import com.nttdata.tim.now.web.utils.RequestHelper;
import com.nttdata.tim.now.web.utils.WebAttributes;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Implementazione di
 * {@link org.springframework.web.filter.OncePerRequestFilter} utilizzata per
 * l'autenticazione utenete in sso. Per ogni request viene verificata la
 * presenza e la coerenza degli header passati negli headers.
 * 
 * @see WEB-INF/web.xml
 */
public class AuthenticationFilter extends OncePerRequestFilter {

	private String usernameAttribute = "HTTP_SM_USER";

	@Autowired
	private UtenteManagerBL userManagerBL;

	@Autowired
	private ApplicationEventPublisher eventDispatcher;

	@Value("${manutenzione}")
	private boolean manutenzione;
	
	@Value("${messaggioDaMostrare}")
	private String messaggioDaMostrare;
	
	
	/**
	 * Imposta il nome dell'attributo header da cui recuperare il valore della
	 * username.
	 * 
	 * @param usernameAttribute
	 */
	public void setUsernameAttribute(String usernameAttribute) {
		this.usernameAttribute = usernameAttribute;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String username = request.getHeader(this.usernameAttribute);
		logger.debug("Request associata al sessionId: " + request.getSession().getId() + ", session valid: "
				+ request.getSession(false)!=null + ", URI requested: " + request.getRequestURI());
 
		if (StringUtils.isBlank(username)) {
			logger.info("Impossibile recuperare lo username dai parametri presenti negli header.");
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return;
		}

		if (sessionExpired(request)||isSessionClientExpired(request)) {
			// redirect su codice http 504 - temporary redirect
			logger.info("SessionId legato alla request non valido - temporary redirected to Idle Page");
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			invalidateTimNowSidCookie(request.getCookies(), response);
			response.sendError(HttpServletResponse.SC_GATEWAY_TIMEOUT);
			return;
		}

		boolean isValidUser = false;

		HttpSession session = request.getSession();
		logger.debug("creata/recuperata sessione - SID: " + session.getId());
		Object sessionUser = session.getAttribute(WebAttributes.SESSION_CURRENT_USER);

		// Se è presente l'attributo username verifico che l'oggetto utente
		// sia compatibile con dati presenti presenti negli header. In caso
		// contrario invalido la sessione ed effettuo nuovamente
		// l'autenticazione.
		if (sessionUser instanceof UserBean) {
			logger.debug("Utente trovato in sessione con sessione valida");
			UserBean current = (UserBean) sessionUser;
			isValidUser = this.sessionUserIsValid(current, username);
			if (!isValidUser) {
				logger.info(
						"L'utente in sessione non e' coerente con i parametri presenti negli headers. La sessione viene invalidata");
				session.invalidate();
			}
		}
		
		//RU_856
		if(manutenzione) {
			response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
			session.setAttribute("messaggioDaMostrare", messaggioDaMostrare);
			return;
		}
		// Effetto il recupero utente solo se non e' presente un utente in
		// sessione o se l'utente corrente non e' coerente con i parametri
		// presenti negli headers.
		if (!isValidUser) {
			logger.debug("Recupero l'utente");
			try {
				UserBean user = this.retrieveUser(username);
				user.setRequestInfo(RequestHelper.getUserRequestInfo(request));
				session.setAttribute(WebAttributes.SESSION_CURRENT_USER, user);
				// Pubblicazione dell'evento di login in modo da poter gestire
				// in maniera modulare le azioni legate a questo evento.
				eventDispatcher.publishEvent(new UserLoginEvent(user));
			} catch (AuthenticationException e) {
				logger.info("Impossibile autenticare l'utente", e);
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				return;
			} catch (Exception e) {
				logger.info("Impossibile autenticare l'utente", e);
				response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
				return;
			}
		}

		filterChain.doFilter(request, response);
	}

	/**
	 * Verifica se deve essere effettuato il refresh dell'utente in sessione a
	 * fronte di variazione degli input presenti negli header.
	 * 
	 * @param user
	 * @param username
	 * @return
	 */
	private boolean sessionUserIsValid(UserBean user, String username) {
		if (user == null || username == null) {
			return false;
		}
		if (!username.equals(user.getUserId())) {
			return false;
		}
		return true;
	}

	/**
	 * Recupera l'utente a partire dallo username passato in input.
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	private UserBean retrieveUser(String username) throws BusinessLayerException, AuthenticationException {
		UserBean user = userManagerBL.getUser(username);
		if (null == user) {
			throw new AuthenticationException("Impossibile recuperare l'utente " + username);
		}
		return user;
	}

	/**
	 * Effettua il check della sessione scaduta ed il requested session id non è
	 * vuoto
	 * 
	 * @param request
	 * @return
	 */
	private boolean sessionExpired(HttpServletRequest request) {
		return (request.getSession(false) == null) && (request.getSession().getId() != null);
	}

	/**
	 * @param cookies
	 * @param response
	 */
	private void invalidateTimNowSidCookie(Cookie[] cookies, HttpServletResponse response) {
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("TIMNOWSID".equals(cookie.getName())) {
					cookie.setMaxAge(0);
					cookie.setValue(null);
				}
				response.addCookie(cookie);
			}
		}
	}

	/**
	 * Checks if client session is expired (by checking the requested
	 * sessionId).
	 * 
	 * 
	 * @param request
	 * @return true if session is expired
	 */
	public static boolean isSessionClientExpired(HttpServletRequest request) {
		return request.getRequestedSessionId() != null && !request.isRequestedSessionIdValid();

	}
}
