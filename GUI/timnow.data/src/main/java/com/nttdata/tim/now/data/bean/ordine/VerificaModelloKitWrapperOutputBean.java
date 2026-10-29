package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//SM_9723
public class VerificaModelloKitWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 6167169896567857624L;
	
	@JsonProperty("outputModelloKit")
	private VerificaCodiceTdKitOutputBean outputModelloKit;

	public VerificaCodiceTdKitOutputBean getOutputModelloKit() {
		return outputModelloKit;
	}

	public void setOutputModelloKit(VerificaCodiceTdKitOutputBean outputModelloKit) {
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
		VerificaModelloKitWrapperOutputBean other = (VerificaModelloKitWrapperOutputBean) obj;
		if (outputModelloKit == null) {
			if (other.outputModelloKit != null)
				return false;
		} else if (!outputModelloKit.equals(other.outputModelloKit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaModelloKitWrapperOutputBean [outputModelloKit=" + outputModelloKit + "]";
	}

	
		
 }
