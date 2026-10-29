package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1335
@JsonInclude(Include.NON_NULL)
public class VerificaIdRisorsaSwitchoffFwaWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 5653747149389010495L;
	
	@JsonProperty("outputVerificaIdRisorsaFwa")
	private VerificaIdRisorsaSwitchoffFwaOutputDTO outputVerificaIdRisorsaFwa;

	public VerificaIdRisorsaSwitchoffFwaOutputDTO getOutputVerificaIdRisorsaFwa() {
		return outputVerificaIdRisorsaFwa;
	}

	public void setOutputVerificaIdRisorsaFwa(VerificaIdRisorsaSwitchoffFwaOutputDTO outputVerificaIdRisorsaFwa) {
		this.outputVerificaIdRisorsaFwa = outputVerificaIdRisorsaFwa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(outputVerificaIdRisorsaFwa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VerificaIdRisorsaSwitchoffFwaWrapperOutputDTO other = (VerificaIdRisorsaSwitchoffFwaWrapperOutputDTO) obj;
		return Objects.equals(outputVerificaIdRisorsaFwa, other.outputVerificaIdRisorsaFwa);
	}

	@Override
	public String toString() {
		return "VerificaIdRisorsaSwitchoffFwaWrapperOutputDTO [outputVerificaIdRisorsaFwa=" + outputVerificaIdRisorsaFwa
				+ "]";
	}
 }
