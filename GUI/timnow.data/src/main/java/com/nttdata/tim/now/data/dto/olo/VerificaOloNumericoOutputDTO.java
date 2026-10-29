package com.nttdata.tim.now.data.dto.olo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class VerificaOloNumericoOutputDTO extends ESBResultDTO {
 
	private static final long serialVersionUID = 707349357687361085L;

	@JsonProperty("esito")
	private String esito;

	@JsonProperty("profiloOlo")
	private List<CodiceOloOutputDTO> codiciOlo;

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public List<CodiceOloOutputDTO> getCodiciOlo() {
		return codiciOlo;
	}

	public void setCodiciOlo(List<CodiceOloOutputDTO> codiciOlo) {
		this.codiciOlo = codiciOlo;
	}

	@Override
	public String toString() {
		return "VerificaOloNumericoOutputDTO [esito=" + esito + ", codiciOlo=" + codiciOlo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiciOlo == null) ? 0 : codiciOlo.hashCode());
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
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
		VerificaOloNumericoOutputDTO other = (VerificaOloNumericoOutputDTO) obj;
		if (codiciOlo == null) {
			if (other.codiciOlo != null)
				return false;
		} else if (!codiciOlo.equals(other.codiciOlo))
			return false;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
			return false;
		return true;
	}

}
