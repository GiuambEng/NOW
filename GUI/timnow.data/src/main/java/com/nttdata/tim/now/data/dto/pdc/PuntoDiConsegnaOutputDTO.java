package com.nttdata.tim.now.data.dto.pdc;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1058
public class PuntoDiConsegnaOutputDTO implements Serializable {

	private static final long serialVersionUID = 3939443365677103504L;

	@JsonProperty("nomeCentralePDC")
    private String nomeCentralePDC;
	
    @JsonProperty("descrizioneClliPDC")
    private String descrizioneClliPDC;
    
    @JsonProperty("idoneitaNgaPDC")
    private String idoneitaNgaPDC;
    
    @JsonProperty("raccoltaTerminatingPDC")
    private String raccoltaTerminatingPDC;
    
    @JsonProperty("roPDC")
    private String roPDC;   
    
    @JsonProperty("codicePDC")
    private String codicePDC;
    
    @JsonProperty("provincia")
    private String provincia;
    
    @JsonProperty("viaPDC")
    private String viaPDC;
    
    @JsonProperty("stato")
    private String stato;
    
    @JsonProperty("codiceClliPDC")
    private String codiceClliPDC;
    
    @JsonProperty("codiceIdbre")
    private String codiceIdbre;
    
    @JsonProperty("comune")
    private String comune;
   
    @JsonProperty("regionePDC")
    private String regionePDC;
    
    @JsonProperty("idoneitaPopPDC")
    private String idoneitaPopPDC;

	public String getNomeCentralePDC() {
		return nomeCentralePDC;
	}

	public void setNomeCentralePDC(String nomeCentralePDC) {
		this.nomeCentralePDC = nomeCentralePDC;
	}

	public String getDescrizioneClliPDC() {
		return descrizioneClliPDC;
	}

	public void setDescrizioneClliPDC(String descrizioneClliPDC) {
		this.descrizioneClliPDC = descrizioneClliPDC;
	}

	public String getIdoneitaNgaPDC() {
		return idoneitaNgaPDC;
	}

	public void setIdoneitaNgaPDC(String idoneitaNgaPDC) {
		this.idoneitaNgaPDC = idoneitaNgaPDC;
	}

	public String getRaccoltaTerminatingPDC() {
		return raccoltaTerminatingPDC;
	}

	public void setRaccoltaTerminatingPDC(String raccoltaTerminatingPDC) {
		this.raccoltaTerminatingPDC = raccoltaTerminatingPDC;
	}

	public String getRoPDC() {
		return roPDC;
	}

	public void setRoPDC(String roPDC) {
		this.roPDC = roPDC;
	}

	public String getCodicePDC() {
		return codicePDC;
	}

