package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1058
public class RecuperaCampiOffertaVPWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -8756726144218935060L;

	@JsonProperty("outputCampiOffertaVP")
	private List<RecuperaCampiOffertaVPOutputBean> outputCampiOffertaVP;

	public List<RecuperaCampiOffertaVPOutputBean> getOutputCampiOffertaVP() {
		return outputCampiOffertaVP;
	}

	public void setOutputCampiOffertaVP(List<RecuperaCampiOffertaVPOutputBean> outputCampiOffertaVP) {
		this.outputCampiOffertaVP = outputCampiOffertaVP;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputCampiOffertaVP == null) ? 0 : outputCampiOffertaVP.hashCode());
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
		RecuperaCampiOffertaVPWrapperOutputBean other = (RecuperaCampiOffertaVPWrapperOutputBean) obj;
		if (outputCampiOffertaVP == null) {
			if (other.outputCampiOffertaVP != null)
				return false;
		} else if (!outputCampiOffertaVP.equals(other.outputCampiOffertaVP))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaCampiOffertaVPWrapperOutputBean [outputCampiOffertaVP=" + outputCampiOffertaVP + "]";
	}
		
 }
