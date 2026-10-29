package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//SM_9825
public class RecuperaCodiciTdKitWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -8918014939560335223L;
	
	@JsonProperty("outputCodiciTdKit")
	private List<RecuperaCodiciTdKitOutputDTO> outputCodiciTdKit;

	public List<RecuperaCodiciTdKitOutputDTO> getOutputCodiciTdKit() {
		return outputCodiciTdKit;
	}

	public void setOutputCodiciTdKit(List<RecuperaCodiciTdKitOutputDTO> outputCodiciTdKit) {
		this.outputCodiciTdKit = outputCodiciTdKit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputCodiciTdKit == null) ? 0 : outputCodiciTdKit.hashCode());
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
		RecuperaCodiciTdKitWrapperOutputDTO other = (RecuperaCodiciTdKitWrapperOutputDTO) obj;
		if (outputCodiciTdKit == null) {
			if (other.outputCodiciTdKit != null)
				return false;
		} else if (!outputCodiciTdKit.equals(other.outputCodiciTdKit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaCodiciTdKitWrapperOutputDTO [outputCodiciTdKit=" + outputCodiciTdKit + "]";
	}
	
}
