package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_966
public class VerificaIntermediateAgentFullWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -2863585111151652906L;

	@JsonProperty("VerificaCompatibilitaIntermediateAgentOutput")
	private VerificaIntermediateAgentFullOutputDTO verificaCompatibilitaIntermediateAgentOutput;
	
	public VerificaIntermediateAgentFullOutputDTO getVerificaCompatibilitaIntermediateAgentOutput() {
		return verificaCompatibilitaIntermediateAgentOutput;
	}

	public void setVerificaCompatibilitaIntermediateAgentOutput(
			VerificaIntermediateAgentFullOutputDTO verificaCompatibilitaIntermediateAgentOutput) {
		this.verificaCompatibilitaIntermediateAgentOutput = verificaCompatibilitaIntermediateAgentOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificaCompatibilitaIntermediateAgentOutput == null) ? 0
				: verificaCompatibilitaIntermediateAgentOutput.hashCode());
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
		VerificaIntermediateAgentFullWrapperOutputDTO other = (VerificaIntermediateAgentFullWrapperOutputDTO) obj;
		if (verificaCompatibilitaIntermediateAgentOutput == null) {
			if (other.verificaCompatibilitaIntermediateAgentOutput != null)
				return false;
		} else if (!verificaCompatibilitaIntermediateAgentOutput
				.equals(other.verificaCompatibilitaIntermediateAgentOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaIntermediateAgentFullWrapperOutputDTO [verificaCompatibilitaIntermediateAgentOutput="
				+ verificaCompatibilitaIntermediateAgentOutput + "]";
	}
	
	
	
 }
