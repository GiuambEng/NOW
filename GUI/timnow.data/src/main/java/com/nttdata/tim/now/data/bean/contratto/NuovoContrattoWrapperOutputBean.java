package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1276
@JsonInclude(Include.NON_NULL) 
public class NuovoContrattoWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 8718757577344885803L;
	
	@JsonProperty("nuovoContrattoOutput")
	private NuovoContrattoOutputBean nuovoContrattoOutput;

	public NuovoContrattoOutputBean getNuovoContrattoOutput() {
		return nuovoContrattoOutput;
	}

	public void setNuovoContrattoOutput(NuovoContrattoOutputBean nuovoContrattoOutput) {
		this.nuovoContrattoOutput = nuovoContrattoOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nuovoContrattoOutput == null) ? 0 : nuovoContrattoOutput.hashCode());
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
		NuovoContrattoWrapperOutputBean other = (NuovoContrattoWrapperOutputBean) obj;
		if (nuovoContrattoOutput == null) {
			if (other.nuovoContrattoOutput != null)
				return false;
		} else if (!nuovoContrattoOutput.equals(other.nuovoContrattoOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NuovoContrattoWrapperOutputBean [nuovoContrattoOutput=" + nuovoContrattoOutput + "]";
	}

}
