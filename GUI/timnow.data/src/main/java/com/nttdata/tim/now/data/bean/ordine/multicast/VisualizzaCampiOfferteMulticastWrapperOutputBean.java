package com.nttdata.tim.now.data.bean.ordine.multicast;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1180
public class VisualizzaCampiOfferteMulticastWrapperOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = -638467579029522526L;
	
	@JsonProperty("outputCampiOfferteMulticast")
	private List<VisualizzaCampiOfferteMulticastOutputBean> outputCampiOfferteMulticast;

	public List<VisualizzaCampiOfferteMulticastOutputBean> getOutputCampiOfferteMulticast() {
		return outputCampiOfferteMulticast;
	}

	public void setOutputCampiOfferteMulticast(
			List<VisualizzaCampiOfferteMulticastOutputBean> outputCampiOfferteMulticast) {
		this.outputCampiOfferteMulticast = outputCampiOfferteMulticast;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputCampiOfferteMulticast == null) ? 0 : outputCampiOfferteMulticast.hashCode());
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
		VisualizzaCampiOfferteMulticastWrapperOutputBean other = (VisualizzaCampiOfferteMulticastWrapperOutputBean) obj;
		if (outputCampiOfferteMulticast == null) {
			if (other.outputCampiOfferteMulticast != null)
				return false;
		} else if (!outputCampiOfferteMulticast.equals(other.outputCampiOfferteMulticast))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VisualizzaCampiOfferteMulticastWrapperOutputBean [outputCampiOfferteMulticast="
				+ outputCampiOfferteMulticast + "]";
	}
 }
