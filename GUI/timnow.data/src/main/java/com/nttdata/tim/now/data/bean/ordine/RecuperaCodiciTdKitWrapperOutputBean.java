package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//SM_9825
public class RecuperaCodiciTdKitWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 5372486474963198605L;
	
	@JsonProperty("outputCodiciTdKit")
	private List<RecuperaCodiciTdKitOutputBean> outputCodiciTdKit;

	public List<RecuperaCodiciTdKitOutputBean> getOutputCodiciTdKit() {
		return outputCodiciTdKit;
	}

	public void setOutputCodiciTdKit(List<RecuperaCodiciTdKitOutputBean> outputCodiciTdKit) {
		this.outputCodiciTdKit = outputCodiciTdKit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputCodiciTdKit == null) ? 0 : outputCodiciTdKit.hashCode());
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
		RecuperaCodiciTdKitWrapperOutputBean other = (RecuperaCodiciTdKitWrapperOutputBean) obj;
		if (outputCodiciTdKit == null) {
			if (other.outputCodiciTdKit != null)
				return false;
		} else if (!outputCodiciTdKit.equals(other.outputCodiciTdKit))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "RecuperaCodiciTdKitWrapperOutputBean [outputCodiciTdKit=" + outputCodiciTdKit + "]";
	}
 }
