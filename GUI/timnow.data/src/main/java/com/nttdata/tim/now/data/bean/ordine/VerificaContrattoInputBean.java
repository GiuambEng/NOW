package com.nttdata.tim.now.data.bean.ordine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_915
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class VerificaContrattoInputBean extends AbstractOutputBean {

	private static final long serialVersionUID = -5213909946330161874L;
	
	@JsonProperty("codiceOloAgcom")
	private String codiceOloAgcom;
	
	@JsonProperty("offerta")
	private String offerta;
	
	@JsonProperty("lavorazione")
	private String lavorazione;
	
	@JsonProperty("dn")
	private String dn;

	//RU_1306
	@JsonProperty("idContratto")
	private String idContratto;
	
	public String getCodiceOloAgcom() {
		return codiceOloAgcom;
	}

	public void setCodiceOloAgcom(String codiceOloAgcom) {
		this.codiceOloAgcom = codiceOloAgcom;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public String getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(String idContratto) {
		this.idContratto = idContratto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceOloAgcom == null) ? 0 : codiceOloAgcom.hashCode());
		result = prime * result + ((dn == null) ? 0 : dn.hashCode());
		result = prime * result + ((lavorazione == null) ? 0 : lavorazione.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
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
		VerificaContrattoInputBean other = (VerificaContrattoInputBean) obj;
		if (codiceOloAgcom == null) {
			if (other.codiceOloAgcom != null)
				return false;
		} else if (!codiceOloAgcom.equals(other.codiceOloAgcom))
			return false;
		if (dn == null) {
			if (other.dn != null)
				return false;
		} else if (!dn.equals(other.dn))
			return false;
		if (lavorazione == null) {
			if (other.lavorazione != null)
				return false;
		} else if (!lavorazione.equals(other.lavorazione))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaContrattoInputBean [codiceOloAgcom=" + codiceOloAgcom + ", offerta=" + offerta
				+ ", lavorazione=" + lavorazione + ", dn=" + dn + "]";
	}

	

}
