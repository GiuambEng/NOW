package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_966
public class VerificaIntermediateAgentFullWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -8110628744183791510L;
	
	@JsonProperty("VerificaCompatibilitaIntermediateAgentOutput")
	private VerificaIntermediateAgentFullOutputBean verificaCompatibilitaIntermediateAgentOutput;
	
	public VerificaIntermediateAgentFullOutputBean getVerificaCompatibilitaIntermediateAgentOutput() {
		return verificaCompatibilitaIntermediateAgentOutput;
	}

	public void setVerificaCompatibilitaIntermediateAgentOutput(VerificaIntermediateAgentFullOutputBean verificaCompatibilitaIntermediateAgentOutput) {
		this.verificaCompatibilitaIntermediateAgentOutput = verificaCompatibilitaIntermediateAgentOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificaCompatibilitaIntermediateAgentOutput == null) ? 0
				: verificaCompatibilitaIntermediateAgentOutput.hashCode());
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
		VerificaIntermediateAgentFullWrapperOutputBean other = (VerificaIntermediateAgentFullWrapperOutputBean) obj;
		if (verificaCompatibilitaIntermediateAgentOutput == null) {
			if (other.verificaCompatibilitaIntermediateAgentOutput != null)
				return false;
		} else if (!verificaCompatibilitaIntermediateAgentOutput
				.equals(other.verificaCompatibilitaIntermediateAgentOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaIntermediateAgentFullWrapperOutputDTO [verificaCompatibilitaIntermediateAgentOutput="
				+ verificaCompatibilitaIntermediateAgentOutput + "]";
	}
	
	
	
 }
