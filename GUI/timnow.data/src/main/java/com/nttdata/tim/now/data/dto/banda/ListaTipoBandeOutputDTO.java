package com.nttdata.tim.now.data.dto.banda;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaTipoBandeOutputDTO extends ESBResultDTO {
 
	private static final long serialVersionUID = -5798801177531438421L;

	@JsonProperty("outputVisualizzaTipoBanda")
	private List<TipoBandaOutputDTO> tipoBandaList;

	public List<TipoBandaOutputDTO> getTipoBandaList() {
		return tipoBandaList;
	}

	public void setTipoBandaList(List<TipoBandaOutputDTO> tipoBandaList) {
		this.tipoBandaList = tipoBandaList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipoBandaList == null) ? 0 : tipoBandaList.hashCode());
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
		ListaTipoBandeOutputDTO other = (ListaTipoBandeOutputDTO) obj;
		if (tipoBandaList == null) {
			if (other.tipoBandaList != null)
				return false;
		} else if (!tipoBandaList.equals(other.tipoBandaList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaTipoBandeOutputDTO [tipoBandaList=" + tipoBandaList + "]";
	}

	
}
