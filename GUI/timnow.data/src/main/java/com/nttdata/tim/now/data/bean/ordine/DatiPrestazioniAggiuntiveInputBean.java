package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_980
@JsonInclude(Include.NON_NULL)
public class DatiPrestazioniAggiuntiveInputBean implements Serializable {

	private static final long serialVersionUID = -3650926058190194014L;
	
	@JsonProperty("flagPrestazioneAggiuntiva")
	private Boolean flagPrestazioneAggiuntiva;
	
	@JsonProperty("prestazioneAggiuntiva")
	private String prestazioneAggiuntiva;

	public Boolean getFlagPrestazioneAggiuntiva() {
		return flagPrestazioneAggiuntiva;
	}

	public void setFlagPrestazioneAggiuntiva(Boolean flagPrestazioneAggiuntiva) {
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
		DatiPrestazioniAggiuntiveInputBean other = (DatiPrestazioniAggiuntiveInputBean) obj;
		if (flagPrestazioneAggiuntiva != other.flagPrestazioneAggiuntiva)
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
		return "DatiPrestazioniAggiuntiveInputBean [flagPrestazioneAggiuntiva=" + flagPrestazioneAggiuntiva
				+ ", prestazioneAggiuntiva=" + prestazioneAggiuntiva + "]";
	}

	
}
