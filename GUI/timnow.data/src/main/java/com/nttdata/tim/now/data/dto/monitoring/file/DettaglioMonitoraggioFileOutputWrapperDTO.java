package com.nttdata.tim.now.data.dto.monitoring.file;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DettaglioMonitoraggioFileOutputWrapperDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = 4628746478851106470L;
	 
	@JsonProperty("monitoraggiodd2")
	private DettaglioMonitoraggioFileOutputDTO monitoring;

	public DettaglioMonitoraggioFileOutputDTO getMonitoring() {
		return monitoring;
	}

	public void setMonitoring(DettaglioMonitoraggioFileOutputDTO monitoring) {
		this.monitoring = monitoring;
	}

	@Override
	public String toString() {
		return "DettaglioMonitoraggioFileOutputDTO [monitoring=" + monitoring + "]";
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
		DettaglioMonitoraggioFileOutputWrapperDTO other = (DettaglioMonitoraggioFileOutputWrapperDTO) obj;
		if (monitoring == null) {
			if (other.monitoring != null)
				return false;
		} else if (!monitoring.equals(other.monitoring))
			return false;
		return true;
	}

}
