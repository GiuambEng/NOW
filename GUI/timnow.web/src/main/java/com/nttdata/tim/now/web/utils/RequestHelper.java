package com.nttdata.tim.now.web.utils;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import com.nttdata.tim.now.data.bean.utente.UserRequestInfoBean;
import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.util.properties.PropertiesHelper;

import org.apache.commons.lang3.StringUtils;

public class RequestHelper {

	/**
	 * Recupera lo username di autenticazione passato dal sso manager.
	 * 
	 * @param request
	 * @return
	 */
	public static String getAuthUsername(HttpServletRequest request) {
		return request.getHeader(PropertiesHelper.getStringProperty("header.var.username"));
	}
	
	/**
	 * Recupera l'ip del client da un header configurato arbitrariamento. Nel
	 * caso in cui l'header non sia valorizzato il valore viene recuperato dal
	 * remoteAddress della request.
	 * 
	 * @param request
	 * @return
	 */
	public static String getClientIp(HttpServletRequest request) {
		String ipAddress;
		//RU_842
		ipAddress = request.getHeader("X-FORWARDED-FOR");
		if(!StringUtils.isBlank(ipAddress)) {
			return splitClientIp(ipAddress);
		}
		ipAddress = request.getHeader(PropertiesHelper.getStringProperty("header.var.clientIp"));
		if (StringUtils.isBlank(ipAddress)) {
			ipAddress = request.getRemoteAddr();			
		}
		
		return splitClientIp(ipAddress);
	}
	
	//RU_XXXX CR 539
	public static String splitClientIp(String ipAddress) {		
		if(ipAddress != null && ipAddress.contains(",")) {
			String[] arrayIpAddress = ipAddress.split(",");
			if(arrayIpAddress != null && arrayIpAddress.length > 0) {
				ipAddress = arrayIpAddress[0];
			}
		}
		return ipAddress;
	}

	/**
	 * Recupera la porta del client da un header configurato arbitrariamento.
	 * Nel caso in cui l'header non sia valorizzato il valore viene recuperato
	 * dal remotePort della request.
	 * 
	 * @param request
	 * @return
	 */
	public static String getClientPort(HttpServletRequest request) {
		String port = request.getHeader(PropertiesHelper.getStringProperty("header.var.clientPort"));
		if (StringUtils.isBlank(port)) {
			port = String.valueOf(request.getRemotePort());
		}
		return port;
	}

	/**
	 * Recupera l'hostname del client dalla request.
	 * 
	 * @param request
	 * @return
	 */
	public static String getClientHostname(HttpServletRequest request) {
		//RU_842
		String ipAddr = getClientIp(request);
		try {
			InetAddress addr = InetAddress.getByName(ipAddr);
			String host = addr.getHostName();
			if( !StringUtils.isBlank(host) )
				return host;
			return request.getRemoteHost();
		}
		catch(Exception e) {
			return request.getRemoteHost();
		}
	}
	
	public static String getServerName(HttpServletRequest request) {
		//RU_842
		String ipAddr = request.getLocalAddr();
		try {
			InetAddress addr = InetAddress.getByName(ipAddr);
			String host = addr.getHostName();
			if( !StringUtils.isBlank(host) )
				return host;
			return request.getLocalAddr();
		}
		catch(Exception e) {
			return request.getLocalAddr();
		}
	}
	
	/**
	 * Recupera lo user agent del client dalla request.
	 * 
	 * @param request
	 * @return
	 */
	public static String getUserAgent(HttpServletRequest request) {
		return request.getHeader("User-Agent");
	}
	
	//RU_842
	public static String getSessionId(HttpServletRequest request) {
		
		String sessionId = request.getSession().getId();
//		if( sessionId != null && sessionId.contains(".")) {
//			String[] splittedId = sessionId.split("\\.");
//			sessionId = splittedId[0];
//		}
		return sessionId;
	}
	
	/**
	 * Crea un oggetto UserRequestInfoBean a partire dalle informazioni presenti
	 * nella request.
	 * 
	 * @param request
	 * @return
	 */
	public static UserRequestInfoBean getUserRequestInfo(HttpServletRequest request) {
		UserRequestInfoBean requestInfo = new UserRequestInfoBean();
		requestInfo.setApplicazioneClient(Constants.APPLICATION_NAME);
		requestInfo.setIpClient(getClientIp(request));//RU_842
		requestInfo.setHostnameClient(getClientHostname(request));//RU_842
		requestInfo.setIpServer(request.getLocalAddr());
		requestInfo.setOsUser(getUserAgent(request));
		requestInfo.setServerName(getServerName(request)); //RU_842
		requestInfo.setSessionId(getSessionId(request)); //RU_842
		return requestInfo;
	}
	
}
