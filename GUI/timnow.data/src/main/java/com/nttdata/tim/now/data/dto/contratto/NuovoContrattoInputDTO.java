package com.nttdata.tim.now.data.dto.contratto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_716
@JsonInclude(Include.NON_NULL) 
public class NuovoContrattoInputDTO implements Serializable{

	private static final long serialVersionUID = 5032757757366929186L;
	
	@JsonProperty("nuovoContratto")
	private List<NuovoContrattoListItemDTO> nuovoContratto;
	
	public List<NuovoContrattoListItemDTO> getNuovoContratto() {
		return nuovoContratto;
	}

	public void setNuovoContratto(List<NuovoContrattoListItemDTO> nuovoContratto) {
		this.nuovoContratto = nuovoContratto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nuovoContratto == null) ? 0 : nuovoContratto.hashCode());
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
		NuovoContrattoInputDTO other = (NuovoContrattoInputDTO) obj;
		if (nuovoContratto == null) {
			if (other.nuovoContratto != null)
				return false;
		} else if (!nuovoContratto.equals(other.nuovoContratto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NuovoContrattoInputDTO [nuovoContratto=" + nuovoContratto + "]";
	}
}
