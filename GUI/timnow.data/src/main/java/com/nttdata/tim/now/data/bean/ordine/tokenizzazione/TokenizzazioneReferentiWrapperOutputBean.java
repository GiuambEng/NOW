package com.nttdata.tim.now.data.bean.ordine.tokenizzazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class TokenizzazioneReferentiWrapperOutputBean extends AbstractOutputBean implements Serializable{

	private static final long serialVersionUID = 4534778916439960282L;
	
	@JsonProperty("referentiTokenizzati")
	private TokenizzazioneReferentiOutputBean referentiTokenizzati;

	public TokenizzazioneReferentiOutputBean getReferentiTokenizzati() {
		return referentiTokenizzati;
	}

	public void setReferentiTokenizzati(TokenizzazioneReferentiOutputBean referentiTokenizzati) {
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
		TokenizzazioneReferentiWrapperOutputBean other = (TokenizzazioneReferentiWrapperOutputBean) obj;
		if (referentiTokenizzati == null) {
			if (other.referentiTokenizzati != null)
				return false;
		} else if (!referentiTokenizzati.equals(other.referentiTokenizzati))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TokenizzazioneReferentiWrapperOutputBean [referentiTokenizzati=" + referentiTokenizzati + "]";
	}

}
