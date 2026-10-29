package com.nttdata.tim.now.data.dto.kitvlan;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class ListaKitVlanOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -6263403624531038369L;
	
	@JsonProperty("listaKitVlan")
	private List<KitVlanOutputDTO> listaKitVlan;

	public List<KitVlanOutputDTO> getListaKitVlan() {
		return listaKitVlan;
	}

	public void setListaKitVlan(List<KitVlanOutputDTO> listaKitVlan) {
		this.listaKitVlan = listaKitVlan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaKitVlan == null) ? 0 : listaKitVlan.hashCode());
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
		ListaKitVlanOutputDTO other = (ListaKitVlanOutputDTO) obj;
		if (listaKitVlan == null) {
			if (other.listaKitVlan != null)
				return false;
		} else if (!listaKitVlan.equals(other.listaKitVlan))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaKitVlanOutputDTO [listaKitVlan=" + listaKitVlan + "]";
	}

}