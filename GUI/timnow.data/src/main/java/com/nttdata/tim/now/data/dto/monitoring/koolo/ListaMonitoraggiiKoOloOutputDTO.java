package com.nttdata.tim.now.data.dto.monitoring.koolo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultExportDTO;

@JsonInclude(Include.NON_NULL)
public class ListaMonitoraggiiKoOloOutputDTO extends ESBResultExportDTO {

	private static final long serialVersionUID = -6920953151121030986L;
	
	@JsonProperty("outputMonitoraggioKOOlo")
	private List<MonitoraggioKoOloOutputDTO> monitorings;

	public List<MonitoraggioKoOloOutputDTO> getMonitorings() {
		return monitorings;
	}

	public void setMonitorings(List<MonitoraggioKoOloOutputDTO> monitorings) {
		this.monitorings = monitorings;
	}

	@Override
	public String toString() {
		return "ListaMonitoraggioKoOloDTO [monitorings=" + monitorings + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((monitorings == null) ? 0 : monitorings.hashCode());
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
		ListaMonitoraggiiKoOloOutputDTO other = (ListaMonitoraggiiKoOloOutputDTO) obj;
		if (monitorings == null) {
			if (other.monitorings != null)
				return false;
		} else if (!monitorings.equals(other.monitorings))
			return false;
		return true;
	}

}
