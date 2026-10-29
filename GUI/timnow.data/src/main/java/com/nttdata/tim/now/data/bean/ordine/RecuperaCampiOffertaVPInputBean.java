package com.nttdata.tim.now.data.bean.ordine;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class RecuperaCampiOffertaVPInputBean {

	@JsonProperty("nomeCampo")
	private String nomeCampo;
	
	@JsonProperty("valoreCampo")
    private String valoreCampo;
	
	//#Task33535
	@JsonProperty("mcr")
    private String mcr;
	
	public String getNomeCampo() {
		return nomeCampo;
	}

	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}

	public String getValoreCampo() {
		return valoreCampo;
	}

	public void setValoreCampo(String valoreCampo) {
		this.valoreCampo = valoreCampo;
	}


	public String getMcr() {
		return mcr;
	}

	public void setMcr(String mcr) {
		this.mcr = mcr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mcr == null) ? 0 : mcr.hashCode());
		result = prime * result + ((nomeCampo == null) ? 0 : nomeCampo.hashCode());
		result = prime * result + ((valoreCampo == null) ? 0 : valoreCampo.hashCode());
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
		RecuperaCampiOffertaVPInputBean other = (RecuperaCampiOffertaVPInputBean) obj;
		if (mcr == null) {
			if (other.mcr != null)
				return false;
		} else if (!mcr.equals(other.mcr))
			return false;
		if (nomeCampo == null) {
			if (other.nomeCampo != null)
				return false;
		} else if (!nomeCampo.equals(other.nomeCampo))
			return false;
		if (valoreCampo == null) {
			if (other.valoreCampo != null)
				return false;
		} else if (!valoreCampo.equals(other.valoreCampo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaCampiOffertaVPInputBean [nomeCampo=" + nomeCampo + ", valoreCampo=" + valoreCampo + ", mcr="
				+ mcr + "]";
	}

	
	
}
