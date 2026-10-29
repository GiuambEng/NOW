package com.nttdata.tim.now.data.dto.monitoring.warning;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaRichiesteMonitoraggioKoWarningOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 5037419746115238980L;
	
	@JsonProperty("DettaglioMonitoraggioKOWarning")
	private List<RichiestaMonitoraggioKoWarningOutputDTO> monitoring;

	public List<RichiestaMonitoraggioKoWarningOutputDTO> getMonitoring() {
		return monitoring;
	}

	public void setMonitoring(List<RichiestaMonitoraggioKoWarningOutputDTO> monitoring) {
		this.monitoring = monitoring;
	}

	@Override
	public String toString() {
		return "ListaRichiesteMonitoraggioKoWarningDTO [monitoring=" + monitoring + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((monitoring == null) ? 0 : monitoring.hashCode());
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
		ListaRichiesteMonitoraggioKoWarningOutputDTO other = (ListaRichiesteMonitoraggioKoWarningOutputDTO) obj;
		if (monitoring == null) {
			if (other.monitoring != null)
				return false;
		} else if (!monitoring.equals(other.monitoring))
			return false;
		return true;
	}

}
