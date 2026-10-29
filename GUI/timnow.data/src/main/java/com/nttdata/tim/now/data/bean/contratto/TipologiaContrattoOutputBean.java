package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TipologiaContrattoOutputBean implements Serializable{
	
	
	private static final long serialVersionUID = 1899189550090080604L;

	@JsonProperty("tipologiaContratto")
	private String tipologiaContratto;
	
	@JsonProperty("idTipologiaContratto")
    private String idTipologiaContratto;

	public String getTipologiaContratto() {
		return tipologiaContratto;
	}

	public void setTipologiaContratto(String tipologiaContratto) {
		this.tipologiaContratto = tipologiaContratto;
	}

	public String getIdTipologiaContratto() {
		return idTipologiaContratto;
	}

	public void setIdTipologiaContratto(String idTipologiaContratto) {
		this.idTipologiaContratto = idTipologiaContratto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipologiaContratto == null) ? 0 : idTipologiaContratto.hashCode());
		result = prime * result + ((tipologiaContratto == null) ? 0 : tipologiaContratto.hashCode());
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
		TipologiaContrattoOutputBean other = (TipologiaContrattoOutputBean) obj;
		if (idTipologiaContratto == null) {
			if (other.idTipologiaContratto != null)
				return false;
		} else if (!idTipologiaContratto.equals(other.idTipologiaContratto))
			return false;
		if (tipologiaContratto == null) {
			if (other.tipologiaContratto != null)
				return false;
		} else if (!tipologiaContratto.equals(other.tipologiaContratto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipologiaContrattoOutputBean [tipologiaContratto=" + tipologiaContratto + ", idTipologiaContratto="
				+ idTipologiaContratto + "]";
	}
	
	
	
}
