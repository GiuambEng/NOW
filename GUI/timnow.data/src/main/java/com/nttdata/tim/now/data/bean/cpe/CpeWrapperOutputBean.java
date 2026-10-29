package com.nttdata.tim.now.data.bean.cpe;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_921
@JsonInclude(Include.NON_NULL)
public class CpeWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -4308210992988236483L;
	
	@JsonProperty("outputTipologiaCPE")
	private List<CpeOutputBean> outputTipologiaCPE;

	public List<CpeOutputBean> getOutputTipologiaCPE() {
		return outputTipologiaCPE;
	}

	public void setOutputTipologiaCPE(List<CpeOutputBean> outputTipologiaCPE) {
		this.outputTipologiaCPE = outputTipologiaCPE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputTipologiaCPE == null) ? 0 : outputTipologiaCPE.hashCode());
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
		CpeWrapperOutputBean other = (CpeWrapperOutputBean) obj;
		if (outputTipologiaCPE == null) {
			if (other.outputTipologiaCPE != null)
				return false;
		} else if (!outputTipologiaCPE.equals(other.outputTipologiaCPE))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CpeWrapperOutputBean [outputTipologiaCPE=" + outputTipologiaCPE + "]";
	}

}