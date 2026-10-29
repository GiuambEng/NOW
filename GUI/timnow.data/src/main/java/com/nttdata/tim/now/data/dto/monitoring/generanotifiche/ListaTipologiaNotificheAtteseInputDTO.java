package com.nttdata.tim.now.data.dto.monitoring.generanotifiche;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ListaTipologiaNotificheAtteseInputDTO implements Serializable {

	private static final long serialVersionUID = 2739078488242555548L;
	
	@JsonProperty("inputListaTipologiaNotificheAttese")
	private List<TipologiaNotificheAtteseInputDTO> notifications;

	public List<TipologiaNotificheAtteseInputDTO> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<TipologiaNotificheAtteseInputDTO> notifications) {
		this.notifications = notifications;
	}

	@Override
	public String toString() {
		return "ListaTipologiaNotificheAtteseInputDTO [notifications=" + notifications + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notifications == null) ? 0 : notifications.hashCode());
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
		ListaTipologiaNotificheAtteseInputDTO other = (ListaTipologiaNotificheAtteseInputDTO) obj;
		if (notifications == null) {
			if (other.notifications != null)
				return false;
		} else if (!notifications.equals(other.notifications))
			return false;
		return true;
	}

}
