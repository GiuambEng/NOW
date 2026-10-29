package com.nttdata.tim.now.data.bean.monitoring.rigenerazionemail;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class RinvioNotificheMonitoraggioRigenerazioneMailListInputBean implements Serializable {

	private static final long serialVersionUID = 8940715227675725536L;
    
	@JsonProperty("listaNotifiche")
	private List<RinvioNotificheMonitoraggioRigenerazioneMailInputBean> listaNotifiche;

	public List<RinvioNotificheMonitoraggioRigenerazioneMailInputBean> getListaNotifiche() {
		return listaNotifiche;
	}

	public void setListaNotifiche(List<RinvioNotificheMonitoraggioRigenerazioneMailInputBean> listaNotifiche) {
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
		RinvioNotificheMonitoraggioRigenerazioneMailListInputBean other = (RinvioNotificheMonitoraggioRigenerazioneMailListInputBean) obj;
		if (listaNotifiche == null) {
			if (other.listaNotifiche != null)
				return false;
		} else if (!listaNotifiche.equals(other.listaNotifiche))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RinvioNotificheMonitoraggioRigenerazioneMailListInputBean [listaNotifiche=" + listaNotifiche + "]";
	}

	
}
