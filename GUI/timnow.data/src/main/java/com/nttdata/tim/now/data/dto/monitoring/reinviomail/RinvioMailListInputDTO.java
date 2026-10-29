package com.nttdata.tim.now.data.dto.monitoring.reinviomail;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class RinvioMailListInputDTO implements Serializable {

	private static final long serialVersionUID = 4343185606613831026L;
	 
	@JsonProperty("listaEmail")
	private List<RinvioMailInputDTO> listaEmail;

	/**
	 * 
	 * @return The listaEmail
	 */
	@JsonProperty("listaEmail")
	public List<RinvioMailInputDTO> getListaEmail() {
		return listaEmail;
	}

	/**
	 * 
	 * @param listaEmail
	 *            The listaEmail
	 */
	@JsonProperty("listaEmail")
	public void setListaEmail(List<RinvioMailInputDTO> listaEmail) {
		this.listaEmail = listaEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaEmail == null) ? 0 : listaEmail.hashCode());
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
		RinvioMailListInputDTO other = (RinvioMailListInputDTO) obj;
		if (listaEmail == null) {
			if (other.listaEmail != null)
				return false;
		} else if (!listaEmail.equals(other.listaEmail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RinvioMailListInputDTO [listaEmail=" + listaEmail + "]";
	}

}
