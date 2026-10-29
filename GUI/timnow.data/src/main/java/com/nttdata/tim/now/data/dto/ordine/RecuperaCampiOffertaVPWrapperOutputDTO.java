package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1058
public class RecuperaCampiOffertaVPWrapperOutputDTO extends ESBResultDTO implements Serializable {
	
	private static final long serialVersionUID = -6103599467025303758L;
	
	@JsonProperty("outputCampiOffertaVP")
	private List<RecuperaCampiOffertaVPOutputDTO> outputCampiOffertaVP;

	public List<RecuperaCampiOffertaVPOutputDTO> getOutputCampiOffertaVP() {
		return outputCampiOffertaVP;
	}

	public void setOutputCampiOffertaVP(List<RecuperaCampiOffertaVPOutputDTO> outputCampiOffertaVP) {
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
		RecuperaCampiOffertaVPWrapperOutputDTO other = (RecuperaCampiOffertaVPWrapperOutputDTO) obj;
		if (outputCampiOffertaVP == null) {
			if (other.outputCampiOffertaVP != null)
				return false;
		} else if (!outputCampiOffertaVP.equals(other.outputCampiOffertaVP))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaCampiOffertaVPWrapperOutputDTO [outputCampiOffertaVP=" + outputCampiOffertaVP + "]";
	}

	
 }
