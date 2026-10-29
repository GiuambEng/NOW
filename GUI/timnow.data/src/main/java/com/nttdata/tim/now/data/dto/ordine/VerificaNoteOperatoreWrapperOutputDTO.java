package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//R1F-20-0236.D
@JsonInclude(Include.NON_NULL)
public class VerificaNoteOperatoreWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -6248096849904365647L;
	
	@JsonProperty("VerificaNumeriNoteOutput")
    private VerificaNoteOperatoreOutputDTO verificaNumeriNoteOutput;

	public VerificaNoteOperatoreOutputDTO getVerificaNumeriNoteOutput() {
		return verificaNumeriNoteOutput;
	}

	public void setVerificaNumeriNoteOutput(VerificaNoteOperatoreOutputDTO verificaNumeriNoteOutput) {
		this.verificaNumeriNoteOutput = verificaNumeriNoteOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificaNumeriNoteOutput == null) ? 0 : verificaNumeriNoteOutput.hashCode());
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
		VerificaNoteOperatoreWrapperOutputDTO other = (VerificaNoteOperatoreWrapperOutputDTO) obj;
		if (verificaNumeriNoteOutput == null) {
			if (other.verificaNumeriNoteOutput != null)
				return false;
		} else if (!verificaNumeriNoteOutput.equals(other.verificaNumeriNoteOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaNoteOperatoreWrapperOutputDTO [verificaNumeriNoteOutput=" + verificaNumeriNoteOutput + "]";
	}
}
