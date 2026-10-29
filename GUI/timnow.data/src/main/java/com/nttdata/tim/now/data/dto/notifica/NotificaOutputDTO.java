package com.nttdata.tim.now.data.dto.notifica;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class NotificaOutputDTO implements Serializable {

	private static final long serialVersionUID = 4970052451553131665L;

	@JsonProperty("tipologiaNotifica")
	private String tipologiaNotifica;

	@JsonProperty("causale")
	private String causale;

	@JsonFormat(pattern = DateHelper.DATE_BE_LONG, shape = JsonFormat.Shape.STRING, timezone = DateHelper.TIMEZONE_IT)
	@JsonProperty("dataCreazione")
	private Date timeStampCreazione;

	@JsonProperty("notificaXML")
	private String notificaXML;

	@JsonProperty("ultimoFileNotifica")
	private String ultimoFileNotifica;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInvioFile")
	private Date dataInvioFile;
	
	//SM_9651
	@JsonProperty("idNotifica")
	private String idNotifica;


	public String getTipologiaNotifica() {
		return tipologiaNotifica;
	}

	public void setTipologiaNotifica(String tipologiaNotifica) {
		this.tipologiaNotifica = tipologiaNotifica;
	}

	public String getCausale() {
		return causale;
	}

	public void setCausale(String causale) {
		this.causale = causale;
	}

	public Date getTimeStampCreazione() {
		return timeStampCreazione;
	}

	public void setTimeStampCreazione(Date timeStampCreazione) {
		this.timeStampCreazione = timeStampCreazione;
	}

	public String getNotificaXML() {
		return notificaXML;
	}

	public void setNotificaXML(String notificaXML) {
		this.notificaXML = notificaXML;
	}

	public String getUltimoFileNotifica() {
		return ultimoFileNotifica;
	}

	public void setUltimoFileNotifica(String ultimoFileNotifica) {
		this.ultimoFileNotifica = ultimoFileNotifica;
	}

	public Date getDataInvioFile() {
		return dataInvioFile;
	}

	public void setDataInvioFile(Date dataInvioFile) {
		this.dataInvioFile = dataInvioFile;
	}

	public String getIdNotifica() {
		return idNotifica;
	}

	public void setIdNotifica(String idNotifica) {
		this.idNotifica = idNotifica;
	}

	@Override
	public String toString() {
		return "NotificaOutputDTO [tipologiaNotifica=" + tipologiaNotifica + ", causale=" + causale
				+ ", timeStampCreazione=" + timeStampCreazione + ", notificaXML=" + notificaXML
				+ ", ultimoFileNotifica=" + ultimoFileNotifica + ", dataInvioFile=" + dataInvioFile + ", idNotifica="
				+ idNotifica + "]";
	}

}
