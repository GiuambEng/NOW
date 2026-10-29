package com.nttdata.tim.now.data.dto.ordine.multicast;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1180
@JsonInclude(Include.NON_NULL)
public class VisualizzaCampiOfferteMulticastOutputDTO implements Serializable {

	private static final long serialVersionUID = 7722015537591819266L;

	@JsonProperty("valoreCampo")
	private String valoreCampo;
	
	@JsonProperty("tipoApparato")
	private String tipoApparato;

	//RU_1199
	@JsonProperty("nomeCentrale")
	private String nomeCentrale;
	
	public String getValoreCampo() {
		return valoreCampo;
	}

	public void setValoreCampo(String valoreCampo) {
		this.valoreCampo = valoreCampo;
	}

	public String getTipoApparato() {
		return tipoApparato;
	}

	public void setTipoApparato(String tipoApparato) {
		this.tipoApparato = tipoApparato;
	}

	public String getNomeCentrale() {
		return nomeCentrale;
	}

	public void setNomeCentrale(String nomeCentrale) {
		this.nomeCentrale = nomeCentrale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeCentrale == null) ? 0 : nomeCentrale.hashCode());
		result = prime * result + ((tipoApparato == null) ? 0 : tipoApparato.hashCode());
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
		VisualizzaCampiOfferteMulticastOutputDTO other = (VisualizzaCampiOfferteMulticastOutputDTO) obj;
		if (nomeCentrale == null) {
			if (other.nomeCentrale != null)
				return false;
		} else if (!nomeCentrale.equals(other.nomeCentrale))
			return false;
		if (tipoApparato == null) {
			if (other.tipoApparato != null)
				return false;
		} else if (!tipoApparato.equals(other.tipoApparato))
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
		return "VisualizzaCampiOfferteMulticastOutputDTO [valoreCampo=" + valoreCampo + ", tipoApparato=" + tipoApparato
				+ ", nomeCentrale=" + nomeCentrale + "]";
	}
}
