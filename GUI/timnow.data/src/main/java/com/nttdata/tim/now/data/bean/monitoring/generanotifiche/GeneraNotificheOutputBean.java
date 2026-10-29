package com.nttdata.tim.now.data.bean.monitoring.generanotifiche;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.data.bean.codice.CodiceOutputBean;

@JsonInclude(Include.NON_NULL)
public class GeneraNotificheOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -7729518249525197125L;

    @JsonProperty("idRichiesta")
	private String idRichiesta;

	@JsonProperty("idNotifica")
	private String idNotifica;

	@JsonProperty("esito")
	private CodiceOutputBean esito;

	public String getIdRichiesta() {
		return idRichiesta;
	}

	public void setIdRichiesta(String idRichiesta) {
		this.idRichiesta = idRichiesta;
	}

	public String getIdNotifica() {
		return idNotifica;
	}

	public void setIdNotifica(String idNotifica) {
		this.idNotifica = idNotifica;
	}

	public CodiceOutputBean getEsito() {
		return esito;
	}

	public void setEsito(CodiceOutputBean esito) {
		this.esito = esito;
	}

	@Override
	public String toString() {
		return "GeneraNotificheOutputBean [idRichiesta=" + idRichiesta + ", idNotifica=" + idNotifica + ", esito="
				+ esito + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
		result = prime * result + ((idNotifica == null) ? 0 : idNotifica.hashCode());
		result = prime * result + ((idRichiesta == null) ? 0 : idRichiesta.hashCode());
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
		GeneraNotificheOutputBean other = (GeneraNotificheOutputBean) obj;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
			return false;
		if (idNotifica == null) {
			if (other.idNotifica != null)
				return false;
		} else if (!idNotifica.equals(other.idNotifica))
			return false;
		if (idRichiesta == null) {
			if (other.idRichiesta != null)
				return false;
		} else if (!idRichiesta.equals(other.idRichiesta))
			return false;
		return true;
	}

}