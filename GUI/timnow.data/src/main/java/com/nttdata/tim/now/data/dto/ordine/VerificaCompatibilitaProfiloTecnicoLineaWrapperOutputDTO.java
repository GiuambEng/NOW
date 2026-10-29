package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//R1I-21-0138
@JsonInclude(Include.NON_NULL)
public class VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -7830394905380553705L;
	
	@JsonProperty("VerificaCompatibilitaProfiloTecnicoLineaOutput")
	private VerificaCompatibilitaProfiloTecnicoLineaOutputDTO verificaCompatibilitaProfiloTecnicoLineaOutput;

	public VerificaCompatibilitaProfiloTecnicoLineaOutputDTO getVerificaCompatibilitaProfiloTecnicoLineaOutput() {
		return verificaCompatibilitaProfiloTecnicoLineaOutput;
	}

	public void setVerificaCompatibilitaProfiloTecnicoLineaOutput(
			VerificaCompatibilitaProfiloTecnicoLineaOutputDTO verificaCompatibilitaProfiloTecnicoLineaOutput) {
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
		VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputDTO other = (VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputDTO) obj;
		if (verificaCompatibilitaProfiloTecnicoLineaOutput == null) {
			if (other.verificaCompatibilitaProfiloTecnicoLineaOutput != null)
				return false;
		} else if (!verificaCompatibilitaProfiloTecnicoLineaOutput
				.equals(other.verificaCompatibilitaProfiloTecnicoLineaOutput))
			return false;
		return true;
	}	
 }
