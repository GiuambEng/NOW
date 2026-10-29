package com.nttdata.tim.now.data.bean.cpe;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_921
@JsonInclude(Include.NON_NULL)
public class CpeOutputBean implements Serializable {

	private static final long serialVersionUID = -3324061375008719266L;

	@JsonProperty("tipologiaCPE")
	private String tipologiaCpe;

	public String getTipologiaCpe() {
		return tipologiaCpe;
	}

	public void setTipologiaCpe(String tipologiaCpe) {
		this.tipologiaCpe = tipologiaCpe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipologiaCpe == null) ? 0 : tipologiaCpe.hashCode());
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
		CpeOutputBean other = (CpeOutputBean) obj;
		if (tipologiaCpe == null) {
			if (other.tipologiaCpe != null)
				return false;
		} else if (!tipologiaCpe.equals(other.tipologiaCpe))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CpeOutputBean [tipologiaCpe=" + tipologiaCpe + "]";
	}
	
	

}