package com.nttdata.tim.now.data.bean.utente;

import java.io.Serializable;
import java.util.Date;

public class UserRequestInfoBean implements Serializable {

    private static final long serialVersionUID = -6389671062260779657L;

    private String applicazioneClient;
	private String descrizioneFunzione;
	private String descrizioneProfilo;
	private String hostnameClient;
	private String ipClient;
	private String ipServer;
	private String osUser;
	private String serverName;
	private String sessionId;
	private String userId;
	private Date timestampInserimento;

	public String getApplicazioneClient() {
		return applicazioneClient;
	}

	public void setApplicazioneClient(String applicazioneClient) {
		this.applicazioneClient = applicazioneClient;
	}

	public String getHostnameClient() {
		return hostnameClient;
	}

	public void setHostnameClient(String hostnameClient) {
		this.hostnameClient = hostnameClient;
	}

	public String getIpClient() {
		return ipClient;
	}

	public void setIpClient(String ipClient) {
		this.ipClient = ipClient;
	}

	public String getIpServer() {
		return ipServer;
	}

	public void setIpServer(String ipServer) {
		this.ipServer = ipServer;
	}

	public String getOsUser() {
		return osUser;
	}

	public void setOsUser(String osUser) {
		this.osUser = osUser;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getTimestampInserimento() {
		return timestampInserimento;
	}

	public void setTimestampInserimento(Date timestampInserimento) {
		this.timestampInserimento = timestampInserimento;
	}

	@Override
	public String toString() {
		return "RequestInfoBean [applicazioneClient=" + applicazioneClient + ", descrizioneFunzione="
				+ descrizioneFunzione + ", descrizioneProfilo=" + descrizioneProfilo + ", hostnameClient="
				+ hostnameClient + ", ipClient=" + ipClient + ", ipServer=" + ipServer + ", osUser=" + osUser
				+ ", serverName=" + serverName + ", sessionId=" + sessionId + ", userId=" + userId
				+ ", timestampInserimento=" + timestampInserimento + "]";
	}

}
