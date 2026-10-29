package com.nttdata.tim.now.data.dto.ordine.richiesta;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class RecuperaRichiesteWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 793636333421829128L;

	@JsonProperty("outputRichieste")
	private List<RecuperaRichiesteOutputDTO> outputRichieste;

	public List<RecuperaRichiesteOutputDTO> getOutputRichieste() {
		return outputRichieste;
	}

	public void setOutputRichieste(List<RecuperaRichiesteOutputDTO> outputRichieste) {
		this.outputRichieste = outputRichieste;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputRichieste == null) ? 0 : outputRichieste.hashCode());
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
		RecuperaRichiesteWrapperOutputDTO other = (RecuperaRichiesteWrapperOutputDTO) obj;
		if (outputRichieste == null) {
			if (other.outputRichieste != null)
				return false;
		} else if (!outputRichieste.equals(other.outputRichieste))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaRichiesteWrapperOutputDTO [outputRichieste=" + outputRichieste + "]";
	}
	
	

}
