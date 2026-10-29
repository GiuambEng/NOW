package com.nttdata.tim.now.data.dto.monitoring.kocautelare;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaDettagliMonitoraggioKoCautelareDTO extends ESBResultDTO {

	private static final long serialVersionUID = 4307111878912424875L;
	
	@JsonProperty("outputDettaglioMonitoraggioCautelare")
	private List<DettaglioMonitoraggioKoCautelareOutputDTO> monitorings;

	public List<DettaglioMonitoraggioKoCautelareOutputDTO> getMonitorings() {
		return monitorings;
	}

	public void setMonitorings(List<DettaglioMonitoraggioKoCautelareOutputDTO> monitorings) {
		this.monitorings = monitorings;
	}

	@Override
	public String toString() {
		return "ListaRichiesteMonitoraggioKoCautelareDTO [monitorings=" + monitorings + "]";
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
		ListaDettagliMonitoraggioKoCautelareDTO other = (ListaDettagliMonitoraggioKoCautelareDTO) obj;
		if (monitorings == null) {
			if (other.monitorings != null)
				return false;
		} else if (!monitorings.equals(other.monitorings))
			return false;
		return true;
	}

}
