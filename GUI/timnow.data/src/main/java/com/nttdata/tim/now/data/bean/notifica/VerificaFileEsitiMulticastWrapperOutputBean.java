package com.nttdata.tim.now.data.bean.notifica;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//CR1-CR4
@JsonInclude(Include.NON_NULL)
public class VerificaFileEsitiMulticastWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 3740123273164385672L;
	
	@JsonProperty("outputVerificaFileEsitiMulticast")
	private VerificaFileEsitiMulticastOutputBean outputVerificaFileEsitiMulticast;

	public VerificaFileEsitiMulticastOutputBean getOutputVerificaFileEsitiMulticast() {
		return outputVerificaFileEsitiMulticast;
	}

	public void setOutputVerificaFileEsitiMulticast(VerificaFileEsitiMulticastOutputBean outputVerificaFileEsitiMulticast) {
		this.outputVerificaFileEsitiMulticast = outputVerificaFileEsitiMulticast;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((outputVerificaFileEsitiMulticast == null) ? 0 : outputVerificaFileEsitiMulticast.hashCode());
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
		VerificaFileEsitiMulticastWrapperOutputBean other = (VerificaFileEsitiMulticastWrapperOutputBean) obj;
		if (outputVerificaFileEsitiMulticast == null) {
			if (other.outputVerificaFileEsitiMulticast != null)
				return false;
		} else if (!outputVerificaFileEsitiMulticast.equals(other.outputVerificaFileEsitiMulticast))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaFileEsitiMulticastWrapperOutputBean [outputVerificaFileEsitiMulticast="
				+ outputVerificaFileEsitiMulticast + "]";
	}
}