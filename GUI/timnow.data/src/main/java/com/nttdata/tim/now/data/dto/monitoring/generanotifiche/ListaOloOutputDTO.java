package com.nttdata.tim.now.data.dto.monitoring.generanotifiche;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaOloOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -6745981615043844933L;
	
	@JsonProperty("ListaOloOutput")
	private List<OloDTO> olos;

	public List<OloDTO> getOlos() {
		return olos;
	}

	public void setOlos(List<OloDTO> olos) {
		this.olos = olos;
	}

	@Override
	public String toString() {
		return "ListaOloOutputDTO [olos=" + olos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((olos == null) ? 0 : olos.hashCode());
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
		ListaOloOutputDTO other = (ListaOloOutputDTO) obj;
		if (olos == null) {
			if (other.olos != null)
				return false;
		} else if (!olos.equals(other.olos))
			return false;
		return true;
	}

}
