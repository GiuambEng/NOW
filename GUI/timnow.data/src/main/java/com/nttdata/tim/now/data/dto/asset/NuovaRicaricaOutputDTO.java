package com.nttdata.tim.now.data.dto.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class NuovaRicaricaOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 2047547603916926510L;

	@JsonProperty("processID")
    private String processID;

	public String getProcessID() {
		return processID;
	}

	public void setProcessID(String processID) {
		this.processID = processID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((processID == null) ? 0 : processID.hashCode());
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
		NuovaRicaricaOutputDTO other = (NuovaRicaricaOutputDTO) obj;
		if (processID == null) {
			if (other.processID != null)
				return false;
		} else if (!processID.equals(other.processID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NuovaRicaricaOutputDTO [processID=" + processID + "]";
	}
    
	
    
}
