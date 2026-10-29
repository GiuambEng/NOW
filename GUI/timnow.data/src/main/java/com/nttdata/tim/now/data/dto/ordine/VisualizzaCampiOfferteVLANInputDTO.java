package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class VisualizzaCampiOfferteVLANInputDTO implements Serializable {

	private static final long serialVersionUID = -2910074711637443419L;

	@JsonProperty("nomeCampo")
    private String nomeCampo;
	
	@JsonProperty("valoreCampo")
    private String valoreCampo;
	
	@JsonProperty("idOfferta")
	private String idOfferta;
	
	@JsonProperty("codOloAgcom")
    private String codOloAgcom;

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

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}
	
	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOloAgcom == null) ? 0 : codOloAgcom.hashCode());
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
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
		VisualizzaCampiOfferteVLANInputDTO other = (VisualizzaCampiOfferteVLANInputDTO) obj;
		if (codOloAgcom == null) {
			if (other.codOloAgcom != null)
				return false;
		} else if (!codOloAgcom.equals(other.codOloAgcom))
			return false;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
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
		return "VisualizzaCampiOfferteVLANInputDTO [nomeCampo=" + nomeCampo + ", valoreCampo=" + valoreCampo
				+ ", idOfferta=" + idOfferta + ", codOloAgcom=" + codOloAgcom + "]";
	}
	
}
