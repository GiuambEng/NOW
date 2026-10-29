package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_833 FIX FWA CESSAZIONE
public class VerificaCodiceOrdineOloWrapperOutputBean extends AbstractOutputBean implements Serializable {
	
	private static final long serialVersionUID = 3096880794571902100L;

	@JsonProperty("VerificaCodiceOrdineOloOutput")
	VerificaCodiceOrdineOloOutputBean verificaCodiceOrdineOloOutput;

	public VerificaCodiceOrdineOloOutputBean getVerificaCodiceOrdineOloOutput() {
		return verificaCodiceOrdineOloOutput;
	}

	public void setVerificaCodiceOrdineOloOutput(VerificaCodiceOrdineOloOutputBean verificaCodiceOrdineOloOutput) {
		this.verificaCodiceOrdineOloOutput = verificaCodiceOrdineOloOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((verificaCodiceOrdineOloOutput == null) ? 0 : verificaCodiceOrdineOloOutput.hashCode());
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
		VerificaCodiceOrdineOloWrapperOutputBean other = (VerificaCodiceOrdineOloWrapperOutputBean) obj;
		if (verificaCodiceOrdineOloOutput == null) {
			if (other.verificaCodiceOrdineOloOutput != null)
				return false;
		} else if (!verificaCodiceOrdineOloOutput.equals(other.verificaCodiceOrdineOloOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaCodiceOrdineOloWrapperOutputBean [verificaCodiceOrdineOloOutput="
				+ verificaCodiceOrdineOloOutput + "]";
	}
    
	
}
