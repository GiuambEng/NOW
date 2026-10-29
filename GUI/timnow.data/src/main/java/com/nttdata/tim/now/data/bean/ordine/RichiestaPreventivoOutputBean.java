package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class RichiestaPreventivoOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -5425694729700068451L;

    @JsonProperty("esito")
    private RichiestaPreventivoEsitoOutputBean esito;

	public RichiestaPreventivoEsitoOutputBean getEsito() {
		return esito;
	}

	public void setEsito(RichiestaPreventivoEsitoOutputBean esito) {
		this.esito = esito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
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
		RichiestaPreventivoOutputBean other = (RichiestaPreventivoOutputBean) obj;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RichiestaPreventivoOutputBean [esito=" + esito + "]";
	}
	
}
