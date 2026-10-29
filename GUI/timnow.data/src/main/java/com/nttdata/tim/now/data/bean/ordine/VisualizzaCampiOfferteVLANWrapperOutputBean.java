package com.nttdata.tim.now.data.bean.ordine;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1058
public class VisualizzaCampiOfferteVLANWrapperOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = 577067784749712729L;
	
	@JsonProperty("outputCampiOfferteVLAN")
	private List<VisualizzaCampiOfferteVLANOutputBean> outputCampiOfferteVLAN;

	public List<VisualizzaCampiOfferteVLANOutputBean> getOutputCampiOfferteVLAN() {
		return outputCampiOfferteVLAN;
	}

	public void setOutputCampiOfferteVLAN(List<VisualizzaCampiOfferteVLANOutputBean> outputCampiOfferteVLAN) {
		this.outputCampiOfferteVLAN = outputCampiOfferteVLAN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputCampiOfferteVLAN == null) ? 0 : outputCampiOfferteVLAN.hashCode());
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
		VisualizzaCampiOfferteVLANWrapperOutputBean other = (VisualizzaCampiOfferteVLANWrapperOutputBean) obj;
		if (outputCampiOfferteVLAN == null) {
			if (other.outputCampiOfferteVLAN != null)
				return false;
		} else if (!outputCampiOfferteVLAN.equals(other.outputCampiOfferteVLAN))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VisualizzaCampiOfferteVLANWrapperOutputBean [outputCampiOfferteVLAN=" + outputCampiOfferteVLAN + "]";
	}

			
 }
