package com.nttdata.tim.now.data.dto.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class VerificaIdRisorsaNakedInputDTO implements Serializable {
 
    private static final long serialVersionUID = -6350141811106277423L;

    @JsonProperty("idRisorsaNaked")
    private String idRisorsaNaked;
    
    @JsonProperty("tipoLineaWLR")
    private String tipoLineaWLR;
    
    @JsonProperty("idRichiesta")
    private String idRichiesta;

	public String getIdRisorsaNaked() {
		return idRisorsaNaked;
	}

	public void setIdRisorsaNaked(String idRisorsaNaked) {
		this.idRisorsaNaked = idRisorsaNaked;
	}

	public String getTipoLineaWLR() {
		return tipoLineaWLR;
	}

	public void setTipoLineaWLR(String tipoLineaWLR) {
		this.tipoLineaWLR = tipoLineaWLR;
	}

	public String getIdRichiesta() {
		return idRichiesta;
	}

	public void setIdRichiesta(String idRichiesta) {
		this.idRichiesta = idRichiesta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRichiesta == null) ? 0 : idRichiesta.hashCode());
		result = prime * result + ((idRisorsaNaked == null) ? 0 : idRisorsaNaked.hashCode());
		result = prime * result + ((tipoLineaWLR == null) ? 0 : tipoLineaWLR.hashCode());
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
		VerificaIdRisorsaNakedInputDTO other = (VerificaIdRisorsaNakedInputDTO) obj;
		if (idRichiesta == null) {
			if (other.idRichiesta != null)
				return false;
		} else if (!idRichiesta.equals(other.idRichiesta))
			return false;
		if (idRisorsaNaked == null) {
			if (other.idRisorsaNaked != null)
				return false;
		} else if (!idRisorsaNaked.equals(other.idRisorsaNaked))
			return false;
		if (tipoLineaWLR == null) {
			if (other.tipoLineaWLR != null)
				return false;
		} else if (!tipoLineaWLR.equals(other.tipoLineaWLR))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaIdRisorsaNakedInputDTO [idRisorsaNaked=" + idRisorsaNaked + ", tipoLineaWLR=" + tipoLineaWLR
				+ ", idRichiesta=" + idRichiesta + "]";
	}
	
}
