package com.nttdata.tim.now.data.dto.track;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class TrackDTO implements Serializable {

	private static final long serialVersionUID = -5173640752629937717L;

	@JsonProperty("APPLICAZIONE_CLIENT")
	private String applicazioneClient;

	@JsonProperty("DESCR_FUNZIONE")
	private String descrizioneFunzione;

	@JsonProperty("DESCR_PROFILO")
	private String descrizioneProfilo;

	@JsonProperty("HOSTNAME_CLIENT")
	private String hostnameClient;

	@JsonProperty("IP_CLIENT")
	private String ipClient;

	@JsonProperty("IP_SERVER")
	private String ipServer;

	@JsonProperty("OS_USER")
	private String osUser;

	@JsonProperty("PARAMETRI_OPERAZIONE")
	private String parametriOperazione;

	@JsonProperty("SERVER_NAME")
	private String serverName;

	@JsonProperty("SESSION_ID")
	private String sessionId;

	@JsonProperty("TIPO_OPERAZIONE")
	private String tipoOperazione;

	@JsonProperty("USERID")
	private String userId;

	//SM_8906
	@JsonFormat(pattern = DateHelper.TIMESTAMP_BE_TRACKING, timezone = DateHelper.TIMEZONE_IT ,shape = JsonFormat.Shape.STRING)
	@JsonProperty("TIMSTP_INSMTO")
	private Date timestampInserimento;

	//RU_902	//SM_8906
	@JsonFormat(pattern = DateHelper.TIMESTAMP_BE_TRACKING, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
	@JsonProperty("TIMSTP_INIZIO")
	private Date timestampInizio;

	//SM_8906
	@JsonFormat(pattern = DateHelper.TIMESTAMP_BE_TRACKING, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
	@JsonProperty("TIMSTP_FINE")
	private Date timestampFine;

	@JsonProperty("NUM_DATI_ESPORTATI")
	private Integer numeroDatiEsportati;

	@JsonProperty("CONTENUTO_FILE")
	private String contenutoFile;

	@JsonProperty("NOME_FILE")
	private String nomeFile;

	@JsonProperty("ESITO")
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
}
