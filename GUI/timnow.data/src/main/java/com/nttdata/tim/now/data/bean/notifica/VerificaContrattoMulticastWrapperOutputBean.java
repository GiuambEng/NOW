package com.nttdata.tim.now.data.bean.notifica;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1180
@JsonInclude(Include.NON_NULL)
public class VerificaContrattoMulticastWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -5582265988552457047L;
	
	@JsonProperty("outputVerificaContrattoMulticast")
	private VerificaContrattoMulticastOutputBean outputVerificaContrattoMulticast;

	public VerificaContrattoMulticastOutputBean getOutputVerificaContrattoMulticast() {
		return outputVerificaContrattoMulticast;
	}

	public void setOutputVerificaContrattoMulticast(VerificaContrattoMulticastOutputBean outputVerificaContrattoMulticast) {
		this.outputVerificaContrattoMulticast = outputVerificaContrattoMulticast;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((outputVerificaContrattoMulticast == null) ? 0 : outputVerificaContrattoMulticast.hashCode());
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
		VerificaContrattoMulticastWrapperOutputBean other = (VerificaContrattoMulticastWrapperOutputBean) obj;
		if (outputVerificaContrattoMulticast == null) {
			if (other.outputVerificaContrattoMulticast != null)
				return false;
		} else if (!outputVerificaContrattoMulticast.equals(other.outputVerificaContrattoMulticast))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaContrattoMulticastWrapperOutputBean [outputVerificaContrattoMulticast="
				+ outputVerificaContrattoMulticast + "]";
	}
}