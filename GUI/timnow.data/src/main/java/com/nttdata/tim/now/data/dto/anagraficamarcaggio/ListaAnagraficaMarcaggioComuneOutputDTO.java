package com.nttdata.tim.now.data.dto.anagraficamarcaggio;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaAnagraficaMarcaggioComuneOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 4988010504400483613L;
	
	@JsonProperty("listaAnagraficaMarcaggioComuni")
	private List<AnagraficaMarcaggioComuneOutputDTO> listaAnagraficaMarcaggioComuni;
	
	@JsonProperty("idExportFile")
	private String idExportFile;

	public String getIdExportFile() {
		return idExportFile;
	}

	public void setIdExportFile(String idExportFile) {
		this.idExportFile = idExportFile;
	}

	public List<AnagraficaMarcaggioComuneOutputDTO> getListaAnagraficaMarcaggioComuni() {
		return listaAnagraficaMarcaggioComuni;
	}

	public void setListaAnagraficaMarcaggioComuni(List<AnagraficaMarcaggioComuneOutputDTO> listaAnagraficaMarcaggioComuni) {
		this.listaAnagraficaMarcaggioComuni = listaAnagraficaMarcaggioComuni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idExportFile == null) ? 0 : idExportFile.hashCode());
		result = prime * result
				+ ((listaAnagraficaMarcaggioComuni == null) ? 0 : listaAnagraficaMarcaggioComuni.hashCode());
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
		ListaAnagraficaMarcaggioComuneOutputDTO other = (ListaAnagraficaMarcaggioComuneOutputDTO) obj;
		if (idExportFile == null) {
			if (other.idExportFile != null)
				return false;
		} else if (!idExportFile.equals(other.idExportFile))
			return false;
		if (listaAnagraficaMarcaggioComuni == null) {
			if (other.listaAnagraficaMarcaggioComuni != null)
				return false;
		} else if (!listaAnagraficaMarcaggioComuni.equals(other.listaAnagraficaMarcaggioComuni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaAnagraficaMarcaggioComuneOutputDTO [listaAnagraficaMarcaggioComuni="
				+ listaAnagraficaMarcaggioComuni + ", idExportFile=" + idExportFile + "]";
	}

	
}