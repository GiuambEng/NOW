package com.nttdata.tim.now.data.dto.monitoring.generanotifiche;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class OloDTO implements Serializable {

	private static final long serialVersionUID = 4114877139412843289L;

	@JsonProperty("olo")
	private String olo;

	@JsonProperty("ragioneSociale")
	private String ragioneSociale;

	@JsonProperty("codiceOlo")
	private String codiceOlo;

	@JsonProperty("codificaOlo")
	private String codificaOlo;

	public String getOlo() {
		return olo;
	}

	public void setOlo(String olo) {
		this.olo = olo;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getCodiceOlo() {
		return codiceOlo;
	}

	public void setCodiceOlo(String codiceOlo) {
		this.codiceOlo = codiceOlo;
	}

	public String getCodificaOlo() {
		return codificaOlo;
	}

	public void setCodificaOlo(String codificaOlo) {
		this.codificaOlo = codificaOlo;
	}

	@Override
	public String toString() {
		return "OloDTO [olo=" + olo + ", ragioneSociale=" + ragioneSociale + ", codiceOlo=" + codiceOlo
				+ ", codificaOlo=" + codificaOlo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceOlo == null) ? 0 : codiceOlo.hashCode());
		result = prime * result + ((codificaOlo == null) ? 0 : codificaOlo.hashCode());
		result = prime * result + ((olo == null) ? 0 : olo.hashCode());
		result = prime * result + ((ragioneSociale == null) ? 0 : ragioneSociale.hashCode());
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
		OloDTO other = (OloDTO) obj;
		if (codiceOlo == null) {
			if (other.codiceOlo != null)
				return false;
		} else if (!codiceOlo.equals(other.codiceOlo))
			return false;
		if (codificaOlo == null) {
			if (other.codificaOlo != null)
				return false;
		} else if (!codificaOlo.equals(other.codificaOlo))
			return false;
		if (olo == null) {
			if (other.olo != null)
				return false;
		} else if (!olo.equals(other.olo))
			return false;
		if (ragioneSociale == null) {
			if (other.ragioneSociale != null)
				return false;
		} else if (!ragioneSociale.equals(other.ragioneSociale))
			return false;
		return true;
	}

}
