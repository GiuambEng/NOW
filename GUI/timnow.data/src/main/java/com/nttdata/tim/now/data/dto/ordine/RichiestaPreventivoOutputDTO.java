package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class RichiestaPreventivoOutputDTO extends ESBResultDTO implements Serializable {
	
	private static final long serialVersionUID = 3811959283792663843L;

    @JsonProperty("esito")
    private RichiestaPreventivoEsitoOutputDTO esito;

	public RichiestaPreventivoEsitoOutputDTO getEsito() {
		return esito;
	}

	public void setEsito(RichiestaPreventivoEsitoOutputDTO esito) {
		this.esito = esito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		RichiestaPreventivoOutputDTO other = (RichiestaPreventivoOutputDTO) obj;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RichiestaPreventivoOutputDTO [esito=" + esito + "]";
	}
    
}
