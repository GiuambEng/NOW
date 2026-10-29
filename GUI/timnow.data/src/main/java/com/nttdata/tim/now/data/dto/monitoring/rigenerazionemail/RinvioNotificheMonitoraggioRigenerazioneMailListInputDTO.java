package com.nttdata.tim.now.data.dto.monitoring.rigenerazionemail;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class RinvioNotificheMonitoraggioRigenerazioneMailListInputDTO implements Serializable {

	private static final long serialVersionUID = -633223162643085301L;

	@JsonProperty("listaNotifiche")
	private List<RinvioNotificheMonitoraggioRigenerazioneMailInputDTO> listaNotifiche;

	public List<RinvioNotificheMonitoraggioRigenerazioneMailInputDTO> getListaNotifiche() {
		return listaNotifiche;
	}

	public void setListaNotifiche(List<RinvioNotificheMonitoraggioRigenerazioneMailInputDTO> listaNotifiche) {
		this.listaNotifiche = listaNotifiche;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaNotifiche == null) ? 0 : listaNotifiche.hashCode());
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
		RinvioNotificheMonitoraggioRigenerazioneMailListInputDTO other = (RinvioNotificheMonitoraggioRigenerazioneMailListInputDTO) obj;
		if (listaNotifiche == null) {
			if (other.listaNotifiche != null)
				return false;
		} else if (!listaNotifiche.equals(other.listaNotifiche))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RinvioNotificheMonitoraggioRigenerazioneMailListInputDTO [listaNotifiche=" + listaNotifiche + "]";
	}


}
