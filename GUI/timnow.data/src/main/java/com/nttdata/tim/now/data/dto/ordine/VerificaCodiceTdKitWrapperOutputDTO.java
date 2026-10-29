package com.nttdata.tim.now.data.dto.ordine;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1058
public class VerificaCodiceTdKitWrapperOutputDTO extends ESBResultDTO{

	private static final long serialVersionUID = -6997465397594135839L;
	
	@JsonProperty("ControlliCodiceTDKitOutput")
    private VerificaCodiceTdKitOutputDTO controlliCodiceTDKitOutput;

	public VerificaCodiceTdKitOutputDTO getControlliCodiceTDKitOutput() {
		return controlliCodiceTDKitOutput;
	}

	public void setControlliCodiceTDKitOutput(VerificaCodiceTdKitOutputDTO controlliCodiceTDKitOutput) {
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
		VerificaCodiceTdKitWrapperOutputDTO other = (VerificaCodiceTdKitWrapperOutputDTO) obj;
		if (controlliCodiceTDKitOutput == null) {
			if (other.controlliCodiceTDKitOutput != null)
				return false;
		} else if (!controlliCodiceTDKitOutput.equals(other.controlliCodiceTDKitOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaCodiceTdKitWrapperOutputDTO [controlliCodiceTDKitOutput=" + controlliCodiceTDKitOutput + "]";
	}

	
    
}
