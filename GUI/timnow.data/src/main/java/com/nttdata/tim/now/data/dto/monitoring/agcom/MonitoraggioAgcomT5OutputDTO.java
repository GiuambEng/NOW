package com.nttdata.tim.now.data.dto.monitoring.agcom;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultExportDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioAgcomT5OutputDTO extends ESBResultExportDTO {

	private static final long serialVersionUID = -7407620485624624080L;
	
	@JsonProperty("MonitoraggioAgcomT5ListOut")
	private List<MonitoraggioAgcomT5DTO> monitorings;

	public List<MonitoraggioAgcomT5DTO> getMonitorings() {
		return monitorings;
	}

	public void setMonitorings(List<MonitoraggioAgcomT5DTO> monitorings) {
		this.monitorings = monitorings;
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
		MonitoraggioAgcomT5OutputDTO other = (MonitoraggioAgcomT5OutputDTO) obj;
		if (monitorings == null) {
			if (other.monitorings != null)
				return false;
		} else if (!monitorings.equals(other.monitorings))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MonitoraggioAgcomT5OutputDTO [monitorings=" + monitorings + "]";
	}

}
