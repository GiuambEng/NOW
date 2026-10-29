
package com.nttdata.tim.now.data.dto.banda;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class VerificaCoppiaBandePiccoInputDTO implements Serializable {
 
	private static final long serialVersionUID = 7395169911598474661L;

	@JsonProperty("profiloTecnicoLinea")
    private String profiloTecnicoLinea;

    @JsonProperty("userVlan")
    private List<VerificaCoppiaBandePiccoBandaInputDTO> userVlan;
    
    @JsonProperty("idRisorsa1")
    private String idRisorsa1;
    
    @JsonProperty("idRisorsa2")
    private String idRisorsa2;
    
    @JsonProperty("tipoVariazione")
    private String tipoVariazione;
    
    @JsonProperty("lavorazione")
    private String lavorazione;
    
    @JsonProperty("encapsulation")
    private String encapsulation;
    
    @JsonProperty("tagging")
    private String tagging;
    
    @JsonProperty("offerta")
    private String offerta;

	public String getProfiloTecnicoLinea() {
		return profiloTecnicoLinea;
	}

	public void setProfiloTecnicoLinea(String profiloTecnicoLinea) {
		this.profiloTecnicoLinea = profiloTecnicoLinea;
	}

	public List<VerificaCoppiaBandePiccoBandaInputDTO> getUserVlan() {
		return userVlan;
	}

	public void setUserVlan(List<VerificaCoppiaBandePiccoBandaInputDTO> userVlan) {
		this.userVlan = userVlan;
	}

	public String getIdRisorsa1() {
		return idRisorsa1;
	}

	public void setIdRisorsa1(String idRisorsa1) {
		this.idRisorsa1 = idRisorsa1;
	}

	public String getIdRisorsa2() {
		return idRisorsa2;
	}

	public void setIdRisorsa2(String idRisorsa2) {
		this.idRisorsa2 = idRisorsa2;
	}

	public String getTipoVariazione() {
		return tipoVariazione;
	}

	public void setTipoVariazione(String tipoVariazione) {
		this.tipoVariazione = tipoVariazione;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getEncapsulation() {
		return encapsulation;
	}

	public void setEncapsulation(String encapsulation) {
		this.encapsulation = encapsulation;
	}

	public String getTagging() {
		return tagging;
	}

	public void setTagging(String tagging) {
		this.tagging = tagging;
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
		result = prime * result + ((encapsulation == null) ? 0 : encapsulation.hashCode());
		result = prime * result + ((idRisorsa1 == null) ? 0 : idRisorsa1.hashCode());
		result = prime * result + ((idRisorsa2 == null) ? 0 : idRisorsa2.hashCode());
		result = prime * result + ((lavorazione == null) ? 0 : lavorazione.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((profiloTecnicoLinea == null) ? 0 : profiloTecnicoLinea.hashCode());
		result = prime * result + ((tagging == null) ? 0 : tagging.hashCode());
		result = prime * result + ((tipoVariazione == null) ? 0 : tipoVariazione.hashCode());
		result = prime * result + ((userVlan == null) ? 0 : userVlan.hashCode());
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
		VerificaCoppiaBandePiccoInputDTO other = (VerificaCoppiaBandePiccoInputDTO) obj;
		if (encapsulation == null) {
			if (other.encapsulation != null)
				return false;
		} else if (!encapsulation.equals(other.encapsulation))
			return false;
		if (idRisorsa1 == null) {
			if (other.idRisorsa1 != null)
				return false;
		} else if (!idRisorsa1.equals(other.idRisorsa1))
			return false;
		if (idRisorsa2 == null) {
			if (other.idRisorsa2 != null)
				return false;
		} else if (!idRisorsa2.equals(other.idRisorsa2))
			return false;
		if (lavorazione == null) {
			if (other.lavorazione != null)
				return false;
		} else if (!lavorazione.equals(other.lavorazione))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (profiloTecnicoLinea == null) {
			if (other.profiloTecnicoLinea != null)
				return false;
		} else if (!profiloTecnicoLinea.equals(other.profiloTecnicoLinea))
			return false;
		if (tagging == null) {
			if (other.tagging != null)
				return false;
		} else if (!tagging.equals(other.tagging))
			return false;
		if (tipoVariazione == null) {
			if (other.tipoVariazione != null)
				return false;
		} else if (!tipoVariazione.equals(other.tipoVariazione))
			return false;
		if (userVlan == null) {
			if (other.userVlan != null)
				return false;
		} else if (!userVlan.equals(other.userVlan))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaCoppiaBandePiccoInputDTO [profiloTecnicoLinea=" + profiloTecnicoLinea + ", userVlan=" + userVlan
				+ ", idRisorsa1=" + idRisorsa1 + ", idRisorsa2=" + idRisorsa2 + ", tipoVariazione=" + tipoVariazione
				+ ", lavorazione=" + lavorazione + ", encapsulation=" + encapsulation + ", tagging=" + tagging
				+ ", offerta=" + offerta + "]";
	}
   
}
