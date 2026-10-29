package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class RecuperaCARWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -4485788067699101738L;
	
	@JsonProperty("outputCAR")
    private List<RecuperaCAROutputDTO> outputCAR;

	public List<RecuperaCAROutputDTO> getOutputCAR() {
		return outputCAR;
	}

	public void setOutputCAR(List<RecuperaCAROutputDTO> outputCAR) {
		this.outputCAR = outputCAR;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputCAR == null) ? 0 : outputCAR.hashCode());
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
		RecuperaCARWrapperOutputDTO other = (RecuperaCARWrapperOutputDTO) obj;
		if (outputCAR == null) {
			if (other.outputCAR != null)
				return false;
		} else if (!outputCAR.equals(other.outputCAR))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaCARWrapperOutputDTO [outputCAR=" + outputCAR + "]";
	}
	
}
