package com.nttdata.tim.now.data.dto.asset;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaCodiciRifiutoOutputDTO extends ESBResultDTO implements Serializable  {

	private static final long serialVersionUID = -5760681022696798762L;

	@JsonProperty("listaCodiciRifiutoOutput")
	private List<CodiciRifiutoOutputDTO>  lista;

	public List<CodiciRifiutoOutputDTO> getLista() {
		return lista;
	}

	public void setLista(List<CodiciRifiutoOutputDTO> lista) {
		this.lista = lista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
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
		ListaCodiciRifiutoOutputDTO other = (ListaCodiciRifiutoOutputDTO) obj;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaCodiciRifiutoOutputDTO [lista=" + lista + "]";
	}
	
	
}
