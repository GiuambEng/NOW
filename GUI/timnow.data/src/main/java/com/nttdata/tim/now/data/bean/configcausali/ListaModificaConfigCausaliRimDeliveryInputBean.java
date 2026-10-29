package com.nttdata.tim.now.data.bean.configcausali;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ListaModificaConfigCausaliRimDeliveryInputBean implements Serializable {
	private static final long serialVersionUID = -2490187531124718979L;

	@JsonProperty("inputModificaConfigCausaliRimDelivery")
	private List<ModificaConfigCausaliRimDeliveryInputBean> listaConfig;

	public List<ModificaConfigCausaliRimDeliveryInputBean> getListaConfig() {
		return listaConfig;
	}

	public void setListaConfig(List<ModificaConfigCausaliRimDeliveryInputBean> listaConfig) {
		this.listaConfig = listaConfig;
	}

	@Override
	public String toString() {
		return "ListaConfigCausaliRimDeliveryInputBean [listaConfig=" + listaConfig + "]";
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
		ListaModificaConfigCausaliRimDeliveryInputBean other = (ListaModificaConfigCausaliRimDeliveryInputBean) obj;
		if (listaConfig == null) {
			if (other.listaConfig != null)
				return false;
		} else if (!listaConfig.equals(other.listaConfig))
			return false;
		return true;
	}
	
}