package com.nttdata.tim.now.data.dto.file;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class FileDTO implements Serializable {
	
	private static final long serialVersionUID = -8082460741315716079L;

	@JsonProperty("codiceOloNumerico")
	private String codiceOloNumerico;

	@JsonProperty("codificaOloAgcom")
	private String codificaOloAgcom;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFile")
	private Date dataFile;

	@JsonProperty("descrizioneStatoFile")
	private String descrizioneStatoFile;

	@JsonProperty("esito")
	private String esito;

	@JsonProperty("idFile")
	private String idFile;

	@JsonProperty("tipologiaFile")
	private String tipologiaFile;

	@JsonProperty("versoFile")
	private String versoFile;

	@JsonProperty("nomeFile")
	private String nomeFile;

	@JsonProperty("esitoInvio")
	private String esitoInvio;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("timestampCreazioneFile")
	private String timestampCreazioneFile;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("timestampInvio")
	private String timestampInvio;

	public String getCodiceOloNumerico() {
		return codiceOloNumerico;
	}

	public void setCodiceOloNumerico(String codiceOloNumerico) {
		this.codiceOloNumerico = codiceOloNumerico;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public Date getDataFile() {
		return dataFile;
	}

	public void setDataFile(Date dataFile) {
		this.dataFile = dataFile;
	}

	public String getDescrizioneStatoFile() {
		return descrizioneStatoFile;
	}

	public void setDescrizioneStatoFile(String descrizioneStatoFile) {
		this.descrizioneStatoFile = descrizioneStatoFile;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getIdFile() {
		return idFile;
	}

	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}

	public String getTipologiaFile() {
		return tipologiaFile;
	}

	public void setTipologiaFile(String tipologiaFile) {
		this.tipologiaFile = tipologiaFile;
	}

	public String getVersoFile() {
		return versoFile;
	}

	public void setVersoFile(String versoFile) {
		this.versoFile = versoFile;
	}

	public String getEsitoInvio() {
		return esitoInvio;
	}

	public void setEsitoInvio(String esitoInvio) {
		this.esitoInvio = esitoInvio;
	}

	public String getTimestampCreazioneFile() {
		return timestampCreazioneFile;
	}

	public void setTimestampCreazioneFile(String timestampCreazioneFile) {
		this.timestampCreazioneFile = timestampCreazioneFile;
	}

	public String getTimestampInvio() {
		return timestampInvio;
	}

	public void setTimestampInvio(String timestampInvio) {
		this.timestampInvio = timestampInvio;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

}
