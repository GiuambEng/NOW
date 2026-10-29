package com.nttdata.tim.now.data.dto.monitoring.notificheolo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class ListaDettagliMonitoraggioNotificheOloOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = -7697898948133387816L;
	
	@JsonProperty("Lista_Dettaglio")
	private List<DettaglioMonitoraggioNotificheOloOutputDTO> detail;

	public List<DettaglioMonitoraggioNotificheOloOutputDTO> getDetail() {
		return detail;
	}

	public void setDeatail(List<DettaglioMonitoraggioNotificheOloOutputDTO> detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "ListaDettagliMonitoraggioNotificheOloDTO [detail=" + detail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
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
		ListaDettagliMonitoraggioNotificheOloOutputDTO other = (ListaDettagliMonitoraggioNotificheOloOutputDTO) obj;
		if (detail == null) {
			if (other.detail != null)
				return false;
		} else if (!detail.equals(other.detail))
			return false;
		return true;
	}

}
