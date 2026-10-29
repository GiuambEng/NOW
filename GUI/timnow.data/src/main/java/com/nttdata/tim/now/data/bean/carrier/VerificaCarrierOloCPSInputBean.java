package com.nttdata.tim.now.data.bean.carrier;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_915
@JsonInclude(Include.NON_NULL)
public class VerificaCarrierOloCPSInputBean implements Serializable {

	private static final long serialVersionUID = 5303880921332644736L;

	@JsonProperty("codificaOloAgcom")
	private String codificaOloAgcom;

	@JsonProperty("lavorazione")
    private String lavorazione;
	
	@JsonProperty("offerta")
    private String offerta;
	
	@JsonProperty("codiceCarrierOlo")
    private String codiceCarrierOlo;

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getCodiceCarrierOlo() {
		return codiceCarrierOlo;
	}

	public void setCodiceCarrierOlo(String codiceCarrierOlo) {
		this.codiceCarrierOlo = codiceCarrierOlo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codificaOloAgcom == null) ? 0 : codificaOloAgcom.hashCode());
		result = prime * result + ((codiceCarrierOlo == null) ? 0 : codiceCarrierOlo.hashCode());
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
		VerificaCarrierOloCPSInputBean other = (VerificaCarrierOloCPSInputBean) obj;
		if (codificaOloAgcom == null) {
			if (other.codificaOloAgcom != null)
				return false;
		} else if (!codificaOloAgcom.equals(other.codificaOloAgcom))
			return false;
		if (codiceCarrierOlo == null) {
			if (other.codiceCarrierOlo != null)
				return false;
		} else if (!codiceCarrierOlo.equals(other.codiceCarrierOlo))
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
		return "VerificaCarrierOloCPSInputBean [codificaOloAgcom=" + codificaOloAgcom + ", lavorazione=" + lavorazione
				+ ", offerta=" + offerta + ", codiceCarrierOlo=" + codiceCarrierOlo + "]";
	}
    
   

}