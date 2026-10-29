package com.nttdata.tim.now.data.dto.ordine;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//SM_9723
public class VerificaModelloKitWrapperOutputDTO extends ESBResultDTO{

	private static final long serialVersionUID = 6146376166328749279L;
	
	@JsonProperty("outputModelloKit")
    private VerificaCodiceTdKitOutputDTO outputModelloKit;

	public VerificaCodiceTdKitOutputDTO getOutputModelloKit() {
		return outputModelloKit;
	}

	public void setOutputModelloKit(VerificaCodiceTdKitOutputDTO outputModelloKit) {
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
		VerificaModelloKitWrapperOutputDTO other = (VerificaModelloKitWrapperOutputDTO) obj;
		if (outputModelloKit == null) {
			if (other.outputModelloKit != null)
				return false;
		} else if (!outputModelloKit.equals(other.outputModelloKit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaModelloKitWrapperOutputDTO [outputModelloKit=" + outputModelloKit + "]";
	}

	
	
    
}
