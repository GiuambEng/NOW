package com.nttdata.tim.now.data.bean.monitoring.reinviomail;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class RinvioMailOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -1016217634044699172L;

    @JsonProperty("idNotifica")
	private String idNotifica;

	@JsonProperty("contenutoMail")
	private String contenutoMail;

	@JsonProperty("destinatarioEmailA")
	private String destinatarioEmailA;

	@JsonProperty("destinatarioEmailCC")
	private String destinatarioEmailCC;

	@JsonProperty("tipologiaNotifica")
	private String tipologiaNotifica;

	@JsonProperty("oggetto")
	private String oggetto;

	@JsonFormat(pattern = DateHelper.DATE_FE_LONG, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInvio")
	private Date dataInvio;

	@JsonProperty("check")
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
		return "MailBean [idNotifica=" + idNotifica + ", contenutoMail=" + contenutoMail + ", destinatarioEmailA="
				+ destinatarioEmailA + ", destinatarioEmailCC=" + destinatarioEmailCC + ", tipologiaNotifica="
				+ tipologiaNotifica + ", oggetto=" + oggetto + ", dataInvio=" + dataInvio + ", check=" + check + "]";
	}

}