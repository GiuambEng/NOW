package com.nttdata.tim.now.data.dto.monitoring.rigenerazionemail;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class ListaRichiesteMonitoraggioRigenerazioneMailOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = -7697898948133387816L;
	
	@JsonProperty("Lista_Richieste")
	private List<RichiesteMonitoraggioRigenerazioneMailOutputDTO> richieste;

	public List<RichiesteMonitoraggioRigenerazioneMailOutputDTO> getRichieste() {
		return richieste;
	}

	public void setRichieste(List<RichiesteMonitoraggioRigenerazioneMailOutputDTO> richieste) {
		this.richieste = richieste;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((richieste == null) ? 0 : richieste.hashCode());
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
		ListaRichiesteMonitoraggioRigenerazioneMailOutputDTO other = (ListaRichiesteMonitoraggioRigenerazioneMailOutputDTO) obj;
		if (richieste == null) {
			if (other.richieste != null)
				return false;
		} else if (!richieste.equals(other.richieste))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaRichiesteMonitoraggioRigenerazioneMailOutputDTO [richieste=" + richieste + "]";
	}


}
