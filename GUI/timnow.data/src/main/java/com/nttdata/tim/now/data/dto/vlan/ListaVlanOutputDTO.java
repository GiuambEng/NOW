package com.nttdata.tim.now.data.dto.vlan;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class ListaVlanOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 8909711549747822250L;
	
	@JsonProperty("listaVLAN")
	private List<VlanOutputDTO> listaVlan;

	public List<VlanOutputDTO> getListaVlan() {
		return listaVlan;
	}

	public void setListaVlan(List<VlanOutputDTO> listaVlan) {
		this.listaVlan = listaVlan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaVlan == null) ? 0 : listaVlan.hashCode());
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
		ListaVlanOutputDTO other = (ListaVlanOutputDTO) obj;
		if (listaVlan == null) {
			if (other.listaVlan != null)
				return false;
		} else if (!listaVlan.equals(other.listaVlan))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaVlanOutputDTO [listaVlan=" + listaVlan + "]";
	}
	
	
}