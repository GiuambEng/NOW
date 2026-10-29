package com.nttdata.tim.now.data.dto.ordine.tokenizzazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class DetokenizzazioneReferentiWrapperOutputDTO extends ESBResultDTO implements Serializable{

	private static final long serialVersionUID = 4319006587803868532L;
	
	@JsonProperty("referentiDetokenizzati")
	private DetokenizzazioneReferentiOutputDTO referentiDetokenizzati;

	public DetokenizzazioneReferentiOutputDTO getReferentiDetokenizzati() {
		return referentiDetokenizzati;
	}

	public void setReferentiDetokenizzati(DetokenizzazioneReferentiOutputDTO referentiDetokenizzati) {
		this.referentiDetokenizzati = referentiDetokenizzati;
	}

	

}
