package com.nttdata.tim.now.data.dto.configcausali;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ListaModificaConfigCausaliRimDeliveryInputDTO implements Serializable {

    private static final long serialVersionUID = 6905401815725487936L;

    @JsonProperty("inputModificaConfigCausaliRimDelivery")
	private List<ModificaConfigCausaliRimDeliveryInputDTO> listaConfig;

	public List<ModificaConfigCausaliRimDeliveryInputDTO> getListaConfig() {
		return listaConfig;
	}

	public void setListaConfig(List<ModificaConfigCausaliRimDeliveryInputDTO> listaConfig) {
		this.listaConfig = listaConfig;
	}

	@Override
	public String toString() {
		return "ListaConfigCausaliRimDeliveryInputDTO [listaConfig=" + listaConfig + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaConfig == null) ? 0 : listaConfig.hashCode());
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
		ListaModificaConfigCausaliRimDeliveryInputDTO other = (ListaModificaConfigCausaliRimDeliveryInputDTO) obj;
		if (listaConfig == null) {
			if (other.listaConfig != null)
				return false;
		} else if (!listaConfig.equals(other.listaConfig))
			return false;
		return true;
	}
	
}