package com.nttdata.tim.now.data.dto.asset;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class TaglioRicaricaAssetWrapperOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -4353412620641606407L;

	@JsonProperty("ListaTaglioRicaricaPerOfferta")
	private List<TaglioRicaricaOutputDTO> list;

	public List<TaglioRicaricaOutputDTO> getList() {
		return list;
	}

	public void setList(List<TaglioRicaricaOutputDTO> list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		TaglioRicaricaAssetWrapperOutputDTO other = (TaglioRicaricaAssetWrapperOutputDTO) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaglioRicaricaAssetWrapperOutputDTO [list=" + list + "]";
	}

	
}
