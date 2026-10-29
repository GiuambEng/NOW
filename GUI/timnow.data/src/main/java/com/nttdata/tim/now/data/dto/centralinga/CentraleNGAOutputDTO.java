package com.nttdata.tim.now.data.dto.centralinga;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1058
public class CentraleNGAOutputDTO implements Serializable {

	private static final long serialVersionUID = -2724091203950887692L;

	@JsonProperty("nomeCentralePdc")
    private String nomeCentralePdc;
	
    @JsonProperty("dataProntoVendita")
    private String dataProntoVendita;
    
    @JsonProperty("dataAttivazione")
    private String dataAttivazione;
    
    @JsonProperty("codiceClli")
    private String codiceClli;
    
    @JsonProperty("nomeMacroarea")
    private String nomeMacroarea;   
    
    @JsonProperty("nomePdc")
    private String nomePdc;
    
    @JsonProperty("stato")
    private String stato;
    
    @JsonProperty("tecnologia")
    private String tecnologia;
    
    @JsonProperty("codiceClliPdc")
    private String codiceClliPdc;
    
    @JsonProperty("codiceIdbre")
    private String codiceIdbre;
    
    @JsonProperty("comune")
    private String comune;
    
    @JsonProperty("flagProntoVendita")
    private String flagProntoVendita;
    
    @JsonProperty("falgPdc")
    private String falgPdc;
    
    @JsonProperty("distretto")
    private String distretto;
    
    @JsonProperty("nomeCentrale")
    private String nomeCentrale;

	public String getNomeCentralePdc() {
		return nomeCentralePdc;
	}

	public void setNomeCentralePdc(String nomeCentralePdc) {
		this.nomeCentralePdc = nomeCentralePdc;
	}

	public String getDataProntoVendita() {
		return dataProntoVendita;
	}

	public void setDataProntoVendita(String dataProntoVendita) {
		this.dataProntoVendita = dataProntoVendita;
	}

	public String getDataAttivazione() {
		return dataAttivazione;
	}

	public void setDataAttivazione(String dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
	}

	public String getCodiceClli() {
		return codiceClli;
	}

	public void setCodiceClli(String codiceClli) {
		this.codiceClli = codiceClli;
	}

	public String getNomeMacroarea() {
		return nomeMacroarea;
	}

	public void setNomeMacroarea(String nomeMacroarea) {
		this.nomeMacroarea = nomeMacroarea;
	}

	public String getNomePdc() {
		return nomePdc;
	}

