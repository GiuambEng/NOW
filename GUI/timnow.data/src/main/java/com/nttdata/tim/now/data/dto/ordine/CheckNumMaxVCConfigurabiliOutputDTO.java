package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class CheckNumMaxVCConfigurabiliOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -6582111871176305481L;

	@JsonProperty("numMaxVCxCF")
    private String numMaxVCxCF;

	public String getNumMaxVCxCF() {
		return numMaxVCxCF;
	}

	public void setNumMaxVCxCF(String numMaxVCxCF) {
		this.numMaxVCxCF = numMaxVCxCF;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numMaxVCxCF == null) ? 0 : numMaxVCxCF.hashCode());
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
		CheckNumMaxVCConfigurabiliOutputDTO other = (CheckNumMaxVCConfigurabiliOutputDTO) obj;
		if (numMaxVCxCF == null) {
			if (other.numMaxVCxCF != null)
				return false;
		} else if (!numMaxVCxCF.equals(other.numMaxVCxCF))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CheckNumMaxVCConfigurabiliOutputDTO [numMaxVCxCF=" + numMaxVCxCF + "]";
	}
	
	

}
