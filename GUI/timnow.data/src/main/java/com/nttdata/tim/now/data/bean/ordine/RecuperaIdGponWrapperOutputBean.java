package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1150
public class RecuperaIdGponWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 1542258595795439582L;
	
	@JsonProperty("outputIdGpon")
	private List<RecuperaIdGponOutputBean> outputIdGpon;

	public List<RecuperaIdGponOutputBean> getOutputIdGpon() {
		return outputIdGpon;
	}

	public void setOutputIdGpon(List<RecuperaIdGponOutputBean> outputIdGpon) {
		this.outputIdGpon = outputIdGpon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputIdGpon == null) ? 0 : outputIdGpon.hashCode());
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
		RecuperaIdGponWrapperOutputBean other = (RecuperaIdGponWrapperOutputBean) obj;
		if (outputIdGpon == null) {
			if (other.outputIdGpon != null)
				return false;
		} else if (!outputIdGpon.equals(other.outputIdGpon))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaIdGponWrapperOutputBean [outputIdGpon=" + outputIdGpon + "]";
	}

 }
