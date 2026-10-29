package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1164
public class VerificaContrattoCoinvestimentoComuneWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -2919753050106461019L;
	
	@JsonProperty("VerificaContrattoCoinvestimentoComuneOuput")
	private VerificaContrattoCoinvestimentoComuneOutputDTO verificaContrattoCoinvestimentoComuneOutput;
	
	public VerificaContrattoCoinvestimentoComuneOutputDTO getVerificaContrattoCoinvestimentoComuneOutput() {
		return verificaContrattoCoinvestimentoComuneOutput;
	}

	public void setVerificaContrattoCoinvestimentoComuneOutput(
			VerificaContrattoCoinvestimentoComuneOutputDTO verificaContrattoCoinvestimentoComuneOutput) {
		this.verificaContrattoCoinvestimentoComuneOutput = verificaContrattoCoinvestimentoComuneOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificaContrattoCoinvestimentoComuneOutput == null) ? 0
				: verificaContrattoCoinvestimentoComuneOutput.hashCode());
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
		VerificaContrattoCoinvestimentoComuneWrapperOutputDTO other = (VerificaContrattoCoinvestimentoComuneWrapperOutputDTO) obj;
		if (verificaContrattoCoinvestimentoComuneOutput == null) {
			if (other.verificaContrattoCoinvestimentoComuneOutput != null)
				return false;
		} else if (!verificaContrattoCoinvestimentoComuneOutput
				.equals(other.verificaContrattoCoinvestimentoComuneOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaContrattoCoinvestimentoComuneWrapperOutputDTO [verificaContrattoCoinvestimentoComuneOutput="
				+ verificaContrattoCoinvestimentoComuneOutput + "]";
	}
 }
