package com.nttdata.tim.now.data.dto.asset;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//R1I-21-0203
@JsonInclude(Include.NON_NULL)
public class ListaFeederOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -5098407440994318479L;
	
	@JsonProperty("FeederDettaglioAssetOutput")
	private List<FeederOutputDTO> feeders;

	public List<FeederOutputDTO> getFeeders() {
		return feeders;
	}

	public void setFeeders(List<FeederOutputDTO> feeders) {
		this.feeders = feeders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feeders == null) ? 0 : feeders.hashCode());
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
		ListaFeederOutputDTO other = (ListaFeederOutputDTO) obj;
		if (feeders == null) {
			if (other.feeders != null)
				return false;
		} else if (!feeders.equals(other.feeders))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaFeederOutputDTO [feeders=" + feeders + "]";
	}

}
