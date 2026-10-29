package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1181
@JsonInclude(Include.NON_NULL)
public class VerificaRecuperoModemWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 3688555982862984703L;
	
	@JsonProperty("outputVerificaRecuperoModem")
	private VerificaRecuperoModemOutputDTO outputVerificaRecuperoModem;

	public VerificaRecuperoModemOutputDTO getOutputVerificaRecuperoModem() {
		return outputVerificaRecuperoModem;
	}

	public void setOutputVerificaRecuperoModem(VerificaRecuperoModemOutputDTO outputVerificaRecuperoModem) {
		this.outputVerificaRecuperoModem = outputVerificaRecuperoModem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputVerificaRecuperoModem == null) ? 0 : outputVerificaRecuperoModem.hashCode());
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
		VerificaRecuperoModemWrapperOutputDTO other = (VerificaRecuperoModemWrapperOutputDTO) obj;
		if (outputVerificaRecuperoModem == null) {
			if (other.outputVerificaRecuperoModem != null)
				return false;
		} else if (!outputVerificaRecuperoModem.equals(other.outputVerificaRecuperoModem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaRecuperoModemWrapperOutputDTO [outputVerificaRecuperoModem=" + outputVerificaRecuperoModem
				+ "]";
	}
 }
