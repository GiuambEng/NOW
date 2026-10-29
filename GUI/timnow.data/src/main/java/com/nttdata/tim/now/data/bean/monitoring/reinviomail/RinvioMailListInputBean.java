package com.nttdata.tim.now.data.bean.monitoring.reinviomail;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class RinvioMailListInputBean implements Serializable {

	private static final long serialVersionUID = 5953961298569040659L;
	
	@JsonProperty("listaEmail")
	private List<RinvioMailInputBean> listaEmail;

	/**
	 * 
	 * @return The listaEmail
	 */
	@JsonProperty("listaEmail")
	public List<RinvioMailInputBean> getListaEmail() {
		return listaEmail;
	}

	/**
	 * 
	 * @param listaEmail
	 *            The listaEmail
	 */
	@JsonProperty("listaEmail")
	public void setListaEmail(List<RinvioMailInputBean> listaEmail) {
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
		RinvioMailListInputBean other = (RinvioMailListInputBean) obj;
		if (listaEmail == null) {
			if (other.listaEmail != null)
				return false;
		} else if (!listaEmail.equals(other.listaEmail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RinvioMailListInputBean [listaEmail=" + listaEmail + "]";
	}

}
