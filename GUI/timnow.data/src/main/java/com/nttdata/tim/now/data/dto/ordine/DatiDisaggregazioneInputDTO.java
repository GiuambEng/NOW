package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_980
@JsonInclude(Include.NON_NULL)
public class DatiDisaggregazioneInputDTO implements Serializable {

	private static final long serialVersionUID = 554257443335156010L;

	@JsonProperty("systemUnico")
	private String systemUnico;
	
	@JsonProperty("noteSu")
	private String noteSu;

	public String getSystemUnico() {
		return systemUnico;
	}

	public void setSystemUnico(String systemUnico) {
		this.systemUnico = systemUnico;
	}

	public String getNoteSu() {
		return noteSu;
	}

	public void setNoteSu(String noteSu) {
		this.noteSu = noteSu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noteSu == null) ? 0 : noteSu.hashCode());
		result = prime * result + ((systemUnico == null) ? 0 : systemUnico.hashCode());
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
		DatiDisaggregazioneInputDTO other = (DatiDisaggregazioneInputDTO) obj;
		if (noteSu == null) {
			if (other.noteSu != null)
				return false;
		} else if (!noteSu.equals(other.noteSu))
			return false;
		if (systemUnico == null) {
			if (other.systemUnico != null)
				return false;
		} else if (!systemUnico.equals(other.systemUnico))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatiDisaggregazioneInputDTO [systemUnico=" + systemUnico + ", noteSu=" + noteSu + "]";
	}

}
