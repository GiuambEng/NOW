package com.nttdata.tim.now.data.dto.notifica;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1180
@JsonInclude(Include.NON_NULL)
public class VerificaContrattoMulticastWrapperOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -4174330650863863558L;
	
	@JsonProperty("outputVerificaContrattoMulticast")
	private VerificaContrattoMulticastOutputDTO outputVerificaContrattoMulticast;

	public VerificaContrattoMulticastOutputDTO getOutputVerificaContrattoMulticast() {
		return outputVerificaContrattoMulticast;
	}

	public void setOutputVerificaContrattoMulticast(VerificaContrattoMulticastOutputDTO outputVerificaContrattoMulticast) {
		this.outputVerificaContrattoMulticast = outputVerificaContrattoMulticast;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((outputVerificaContrattoMulticast == null) ? 0 : outputVerificaContrattoMulticast.hashCode());
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
		VerificaContrattoMulticastWrapperOutputDTO other = (VerificaContrattoMulticastWrapperOutputDTO) obj;
		if (outputVerificaContrattoMulticast == null) {
			if (other.outputVerificaContrattoMulticast != null)
				return false;
		} else if (!outputVerificaContrattoMulticast.equals(other.outputVerificaContrattoMulticast))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaContrattoMulticastWrapperOutputDTO [outputVerificaContrattoMulticast="
				+ outputVerificaContrattoMulticast + "]";
	}



}
