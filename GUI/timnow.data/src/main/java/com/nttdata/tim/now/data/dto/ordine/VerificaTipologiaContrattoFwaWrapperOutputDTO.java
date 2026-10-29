package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1129
@JsonInclude(Include.NON_NULL)
public class VerificaTipologiaContrattoFwaWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 6507006739375143428L;
	
	@JsonProperty("outputTipologieFWA")
    private VerificaTipologiaContrattoFwaOutputDTO outputTipologieFwa;

	public VerificaTipologiaContrattoFwaOutputDTO getOutputTipologieFwa() {
		return outputTipologieFwa;
	}

	public void setOutputTipologieFwa(VerificaTipologiaContrattoFwaOutputDTO outputTipologieFwa) {
		this.outputTipologieFwa = outputTipologieFwa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputTipologieFwa == null) ? 0 : outputTipologieFwa.hashCode());
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
		VerificaTipologiaContrattoFwaWrapperOutputDTO other = (VerificaTipologiaContrattoFwaWrapperOutputDTO) obj;
		if (outputTipologieFwa == null) {
			if (other.outputTipologieFwa != null)
				return false;
		} else if (!outputTipologieFwa.equals(other.outputTipologieFwa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaTipologiaContrattoFwaWrapperOutputDTO [outputTipologieFwa=" + outputTipologieFwa + "]";
	}	
}