	public void setNomePdc(String nomePdc) {
		this.nomePdc = nomePdc;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getCodiceClliPdc() {
		return codiceClliPdc;
	}

	public void setCodiceClliPdc(String codiceClliPdc) {
		this.codiceClliPdc = codiceClliPdc;
	}

	public String getCodiceIdbre() {
		return codiceIdbre;
	}

	@Override
	public String toString() {
		return "CentraliNGAOutputDTO [nomeCentralePdc=" + nomeCentralePdc + ", dataProntoVendita=" + dataProntoVendita
				+ ", dataAttivazione=" + dataAttivazione + ", codiceClli=" + codiceClli + ", nomeMacroarea="
				+ nomeMacroarea + ", nomePdc=" + nomePdc + ", stato=" + stato + ", tecnologia=" + tecnologia
				+ ", codiceClliPdc=" + codiceClliPdc + ", codiceIdbre=" + codiceIdbre + ", comune=" + comune
				+ ", flagProntoVendita=" + flagProntoVendita + ", falgPdc=" + falgPdc + ", distretto=" + distretto
				+ ", nomeCentrale=" + nomeCentrale + "]";
	}

	public void setCodiceIdbre(String codiceIdbre) {
		this.codiceIdbre = codiceIdbre;
	}

	public String getComune() {
		return comune;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceClli == null) ? 0 : codiceClli.hashCode());
		result = prime * result + ((codiceClliPdc == null) ? 0 : codiceClliPdc.hashCode());
		result = prime * result + ((codiceIdbre == null) ? 0 : codiceIdbre.hashCode());
		result = prime * result + ((comune == null) ? 0 : comune.hashCode());
		result = prime * result + ((dataAttivazione == null) ? 0 : dataAttivazione.hashCode());
		result = prime * result + ((dataProntoVendita == null) ? 0 : dataProntoVendita.hashCode());
		result = prime * result + ((distretto == null) ? 0 : distretto.hashCode());
		result = prime * result + ((falgPdc == null) ? 0 : falgPdc.hashCode());
		result = prime * result + ((flagProntoVendita == null) ? 0 : flagProntoVendita.hashCode());
		result = prime * result + ((nomeCentrale == null) ? 0 : nomeCentrale.hashCode());
		result = prime * result + ((nomeCentralePdc == null) ? 0 : nomeCentralePdc.hashCode());
		result = prime * result + ((nomeMacroarea == null) ? 0 : nomeMacroarea.hashCode());
		result = prime * result + ((nomePdc == null) ? 0 : nomePdc.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		result = prime * result + ((tecnologia == null) ? 0 : tecnologia.hashCode());
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
		CentraleNGAOutputDTO other = (CentraleNGAOutputDTO) obj;
		if (codiceClli == null) {
			if (other.codiceClli != null)
				return false;
		} else if (!codiceClli.equals(other.codiceClli))
			return false;
		if (codiceClliPdc == null) {
			if (other.codiceClliPdc != null)
				return false;
		} else if (!codiceClliPdc.equals(other.codiceClliPdc))
			return false;
		if (codiceIdbre == null) {
			if (other.codiceIdbre != null)
				return false;
		} else if (!codiceIdbre.equals(other.codiceIdbre))
			return false;
		if (comune == null) {
			if (other.comune != null)
				return false;
		} else if (!comune.equals(other.comune))
			return false;
		if (dataAttivazione == null) {
			if (other.dataAttivazione != null)
				return false;
		} else if (!dataAttivazione.equals(other.dataAttivazione))
			return false;
		if (dataProntoVendita == null) {
			if (other.dataProntoVendita != null)
				return false;
		} else if (!dataProntoVendita.equals(other.dataProntoVendita))
			return false;
		if (distretto == null) {
			if (other.distretto != null)
				return false;
		} else if (!distretto.equals(other.distretto))
			return false;
		if (falgPdc == null) {
			if (other.falgPdc != null)
				return false;
		} else if (!falgPdc.equals(other.falgPdc))
			return false;
		if (flagProntoVendita == null) {
			if (other.flagProntoVendita != null)
				return false;
		} else if (!flagProntoVendita.equals(other.flagProntoVendita))
			return false;
		if (nomeCentrale == null) {
			if (other.nomeCentrale != null)
				return false;
		} else if (!nomeCentrale.equals(other.nomeCentrale))
			return false;
		if (nomeCentralePdc == null) {
			if (other.nomeCentralePdc != null)
				return false;
		} else if (!nomeCentralePdc.equals(other.nomeCentralePdc))
			return false;
		if (nomeMacroarea == null) {
			if (other.nomeMacroarea != null)
				return false;
		} else if (!nomeMacroarea.equals(other.nomeMacroarea))
			return false;
		if (nomePdc == null) {
			if (other.nomePdc != null)
				return false;
		} else if (!nomePdc.equals(other.nomePdc))
			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		if (tecnologia == null) {
			if (other.tecnologia != null)
				return false;
		} else if (!tecnologia.equals(other.tecnologia))
			return false;
		return true;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getFlagProntoVendita() {
		return flagProntoVendita;
	}

	public void setFlagProntoVendita(String flagProntoVendita) {
		this.flagProntoVendita = flagProntoVendita;
	}

	public String getFalgPdc() {
		return falgPdc;
	}

	public void setFalgPdc(String falgPdc) {
		this.falgPdc = falgPdc;
	}

	public String getDistretto() {
		return distretto;
	}

	public void setDistretto(String distretto) {
		this.distretto = distretto;
	}

	public String getNomeCentrale() {
		return nomeCentrale;
	}

	public void setNomeCentrale(String nomeCentrale) {
		this.nomeCentrale = nomeCentrale;
	}
    
    
}
