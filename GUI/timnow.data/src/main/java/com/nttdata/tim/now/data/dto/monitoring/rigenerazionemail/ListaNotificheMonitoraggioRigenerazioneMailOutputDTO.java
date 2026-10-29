package com.nttdata.tim.now.data.dto.monitoring.rigenerazionemail;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class ListaNotificheMonitoraggioRigenerazioneMailOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = 1242231841649477433L;

	@JsonProperty("listaNotifiche")
	private List<NotificheMonitoraggioRigenerazioneMailOutputDTO> notifiche;

	public List<NotificheMonitoraggioRigenerazioneMailOutputDTO> getNotifiche() {
		return notifiche;
	}

	public void setNotifiche(List<NotificheMonitoraggioRigenerazioneMailOutputDTO> notifiche) {
		this.notifiche = notifiche;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notifiche == null) ? 0 : notifiche.hashCode());
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
		ListaNotificheMonitoraggioRigenerazioneMailOutputDTO other = (ListaNotificheMonitoraggioRigenerazioneMailOutputDTO) obj;
		if (notifiche == null) {
			if (other.notifiche != null)
				return false;
		} else if (!notifiche.equals(other.notifiche))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaNotificheMonitoraggioRigenerazioneMailOutputDTO [notifiche=" + notifiche + "]";
	}


}
