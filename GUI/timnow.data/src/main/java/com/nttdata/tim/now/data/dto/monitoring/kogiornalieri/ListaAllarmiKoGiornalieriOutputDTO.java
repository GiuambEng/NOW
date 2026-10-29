package com.nttdata.tim.now.data.dto.monitoring.kogiornalieri;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultExportDTO;

@JsonInclude(Include.NON_NULL)
public class ListaAllarmiKoGiornalieriOutputDTO extends ESBResultExportDTO {

	private static final long serialVersionUID = 2699203807389404988L;
	
	@JsonProperty("OutputAllarmiKOGiornalieri")
	private List<AllarmeKoGiornalieroOutputDTO> alarms;

	public List<AllarmeKoGiornalieroOutputDTO> getAlarms() {
		return alarms;
	}

	public void setAlarms(List<AllarmeKoGiornalieroOutputDTO> alarms) {
		this.alarms = alarms;
	}

	@Override
	public String toString() {
		return "ListaAllarmiDTO [alarms=" + alarms + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alarms == null) ? 0 : alarms.hashCode());
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
		ListaAllarmiKoGiornalieriOutputDTO other = (ListaAllarmiKoGiornalieriOutputDTO) obj;
		if (alarms == null) {
			if (other.alarms != null)
				return false;
		} else if (!alarms.equals(other.alarms))
			return false;
		return true;
	}

}
