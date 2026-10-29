package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class ConsistenzaWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -3051221168519943173L;
	
	@JsonProperty("OutputRecuperoConsistenzaIdRisorsa")
    private ConsistenzaOutputDTO consistenza;

	public ConsistenzaOutputDTO getConsistenza() {
		return consistenza;
	}

	public void setConsistenza(ConsistenzaOutputDTO consistenza) {
		this.consistenza = consistenza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consistenza == null) ? 0 : consistenza.hashCode());
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
		ConsistenzaWrapperOutputDTO other = (ConsistenzaWrapperOutputDTO) obj;
		if (consistenza == null) {
			if (other.consistenza != null)
				return false;
		} else if (!consistenza.equals(other.consistenza))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConsistenzaWrapperOutputDTO [consistenza=" + consistenza + "]";
	}
	
}
