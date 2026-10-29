package com.nttdata.tim.now.data.dto.nodi;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class ListaNodiOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 4458997557209005111L;
	
	@JsonProperty("listaNodi")
	private List<NodoOutputDTO> listaNodi;

	public List<NodoOutputDTO> getListaNodi() {
		return listaNodi;
	}

	public void setListaNodi(List<NodoOutputDTO> listaNodi) {
		this.listaNodi = listaNodi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaNodi == null) ? 0 : listaNodi.hashCode());
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
		ListaNodiOutputDTO other = (ListaNodiOutputDTO) obj;
		if (listaNodi == null) {
			if (other.listaNodi != null)
				return false;
		} else if (!listaNodi.equals(other.listaNodi))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaNodiOutputDTO [listaNodi=" + listaNodi + "]";
	}
	
	
}