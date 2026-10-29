package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class RecuperaSubContractorWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 7582377372553581114L;
	
	@JsonProperty("listaSubcontractor")
    private List<RecuperaSubContractorOutputDTO> listaSubcontractor;

	public List<RecuperaSubContractorOutputDTO> getListaSubcontractor() {
		return listaSubcontractor;
	}

	public void setListaSubcontractor(List<RecuperaSubContractorOutputDTO> listaSubcontractor) {
		this.listaSubcontractor = listaSubcontractor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaSubcontractor == null) ? 0 : listaSubcontractor.hashCode());
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
		RecuperaSubContractorWrapperOutputDTO other = (RecuperaSubContractorWrapperOutputDTO) obj;
		if (listaSubcontractor == null) {
			if (other.listaSubcontractor != null)
				return false;
		} else if (!listaSubcontractor.equals(other.listaSubcontractor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaSubContractorWrapperOutputDTO [listaSubcontractor=" + listaSubcontractor + "]";
	}
}
