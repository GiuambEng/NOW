package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_833 FIX FWA CESSAZIONE
public class VerificaCodiceOrdineOloWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 2023108830976494683L;

	@JsonProperty("VerificaCodiceOrdineOloOutput")
	VerificaCodiceOrdineOloOutputDTO verificaCodiceOrdineOloOutput;

	
	public VerificaCodiceOrdineOloOutputDTO getVerificaCodiceOrdineOloOutput() {
		return verificaCodiceOrdineOloOutput;
	}


	public void setVerificaCodiceOrdineOloOutput(VerificaCodiceOrdineOloOutputDTO verificaCodiceOrdineOloOutput) {
		this.verificaCodiceOrdineOloOutput = verificaCodiceOrdineOloOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((verificaCodiceOrdineOloOutput == null) ? 0 : verificaCodiceOrdineOloOutput.hashCode());
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
		VerificaCodiceOrdineOloWrapperOutputDTO other = (VerificaCodiceOrdineOloWrapperOutputDTO) obj;
		if (verificaCodiceOrdineOloOutput == null) {
			if (other.verificaCodiceOrdineOloOutput != null)
				return false;
		} else if (!verificaCodiceOrdineOloOutput.equals(other.verificaCodiceOrdineOloOutput))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "VerificaCodiceOrdineOloWrapperOutputDTO [verificaCodiceOrdineOloOutput=" + verificaCodiceOrdineOloOutput
				+ "]";
	}
	
	
 }
