package com.nttdata.tim.now.data.dto.contratto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class VerificaContrattoWrapperOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 5746261154033962257L;

	@JsonProperty("VerificaContrattoOutput")
	private VerificaContrattoOutputDTO verificaContrattoOutput;

	public VerificaContrattoOutputDTO getVerificaContrattoOutput() {
		return verificaContrattoOutput;
	}

	public void setVerificaContrattoOutput(VerificaContrattoOutputDTO verificaContrattoOutput) {
		this.verificaContrattoOutput = verificaContrattoOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificaContrattoOutput == null) ? 0 : verificaContrattoOutput.hashCode());
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
		VerificaContrattoWrapperOutputDTO other = (VerificaContrattoWrapperOutputDTO) obj;
		if (verificaContrattoOutput == null) {
			if (other.verificaContrattoOutput != null)
				return false;
		} else if (!verificaContrattoOutput.equals(other.verificaContrattoOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaContrattoWrapperOutputDTO [verificaContrattoOutput=" + verificaContrattoOutput + "]";
	}

	
}
