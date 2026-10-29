
package com.nttdata.tim.now.data.bean.banda;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ListaControlloValoriBandaPiccoInputBean implements Serializable {
	
	private static final long serialVersionUID = 8364515689399240793L;
	
	@JsonProperty("userVlan")
    private List<ControlloValoriBandaPiccoInputBean> userVlan;

	@JsonProperty("lavorazione")
    private String lavorazione;

	public List<ControlloValoriBandaPiccoInputBean> getUserVlan() {
		return userVlan;
	}

	public void setUserVlan(List<ControlloValoriBandaPiccoInputBean> userVlan) {
		this.userVlan = userVlan;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lavorazione == null) ? 0 : lavorazione.hashCode());
		result = prime * result + ((userVlan == null) ? 0 : userVlan.hashCode());
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
		ListaControlloValoriBandaPiccoInputBean other = (ListaControlloValoriBandaPiccoInputBean) obj;
		if (lavorazione == null) {
			if (other.lavorazione != null)
				return false;
		} else if (!lavorazione.equals(other.lavorazione))
			return false;
		if (userVlan == null) {
			if (other.userVlan != null)
				return false;
		} else if (!userVlan.equals(other.userVlan))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaControlloValoriBandaPiccoInputBean [userVlan=" + userVlan + ", lavorazione=" + lavorazione + "]";
	}



 }
