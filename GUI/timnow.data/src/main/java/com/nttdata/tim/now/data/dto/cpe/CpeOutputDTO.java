package com.nttdata.tim.now.data.dto.cpe;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_921
@JsonInclude(Include.NON_NULL)
public class CpeOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -8246370212617541383L;
	
	@JsonProperty("tipologiaCPE")
	private String tipologiaCpe;

	public String getTipologiaCpe() {
		return tipologiaCpe;
	}

	public void setTipologiaCpe(String tipologiaCpe) {
		this.tipologiaCpe = tipologiaCpe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipologiaCpe == null) ? 0 : tipologiaCpe.hashCode());
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
		CpeOutputDTO other = (CpeOutputDTO) obj;
		if (tipologiaCpe == null) {
			if (other.tipologiaCpe != null)
				return false;
		} else if (!tipologiaCpe.equals(other.tipologiaCpe))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CpeOutputDTO [tipologiaCpe=" + tipologiaCpe + "]";
	}
		
}
