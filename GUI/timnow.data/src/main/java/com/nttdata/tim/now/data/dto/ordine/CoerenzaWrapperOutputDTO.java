package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class CoerenzaWrapperOutputDTO extends ESBResultDTO implements Serializable {
	
	private static final long serialVersionUID = 1394017302995755934L;
	
	@JsonProperty("outputCoerenzaIdRisorsa")
    private CoerenzaOutputDTO coerenza;

	public CoerenzaOutputDTO getCoerenza() {
		return coerenza;
	}

	public void setCoerenza(CoerenzaOutputDTO coerenza) {
		this.coerenza = coerenza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coerenza == null) ? 0 : coerenza.hashCode());
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
		CoerenzaWrapperOutputDTO other = (CoerenzaWrapperOutputDTO) obj;
		if (coerenza == null) {
			if (other.coerenza != null)
				return false;
		} else if (!coerenza.equals(other.coerenza))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CoerenzaWrapperOutputDTO [coerenza=" + coerenza + "]";
	}

}
