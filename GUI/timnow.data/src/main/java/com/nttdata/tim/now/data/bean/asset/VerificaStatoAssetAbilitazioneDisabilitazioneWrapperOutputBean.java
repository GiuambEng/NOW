package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1184
public class VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputBean extends AbstractOutputBean implements Serializable {
	
	private static final long serialVersionUID = -1190856400463738452L;
	
	@JsonProperty("VerificaStatoAssetAbilitazDisabilitazOutput")
	private VerificaStatoAssetAbilitazioneDisabilitazioneOutputBean verificaStatoAssetAbilitazDisabilitazOutput;

	public VerificaStatoAssetAbilitazioneDisabilitazioneOutputBean getVerificaStatoAssetAbilitazDisabilitazOutput() {
		return verificaStatoAssetAbilitazDisabilitazOutput;
	}

	public void setVerificaStatoAssetAbilitazDisabilitazOutput(
			VerificaStatoAssetAbilitazioneDisabilitazioneOutputBean verificaStatoAssetAbilitazDisabilitazOutput) {
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
		VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputBean other = (VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputBean) obj;
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
		return "VerificaStatoAssetAbilitazioneDisabilitazioneWrapperOutputBean [verificaStatoAssetAbilitazDisabilitazOutput="
				+ verificaStatoAssetAbilitazDisabilitazOutput + "]";
	}
}
