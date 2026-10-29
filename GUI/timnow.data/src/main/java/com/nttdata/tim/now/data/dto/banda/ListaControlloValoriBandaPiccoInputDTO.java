
package com.nttdata.tim.now.data.dto.banda;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ListaControlloValoriBandaPiccoInputDTO implements Serializable {
   
	private static final long serialVersionUID = 8220046521955615487L;
	
	@JsonProperty("userVlan")
    private List<ControlloValoriBandaPiccoInputDTO> userVlan;

	@JsonProperty("lavorazione")
    private String lavorazione;

	public List<ControlloValoriBandaPiccoInputDTO> getUserVlan() {
		return userVlan;
	}

	public void setUserVlan(List<ControlloValoriBandaPiccoInputDTO> userVlan) {
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
		ListaControlloValoriBandaPiccoInputDTO other = (ListaControlloValoriBandaPiccoInputDTO) obj;
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
		return "ListaControlloValoriBandaPiccoInputDTO [userVlan=" + userVlan + ", lavorazione=" + lavorazione + "]";
	}



 }
