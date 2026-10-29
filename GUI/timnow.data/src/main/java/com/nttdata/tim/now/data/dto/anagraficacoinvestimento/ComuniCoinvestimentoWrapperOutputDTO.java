package com.nttdata.tim.now.data.dto.anagraficacoinvestimento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1276
@JsonInclude(Include.NON_NULL)
public class ComuniCoinvestimentoWrapperOutputDTO extends ESBResultDTO implements Serializable  {

	private static final long serialVersionUID = 5580172956493909264L;
	
	@JsonProperty("listaComuniCoinvestiti")
	private List<ComuniCoinvestimentoOutputDTO> listaComuniCoinvestiti;
	
	@JsonProperty("idExportFile")
	private String idExportFile;

	public List<ComuniCoinvestimentoOutputDTO> getListaComuniCoinvestiti() {
		return listaComuniCoinvestiti;
	}

	public void setListaComuniCoinvestiti(List<ComuniCoinvestimentoOutputDTO> listaComuniCoinvestiti) {
		this.listaComuniCoinvestiti = listaComuniCoinvestiti;
	}

	public String getIdExportFile() {
		return idExportFile;
	}

	public void setIdExportFile(String idExportFile) {
		this.idExportFile = idExportFile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaComuniCoinvestiti == null) ? 0 : listaComuniCoinvestiti.hashCode());
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
		ComuniCoinvestimentoWrapperOutputDTO other = (ComuniCoinvestimentoWrapperOutputDTO) obj;
		if (listaComuniCoinvestiti == null) {
			if (other.listaComuniCoinvestiti != null)
				return false;
		} else if (!listaComuniCoinvestiti.equals(other.listaComuniCoinvestiti))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ComuniCoinvestimentoWrapperOutputDTO [listaComuniCoinvestiti=" + listaComuniCoinvestiti + "]";
	}
}