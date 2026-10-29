package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;

//RU_1058
public class VerificaKitAbilitatoNGAWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -2863585111151652906L;

	@JsonProperty("ControlliCodiceTDKitOutput")
	private EsitoDTO controlliCodiceTDKitOutput;

	public EsitoDTO getControlliCodiceTDKitOutput() {
		return controlliCodiceTDKitOutput;
	}

	public void setControlliCodiceTDKitOutput(EsitoDTO controlliCodiceTDKitOutput) {
		this.controlliCodiceTDKitOutput = controlliCodiceTDKitOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((controlliCodiceTDKitOutput == null) ? 0 : controlliCodiceTDKitOutput.hashCode());
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
		VerificaKitAbilitatoNGAWrapperOutputDTO other = (VerificaKitAbilitatoNGAWrapperOutputDTO) obj;
		if (controlliCodiceTDKitOutput == null) {
			if (other.controlliCodiceTDKitOutput != null)
				return false;
		} else if (!controlliCodiceTDKitOutput.equals(other.controlliCodiceTDKitOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaKitAbilitatoNGAWrapperOutputDTO [controlliCodiceTDKitOutput=" + controlliCodiceTDKitOutput
				+ "]";
	}
	
		
 }
