package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class RecuperoAssetOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 305750873924329474L;

	@JsonProperty("idAsset")
	private String idAsset;

	@JsonProperty("idRisorsa")
	private String idRisorsa;

	@JsonProperty("numeroTelefonico")
	private String numeroTelefonico;

	@JsonProperty("numeroFittizio")
	private String numeroFittizio;

	@JsonProperty("offerta")
	private String offerta;

	public String getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getNumeroFittizio() {
		return numeroFittizio;
	}

	public void setNumeroFittizio(String numeroFittizio) {
		this.numeroFittizio = numeroFittizio;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAsset == null) ? 0 : idAsset.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((numeroFittizio == null) ? 0 : numeroFittizio.hashCode());
		result = prime * result + ((numeroTelefonico == null) ? 0 : numeroTelefonico.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
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
		RecuperoAssetOutputBean other = (RecuperoAssetOutputBean) obj;
		if (idAsset == null) {
			if (other.idAsset != null)
				return false;
		} else if (!idAsset.equals(other.idAsset))
			return false;
		if (idRisorsa == null) {
			if (other.idRisorsa != null)
				return false;
		} else if (!idRisorsa.equals(other.idRisorsa))
			return false;
		if (numeroFittizio == null) {
			if (other.numeroFittizio != null)
				return false;
		} else if (!numeroFittizio.equals(other.numeroFittizio))
			return false;
		if (numeroTelefonico == null) {
			if (other.numeroTelefonico != null)
				return false;
		} else if (!numeroTelefonico.equals(other.numeroTelefonico))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperoAssetOutputBean [idAsset=" + idAsset + ", idRisorsa=" + idRisorsa + ", numeroTelefonico="
				+ numeroTelefonico + ", numeroFittizio=" + numeroFittizio + ", offerta=" + offerta + "]";
	}


}