package com.nttdata.tim.now.data.dto.monitoring.fatturazione;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFatturazioneDettaglioListOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -5504482995453763303L;
	
	@JsonProperty("outputMonitoraggioFatturazioneDettaglio")
	private List<MonitoraggioFatturazioneDettaglioOutputDTO> list;

	@JsonProperty("outputMonitoraggioFatturazioneDettaglio")
	public List<MonitoraggioFatturazioneDettaglioOutputDTO> getList() {
		return list;
	}

	@JsonProperty("outputMonitoraggioFatturazioneDettaglio")
	public void setList(List<MonitoraggioFatturazioneDettaglioOutputDTO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "MonitoraggioFatturazioneDettaglioListOutputDTO [list=" + list + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		MonitoraggioFatturazioneDettaglioListOutputDTO other = (MonitoraggioFatturazioneDettaglioListOutputDTO) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

}
