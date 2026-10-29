package com.nttdata.tim.now.data.bean.ordine.donating;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdineDonatingDetailOutputBean implements Serializable {

	private static final long serialVersionUID = 1953014060026846793L;

	@JsonProperty("tipologiaNotifica")
	private String tipologiaNotifica;

	@JsonProperty("causale")
	private String causale;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataCreazione")
	private Date dataCreazione;

	@JsonProperty("notificaXML")
	private String notificaXML;

	@JsonProperty("ultimoFileNotifica")
	private String ultimoFileNotifica;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInvioFile")
	private Date dataInvioFile;

	@JsonProperty("tipologiaNotifica")
	public String getTipologiaNotifica() {
		return tipologiaNotifica;
	}

	@JsonProperty("tipologiaNotifica")
	public void setTipologiaNotifica(String tipologiaNotifica) {
		this.tipologiaNotifica = tipologiaNotifica;
	}

	@JsonProperty("causale")
	public String getCausale() {
		return causale;
	}

	@JsonProperty("causale")
	public void setCausale(String causale) {
		this.causale = causale;
	}

	@JsonProperty("dataCreazione")
	public Date getDataCreazione() {
		return dataCreazione;
	}

	@JsonProperty("dataCreazione")
	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	@JsonProperty("notificaXML")
	public String getNotificaXML() {
		return notificaXML;
	}
	
	@JsonProperty("notificaXML")
	public void setNotificaXML(String notificaXML) {
		this.notificaXML = notificaXML;
	}

	@JsonProperty("ultimoFileNotifica")
	public String getUltimoFileNotifica() {
		return ultimoFileNotifica;
	}

	@JsonProperty("ultimoFileNotifica")
	public void setUltimoFileNotifica(String ultimoFileNotifica) {
		this.ultimoFileNotifica = ultimoFileNotifica;
	}

	@JsonProperty("dataInvioFile")
	public Date getDataInvioFile() {
		return dataInvioFile;
	}

	@JsonProperty("dataInvioFile")
	public void setDataInvioFile(Date dataInvioFile) {
		this.dataInvioFile = dataInvioFile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((causale == null) ? 0 : causale.hashCode());
		result = prime * result + ((dataCreazione == null) ? 0 : dataCreazione.hashCode());
		result = prime * result + ((dataInvioFile == null) ? 0 : dataInvioFile.hashCode());
		result = prime * result + ((notificaXML == null) ? 0 : notificaXML.hashCode());
		result = prime * result + ((tipologiaNotifica == null) ? 0 : tipologiaNotifica.hashCode());
		result = prime * result + ((ultimoFileNotifica == null) ? 0 : ultimoFileNotifica.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdineDonatingDetailOutputBean other = (OrdineDonatingDetailOutputBean) obj;
		if (causale == null) {
			if (other.causale != null)
				return false;
		} else if (!causale.equals(other.causale))
			return false;
		if (dataCreazione == null) {
			if (other.dataCreazione != null)
				return false;
		} else if (!dataCreazione.equals(other.dataCreazione))
			return false;
		if (dataInvioFile == null) {
			if (other.dataInvioFile != null)
				return false;
		} else if (!dataInvioFile.equals(other.dataInvioFile))
			return false;
		if (notificaXML == null) {
			if (other.notificaXML != null)
				return false;
		} else if (!notificaXML.equals(other.notificaXML))
			return false;
		if (tipologiaNotifica == null) {
			if (other.tipologiaNotifica != null)
				return false;
		} else if (!tipologiaNotifica.equals(other.tipologiaNotifica))
			return false;
		if (ultimoFileNotifica == null) {
			if (other.ultimoFileNotifica != null)
				return false;
		} else if (!ultimoFileNotifica.equals(other.ultimoFileNotifica))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdineDonatingDetailOutputBean [tipologiaNotifica=" + tipologiaNotifica + ", causale=" + causale
				+ ", dataCreazione=" + dataCreazione + ", notificaXML=" + notificaXML + ", ultimoFileNotifica="
				+ ultimoFileNotifica + ", dataInvioFile=" + dataInvioFile + "]";
	}

}
