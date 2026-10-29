package com.nttdata.tim.now.data.dto.anagraficanpng;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1203
public class CampiAnagraficaNpngWrapperOutputDTO extends ESBResultDTO{

	private static final long serialVersionUID = 1193032374031484587L;
	
	@JsonProperty("campiAnagraficaNPNG")
	private CampiAnagraficaNpngOutputDTO campiAnagraficaNpng;

	public CampiAnagraficaNpngOutputDTO getCampiAnagraficaNpng() {
		return campiAnagraficaNpng;
	}

	public void setCampiAnagraficaNpng(CampiAnagraficaNpngOutputDTO campiAnagraficaNpng) {
		this.campiAnagraficaNpng = campiAnagraficaNpng;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campiAnagraficaNpng == null) ? 0 : campiAnagraficaNpng.hashCode());
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
		CampiAnagraficaNpngWrapperOutputDTO other = (CampiAnagraficaNpngWrapperOutputDTO) obj;
		if (campiAnagraficaNpng == null) {
			if (other.campiAnagraficaNpng != null)
				return false;
		} else if (!campiAnagraficaNpng.equals(other.campiAnagraficaNpng))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CampiAnagraficaNpngOutputDTO [campiAnagraficaNpng=" + campiAnagraficaNpng + "]";
	}
}
