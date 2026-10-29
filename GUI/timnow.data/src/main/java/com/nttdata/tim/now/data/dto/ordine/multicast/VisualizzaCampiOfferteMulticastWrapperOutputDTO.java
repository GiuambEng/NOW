package com.nttdata.tim.now.data.dto.ordine.multicast;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1180
public class VisualizzaCampiOfferteMulticastWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -575639960384005362L;
	
	@JsonProperty("outputCampiOfferteMulticast")
	private List<VisualizzaCampiOfferteMulticastOutputDTO> outputCampiOfferteMulticast;

	public List<VisualizzaCampiOfferteMulticastOutputDTO> getOutputCampiOfferteMulticast() {
		return outputCampiOfferteMulticast;
	}

	public void setOutputCampiOfferteMulticast(List<VisualizzaCampiOfferteMulticastOutputDTO> outputCampiOfferteMulticast) {
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
		VisualizzaCampiOfferteMulticastWrapperOutputDTO other = (VisualizzaCampiOfferteMulticastWrapperOutputDTO) obj;
		if (outputCampiOfferteMulticast == null) {
			if (other.outputCampiOfferteMulticast != null)
				return false;
		} else if (!outputCampiOfferteMulticast.equals(other.outputCampiOfferteMulticast))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VisualizzaCampiOfferteMulticastWrapperOutputDTO [outputCampiOfferteMulticast="
				+ outputCampiOfferteMulticast + "]";
	}
 }
