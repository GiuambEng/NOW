package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class RecuperaCodOloSubContractorWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 7945146481570997527L;
	
	@JsonProperty("listaCodOloSubcontractor")
    private List<RecuperaCodOloSubContractorOutputDTO> listaCodOloSubcontractor;

	public List<RecuperaCodOloSubContractorOutputDTO> getListaCodOloSubcontractor() {
		return listaCodOloSubcontractor;
	}

	public void setListaCodOloSubcontractor(List<RecuperaCodOloSubContractorOutputDTO> listaCodOloSubcontractor) {
		this.listaCodOloSubcontractor = listaCodOloSubcontractor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaCodOloSubcontractor == null) ? 0 : listaCodOloSubcontractor.hashCode());
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
		RecuperaCodOloSubContractorWrapperOutputDTO other = (RecuperaCodOloSubContractorWrapperOutputDTO) obj;
		if (listaCodOloSubcontractor == null) {
			if (other.listaCodOloSubcontractor != null)
				return false;
		} else if (!listaCodOloSubcontractor.equals(other.listaCodOloSubcontractor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaSubContractorWrapperOutputDTO [listaSubcontractor=" + listaCodOloSubcontractor + "]";
	}
}
