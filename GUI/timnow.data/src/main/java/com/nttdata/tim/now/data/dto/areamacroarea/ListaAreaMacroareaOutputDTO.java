package com.nttdata.tim.now.data.dto.areamacroarea;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaAreaMacroareaOutputDTO extends ESBResultDTO implements Serializable {
	
	private static final long serialVersionUID = -7009285638527060995L;
	
	@JsonProperty("listaAreaMacroarea")
	private List<AreaMacroareaOutputDTO> listaAreaMacroarea;

	public List<AreaMacroareaOutputDTO> getListaAreaMacroarea() {
		return listaAreaMacroarea;
	}

	public void setListaAreaMacroarea(List<AreaMacroareaOutputDTO> listaAreaMacroarea) {
		this.listaAreaMacroarea = listaAreaMacroarea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaAreaMacroarea == null) ? 0 : listaAreaMacroarea.hashCode());
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
		ListaAreaMacroareaOutputDTO other = (ListaAreaMacroareaOutputDTO) obj;
		if (listaAreaMacroarea == null) {
			if (other.listaAreaMacroarea != null)
				return false;
		} else if (!listaAreaMacroarea.equals(other.listaAreaMacroarea))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaAreaMacroareaOutputDTO [listaAreaMacroarea=" + listaAreaMacroarea + "]";
	}

}