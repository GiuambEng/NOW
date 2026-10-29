package com.nttdata.tim.now.data.dto.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1184
public class VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 7822736183157804572L;
	
	@JsonProperty("VerificaStatoAssetAbilitazDisabilitazOutput")
	private VerificaStatoAssetAbilitazioneDisabilitazioneOutputDTO verificaStatoAssetAbilitazDisabilitazOutput;

	public VerificaStatoAssetAbilitazioneDisabilitazioneOutputDTO getVerificaStatoAssetAbilitazDisabilitazOutput() {
		return verificaStatoAssetAbilitazDisabilitazOutput;
	}

	public void setVerificaStatoAssetAbilitazDisabilitazOutput(
			VerificaStatoAssetAbilitazioneDisabilitazioneOutputDTO verificaStatoAssetAbilitazDisabilitazOutput) {
		this.verificaStatoAssetAbilitazDisabilitazOutput = verificaStatoAssetAbilitazDisabilitazOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificaStatoAssetAbilitazDisabilitazOutput == null) ? 0
				: verificaStatoAssetAbilitazDisabilitazOutput.hashCode());
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
		VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputDTO other = (VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputDTO) obj;
		if (verificaStatoAssetAbilitazDisabilitazOutput == null) {
			if (other.verificaStatoAssetAbilitazDisabilitazOutput != null)
				return false;
		} else if (!verificaStatoAssetAbilitazDisabilitazOutput
				.equals(other.verificaStatoAssetAbilitazDisabilitazOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputDTO [verificaStatoAssetAbilitazDisabilitazOutput="
				+ verificaStatoAssetAbilitazDisabilitazOutput + "]";
	}

	
 }
