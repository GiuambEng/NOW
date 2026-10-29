package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class VerificaOloWholesalerInputDTO implements Serializable {
 
	private static final long serialVersionUID = -6959314056418316772L;

	@JsonProperty("RoutingNumberRecipient")
	private String routingNumberRecipient;

	@JsonProperty("codificaAgcomRecipient")
	private String codificaAgcomRecipient;

	@JsonProperty("offerta")
	private String offerta;

	@JsonProperty("tipoLinea")
	private String tipoLinea;

	@JsonProperty("componenteNumberPortability")
	private String componenteNumberPortability;
	
	@JsonProperty("canaleRichiesta")
	private String canaleRichiesta;
	
	@JsonProperty("idRichiestaOlo")
	private String idRichiestaOlo;

	public String getRoutingNumberRecipient() {
		return routingNumberRecipient;
	}

	public void setRoutingNumberRecipient(String routingNumberRecipient) {
		this.routingNumberRecipient = routingNumberRecipient;
	}

	public String getCodificaAgcomRecipient() {
		return codificaAgcomRecipient;
	}

	public void setCodificaAgcomRecipient(String codificaAgcomRecipient) {
		this.codificaAgcomRecipient = codificaAgcomRecipient;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getTipoLinea() {
		return tipoLinea;
	}

	public void setTipoLinea(String tipoLinea) {
		this.tipoLinea = tipoLinea;
	}

	public String getComponenteNumberPortability() {
		return componenteNumberPortability;
	}

	public void setComponenteNumberPortability(String componenteNumberPortability) {
		this.componenteNumberPortability = componenteNumberPortability;
	}

	public String getCanaleRichiesta() {
		return canaleRichiesta;
	}

	public void setCanaleRichiesta(String canaleRichiesta) {
		this.canaleRichiesta = canaleRichiesta;
	}

	public String getIdRichiestaOlo() {
		return idRichiestaOlo;
	}

	public void setIdRichiestaOlo(String idRichiestaOlo) {
		this.idRichiestaOlo = idRichiestaOlo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canaleRichiesta == null) ? 0 : canaleRichiesta.hashCode());
		result = prime * result + ((codificaAgcomRecipient == null) ? 0 : codificaAgcomRecipient.hashCode());
		result = prime * result + ((componenteNumberPortability == null) ? 0 : componenteNumberPortability.hashCode());
		result = prime * result + ((idRichiestaOlo == null) ? 0 : idRichiestaOlo.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((routingNumberRecipient == null) ? 0 : routingNumberRecipient.hashCode());
		result = prime * result + ((tipoLinea == null) ? 0 : tipoLinea.hashCode());
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
		VerificaOloWholesalerInputDTO other = (VerificaOloWholesalerInputDTO) obj;
		if (canaleRichiesta == null) {
			if (other.canaleRichiesta != null)
				return false;
		} else if (!canaleRichiesta.equals(other.canaleRichiesta))
			return false;
		if (codificaAgcomRecipient == null) {
			if (other.codificaAgcomRecipient != null)
				return false;
		} else if (!codificaAgcomRecipient.equals(other.codificaAgcomRecipient))
			return false;
		if (componenteNumberPortability == null) {
			if (other.componenteNumberPortability != null)
				return false;
		} else if (!componenteNumberPortability.equals(other.componenteNumberPortability))
			return false;
		if (idRichiestaOlo == null) {
			if (other.idRichiestaOlo != null)
				return false;
		} else if (!idRichiestaOlo.equals(other.idRichiestaOlo))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (routingNumberRecipient == null) {
			if (other.routingNumberRecipient != null)
				return false;
		} else if (!routingNumberRecipient.equals(other.routingNumberRecipient))
			return false;
		if (tipoLinea == null) {
			if (other.tipoLinea != null)
				return false;
		} else if (!tipoLinea.equals(other.tipoLinea))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaOloWholesalerInputDTO [routingNumberRecipient=" + routingNumberRecipient
				+ ", codificaAgcomRecipient=" + codificaAgcomRecipient + ", offerta=" + offerta + ", tipoLinea="
				+ tipoLinea + ", componenteNumberPortability=" + componenteNumberPortability + ", canaleRichiesta="
				+ canaleRichiesta + ", idRichiestaOlo=" + idRichiestaOlo + "]";
	}

}
