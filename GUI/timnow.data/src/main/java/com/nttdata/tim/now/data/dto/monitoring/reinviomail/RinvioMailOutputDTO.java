package com.nttdata.tim.now.data.dto.monitoring.reinviomail;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class RinvioMailOutputDTO implements Serializable {

	private static final long serialVersionUID = 4910471597380408702L;

	@JsonProperty("ID_NOTIFICA")
	private String idNotifica;

	@JsonProperty("CONTENUTO_MAIL")
	private String contenutoMail;

	@JsonProperty("DESTINATARIO_EMAIL_A")
	private String destinatarioEmailA;

	@JsonProperty("DESTINATARIO_EMAIL_CC")
	private String destinatarioEmailCC;

	@JsonProperty("TIPOLOGIA_NOTIFICA")
	private String tipologiaNotifica;

	@JsonProperty("OGGETTO_DELLA_MAIL")
	private String oggetto;

	@JsonFormat(pattern = DateHelper.DATE_BE_LONG, shape = JsonFormat.Shape.STRING)
	@JsonProperty("DATA_INVIO")
	private Date dataInvio;

	@JsonProperty("Check_Di_Ri_invio")
	private boolean check;

	public String getContenutoMail() {
		return contenutoMail;
	}

	public void setContenutoMail(String contenutoMail) {
		this.contenutoMail = contenutoMail;
	}

	public String getDestinatarioEmailA() {
		return destinatarioEmailA;
	}

	public void setDestinatarioEmailA(String destinatarioEmailA) {
		this.destinatarioEmailA = destinatarioEmailA;
	}

	public String getDestinatarioEmailCC() {
		return destinatarioEmailCC;
	}

	public void setDestinatarioEmailCC(String destinatarioEmailCC) {
		this.destinatarioEmailCC = destinatarioEmailCC;
	}

	public String getTipologiaNotifica() {
		return tipologiaNotifica;
	}

	public void setTipologiaNotifica(String tipologiaNotifica) {
		this.tipologiaNotifica = tipologiaNotifica;
	}

	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getIdNotifica() {
		return idNotifica;
	}

	public void setIdNotifica(String idNotifica) {
		this.idNotifica = idNotifica;
	}

	@Override
	public String toString() {
		return "MailDTO [idNotifica=" + idNotifica + ", contenutoMail=" + contenutoMail + ", destinatarioEmailA="
				+ destinatarioEmailA + ", destinatarioEmailCC=" + destinatarioEmailCC + ", tipologiaNotifica="
				+ tipologiaNotifica + ", oggetto=" + oggetto + ", dataInvio=" + dataInvio + ", check=" + check + "]";
	}

}
