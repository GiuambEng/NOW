package com.nttdata.tim.now.data.dto.anagraficanpng;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1203
public class OpzioneTrafficoNpngWrapperOutputDTO extends ESBResultDTO{

	private static final long serialVersionUID = -8687796261572913106L;
	
    @JsonProperty("listaOpzTrafficoNPNG")
	private List<OpzioneTrafficoNpngOutputDTO> listaOpzTrafficoNPNG;

	public List<OpzioneTrafficoNpngOutputDTO> getListaOpzTrafficoNPNG() {
		return listaOpzTrafficoNPNG;
	}

	public void setListaOpzTrafficoNPNG(List<OpzioneTrafficoNpngOutputDTO> listaOpzTrafficoNPNG) {
		this.listaOpzTrafficoNPNG = listaOpzTrafficoNPNG;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaOpzTrafficoNPNG == null) ? 0 : listaOpzTrafficoNPNG.hashCode());
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
		OpzioneTrafficoNpngWrapperOutputDTO other = (OpzioneTrafficoNpngWrapperOutputDTO) obj;
		if (listaOpzTrafficoNPNG == null) {
			if (other.listaOpzTrafficoNPNG != null)
				return false;
		} else if (!listaOpzTrafficoNPNG.equals(other.listaOpzTrafficoNPNG))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OpzioneTrafficoNpngWrapperOutputDTO [listaOpzTrafficoNPNG=" + listaOpzTrafficoNPNG + "]";
	}
}
