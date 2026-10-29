
package com.nttdata.tim.now.data.dto.banda;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE, setterVisibility=JsonAutoDetect.Visibility.NONE, creatorVisibility=JsonAutoDetect.Visibility.NONE)
public class ControlloValoriBandaPiccoInputDTO implements Serializable {
 
	private static final long serialVersionUID = -6835718900133344058L;

	@JsonProperty("bandaPiccoDown")
	private String bandaPiccoDown;
	
	@JsonProperty("bandaPiccoUp")
	private String bandaPiccoUp;
	
	@JsonProperty("tipoCos")
	private String tipoCos;
	
	@JsonProperty("codVlan")
	private String codVlan;

	public String getBandaPiccoDown() {
		return bandaPiccoDown;
	}

	public void setBandaPiccoDown(String bandaPiccoDown) {
		this.bandaPiccoDown = bandaPiccoDown;
	}

	public String getBandaPiccoUp() {
		return bandaPiccoUp;
	}

	public void setBandaPiccoUp(String bandaPiccoUp) {
		this.bandaPiccoUp = bandaPiccoUp;
	}

	public String getTipoCos() {
		return tipoCos;
	}

	public void setTipoCos(String tipoCos) {
		this.tipoCos = tipoCos;
	}

	public String getCodVlan() {
		return codVlan;
	}

	public void setCodVlan(String codVlan) {
		this.codVlan = codVlan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bandaPiccoDown == null) ? 0 : bandaPiccoDown.hashCode());
		result = prime * result + ((bandaPiccoUp == null) ? 0 : bandaPiccoUp.hashCode());
		result = prime * result + ((codVlan == null) ? 0 : codVlan.hashCode());
		result = prime * result + ((tipoCos == null) ? 0 : tipoCos.hashCode());
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
		ControlloValoriBandaPiccoInputDTO other = (ControlloValoriBandaPiccoInputDTO) obj;
		if (bandaPiccoDown == null) {
			if (other.bandaPiccoDown != null)
				return false;
		} else if (!bandaPiccoDown.equals(other.bandaPiccoDown))
			return false;
		if (bandaPiccoUp == null) {
			if (other.bandaPiccoUp != null)
				return false;
		} else if (!bandaPiccoUp.equals(other.bandaPiccoUp))
			return false;
		if (codVlan == null) {
			if (other.codVlan != null)
				return false;
		} else if (!codVlan.equals(other.codVlan))
			return false;
		if (tipoCos == null) {
			if (other.tipoCos != null)
				return false;
		} else if (!tipoCos.equals(other.tipoCos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ControlloValoriBandaPiccoInputDTO [bandaPiccoDown=" + bandaPiccoDown + ", bandaPiccoUp=" + bandaPiccoUp
				+ ", tipoCos=" + tipoCos + ", codVlan=" + codVlan + "]";
	}

	
}
