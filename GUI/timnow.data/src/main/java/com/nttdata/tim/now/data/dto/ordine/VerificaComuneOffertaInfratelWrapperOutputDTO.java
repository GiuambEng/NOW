package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1060
public class VerificaComuneOffertaInfratelWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -3642277322714835076L;
	
	@JsonProperty("VerificaComuneOffertaInfratelOutput")
	private VerificaComuneOffertaInfratelOutputDTO verificaComuneOffertaInfratelOutput;

	public VerificaComuneOffertaInfratelOutputDTO getVerificaComuneOffertaInfratelOutput() {
		return verificaComuneOffertaInfratelOutput;
	}

	public void setVerificaComuneOffertaInfratelOutput(
			VerificaComuneOffertaInfratelOutputDTO verificaComuneOffertaInfratelOutput) {
		this.verificaComuneOffertaInfratelOutput = verificaComuneOffertaInfratelOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((verificaComuneOffertaInfratelOutput == null) ? 0 : verificaComuneOffertaInfratelOutput.hashCode());
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
		VerificaComuneOffertaInfratelWrapperOutputDTO other = (VerificaComuneOffertaInfratelWrapperOutputDTO) obj;
		if (verificaComuneOffertaInfratelOutput == null) {
			if (other.verificaComuneOffertaInfratelOutput != null)
				return false;
		} else if (!verificaComuneOffertaInfratelOutput.equals(other.verificaComuneOffertaInfratelOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaComuneOffertaInfratelWrapperOutputDTO [verificaComuneOffertaInfratelOutput="
				+ verificaComuneOffertaInfratelOutput + "]";
	}

	
 }
