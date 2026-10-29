package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//SM_9825
@JsonInclude(Include.NON_NULL)
public class VerificaModelloKitMadrWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 1946269714058916778L;
	
	@JsonProperty("outputModelloKit")
	private VerificaModelloKitMadrOutputBean outputModelloKit;

	public VerificaModelloKitMadrOutputBean getOutputModelloKit() {
		return outputModelloKit;
	}

	public void setOutputModelloKit(VerificaModelloKitMadrOutputBean outputModelloKit) {
		this.outputModelloKit = outputModelloKit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputModelloKit == null) ? 0 : outputModelloKit.hashCode());
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
		VerificaModelloKitMadrWrapperOutputBean other = (VerificaModelloKitMadrWrapperOutputBean) obj;
		if (outputModelloKit == null) {
			if (other.outputModelloKit != null)
				return false;
		} else if (!outputModelloKit.equals(other.outputModelloKit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaModelloKitMadrWrapperOutputBean [outputModelloKit=" + outputModelloKit + "]";
	}
}