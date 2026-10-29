package com.nttdata.tim.now.data.dto.monitoring.fatturazione;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultExportDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFatturazioneContatoreListOutputDTO extends ESBResultExportDTO {

	private static final long serialVersionUID = 7970506284994896618L;
	
	@JsonProperty("outputMonitoraggioFatturazioneSecondario")
	private List<MonitoraggioFatturazioneContatoreOutputDTO> list;

	@JsonProperty("outputMonitoraggioFatturazioneSecondario")
	public List<MonitoraggioFatturazioneContatoreOutputDTO> getList() {
		return list;
	}

	@JsonProperty("outputMonitoraggioFatturazioneSecondario")
	public void setList(List<MonitoraggioFatturazioneContatoreOutputDTO> list) {
		this.list = list;
	}
	

	@Override
	public String toString() {
		return "MonitoraggioFatturazioneContatoreListOutputDTO [list=" + list + "]";
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
		MonitoraggioFatturazioneContatoreListOutputDTO other = (MonitoraggioFatturazioneContatoreListOutputDTO) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

}
