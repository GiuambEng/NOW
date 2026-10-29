package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//SM_9825
@JsonInclude(Include.NON_NULL)
public class VerificaModelloKitMadrWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 6063290502969607139L;

	@JsonProperty("outputModelloKit")
	private VerificaModelloKitMadrOutputDTO outputModelloKit;

	public VerificaModelloKitMadrOutputDTO getOutputModelloKit() {
		return outputModelloKit;
	}

	public void setOutputModelloKit(VerificaModelloKitMadrOutputDTO outputModelloKit) {
		this.outputModelloKit = outputModelloKit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputModelloKit == null) ? 0 : outputModelloKit.hashCode());
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
		VerificaModelloKitMadrWrapperOutputDTO other = (VerificaModelloKitMadrWrapperOutputDTO) obj;
		if (outputModelloKit == null) {
			if (other.outputModelloKit != null)
				return false;
		} else if (!outputModelloKit.equals(other.outputModelloKit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaModelloKitMadrWrapperOutputDTO [outputModelloKit=" + outputModelloKit + "]";
	}


}
