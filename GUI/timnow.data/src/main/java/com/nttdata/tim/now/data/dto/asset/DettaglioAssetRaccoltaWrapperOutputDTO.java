package com.nttdata.tim.now.data.dto.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1188
public class DettaglioAssetRaccoltaWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 427918518711519221L;
	
	@JsonProperty("DettaglioAssetRaccoltaOutput")
	private DettaglioAssetRaccoltaOutputDTO dettaglioAssetRaccoltaOutput;

	public DettaglioAssetRaccoltaOutputDTO getDettaglioAssetRaccoltaOutput() {
		return dettaglioAssetRaccoltaOutput;
	}

	public void setDettaglioAssetRaccoltaOutput(DettaglioAssetRaccoltaOutputDTO dettaglioAssetRaccoltaOutput) {
		this.dettaglioAssetRaccoltaOutput = dettaglioAssetRaccoltaOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dettaglioAssetRaccoltaOutput == null) ? 0 : dettaglioAssetRaccoltaOutput.hashCode());
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
		DettaglioAssetRaccoltaWrapperOutputDTO other = (DettaglioAssetRaccoltaWrapperOutputDTO) obj;
		if (dettaglioAssetRaccoltaOutput == null) {
			if (other.dettaglioAssetRaccoltaOutput != null)
				return false;
		} else if (!dettaglioAssetRaccoltaOutput.equals(other.dettaglioAssetRaccoltaOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DettaglioAssetRaccoltaWrapperOutputBean [dettaglioAssetRaccoltaOutput=" + dettaglioAssetRaccoltaOutput
				+ "]";
	}

}
