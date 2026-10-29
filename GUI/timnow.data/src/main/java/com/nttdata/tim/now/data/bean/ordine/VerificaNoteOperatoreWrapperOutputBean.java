package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//R1F-20-0236.D
@JsonInclude(Include.NON_NULL)
public class VerificaNoteOperatoreWrapperOutputBean extends AbstractOutputBean implements Serializable {
	
	private static final long serialVersionUID = -2257967651424275855L;
	
	@JsonProperty("VerificaNumeriNoteOutput")
    private VerificaNoteOperatoreOutputBean verificaNumeriNoteOutput;

	public VerificaNoteOperatoreOutputBean getVerificaNumeriNoteOutput() {
		return verificaNumeriNoteOutput;
	}

	public void setVerificaNumeriNoteOutput(VerificaNoteOperatoreOutputBean verificaNumeriNoteOutput) {
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
		VerificaNoteOperatoreWrapperOutputBean other = (VerificaNoteOperatoreWrapperOutputBean) obj;
		if (verificaNumeriNoteOutput == null) {
			if (other.verificaNumeriNoteOutput != null)
				return false;
		} else if (!verificaNumeriNoteOutput.equals(other.verificaNumeriNoteOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaNoteOperatoreWrapperOutputBean [verificaNumeriNoteOutput=" + verificaNumeriNoteOutput + "]";
	}

}
