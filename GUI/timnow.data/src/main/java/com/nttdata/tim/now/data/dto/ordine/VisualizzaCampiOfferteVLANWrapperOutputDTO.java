package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1058
public class VisualizzaCampiOfferteVLANWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 7363090846431477467L;
	
	@JsonProperty("outputCampiOfferteVLAN")
	private List<VisualizzaCampiOfferteVLANOutputDTO> outputCampiOfferteVLAN;

	public List<VisualizzaCampiOfferteVLANOutputDTO> getOutputCampiOfferteVLAN() {
		return outputCampiOfferteVLAN;
	}

	public void setOutputCampiOfferteVLAN(List<VisualizzaCampiOfferteVLANOutputDTO> outputCampiOfferteVLAN) {
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
		VisualizzaCampiOfferteVLANWrapperOutputDTO other = (VisualizzaCampiOfferteVLANWrapperOutputDTO) obj;
		if (outputCampiOfferteVLAN == null) {
			if (other.outputCampiOfferteVLAN != null)
				return false;
		} else if (!outputCampiOfferteVLAN.equals(other.outputCampiOfferteVLAN))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VisualizzaCampiOfferteVLANWrapperOutputDTO [outputCampiOfferteVLAN=" + outputCampiOfferteVLAN + "]";
	}
	
 }
