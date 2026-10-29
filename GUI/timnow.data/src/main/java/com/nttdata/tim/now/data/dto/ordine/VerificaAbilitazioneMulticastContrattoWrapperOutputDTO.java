package com.nttdata.tim.now.data.dto.ordine;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1180
@JsonInclude(Include.NON_NULL)
public class VerificaAbilitazioneMulticastContrattoWrapperOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -7197621406148045633L;

	@JsonProperty("VerificaAbilitazioneMcContrattoOutput")
	private VerificaAbilitazioneMulticastContrattoOutputDTO verificaAbilitazioneMcContrattoOutput;

	public VerificaAbilitazioneMulticastContrattoOutputDTO getVerificaAbilitazioneMcContrattoOutput() {
		return verificaAbilitazioneMcContrattoOutput;
	}

	public void setVerificaAbilitazioneMcContrattoOutput(
			VerificaAbilitazioneMulticastContrattoOutputDTO verificaAbilitazioneMcContrattoOutput) {
		this.verificaAbilitazioneMcContrattoOutput = verificaAbilitazioneMcContrattoOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificaAbilitazioneMcContrattoOutput == null) ? 0
				: verificaAbilitazioneMcContrattoOutput.hashCode());
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
		VerificaAbilitazioneMulticastContrattoWrapperOutputDTO other = (VerificaAbilitazioneMulticastContrattoWrapperOutputDTO) obj;
		if (verificaAbilitazioneMcContrattoOutput == null) {
			if (other.verificaAbilitazioneMcContrattoOutput != null)
				return false;
		} else if (!verificaAbilitazioneMcContrattoOutput.equals(other.verificaAbilitazioneMcContrattoOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaAbilitazioneContrattoMulticastWrapperOutputDTO [verificaAbilitazioneMcContrattoOutput="
				+ verificaAbilitazioneMcContrattoOutput + "]";
	}

	

}
