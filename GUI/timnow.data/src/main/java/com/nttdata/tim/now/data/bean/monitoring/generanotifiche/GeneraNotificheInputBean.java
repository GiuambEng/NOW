package com.nttdata.tim.now.data.bean.monitoring.generanotifiche;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.data.bean.olo.CodiceOloBean;

@JsonInclude(Include.NON_NULL)
public class GeneraNotificheInputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -6509413464138081372L;

    @JsonProperty("codOlo")
	private CodiceOloBean codOlo;

	@JsonProperty("listaRichieste")
	private List<RichiestaGeneraNotificheInputBean> listaRichieste;

	public CodiceOloBean getCodOlo() {
		return codOlo;
	}

	public void setCodOlo(CodiceOloBean codOlo) {
		this.codOlo = codOlo;
	}

	public List<RichiestaGeneraNotificheInputBean> getListaRichieste() {
		return listaRichieste;
	}

	public void setListaRichieste(List<RichiestaGeneraNotificheInputBean> listaRichieste) {
		this.listaRichieste = listaRichieste;
	}

	@Override
	public String toString() {
		return "GeneraNotificheInputBean [codOlo=" + codOlo + ", listaRichieste=" + listaRichieste + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOlo == null) ? 0 : codOlo.hashCode());
		result = prime * result + ((listaRichieste == null) ? 0 : listaRichieste.hashCode());
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
		GeneraNotificheInputBean other = (GeneraNotificheInputBean) obj;
		if (codOlo == null) {
			if (other.codOlo != null)
				return false;
		} else if (!codOlo.equals(other.codOlo))
			return false;
		if (listaRichieste == null) {
			if (other.listaRichieste != null)
				return false;
		} else if (!listaRichieste.equals(other.listaRichieste))
			return false;
		return true;
	}

}