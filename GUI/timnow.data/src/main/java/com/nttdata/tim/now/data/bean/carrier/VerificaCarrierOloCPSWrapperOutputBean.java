package com.nttdata.tim.now.data.bean.carrier;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_915
@JsonInclude(Include.NON_NULL)
public class VerificaCarrierOloCPSWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 4772053036667256385L;
	
	@JsonProperty("verificaCarrierOloCPSOutput")
	private VerificaCarrierOloCPSOutputBean verificaCarrierOloCPSOutput;

	public VerificaCarrierOloCPSOutputBean getVerificaCarrierOloCPSOutput() {
		return verificaCarrierOloCPSOutput;
	}

	public void setVerificaCarrierOloCPSOutput(VerificaCarrierOloCPSOutputBean verificaCarrierOloCPSOutput) {
		this.verificaCarrierOloCPSOutput = verificaCarrierOloCPSOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificaCarrierOloCPSOutput == null) ? 0 : verificaCarrierOloCPSOutput.hashCode());
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
		VerificaCarrierOloCPSWrapperOutputBean other = (VerificaCarrierOloCPSWrapperOutputBean) obj;
		if (verificaCarrierOloCPSOutput == null) {
			if (other.verificaCarrierOloCPSOutput != null)
				return false;
		} else if (!verificaCarrierOloCPSOutput.equals(other.verificaCarrierOloCPSOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaCarrierOloCPSWrapperOutputBean [verificaCarrierOloCPSOutput=" + verificaCarrierOloCPSOutput
				+ "]";
	}

}