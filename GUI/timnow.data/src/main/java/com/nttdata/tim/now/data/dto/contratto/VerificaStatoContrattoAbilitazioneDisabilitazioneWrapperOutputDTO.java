package com.nttdata.tim.now.data.dto.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1184
public class VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -7055872198536559263L;
	
	@JsonProperty("VerificaStatoContrattoDisabilitazAbilitazOutput")
	private VerificaStatoContrattoAbilitazioneDisabilitazioneOutputDTO verificaStatoContrattoAbilitazDisabilitazOutput;

	public VerificaStatoContrattoAbilitazioneDisabilitazioneOutputDTO getVerificaStatoContrattoAbilitazDisabilitazOutput() {
		return verificaStatoContrattoAbilitazDisabilitazOutput;
	}

	public void setVerificaStatoContrattoAbilitazDisabilitazOutput(
			VerificaStatoContrattoAbilitazioneDisabilitazioneOutputDTO verificaStatoContrattoAbilitazDisabilitazOutput) {
		this.verificaStatoContrattoAbilitazDisabilitazOutput = verificaStatoContrattoAbilitazDisabilitazOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificaStatoContrattoAbilitazDisabilitazOutput == null) ? 0
				: verificaStatoContrattoAbilitazDisabilitazOutput.hashCode());
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
		VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputDTO other = (VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputDTO) obj;
		if (verificaStatoContrattoAbilitazDisabilitazOutput == null) {
			if (other.verificaStatoContrattoAbilitazDisabilitazOutput != null)
				return false;
		} else if (!verificaStatoContrattoAbilitazDisabilitazOutput
				.equals(other.verificaStatoContrattoAbilitazDisabilitazOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputDTO [verificaStatoContrattoAbilitazDisabilitazOutput="
				+ verificaStatoContrattoAbilitazDisabilitazOutput + "]";
	}
 }
