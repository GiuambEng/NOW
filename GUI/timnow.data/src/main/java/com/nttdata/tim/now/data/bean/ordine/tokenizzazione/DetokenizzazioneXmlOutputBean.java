package com.nttdata.tim.now.data.bean.ordine.tokenizzazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//SM_9686
public class DetokenizzazioneXmlOutputBean extends AbstractOutputBean implements Serializable{

	private static final long serialVersionUID = -9118485144759954837L;
	
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
		DetokenizzazioneXmlOutputBean other = (DetokenizzazioneXmlOutputBean) obj;
		if (tracciatoDetokenizzato == null) {
			if (other.tracciatoDetokenizzato != null)
				return false;
		} else if (!tracciatoDetokenizzato.equals(other.tracciatoDetokenizzato))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetokenizzazioneXmlOutputBean [tracciatoDetokenizzato=" + tracciatoDetokenizzato + "]";
	}


}
