package com.nttdata.tim.now.data.bean.ordine.dettaglio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class AttributoDettaglioOrdineBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -4864463247856907337L;

    @JsonProperty("nomeAttributo")
	private String nomeAttributo;

	@JsonProperty("valoreAttributo")
	private String valoreAttributo;

	public String getNomeAttributo() {
		return nomeAttributo;
	}

	public void setNomeAttributo(String nomeAttributo) {
		this.nomeAttributo = nomeAttributo;
	}

	public String getValoreAttributo() {
		return valoreAttributo;
	}

	public void setValoreAttributo(String valoreAttributo) {
		this.valoreAttributo = valoreAttributo;
	}

	@Override
	public String toString() {
		return "AttributoDettaglioOrdineBean [nomeAttributo=" + nomeAttributo + ", valoreAttributo=" + valoreAttributo
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeAttributo == null) ? 0 : nomeAttributo.hashCode());
		result = prime * result + ((valoreAttributo == null) ? 0 : valoreAttributo.hashCode());
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
		AttributoDettaglioOrdineBean other = (AttributoDettaglioOrdineBean) obj;
		if (nomeAttributo == null) {
			if (other.nomeAttributo != null)
				return false;
		} else if (!nomeAttributo.equals(other.nomeAttributo))
			return false;
		if (valoreAttributo == null) {
			if (other.valoreAttributo != null)
				return false;
		} else if (!valoreAttributo.equals(other.valoreAttributo))
			return false;
		return true;
	}

}