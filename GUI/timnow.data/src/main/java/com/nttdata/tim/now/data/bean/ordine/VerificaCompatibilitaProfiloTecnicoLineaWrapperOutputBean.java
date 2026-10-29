package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//R1I-21-0138
@JsonInclude(Include.NON_NULL)
public class VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -5282831610340513481L;
	
	@JsonProperty("VerificaCompatibilitaProfiloTecnicoLineaOutput")
	private VerificaCompatibilitaProfiloTecnicoLineaOutputBean verificaCompatibilitaProfiloTecnicoLineaOutput;

	public VerificaCompatibilitaProfiloTecnicoLineaOutputBean getVerificaCompatibilitaProfiloTecnicoLineaOutput() {
		return verificaCompatibilitaProfiloTecnicoLineaOutput;
	}

	public void setVerificaCompatibilitaProfiloTecnicoLineaOutput(
			VerificaCompatibilitaProfiloTecnicoLineaOutputBean verificaCompatibilitaProfiloTecnicoLineaOutput) {
		this.verificaCompatibilitaProfiloTecnicoLineaOutput = verificaCompatibilitaProfiloTecnicoLineaOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificaCompatibilitaProfiloTecnicoLineaOutput == null) ? 0
				: verificaCompatibilitaProfiloTecnicoLineaOutput.hashCode());
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
		VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputBean other = (VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputBean) obj;
		if (verificaCompatibilitaProfiloTecnicoLineaOutput == null) {
			if (other.verificaCompatibilitaProfiloTecnicoLineaOutput != null)
				return false;
		} else if (!verificaCompatibilitaProfiloTecnicoLineaOutput
				.equals(other.verificaCompatibilitaProfiloTecnicoLineaOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputBean [verificaCompatibilitaProfiloTecnicoLineaOutput="
				+ verificaCompatibilitaProfiloTecnicoLineaOutput + "]";
	}
	
	
	

}