package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_716
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL) 
public class NuovoContrattoInputBean implements Serializable{

	private static final long serialVersionUID = -8894370964818743012L;
	
	@JsonProperty("nuovoContratto")
	private List<NuovoContrattoListItemBean> nuovoContratto;

	public List<NuovoContrattoListItemBean> getNuovoContratto() {
		return nuovoContratto;
	}

	public void setNuovoContratto(List<NuovoContrattoListItemBean> nuovoContratto) {
		this.nuovoContratto = nuovoContratto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nuovoContratto == null) ? 0 : nuovoContratto.hashCode());
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
		NuovoContrattoInputBean other = (NuovoContrattoInputBean) obj;
		if (nuovoContratto == null) {
			if (other.nuovoContratto != null)
				return false;
		} else if (!nuovoContratto.equals(other.nuovoContratto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NuovoContrattoListItemBean [nuovoContratto=" + nuovoContratto + "]";
	}

}
