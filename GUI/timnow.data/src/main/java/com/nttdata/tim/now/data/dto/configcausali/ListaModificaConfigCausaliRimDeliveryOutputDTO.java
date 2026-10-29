package com.nttdata.tim.now.data.dto.configcausali;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaModificaConfigCausaliRimDeliveryOutputDTO extends ESBResultDTO implements Serializable {

    private static final long serialVersionUID = -5278593800999584518L;

    @JsonProperty("outputModificaConfigCausaliRimDelivery")
	private List<ModificaConfigCausaliRimDeliveryOutputDTO> listaConfig;

	public List<ModificaConfigCausaliRimDeliveryOutputDTO> getListaConfig() {
		return listaConfig;
	}

	public void setListaConfig(List<ModificaConfigCausaliRimDeliveryOutputDTO> listaConfig) {
		this.listaConfig = listaConfig;
	}

	@Override
	public String toString() {
		return "ListaModificaConfigCausaliRimDeliveryOutputDTO [listaConfig=" + listaConfig + "]";
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
		ListaModificaConfigCausaliRimDeliveryOutputDTO other = (ListaModificaConfigCausaliRimDeliveryOutputDTO) obj;
		if (listaConfig == null) {
			if (other.listaConfig != null)
				return false;
		} else if (!listaConfig.equals(other.listaConfig))
			return false;
		return true;
	}

}