package com.nttdata.tim.now.data.dto.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1276
@JsonInclude(Include.NON_NULL)
public class NuovoContrattoWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -4635748999863602469L;
	
	@JsonProperty("nuovoContrattoOutput")
	private NuovoContrattoOutputDTO nuovoContrattoOutput;

	public NuovoContrattoOutputDTO getNuovoContrattoOutput() {
		return nuovoContrattoOutput;
	}

	public void setNuovoContrattoOutput(NuovoContrattoOutputDTO nuovoContrattoOutput) {
		this.nuovoContrattoOutput = nuovoContrattoOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nuovoContrattoOutput == null) ? 0 : nuovoContrattoOutput.hashCode());
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
		NuovoContrattoWrapperOutputDTO other = (NuovoContrattoWrapperOutputDTO) obj;
		if (nuovoContrattoOutput == null) {
			if (other.nuovoContrattoOutput != null)
				return false;
		} else if (!nuovoContrattoOutput.equals(other.nuovoContrattoOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NuovoContrattoWrapperOutputDTO [nuovoContrattoOutput=" + nuovoContrattoOutput + "]";
	}

 }
