package com.nttdata.tim.now.data.dto.monitoring.notificheolo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaMonitoraggioNotificheOloOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 3940985475757934295L;
	
	@JsonProperty("Lista_MonitoraggioNotifiche_OLO")
	private List<MonitoraggioNotificheOloOutputDTO> monitorings;

	public List<MonitoraggioNotificheOloOutputDTO> getMonitorings() {
		return monitorings;
	}

	public void setMonitorings(List<MonitoraggioNotificheOloOutputDTO> monitorings) {
		this.monitorings = monitorings;
	}

	@Override
	public String toString() {
		return "ListaMonitoraggioNotificheOloDTO [monitorings=" + monitorings + "]";
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
		ListaMonitoraggioNotificheOloOutputDTO other = (ListaMonitoraggioNotificheOloOutputDTO) obj;
		if (monitorings == null) {
			if (other.monitorings != null)
				return false;
		} else if (!monitorings.equals(other.monitorings))
			return false;
		return true;
	}

}
