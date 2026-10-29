package com.nttdata.tim.now.data.dto.anagraficainfratel;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaAnagraficaComuneInfratelOutputDTO extends ESBResultDTO implements Serializable {
	
	private static final long serialVersionUID = -262891565459523042L;
	
	@JsonProperty("listaOLOComuneInfratel")
	private List<AnagraficaComuneInfratelOutputDTO> listaOLOComuneInfratel;

	public List<AnagraficaComuneInfratelOutputDTO> getListaOLOComuneInfratel() {
		return listaOLOComuneInfratel;
	}

	public void setListaOLOComuneInfratel(List<AnagraficaComuneInfratelOutputDTO> listaOLOComuneInfratel) {
		this.listaOLOComuneInfratel = listaOLOComuneInfratel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaOLOComuneInfratel == null) ? 0 : listaOLOComuneInfratel.hashCode());
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
		ListaAnagraficaComuneInfratelOutputDTO other = (ListaAnagraficaComuneInfratelOutputDTO) obj;
		if (listaOLOComuneInfratel == null) {
			if (other.listaOLOComuneInfratel != null)
				return false;
		} else if (!listaOLOComuneInfratel.equals(other.listaOLOComuneInfratel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaAnagraficaComuneInfratelOutputDTO [listaOLOComuneInfratel=" + listaOLOComuneInfratel + "]";
	}
	
	
	
}