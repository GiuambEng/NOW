package com.nttdata.tim.now.data.dto.ordine.tokenizzazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//SM_9686
public class DetokenizzazioneXmlOutputDTO extends ESBResultDTO implements Serializable{

	private static final long serialVersionUID = -3677466271383172136L;
	
	@JsonProperty("tracciatoDetokenizzato")
	private String tracciatoDetokenizzato;

	public String getTracciatoDetokenizzato() {
		return tracciatoDetokenizzato;
	}
	
	public void setTracciatoDetokenizzato(String tracciatoDetokenizzato) {
		this.tracciatoDetokenizzato = tracciatoDetokenizzato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tracciatoDetokenizzato == null) ? 0 : tracciatoDetokenizzato.hashCode());
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
		DetokenizzazioneXmlOutputDTO other = (DetokenizzazioneXmlOutputDTO) obj;
		if (tracciatoDetokenizzato == null) {
			if (other.tracciatoDetokenizzato != null)
				return false;
		} else if (!tracciatoDetokenizzato.equals(other.tracciatoDetokenizzato))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetokenizzazioneXmlOutputDTO [tracciatoDetokenizzato=" + tracciatoDetokenizzato + "]";
	}
}
