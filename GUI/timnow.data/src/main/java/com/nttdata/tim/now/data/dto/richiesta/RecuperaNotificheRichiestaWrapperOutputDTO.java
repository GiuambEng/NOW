package com.nttdata.tim.now.data.dto.richiesta;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.notifica.RecuperaNotificheRichiestaOutputDTO;

@JsonInclude(Include.NON_NULL)
public class RecuperaNotificheRichiestaWrapperOutputDTO extends ESBResultDTO {


	private static final long serialVersionUID = -6902497185032515143L;
	
	@JsonProperty("outputRecuperaNotificheRichiesta")
	private List<RecuperaNotificheRichiestaOutputDTO> outputRecuperaNotificheRichiesta;

	public List<RecuperaNotificheRichiestaOutputDTO> getOutputRecuperaNotificheRichiesta() {
		return outputRecuperaNotificheRichiesta;
	}

	public void setOutputRecuperaNotificheRichiesta(
			List<RecuperaNotificheRichiestaOutputDTO> outputRecuperaNotificheRichiesta) {
		this.outputRecuperaNotificheRichiesta = outputRecuperaNotificheRichiesta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((outputRecuperaNotificheRichiesta == null) ? 0 : outputRecuperaNotificheRichiesta.hashCode());
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
		RecuperaNotificheRichiestaWrapperOutputDTO other = (RecuperaNotificheRichiestaWrapperOutputDTO) obj;
		if (outputRecuperaNotificheRichiesta == null) {
			if (other.outputRecuperaNotificheRichiesta != null)
				return false;
		} else if (!outputRecuperaNotificheRichiesta.equals(other.outputRecuperaNotificheRichiesta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaNotificheRichiestaWrapperOutputDTO [outputRecuperaNotificheRichiesta="
				+ outputRecuperaNotificheRichiesta + "]";
	}

	
}
