package com.nttdata.tim.now.data.dto.ordine.tokenizzazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class TokenizzazioneReferentiWrapperOutputDTO extends ESBResultDTO implements Serializable{

	private static final long serialVersionUID = -7311212546690540396L;
	
	@JsonProperty("referentiTokenizzati")
	private TokenizzazioneReferentiOutputDTO referentiTokenizzati;

	public TokenizzazioneReferentiOutputDTO getReferentiTokenizzati() {
		return referentiTokenizzati;
	}

	public void setReferentiTokenizzati(TokenizzazioneReferentiOutputDTO referentiTokenizzati) {
		this.referentiTokenizzati = referentiTokenizzati;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((referentiTokenizzati == null) ? 0 : referentiTokenizzati.hashCode());
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
		TokenizzazioneReferentiWrapperOutputDTO other = (TokenizzazioneReferentiWrapperOutputDTO) obj;
		if (referentiTokenizzati == null) {
			if (other.referentiTokenizzati != null)
				return false;
		} else if (!referentiTokenizzati.equals(other.referentiTokenizzati))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TokenizzazioneReferentiWrapperOutputDTO [referentiTokenizzati=" + referentiTokenizzati + "]";
	}

}
