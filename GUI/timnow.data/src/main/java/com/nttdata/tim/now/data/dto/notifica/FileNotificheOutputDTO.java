package com.nttdata.tim.now.data.dto.notifica;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class FileNotificheOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 4974357591593570118L;

	@JsonProperty("idFileProcessatoOutput")
	private String idFileProcessatoOutput;

	@JsonProperty("idNotifica")
	private String idNotifica;

	@JsonProperty("tipoNotifica")
	private String tipoNotifica;

	@JsonProperty("nomeFile")
	private String nomeFile;

	@JsonProperty("codOloAgcom")
	private String codOloAgcom;

	@JsonProperty("dimensioneFile")
	private String dimensioneFile;

	@JsonProperty("esitoInvio")
	private String esitoInvio;

	@JsonProperty("quantitaRecordTotali")
	private String quantitaRecordTotali;

	@JsonProperty("idFile")
	private String idFile;

	@JsonFormat(pattern = DateHelper.DATE_BE_LONG, shape = JsonFormat.Shape.STRING, timezone = DateHelper.TIMEZONE_IT)
	@JsonProperty("timestampCreazioneFile")
	private Date timestampCreazioneFile;

	@JsonFormat(pattern = DateHelper.DATE_BE_LONG, shape = JsonFormat.Shape.STRING, timezone = DateHelper.TIMEZONE_IT)
	@JsonProperty("timestampInvio")
	private Date timestampInvio;

	public String getIdFileProcessatoOutput() {
		return idFileProcessatoOutput;
	}

	public void setIdFileProcessatoOutput(String idFile) {
		this.idFileProcessatoOutput = idFile;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public String getTipoNotifica() {
		return tipoNotifica;
	}

	public void setTipoNotifica(String tipoNotifica) {
		this.tipoNotifica = tipoNotifica;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getDimensioneFile() {
		return dimensioneFile;
	}

	public void setDimensioneFile(String dimensioneFile) {
		this.dimensioneFile = dimensioneFile;
	}

	public String getEsitoInvio() {
		return esitoInvio;
	}

	public void setEsitoInvio(String esitoInvio) {
		this.esitoInvio = esitoInvio;
	}

	public String getQuantitaRecordTotali() {
		return quantitaRecordTotali;
	}

	public void setQuantitaRecordTotali(String quantitaRecordTotali) {
		this.quantitaRecordTotali = quantitaRecordTotali;
	}

	public String getIdNotifica() {
		return idNotifica;
	}

	public void setIdNotifica(String idNotifica) {
		this.idNotifica = idNotifica;
	}

	public String getIdFile() {
		return idFile;
	}

	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}

	public Date getTimestampCreazioneFile() {
		return timestampCreazioneFile;
	}

	public void setTimestampCreazioneFile(Date timestampCreazioneFile) {
		this.timestampCreazioneFile = timestampCreazioneFile;
	}

	public Date getTimestampInvio() {
		return timestampInvio;
	}

	public void setTimestampInvio(Date timestampInvio) {
		this.timestampInvio = timestampInvio;
	}

}
