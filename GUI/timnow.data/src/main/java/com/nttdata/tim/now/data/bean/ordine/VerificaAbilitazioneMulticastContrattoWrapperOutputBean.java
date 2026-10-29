package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1180
@JsonInclude(Include.NON_NULL)
public class VerificaAbilitazioneMulticastContrattoWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -3317408491374495588L;
	
	@JsonProperty("VerificaAbilitazioneMcContrattoOutput")
	private VerificaAbilitazioneMulticastContrattoOutputBean verificaAbilitazioneMcContrattoOutput;

	public VerificaAbilitazioneMulticastContrattoOutputBean getVerificaAbilitazioneMcContrattoOutput() {
		return verificaAbilitazioneMcContrattoOutput;
	}

	public void setVerificaAbilitazioneMcContrattoOutput(
			VerificaAbilitazioneMulticastContrattoOutputBean verificaAbilitazioneMcContrattoOutput) {
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
		VerificaAbilitazioneMulticastContrattoWrapperOutputBean other = (VerificaAbilitazioneMulticastContrattoWrapperOutputBean) obj;
		if (verificaAbilitazioneMcContrattoOutput == null) {
			if (other.verificaAbilitazioneMcContrattoOutput != null)
				return false;
		} else if (!verificaAbilitazioneMcContrattoOutput.equals(other.verificaAbilitazioneMcContrattoOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaAbilitazioneMulticastContrattoWrapperOutputBean [verificaAbilitazioneMcContrattoOutput="
				+ verificaAbilitazioneMcContrattoOutput + "]";
	}

	

}