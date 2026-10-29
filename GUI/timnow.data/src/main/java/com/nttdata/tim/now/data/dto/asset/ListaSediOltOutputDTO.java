package com.nttdata.tim.now.data.dto.asset;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//R1I-21-0203
@JsonInclude(Include.NON_NULL)
public class ListaSediOltOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -1404150712507335401L;
	
	@JsonProperty("SediOltDettaglioAssetOutput")
	private List<SedeOltOutputDTO> sediOlt;

	public List<SedeOltOutputDTO> getSediOlt() {
		return sediOlt;
	}

	public void setSediOlt(List<SedeOltOutputDTO> sediOlt) {
		this.sediOlt = sediOlt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sediOlt == null) ? 0 : sediOlt.hashCode());
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
		ListaSediOltOutputDTO other = (ListaSediOltOutputDTO) obj;
		if (sediOlt == null) {
			if (other.sediOlt != null)
				return false;
		} else if (!sediOlt.equals(other.sediOlt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaSediOltOutputDTO [sediOlt=" + sediOlt + "]";
	}

}
