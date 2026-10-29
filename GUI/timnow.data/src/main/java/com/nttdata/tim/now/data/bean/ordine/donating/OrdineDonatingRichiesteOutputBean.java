package com.nttdata.tim.now.data.bean.ordine.donating;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdineDonatingRichiesteOutputBean implements Serializable {
	
	private static final long serialVersionUID = 3725895844198217327L;

	@JsonProperty("codiceRichiestaOao")
	private String codiceRichiestaOao;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInvio")
	private Date dataInvio;

	@JsonProperty("statoNow")
	private String statoNow;

	@JsonProperty("statoOao")
	private String statoOao;

	@JsonProperty("xml")
	private String xml;

	@JsonProperty("lavorazione")
	private String lavorazione;

	@JsonProperty("userId")
	private String userId;

	public String getCodiceRichiestaOao() {
		return codiceRichiestaOao;
	}

	public void setCodiceRichiestaOao(String codiceRichiestaOao) {
		this.codiceRichiestaOao = codiceRichiestaOao;
	}

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}

	public String getStatoNow() {
		return statoNow;
	}

	public void setStatoNow(String statoNow) {
		this.statoNow = statoNow;
	}

	public String getStatoOao() {
		return statoOao;
	}

	public void setStatoOao(String statoOao) {
		this.statoOao = statoOao;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceRichiestaOao == null) ? 0 : codiceRichiestaOao.hashCode());
		result = prime * result + ((dataInvio == null) ? 0 : dataInvio.hashCode());
		result = prime * result + ((lavorazione == null) ? 0 : lavorazione.hashCode());
		result = prime * result + ((statoNow == null) ? 0 : statoNow.hashCode());
		result = prime * result + ((statoOao == null) ? 0 : statoOao.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((xml == null) ? 0 : xml.hashCode());
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
		OrdineDonatingRichiesteOutputBean other = (OrdineDonatingRichiesteOutputBean) obj;
		if (codiceRichiestaOao == null) {
			if (other.codiceRichiestaOao != null)
				return false;
		} else if (!codiceRichiestaOao.equals(other.codiceRichiestaOao))
			return false;
		if (dataInvio == null) {
			if (other.dataInvio != null)
				return false;
		} else if (!dataInvio.equals(other.dataInvio))
			return false;
		if (lavorazione == null) {
			if (other.lavorazione != null)
				return false;
		} else if (!lavorazione.equals(other.lavorazione))
			return false;
		if (statoNow == null) {
			if (other.statoNow != null)
				return false;
		} else if (!statoNow.equals(other.statoNow))
			return false;
		if (statoOao == null) {
			if (other.statoOao != null)
				return false;
		} else if (!statoOao.equals(other.statoOao))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (xml == null) {
			if (other.xml != null)
				return false;
		} else if (!xml.equals(other.xml))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdineDonatingRichiesteOutputBean [codiceRichiestaOao=" + codiceRichiestaOao + ", dataInvio=" + dataInvio
				+ ", statoNow=" + statoNow + ", statoOao=" + statoOao + ", xml=" + xml + ", lavorazione=" + lavorazione
				+ ", userId=" + userId + "]";
	}
	

}
