package com.nttdata.tim.now.data.dto.ordine;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_871
public class VerificaInConsistenzaPresenzaModemOutputWrapperDTO extends ESBResultDTO{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("VerificaInConsistenzaPresenzaModemOutput")
	VerificaInConsistenzaPresenzaModemOutputDTO verificaInConsistenzaPresenzaModemOutput;
	
	public VerificaInConsistenzaPresenzaModemOutputDTO getVerificaInConsistenzaPresenzaModemOutput() {
		return verificaInConsistenzaPresenzaModemOutput;
	}

	public void setVerificaInConsistenzaPresenzaModemOutput(
			VerificaInConsistenzaPresenzaModemOutputDTO verificaInConsistenzaPresenzaModemOutput) {
		this.verificaInConsistenzaPresenzaModemOutput = verificaInConsistenzaPresenzaModemOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificaInConsistenzaPresenzaModemOutput == null) ? 0
				: verificaInConsistenzaPresenzaModemOutput.hashCode());
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
		VerificaInConsistenzaPresenzaModemOutputWrapperDTO other = (VerificaInConsistenzaPresenzaModemOutputWrapperDTO) obj;
		if (verificaInConsistenzaPresenzaModemOutput == null) {
			if (other.verificaInConsistenzaPresenzaModemOutput != null)
				return false;
		} else if (!verificaInConsistenzaPresenzaModemOutput.equals(other.verificaInConsistenzaPresenzaModemOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaInConsistenzaPresenzaModemOutputWrapperDTO [verificaInConsistenzaPresenzaModemOutput="
				+ verificaInConsistenzaPresenzaModemOutput + "]";
	}
	
	
}
