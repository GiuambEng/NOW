package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1089
@JsonInclude(Include.NON_NULL)
public class VerificaCongruenzaClusterComuneVlanInputBean implements Serializable {

	private static final long serialVersionUID = 3119726431146260282L;
	
	@JsonProperty("lavorazione")
    private String lavorazione;
	
	@JsonProperty("codiceIstatComune")
	private String codiceIstatComune;
	
	@JsonProperty("indirizzoClienteFinale")
	private IndirizzoDatiClienteFinaleInputBean indirizzoClienteFinale;
		
	@JsonProperty("idAsset")
    private String idAsset;
	
	@JsonProperty("codiciVlan")
	private List<String> codiciVlan;

	@JsonProperty("idOfferta")
	private String idOfferta;

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getCodiceIstatComune() {
		return codiceIstatComune;
	}

	public void setCodiceIstatComune(String codiceIstatComune) {
		this.codiceIstatComune = codiceIstatComune;
	}

	public IndirizzoDatiClienteFinaleInputBean getIndirizzoClienteFinale() {
		return indirizzoClienteFinale;
	}

	public void setIndirizzoClienteFinale(IndirizzoDatiClienteFinaleInputBean indirizzoClienteFinale) {
		this.indirizzoClienteFinale = indirizzoClienteFinale;
	}

	public String getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}

	public List<String> getCodiciVlan() {
		return codiciVlan;
	}

	public void setCodiciVlan(List<String> codiciVlan) {
		this.codiciVlan = codiciVlan;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceIstatComune == null) ? 0 : codiceIstatComune.hashCode());
		result = prime * result + ((codiciVlan == null) ? 0 : codiciVlan.hashCode());
		result = prime * result + ((idAsset == null) ? 0 : idAsset.hashCode());
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((indirizzoClienteFinale == null) ? 0 : indirizzoClienteFinale.hashCode());
		result = prime * result + ((lavorazione == null) ? 0 : lavorazione.hashCode());
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
		VerificaCongruenzaClusterComuneVlanInputBean other = (VerificaCongruenzaClusterComuneVlanInputBean) obj;
		if (codiceIstatComune == null) {
			if (other.codiceIstatComune != null)
				return false;
		} else if (!codiceIstatComune.equals(other.codiceIstatComune))
			return false;
		if (codiciVlan == null) {
			if (other.codiciVlan != null)
				return false;
		} else if (!codiciVlan.equals(other.codiciVlan))
			return false;
		if (idAsset == null) {
			if (other.idAsset != null)
				return false;
		} else if (!idAsset.equals(other.idAsset))
			return false;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		if (indirizzoClienteFinale == null) {
			if (other.indirizzoClienteFinale != null)
				return false;
		} else if (!indirizzoClienteFinale.equals(other.indirizzoClienteFinale))
			return false;
		if (lavorazione == null) {
			if (other.lavorazione != null)
				return false;
		} else if (!lavorazione.equals(other.lavorazione))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaCongruenzaClusterComuneVlanInputBean [lavorazione=" + lavorazione + ", codiceIstatComune="
				+ codiceIstatComune + ", indirizzoClienteFinale=" + indirizzoClienteFinale + ", idAsset=" + idAsset
				+ ", codiciVlan=" + codiciVlan + ", idOfferta=" + idOfferta + "]";
	}
}
