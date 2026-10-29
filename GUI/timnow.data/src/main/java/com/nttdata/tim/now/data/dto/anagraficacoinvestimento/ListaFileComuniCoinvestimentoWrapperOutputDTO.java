package com.nttdata.tim.now.data.dto.anagraficacoinvestimento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1276
@JsonInclude(Include.NON_NULL)
public class ListaFileComuniCoinvestimentoWrapperOutputDTO extends ESBResultDTO implements Serializable  {

	private static final long serialVersionUID = -2971974442810532293L;
	
	@JsonProperty("listaFileComuniCoinvestiti")
	private List<FileComuniCoinvestimentoOutputDTO> listaFileComuniCoinvestiti;

	public List<FileComuniCoinvestimentoOutputDTO> getListaFileComuniCoinvestiti() {
		return listaFileComuniCoinvestiti;
	}

	public void setListaFileComuniCoinvestiti(List<FileComuniCoinvestimentoOutputDTO> listaFileComuniCoinvestiti) {
		this.listaFileComuniCoinvestiti = listaFileComuniCoinvestiti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaFileComuniCoinvestiti == null) ? 0 : listaFileComuniCoinvestiti.hashCode());
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
		ListaFileComuniCoinvestimentoWrapperOutputDTO other = (ListaFileComuniCoinvestimentoWrapperOutputDTO) obj;
		if (listaFileComuniCoinvestiti == null) {
			if (other.listaFileComuniCoinvestiti != null)
				return false;
		} else if (!listaFileComuniCoinvestiti.equals(other.listaFileComuniCoinvestiti))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaFileComuniCoinvestimentoWrapperOutputDTO [listaFileComuniCoinvestiti=" + listaFileComuniCoinvestiti
				+ "]";
	}

}