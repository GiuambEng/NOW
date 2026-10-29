package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1164
public class VerificaContrattoCoinvestimentoComuneWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -6585830446411727871L;
	
	@JsonProperty("VerificaContrattoCoinvestimentoComuneOuput")
	private VerificaContrattoCoinvestimentoComuneOutputBean verificaContrattoCoinvestimentoComuneOutput;

	public VerificaContrattoCoinvestimentoComuneOutputBean getVerificaContrattoCoinvestimentoComuneOutput() {
		return verificaContrattoCoinvestimentoComuneOutput;
	}

	public void setVerificaContrattoCoinvestimentoComuneOutput(
			VerificaContrattoCoinvestimentoComuneOutputBean verificaContrattoCoinvestimentoComuneOutput) {
		this.verificaContrattoCoinvestimentoComuneOutput = verificaContrattoCoinvestimentoComuneOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificaContrattoCoinvestimentoComuneOutput == null) ? 0
				: verificaContrattoCoinvestimentoComuneOutput.hashCode());
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
		VerificaContrattoCoinvestimentoComuneWrapperOutputBean other = (VerificaContrattoCoinvestimentoComuneWrapperOutputBean) obj;
		if (verificaContrattoCoinvestimentoComuneOutput == null) {
			if (other.verificaContrattoCoinvestimentoComuneOutput != null)
				return false;
		} else if (!verificaContrattoCoinvestimentoComuneOutput
				.equals(other.verificaContrattoCoinvestimentoComuneOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaContrattoCoinvestimentoComuneWrapperOutputBean [verificaContrattoCoinvestimentoComuneOutput="
				+ verificaContrattoCoinvestimentoComuneOutput + "]";
	}

	
}
