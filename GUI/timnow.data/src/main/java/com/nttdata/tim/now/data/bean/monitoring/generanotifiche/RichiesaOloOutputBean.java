package com.nttdata.tim.now.data.bean.monitoring.generanotifiche;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.monitoring.RichiestaOloBean;

@JsonInclude(Include.NON_NULL)
public class RichiesaOloOutputBean extends RichiestaOloBean {

    private static final long serialVersionUID = -7152494411423421507L;
    @JsonProperty("idRichiestaOlo")
	protected String idRichiestaolo;

	public String getIdRichiestaolo() {
		return idRichiestaolo;
	}

	public void setIdRichiestaolo(String idRichiestaolo) {
		this.idRichiestaolo = idRichiestaolo;
	}

	@Override
	public String toString() {
		return "RichiesaOloOutputBean [idRichiestaolo=" + idRichiestaolo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRichiestaolo == null) ? 0 : idRichiestaolo.hashCode());
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
		RichiesaOloOutputBean other = (RichiesaOloOutputBean) obj;
		if (idRichiestaolo == null) {
			if (other.idRichiestaolo != null)
				return false;
		} else if (!idRichiestaolo.equals(other.idRichiestaolo))
			return false;
		return true;
	}

}