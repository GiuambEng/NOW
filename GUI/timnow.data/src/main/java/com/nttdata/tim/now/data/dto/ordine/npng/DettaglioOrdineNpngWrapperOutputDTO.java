package com.nttdata.tim.now.data.dto.ordine.npng;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1203
public class DettaglioOrdineNpngWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 1157789115537030354L;
	
	@JsonProperty("dettaglioOrdineNPNG")
	private DettaglioOrdineNpngOutputDTO dettaglioOrdineNpng;

	public DettaglioOrdineNpngOutputDTO getDettaglioOrdineNpng() {
		return dettaglioOrdineNpng;
	}

	public void setDettaglioOrdineNpng(DettaglioOrdineNpngOutputDTO dettaglioOrdineNpng) {
		this.dettaglioOrdineNpng = dettaglioOrdineNpng;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dettaglioOrdineNpng == null) ? 0 : dettaglioOrdineNpng.hashCode());
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
		DettaglioOrdineNpngWrapperOutputDTO other = (DettaglioOrdineNpngWrapperOutputDTO) obj;
		if (dettaglioOrdineNpng == null) {
			if (other.dettaglioOrdineNpng != null)
				return false;
		} else if (!dettaglioOrdineNpng.equals(other.dettaglioOrdineNpng))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DettaglioOrdineNpngWrapperOutputDTO [dettaglioOrdineNpng=" + dettaglioOrdineNpng + "]";
	}
 }
