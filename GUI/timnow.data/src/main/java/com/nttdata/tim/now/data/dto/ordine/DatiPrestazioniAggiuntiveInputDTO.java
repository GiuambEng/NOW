package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_980
@JsonInclude(Include.NON_NULL)
public class DatiPrestazioniAggiuntiveInputDTO implements Serializable {

	private static final long serialVersionUID = 9078007772143867194L;

	@JsonProperty("flagPrestazioneAggiuntiva")
	private String flagPrestazioneAggiuntiva;
	
	@JsonProperty("prestazioneAggiuntiva")
	private String prestazioneAggiuntiva;

	public String getFlagPrestazioneAggiuntiva() {
		return flagPrestazioneAggiuntiva;
	}

	public void setFlagPrestazioneAggiuntiva(String flagPrestazioneAggiuntiva) {
		this.flagPrestazioneAggiuntiva = flagPrestazioneAggiuntiva;
	}

	public String getPrestazioneAggiuntiva() {
		return prestazioneAggiuntiva;
	}

	public void setPrestazioneAggiuntiva(String prestazioneAggiuntiva) {
		this.prestazioneAggiuntiva = prestazioneAggiuntiva;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flagPrestazioneAggiuntiva == null) ? 0 : flagPrestazioneAggiuntiva.hashCode());
		result = prime * result + ((prestazioneAggiuntiva == null) ? 0 : prestazioneAggiuntiva.hashCode());
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
		DatiPrestazioniAggiuntiveInputDTO other = (DatiPrestazioniAggiuntiveInputDTO) obj;
		if (flagPrestazioneAggiuntiva == null) {
			if (other.flagPrestazioneAggiuntiva != null)
				return false;
		} else if (!flagPrestazioneAggiuntiva.equals(other.flagPrestazioneAggiuntiva))
			return false;
		if (prestazioneAggiuntiva == null) {
			if (other.prestazioneAggiuntiva != null)
				return false;
		} else if (!prestazioneAggiuntiva.equals(other.prestazioneAggiuntiva))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatiPrestazioniAggiuntiveInputDTO [flagPrestazioneAggiuntiva=" + flagPrestazioneAggiuntiva
				+ ", prestazioneAggiuntiva=" + prestazioneAggiuntiva + "]";
	}

	
}
