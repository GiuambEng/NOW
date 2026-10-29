package com.nttdata.tim.now.data.bean.offerta;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class OffertaOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -5226173622702291739L;

    @JsonProperty("nomeOfferta")
	private String nomeOfferta;

	@JsonProperty("nomeOffertaCatalogo")
	private String nomeOffertaCatalogo;

	@JsonProperty("idOfferta")
	private String idOfferta;

	@JsonProperty("tipoOrdine")
	private String tipoOrdine;

	public String getNomeOffertaCatalogo() {
		return nomeOffertaCatalogo;
	}

	public void setNomeOffertaCatalogo(String nomeOffertaCatalogo) {
		this.nomeOffertaCatalogo = nomeOffertaCatalogo;
	}

	public String getNomeOfferta() {
		return nomeOfferta;
	}

	public void setNomeOfferta(String nomeOfferta) {
		this.nomeOfferta = nomeOfferta;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getTipoOrdine() {
		return tipoOrdine;
	}

	public void setTipoOrdine(String tipoOrdine) {
		this.tipoOrdine = tipoOrdine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((nomeOfferta == null) ? 0 : nomeOfferta.hashCode());
		result = prime * result + ((nomeOffertaCatalogo == null) ? 0 : nomeOffertaCatalogo.hashCode());
		result = prime * result + ((tipoOrdine == null) ? 0 : tipoOrdine.hashCode());
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
		OffertaOutputBean other = (OffertaOutputBean) obj;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		if (nomeOfferta == null) {
			if (other.nomeOfferta != null)
				return false;
		} else if (!nomeOfferta.equals(other.nomeOfferta))
			return false;
		if (nomeOffertaCatalogo == null) {
			if (other.nomeOffertaCatalogo != null)
				return false;
		} else if (!nomeOffertaCatalogo.equals(other.nomeOffertaCatalogo))
			return false;
		if (tipoOrdine == null) {
			if (other.tipoOrdine != null)
				return false;
		} else if (!tipoOrdine.equals(other.tipoOrdine))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OffertaOutputBean [nomeOfferta=" + nomeOfferta + ", nomeOffertaCatalogo=" + nomeOffertaCatalogo
				+ ", idOfferta=" + idOfferta + ", tipoOrdine=" + tipoOrdine + "]";
	}

}