	public void setCodicePDC(String codicePDC) {
		this.codicePDC = codicePDC;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getViaPDC() {
		return viaPDC;
	}

	public void setViaPDC(String viaPDC) {
		this.viaPDC = viaPDC;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getCodiceClliPDC() {
		return codiceClliPDC;
	}

	public void setCodiceClliPDC(String codiceClliPDC) {
		this.codiceClliPDC = codiceClliPDC;
	}

	public String getCodiceIdbre() {
		return codiceIdbre;
	}

	public void setCodiceIdbre(String codiceIdbre) {
		this.codiceIdbre = codiceIdbre;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getRegionePDC() {
		return regionePDC;
	}

	public void setRegionePDC(String regionePDC) {
		this.regionePDC = regionePDC;
	}

	public String getIdoneitaPopPDC() {
		return idoneitaPopPDC;
	}

	public void setIdoneitaPopPDC(String idoneitaPopPDC) {
		this.idoneitaPopPDC = idoneitaPopPDC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceClliPDC == null) ? 0 : codiceClliPDC.hashCode());
		result = prime * result + ((codiceIdbre == null) ? 0 : codiceIdbre.hashCode());
		result = prime * result + ((codicePDC == null) ? 0 : codicePDC.hashCode());
		result = prime * result + ((comune == null) ? 0 : comune.hashCode());
		result = prime * result + ((descrizioneClliPDC == null) ? 0 : descrizioneClliPDC.hashCode());
		result = prime * result + ((idoneitaNgaPDC == null) ? 0 : idoneitaNgaPDC.hashCode());
		result = prime * result + ((idoneitaPopPDC == null) ? 0 : idoneitaPopPDC.hashCode());
		result = prime * result + ((nomeCentralePDC == null) ? 0 : nomeCentralePDC.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		result = prime * result + ((raccoltaTerminatingPDC == null) ? 0 : raccoltaTerminatingPDC.hashCode());
		result = prime * result + ((regionePDC == null) ? 0 : regionePDC.hashCode());
		result = prime * result + ((roPDC == null) ? 0 : roPDC.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		result = prime * result + ((viaPDC == null) ? 0 : viaPDC.hashCode());
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
		PuntoDiConsegnaOutputDTO other = (PuntoDiConsegnaOutputDTO) obj;
		if (codiceClliPDC == null) {
			if (other.codiceClliPDC != null)
				return false;
		} else if (!codiceClliPDC.equals(other.codiceClliPDC))
			return false;
		if (codiceIdbre == null) {
			if (other.codiceIdbre != null)
				return false;
		} else if (!codiceIdbre.equals(other.codiceIdbre))
			return false;
		if (codicePDC == null) {
			if (other.codicePDC != null)
				return false;
		} else if (!codicePDC.equals(other.codicePDC))
			return false;
		if (comune == null) {
			if (other.comune != null)
				return false;
		} else if (!comune.equals(other.comune))
			return false;
		if (descrizioneClliPDC == null) {
			if (other.descrizioneClliPDC != null)
				return false;
		} else if (!descrizioneClliPDC.equals(other.descrizioneClliPDC))
			return false;
		if (idoneitaNgaPDC == null) {
			if (other.idoneitaNgaPDC != null)
				return false;
		} else if (!idoneitaNgaPDC.equals(other.idoneitaNgaPDC))
			return false;
		if (idoneitaPopPDC == null) {
			if (other.idoneitaPopPDC != null)
				return false;
		} else if (!idoneitaPopPDC.equals(other.idoneitaPopPDC))
			return false;
		if (nomeCentralePDC == null) {
			if (other.nomeCentralePDC != null)
				return false;
		} else if (!nomeCentralePDC.equals(other.nomeCentralePDC))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		if (raccoltaTerminatingPDC == null) {
			if (other.raccoltaTerminatingPDC != null)
				return false;
		} else if (!raccoltaTerminatingPDC.equals(other.raccoltaTerminatingPDC))
			return false;
		if (regionePDC == null) {
			if (other.regionePDC != null)
				return false;
		} else if (!regionePDC.equals(other.regionePDC))
			return false;
		if (roPDC == null) {
			if (other.roPDC != null)
				return false;
		} else if (!roPDC.equals(other.roPDC))
			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		if (viaPDC == null) {
			if (other.viaPDC != null)
				return false;
		} else if (!viaPDC.equals(other.viaPDC))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PuntoDiConsegnaOutputDTO [nomeCentralePDC=" + nomeCentralePDC + ", descrizioneClliPDC="
				+ descrizioneClliPDC + ", idoneitaNgaPDC=" + idoneitaNgaPDC + ", raccoltaTerminatingPDC="
				+ raccoltaTerminatingPDC + ", roPDC=" + roPDC + ", codicePDC=" + codicePDC + ", provincia=" + provincia
				+ ", viaPDC=" + viaPDC + ", stato=" + stato + ", codiceClliPDC=" + codiceClliPDC + ", codiceIdbre="
				+ codiceIdbre + ", comune=" + comune + ", regionePDC=" + regionePDC + ", idoneitaPopPDC="
				+ idoneitaPopPDC + "]";
	}

}
