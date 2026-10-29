package com.nttdata.tim.now.data.dto.monitoring.reinvionotifica;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaRinvioNotificheOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 4373285401534367915L;
	
	@JsonProperty("outpuListaNotificheElement")
	private List<RinvioNotificheOutputDTO> notifications;

	public List<RinvioNotificheOutputDTO> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<RinvioNotificheOutputDTO> notifications) {
		this.notifications = notifications;
	}

}
