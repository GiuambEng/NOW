package com.nttdata.tim.now.data.bean.ordine;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1058
public class RecuperaCARWrapperOutputBean extends AbstractOutputBean{

	private static final long serialVersionUID = 2229393261465426786L;
	
	@JsonProperty("outputCAR")
    private List<RecuperaCAROutputBean> outputCAR;

	public List<RecuperaCAROutputBean> getOutputCAR() {
		return outputCAR;
	}

	public void setOutputCAR(List<RecuperaCAROutputBean> outputCAR) {
		this.outputCAR = outputCAR;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputCAR == null) ? 0 : outputCAR.hashCode());
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
		RecuperaCARWrapperOutputBean other = (RecuperaCARWrapperOutputBean) obj;
		if (outputCAR == null) {
			if (other.outputCAR != null)
				return false;
		} else if (!outputCAR.equals(other.outputCAR))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaCARWrapperOutputBean [outputCAR=" + outputCAR + "]";
	}

	
}
