package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_980
@JsonInclude(Include.NON_NULL)
public class DatiSlaPlusSuInputDTO implements Serializable {
	
	private static final long serialVersionUID = 2567962973442642266L;

	@JsonProperty("flagSlaPlusSu")
	private String flagSlaPlusSu;
	
	@JsonProperty("valoreSla")
	private String valoreSla;

	public String getFlagSlaPlusSu() {
		return flagSlaPlusSu;
	}

	public void setFlagSlaPlusSu(String flagSlaPlusSu) {
		this.flagSlaPlusSu = flagSlaPlusSu;
	}

	public String getValoreSla() {
		return valoreSla;
	}

	public void setValoreSla(String valoreSla) {
		this.valoreSla = valoreSla;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flagSlaPlusSu == null) ? 0 : flagSlaPlusSu.hashCode());
		result = prime * result + ((valoreSla == null) ? 0 : valoreSla.hashCode());
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
		DatiSlaPlusSuInputDTO other = (DatiSlaPlusSuInputDTO) obj;
		if (flagSlaPlusSu == null) {
			if (other.flagSlaPlusSu != null)
				return false;
		} else if (!flagSlaPlusSu.equals(other.flagSlaPlusSu))
			return false;
		if (valoreSla == null) {
			if (other.valoreSla != null)
				return false;
		} else if (!valoreSla.equals(other.valoreSla))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatiSlaPlusSuInputDTO [flagSlaPlusSu=" + flagSlaPlusSu + ", valoreSla=" + valoreSla + "]";
	}
}
