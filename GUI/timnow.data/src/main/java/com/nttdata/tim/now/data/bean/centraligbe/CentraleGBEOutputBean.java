package com.nttdata.tim.now.data.bean.centraligbe;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1058
public class CentraleGBEOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -3980625788273760398L;

	@JsonProperty("stato")
    private String stato;
	
    @JsonProperty("codiceIdbre")
    private String codiceIdbre;
    
    @JsonProperty("comune")
    private String comune;
    
    @JsonProperty("flagQNQ")
    private String flagQNQ;
    
    @JsonProperty("flagLongDistance")
    private String flagLongDistance;   
    
    @JsonProperty("descrizioneClli")
    private String descrizioneClli;
    
    @JsonProperty("tipologiaDslam")
    private String tipologiaDslam;
    
    @JsonProperty("flagProntoVendita")
    private String flagProntoVendita;
    
    @JsonProperty("dataAttivazione")
    private String dataAttivazione;
    
    @JsonProperty("codiceClli")
    private String codiceClli;
    
    @JsonProperty("distretto")
    private String distretto;
    
    @JsonProperty("nomeCentrale")
    private String nomeCentrale;

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
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

	public String getFlagQNQ() {
		return flagQNQ;
	}

	public void setFlagQNQ(String flagQNQ) {
		this.flagQNQ = flagQNQ;
	}

	public String getFlagLongDistance() {
		return flagLongDistance;
	}

	public void setFlagLongDistance(String flagLongDistance) {
		this.flagLongDistance = flagLongDistance;
	}

	public String getDescrizioneClli() {
		return descrizioneClli;
	}

	public void setDescrizioneClli(String descrizioneClli) {
		this.descrizioneClli = descrizioneClli;
	}

	public String getTipologiaDslam() {
		return tipologiaDslam;
	}

	public void setTipologiaDslam(String tipologiaDslam) {
		this.tipologiaDslam = tipologiaDslam;
	}

	public String getFlagProntoVendita() {
		return flagProntoVendita;
	}

	public void setFlagProntoVendita(String flagProntoVendita) {
		this.flagProntoVendita = flagProntoVendita;
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

	@Override
	public String toString() {
		return "CentraliGBEOutputDTO [stato=" + stato + ", codiceIdbre=" + codiceIdbre + ", comune=" + comune
				+ ", flagQNQ=" + flagQNQ + ", flagLongDistance=" + flagLongDistance + ", descrizioneClli="
				+ descrizioneClli + ", tipologiaDslam=" + tipologiaDslam + ", flagProntoVendita=" + flagProntoVendita
				+ ", dataAttivazione=" + dataAttivazione + ", codiceClli=" + codiceClli + ", distretto=" + distretto
				+ ", nomeCentrale=" + nomeCentrale + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceClli == null) ? 0 : codiceClli.hashCode());
		result = prime * result + ((codiceIdbre == null) ? 0 : codiceIdbre.hashCode());
		result = prime * result + ((comune == null) ? 0 : comune.hashCode());
		result = prime * result + ((dataAttivazione == null) ? 0 : dataAttivazione.hashCode());
		result = prime * result + ((descrizioneClli == null) ? 0 : descrizioneClli.hashCode());
		result = prime * result + ((distretto == null) ? 0 : distretto.hashCode());
		result = prime * result + ((flagLongDistance == null) ? 0 : flagLongDistance.hashCode());
		result = prime * result + ((flagProntoVendita == null) ? 0 : flagProntoVendita.hashCode());
		result = prime * result + ((flagQNQ == null) ? 0 : flagQNQ.hashCode());
		result = prime * result + ((nomeCentrale == null) ? 0 : nomeCentrale.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		result = prime * result + ((tipologiaDslam == null) ? 0 : tipologiaDslam.hashCode());
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
		CentraleGBEOutputBean other = (CentraleGBEOutputBean) obj;
		if (codiceClli == null) {
			if (other.codiceClli != null)
				return false;
		} else if (!codiceClli.equals(other.codiceClli))
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
		if (descrizioneClli == null) {
			if (other.descrizioneClli != null)
				return false;
		} else if (!descrizioneClli.equals(other.descrizioneClli))
			return false;
		if (distretto == null) {
			if (other.distretto != null)
				return false;
		} else if (!distretto.equals(other.distretto))
			return false;
		if (flagLongDistance == null) {
			if (other.flagLongDistance != null)
				return false;
		} else if (!flagLongDistance.equals(other.flagLongDistance))
			return false;
		if (flagProntoVendita == null) {
			if (other.flagProntoVendita != null)
				return false;
		} else if (!flagProntoVendita.equals(other.flagProntoVendita))
			return false;
		if (flagQNQ == null) {
			if (other.flagQNQ != null)
				return false;
		} else if (!flagQNQ.equals(other.flagQNQ))
			return false;
		if (nomeCentrale == null) {
			if (other.nomeCentrale != null)
				return false;
		} else if (!nomeCentrale.equals(other.nomeCentrale))
			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		if (tipologiaDslam == null) {
			if (other.tipologiaDslam != null)
				return false;
		} else if (!tipologiaDslam.equals(other.tipologiaDslam))
			return false;
		return true;
	}
    
    
}
