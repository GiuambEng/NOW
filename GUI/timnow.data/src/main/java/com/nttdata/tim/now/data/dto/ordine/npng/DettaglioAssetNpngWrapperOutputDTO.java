package com.nttdata.tim.now.data.dto.ordine.npng;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1203
public class DettaglioAssetNpngWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 3599485491377446995L;
	
	@JsonProperty("dettaglioAssetNPNG")
	private DettaglioAssetNpngOutputDTO dettaglioAssetNpng;

	public DettaglioAssetNpngOutputDTO getDettaglioAssetNpng() {
		return dettaglioAssetNpng;
	}

	public void setDettaglioAssetNpng(DettaglioAssetNpngOutputDTO dettaglioAssetNpng) {
		this.dettaglioAssetNpng = dettaglioAssetNpng;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dettaglioAssetNpng == null) ? 0 : dettaglioAssetNpng.hashCode());
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
		DettaglioAssetNpngWrapperOutputDTO other = (DettaglioAssetNpngWrapperOutputDTO) obj;
		if (dettaglioAssetNpng == null) {
			if (other.dettaglioAssetNpng != null)
				return false;
		} else if (!dettaglioAssetNpng.equals(other.dettaglioAssetNpng))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DettaglioAssetNpngWrapperOutputDTO [dettaglioAssetNpng=" + dettaglioAssetNpng + "]";
	}
 }
