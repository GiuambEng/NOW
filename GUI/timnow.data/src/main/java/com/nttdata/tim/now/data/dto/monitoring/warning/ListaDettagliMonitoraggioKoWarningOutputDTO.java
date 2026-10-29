package com.nttdata.tim.now.data.dto.monitoring.warning;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultExportDTO;

@JsonInclude(Include.NON_NULL)
public class ListaDettagliMonitoraggioKoWarningOutputDTO extends ESBResultExportDTO {

	private static final long serialVersionUID = 537281765843662261L;
	
	@JsonProperty("OutputMonitoraggioKOWarningLiv2")
	private List<DettaglioMonitoraggioKoWarningOutputDTO> monitorings;

	public List<DettaglioMonitoraggioKoWarningOutputDTO> getMonitorings() {
		return monitorings;
	}

	public void setMonitorings(List<DettaglioMonitoraggioKoWarningOutputDTO> monitorings) {
		this.monitorings = monitorings;
	}

	@Override
	public String toString() {
		return "ListaDettagliMonitoraggioKoWarningDTO [monitorings=" + monitorings + "]";
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
		ListaDettagliMonitoraggioKoWarningOutputDTO other = (ListaDettagliMonitoraggioKoWarningOutputDTO) obj;
		if (monitorings == null) {
			if (other.monitorings != null)
				return false;
		} else if (!monitorings.equals(other.monitorings))
			return false;
		return true;
	}

}
