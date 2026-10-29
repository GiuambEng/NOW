package com.nttdata.tim.now.data.dto.ordine.npng;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1203
public class CambioOloNpngOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 2734499535568368381L;
	
	@JsonProperty("processID")
	private String procesId;

	public String getProcesId() {
		return procesId;
	}

	public void setProcesId(String procesId) {
		this.procesId = procesId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((procesId == null) ? 0 : procesId.hashCode());
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
		CambioOloNpngOutputDTO other = (CambioOloNpngOutputDTO) obj;
		if (procesId == null) {
			if (other.procesId != null)
				return false;
		} else if (!procesId.equals(other.procesId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CambioOloNpngOutputDTO [procesId=" + procesId + "]";
	}
 }
