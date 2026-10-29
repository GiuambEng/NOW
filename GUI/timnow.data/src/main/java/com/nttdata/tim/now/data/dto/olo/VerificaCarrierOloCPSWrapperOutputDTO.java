package com.nttdata.tim.now.data.dto.olo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_915
@JsonInclude(Include.NON_NULL)
public class VerificaCarrierOloCPSWrapperOutputDTO extends ESBResultDTO {
 
	private static final long serialVersionUID = 707349357687361085L;

	@JsonProperty("VerificaCarrierOloCPSOutput")
	private VerificaCarrierOloCPSOutputDTO verificaCarrierOloCPSOutput;

	public VerificaCarrierOloCPSOutputDTO getVerificaCarrierOloCPSOutput() {
		return verificaCarrierOloCPSOutput;
	}

	public void setVerificaCarrierOloCPSOutput(VerificaCarrierOloCPSOutputDTO verificaCarrierOloCPSOutput) {
		this.verificaCarrierOloCPSOutput = verificaCarrierOloCPSOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificaCarrierOloCPSOutput == null) ? 0 : verificaCarrierOloCPSOutput.hashCode());
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
		VerificaCarrierOloCPSWrapperOutputDTO other = (VerificaCarrierOloCPSWrapperOutputDTO) obj;
		if (verificaCarrierOloCPSOutput == null) {
			if (other.verificaCarrierOloCPSOutput != null)
				return false;
		} else if (!verificaCarrierOloCPSOutput.equals(other.verificaCarrierOloCPSOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaCarrierOloCPSWrapperOutputDTO [verificaCarrierOloCPSOutput=" + verificaCarrierOloCPSOutput
				+ "]";
	}

}
