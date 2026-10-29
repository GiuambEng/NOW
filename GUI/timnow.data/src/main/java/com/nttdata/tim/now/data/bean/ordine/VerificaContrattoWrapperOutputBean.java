package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_915
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class VerificaContrattoWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 3005964407077761120L;
	
	@JsonProperty("verificaContrattoOutput")
    private VerificaContrattoOutputBean verificaContrattoOutput;

	public VerificaContrattoOutputBean getVerificaContrattoOutput() {
		return verificaContrattoOutput;
	}

	public void setVerificaContrattoOutput(VerificaContrattoOutputBean verificaContrattoOutput) {
		this.verificaContrattoOutput = verificaContrattoOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificaContrattoOutput == null) ? 0 : verificaContrattoOutput.hashCode());
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
		VerificaContrattoWrapperOutputBean other = (VerificaContrattoWrapperOutputBean) obj;
		if (verificaContrattoOutput == null) {
			if (other.verificaContrattoOutput != null)
				return false;
		} else if (!verificaContrattoOutput.equals(other.verificaContrattoOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaContrattoWrapperOutputBean [verificaContrattoOutput=" + verificaContrattoOutput + "]";
	}

    
}
