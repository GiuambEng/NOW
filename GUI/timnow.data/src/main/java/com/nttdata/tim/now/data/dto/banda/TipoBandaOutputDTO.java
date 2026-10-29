
package com.nttdata.tim.now.data.dto.banda;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class TipoBandaOutputDTO implements Serializable {
 
	private static final long serialVersionUID = -8009859756778599157L;

	@JsonProperty("tipoCos")
	private String tipoCos;

	@JsonProperty("tipoBanda")
	private String tipoBanda;

	public String getTipoCos() {
		return tipoCos;
	}

	public void setTipoCos(String tipoCos) {
		this.tipoCos = tipoCos;
	}

	public String getTipoBanda() {
		return tipoBanda;
	}

	public void setTipoBanda(String tipoBanda) {
		this.tipoBanda = tipoBanda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipoBanda == null) ? 0 : tipoBanda.hashCode());
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
		TipoBandaOutputDTO other = (TipoBandaOutputDTO) obj;
		if (tipoBanda == null) {
			if (other.tipoBanda != null)
				return false;
		} else if (!tipoBanda.equals(other.tipoBanda))
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
		return "TipoBandaOutputDTO [tipoCos=" + tipoCos + ", tipoBanda=" + tipoBanda + "]";
	}


}
