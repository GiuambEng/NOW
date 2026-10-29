package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1058
public class VerificaCodiceTdKitWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 6365926033063728271L;
	
	@JsonProperty("ControlliCodiceTDKitOutput")
	private VerificaCodiceTdKitOutputBean controlliCodiceTDKitOutput;

	public VerificaCodiceTdKitOutputBean getControlliCodiceTDKitOutput() {
		return controlliCodiceTDKitOutput;
	}

	public void setControlliCodiceTDKitOutput(VerificaCodiceTdKitOutputBean controlliCodiceTDKitOutput) {
		this.controlliCodiceTDKitOutput = controlliCodiceTDKitOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((controlliCodiceTDKitOutput == null) ? 0 : controlliCodiceTDKitOutput.hashCode());
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
		VerificaCodiceTdKitWrapperOutputBean other = (VerificaCodiceTdKitWrapperOutputBean) obj;
		if (controlliCodiceTDKitOutput == null) {
			if (other.controlliCodiceTDKitOutput != null)
				return false;
		} else if (!controlliCodiceTDKitOutput.equals(other.controlliCodiceTDKitOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaCodiceTdKitWrapperOutputBean [controlliCodiceTDKitOutput=" + controlliCodiceTDKitOutput + "]";
	}

	
		
 }
