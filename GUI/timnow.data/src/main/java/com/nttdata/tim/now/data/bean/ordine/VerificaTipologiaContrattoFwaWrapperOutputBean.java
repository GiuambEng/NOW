package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1129
@JsonInclude(Include.NON_NULL)
public class VerificaTipologiaContrattoFwaWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -3589300793366586849L;
	
	@JsonProperty("outputTipologieFWA")
    private VerificaTipologiaContrattoFwaOutputBean outputTipologieFwa;

	public VerificaTipologiaContrattoFwaOutputBean getOutputTipologieFwa() {
		return outputTipologieFwa;
	}

	public void setOutputTipologieFwa(VerificaTipologiaContrattoFwaOutputBean outputTipologieFwa) {
		this.outputTipologieFwa = outputTipologieFwa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputTipologieFwa == null) ? 0 : outputTipologieFwa.hashCode());
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
		VerificaTipologiaContrattoFwaWrapperOutputBean other = (VerificaTipologiaContrattoFwaWrapperOutputBean) obj;
		if (outputTipologieFwa == null) {
			if (other.outputTipologieFwa != null)
				return false;
		} else if (!outputTipologieFwa.equals(other.outputTipologieFwa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaTipologiaContrattoFwaWrapperOutputBean [outputTipologieFwa=" + outputTipologieFwa + "]";
	}


}
