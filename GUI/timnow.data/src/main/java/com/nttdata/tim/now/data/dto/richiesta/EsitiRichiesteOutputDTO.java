package com.nttdata.tim.now.data.dto.richiesta;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.notifica.NotificaOutputDTO;

@JsonInclude(Include.NON_NULL)
public class EsitiRichiesteOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -466752597361149656L;

	@JsonProperty("visualizzazioneNotificheOutput")
	private List<NotificaOutputDTO> notifications;

	@JsonProperty("visualizzazioneEsitiRichiesteOutput")
	private List<EsitoRichiestaDTO> outcomesRequired;

	public List<NotificaOutputDTO> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<NotificaOutputDTO> notifications) {
		this.notifications = notifications;
	}

	public List<EsitoRichiestaDTO> getOutcomesRequired() {
		return outcomesRequired;
	}

	public void setOutcomesRequired(List<EsitoRichiestaDTO> outcomesRequired) {
		this.outcomesRequired = outcomesRequired;
	}

}
