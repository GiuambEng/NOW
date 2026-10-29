package com.nttdata.tim.now.data.bean.ordine.tokenizzazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class DetokenizzazioneReferentiWrapperOutputBean extends AbstractOutputBean implements Serializable{

	private static final long serialVersionUID = -5260600828732876378L;
	
	@JsonProperty("referentiDetokenizzati")
	private DetokenizzazioneReferentiOutputBean referentiDetokenizzati;

	public DetokenizzazioneReferentiOutputBean getReferentiDetokenizzati() {
		return referentiDetokenizzati;
	}

	public void setReferentiDetokenizzati(DetokenizzazioneReferentiOutputBean referentiDetokenizzati) {
		this.referentiDetokenizzati = referentiDetokenizzati;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((referentiDetokenizzati == null) ? 0 : referentiDetokenizzati.hashCode());
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
		DetokenizzazioneReferentiWrapperOutputBean other = (DetokenizzazioneReferentiWrapperOutputBean) obj;
		if (referentiDetokenizzati == null) {
			if (other.referentiDetokenizzati != null)
				return false;
		} else if (!referentiDetokenizzati.equals(other.referentiDetokenizzati))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetokenizzazioneReferentiWrapperOutputBean [referentiDetokenizzati=" + referentiDetokenizzati + "]";
	}

}
