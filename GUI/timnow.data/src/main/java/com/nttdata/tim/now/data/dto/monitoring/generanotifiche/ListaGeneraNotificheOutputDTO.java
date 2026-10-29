package com.nttdata.tim.now.data.dto.monitoring.generanotifiche;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaGeneraNotificheOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -5933341246746132758L;
	
	@JsonProperty("RinvioNotificheOutput")
	private List<GeneraNotificheOutputDTO> notifications;

	public List<GeneraNotificheOutputDTO> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<GeneraNotificheOutputDTO> notifications) {
		this.notifications = notifications;
	}

	@Override
	public String toString() {
		return "ListaGeneraNotificheOutputDTO [notifications=" + notifications + "]";
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
		ListaGeneraNotificheOutputDTO other = (ListaGeneraNotificheOutputDTO) obj;
		if (notifications == null) {
			if (other.notifications != null)
				return false;
		} else if (!notifications.equals(other.notifications))
			return false;
		return true;
	}

}
