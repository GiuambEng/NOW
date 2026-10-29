package com.nttdata.tim.now.data.dto.ordine.dettaglio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class AttributoDettaglioOrdineDTO implements Serializable {

	private static final long serialVersionUID = -7764758834733245826L;

	@JsonProperty("nomeAttributo")
	private String nomeAttributo;

	@JsonProperty("valoreAttributo")
	private String valoreAttributo;

	public String getNomeAttributo() {
		return nomeAttributo;
	}

	public void setNomeAttributo(String nomeAttributo) {
		this.nomeAttributo = nomeAttributo;
	}

	public String getValoreAttributo() {
		return valoreAttributo;
	}

	public void setValoreAttributo(String valoreAttributo) {
		this.valoreAttributo = valoreAttributo;
	}

	@Override
	public String toString() {
		return "AttributoDettaglioOrdineDTO [nomeAttributo=" + nomeAttributo + ", valoreAttributo=" + valoreAttributo
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeAttributo == null) ? 0 : nomeAttributo.hashCode());
		result = prime * result + ((valoreAttributo == null) ? 0 : valoreAttributo.hashCode());
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
		AttributoDettaglioOrdineDTO other = (AttributoDettaglioOrdineDTO) obj;
		if (nomeAttributo == null) {
			if (other.nomeAttributo != null)
				return false;
		} else if (!nomeAttributo.equals(other.nomeAttributo))
			return false;
		if (valoreAttributo == null) {
			if (other.valoreAttributo != null)
				return false;
		} else if (!valoreAttributo.equals(other.valoreAttributo))
			return false;
		return true;
	}

}
