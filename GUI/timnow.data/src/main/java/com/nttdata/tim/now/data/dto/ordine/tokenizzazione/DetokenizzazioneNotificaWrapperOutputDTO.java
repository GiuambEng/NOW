package com.nttdata.tim.now.data.dto.ordine.tokenizzazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//SM_9651
public class DetokenizzazioneNotificaWrapperOutputDTO extends ESBResultDTO implements Serializable{

	private static final long serialVersionUID = 5643257178493252695L;
	
	@JsonProperty("notificaDetokenizzata")
	private DetokenizzazioneNotificaOutputDTO notificaDetokenizzata;

	public DetokenizzazioneNotificaOutputDTO getNotificaDetokenizzata() {
		return notificaDetokenizzata;
	}

	public void setNotificaDetokenizzata(DetokenizzazioneNotificaOutputDTO notificaDetokenizzata) {
		this.notificaDetokenizzata = notificaDetokenizzata;
	}



}
