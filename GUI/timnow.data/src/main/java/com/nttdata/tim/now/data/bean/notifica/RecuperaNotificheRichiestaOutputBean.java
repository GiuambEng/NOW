package com.nttdata.tim.now.data.bean.notifica;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class RecuperaNotificheRichiestaOutputBean extends AbstractOutputBean implements Serializable {
	
    private static final long serialVersionUID = 6712654951180786658L;

    @JsonProperty("tipologiaNotifica")
	private String tipologiaNotifica;

	@JsonProperty("causale")
	private String causale;

	@JsonFormat(pattern = DateHelper.DATE_FE_LONG, shape = JsonFormat.Shape.STRING, timezone = DateHelper.TIMEZONE_IT)
	@JsonProperty("dataCreazione")
	private Date timeStampCreazione;

	@JsonProperty("notificaXML")
	private String notificaXML;

	@JsonProperty("ultimoFileNotifica")
	private String ultimoFileNotifica;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInvioFile")
	private Date dataInvioFile;

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

	@Override
	public String toString() {
		return "NotificationOutBean [tipologiaNotifica=" + tipologiaNotifica + ", causale=" + causale
				+ ", timeStampCreazione=" + timeStampCreazione + ", notificaXML=" + notificaXML
				+ ", ultimoFileNotifica=" + ultimoFileNotifica + ", dataInvioFile=" + dataInvioFile + "]";
	}

}