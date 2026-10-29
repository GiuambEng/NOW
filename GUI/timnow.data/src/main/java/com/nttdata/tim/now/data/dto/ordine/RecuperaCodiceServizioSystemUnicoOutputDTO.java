package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class RecuperaCodiceServizioSystemUnicoOutputDTO extends ESBResultDTO  implements Serializable {

	private static final long serialVersionUID = -4189924756458905868L;
	
	@JsonProperty("systemUnico")
	private List<String> systemUnico;
	
	@JsonProperty("codiceServizio")
	private List<String> codiceServizio;

	public List<String> getSystemUnico() {
		return systemUnico;
	}

	public void setSystemUnico(List<String> systemUnico) {
		this.systemUnico = systemUnico;
	}

	public List<String> getCodiceServizio() {
		return codiceServizio;
	}

	public void setCodiceServizio(List<String> codiceServizio) {
		this.codiceServizio = codiceServizio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceServizio == null) ? 0 : codiceServizio.hashCode());
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
		RecuperaCodiceServizioSystemUnicoOutputDTO other = (RecuperaCodiceServizioSystemUnicoOutputDTO) obj;
		if (codiceServizio == null) {
			if (other.codiceServizio != null)
				return false;
		} else if (!codiceServizio.equals(other.codiceServizio))
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
		return "RecuperaCodiceServizioSystemUnicoOutputDTO [systemUnico=" + systemUnico + ", codiceServizio="
				+ codiceServizio + "]";
	}

}
