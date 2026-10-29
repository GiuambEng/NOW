package com.nttdata.tim.now.data.bean.ordine.tokenizzazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//SM_9651
public class DetokenizzazioneNotificaWrapperOutputBean extends AbstractOutputBean implements Serializable{

	private static final long serialVersionUID = -1423399401017506344L;

	@JsonProperty("notificaDetokenizzata")
	private DetokenizzazioneNotificaOutputBean notificaDetokenizzata;

	public DetokenizzazioneNotificaOutputBean getNotificaDetokenizzata() {
		return notificaDetokenizzata;
	}

	public void setNotificaDetokenizzata(DetokenizzazioneNotificaOutputBean notificaDetokenizzata) {
		this.notificaDetokenizzata = notificaDetokenizzata;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notificaDetokenizzata == null) ? 0 : notificaDetokenizzata.hashCode());
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
		DetokenizzazioneNotificaWrapperOutputBean other = (DetokenizzazioneNotificaWrapperOutputBean) obj;
		if (notificaDetokenizzata == null) {
			if (other.notificaDetokenizzata != null)
				return false;
		} else if (!notificaDetokenizzata.equals(other.notificaDetokenizzata))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetokenizzazioneNotificaWrapperOutputBean [notificaDetokenizzata=" + notificaDetokenizzata + "]";
	}
	
	

}
