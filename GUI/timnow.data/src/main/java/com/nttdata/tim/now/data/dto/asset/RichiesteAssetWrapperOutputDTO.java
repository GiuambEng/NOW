package com.nttdata.tim.now.data.dto.asset;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class RichiesteAssetWrapperOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = 2530458578796981009L;

	@JsonProperty("ListaRichiesteRicarica")
	private List<RichiesteAssetOutputDTO> list;

	public List<RichiesteAssetOutputDTO> getList() {
		return list;
	}

	public void setList(List<RichiesteAssetOutputDTO> list) {
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
		RichiesteAssetWrapperOutputDTO other = (RichiesteAssetWrapperOutputDTO) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RichiesteAssetWrapperOutputDTO [list=" + list + "]";
	}

	
	
}
