package com.nttdata.tim.now.data.bean.track;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TrackBean implements Serializable {

    private static final long serialVersionUID = 7048123411768320402L;

    private String applicazioneClient;
	private String descrizioneFunzione;
	private String descrizioneProfilo;
	private String hostnameClient;
	private String ipClient;
	private String ipServer;
	private String osUser;
	private String parametriOperazione;
	private String serverName;
	private String sessionId;
	private String tipoOperazione;
	private String userId;
	private Date timestampInserimento;
	
	//RU_902
	private Date timestampInizio;
	private Date timestampFine;
	private Integer numeroDatiEsportati;
	private String contenutoFile;
	private String nomeFile;
	private String esito;

	public String getApplicazioneClient() {
		return applicazioneClient;
	}

	public void setApplicazioneClient(String applicazioneClient) {
		this.applicazioneClient = applicazioneClient;
	}

	public String getDescrizioneFunzione() {
		return descrizioneFunzione;
	}

	public void setDescrizioneFunzione(String descrizioneFunzione) {
		this.descrizioneFunzione = descrizioneFunzione;
	}

	public String getDescrizioneProfilo() {
		return descrizioneProfilo;
	}

	public void setDescrizioneProfilo(String descrizioneProfilo) {
		this.descrizioneProfilo = descrizioneProfilo;
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

	public String getParametriOperazione() {
		return parametriOperazione;
	}

	public void setParametriOperazione(String parametriOperazione) {
		this.parametriOperazione = parametriOperazione;
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

	public String getTipoOperazione() {
		return tipoOperazione;
	}

	public void setTipoOperazione(String tipoOperazione) {
		this.tipoOperazione = tipoOperazione;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getTimestampInserimento() {
		return timestampInserimento;
	}

	public void setTimestampInserimento(Date timestampInserimento) {
		this.timestampInserimento = timestampInserimento;
	}

	//RU_902
	public Date getTimestampInizio() {
		return timestampInizio;
	}

	public void setTimestampInizio(Date timestampInizio) {
		this.timestampInizio = timestampInizio;
	}

	public Date getTimestampFine() {
		return timestampFine;
	}

	public void setTimestampFine(Date timestampFine) {
		this.timestampFine = timestampFine;
	}

	public Integer getNumeroDatiEsportati() {
		return numeroDatiEsportati;
	}

	public void setNumeroDatiEsportati(Integer numeroDatiEsportati) {
		this.numeroDatiEsportati = numeroDatiEsportati;
	}

	public String getContenutoFile() {
		return contenutoFile;
	}

	public void setContenutoFile(String contenutoFile) {
		this.contenutoFile = contenutoFile;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	@Override
	public String toString() {
		return "TrackBean [applicazioneClient=" + applicazioneClient + ", descrizioneFunzione=" + descrizioneFunzione
				+ ", descrizioneProfilo=" + descrizioneProfilo + ", hostnameClient=" + hostnameClient + ", ipClient="
				+ ipClient + ", ipServer=" + ipServer + ", osUser=" + osUser + ", parametriOperazione="
				+ parametriOperazione + ", serverName=" + serverName + ", sessionId=" + sessionId + ", tipoOperazione="
				+ tipoOperazione + ", userId=" + userId + ", timestampInserimento=" + timestampInserimento + "]";
	}

}
