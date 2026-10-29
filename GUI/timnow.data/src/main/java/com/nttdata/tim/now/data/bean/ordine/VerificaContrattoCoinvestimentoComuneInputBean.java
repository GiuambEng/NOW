package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1164
public class VerificaContrattoCoinvestimentoComuneInputBean implements Serializable {

	private static final long serialVersionUID = -5181266604121426693L;

	@JsonProperty("idContratto")
	private String idContratto;

	@JsonProperty("idOfferta")
	private String idOfferta;
				
	@JsonProperty("indirizzoDatiClienteFinale")
	private IndirizzoDatiClienteFinaleInputBean indirizzoDatiClienteFinale;
	
	//SM_10064
	@JsonProperty("lavorazione")
	private String lavorazione;
	
	@JsonProperty("codiceIstatComune")
	private String codiceIstatComune;

	public String getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(String idContratto) {
		this.idContratto = idContratto;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public IndirizzoDatiClienteFinaleInputBean getIndirizzoDatiClienteFinale() {
		return indirizzoDatiClienteFinale;
	}

	public void setIndirizzoDatiClienteFinale(IndirizzoDatiClienteFinaleInputBean indirizzoDatiClienteFinale) {
		this.indirizzoDatiClienteFinale = indirizzoDatiClienteFinale;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public String getCodiceIstatComune() {
		return codiceIstatComune;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public void setCodiceIstatComune(String codiceIstatComune) {
		this.codiceIstatComune = codiceIstatComune;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceIstatComune == null) ? 0 : codiceIstatComune.hashCode());
		result = prime * result + ((idContratto == null) ? 0 : idContratto.hashCode());
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((indirizzoDatiClienteFinale == null) ? 0 : indirizzoDatiClienteFinale.hashCode());
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
		VerificaContrattoCoinvestimentoComuneInputBean other = (VerificaContrattoCoinvestimentoComuneInputBean) obj;
		if (codiceIstatComune == null) {
			if (other.codiceIstatComune != null)
				return false;
		} else if (!codiceIstatComune.equals(other.codiceIstatComune))
			return false;
		if (idContratto == null) {
			if (other.idContratto != null)
				return false;
		} else if (!idContratto.equals(other.idContratto))
			return false;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		if (indirizzoDatiClienteFinale == null) {
			if (other.indirizzoDatiClienteFinale != null)
				return false;
		} else if (!indirizzoDatiClienteFinale.equals(other.indirizzoDatiClienteFinale))
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
		return "VerificaContrattoCoinvestimentoComuneInputBean [idContratto=" + idContratto + ", idOfferta=" + idOfferta
				+ ", indirizzoDatiClienteFinale=" + indirizzoDatiClienteFinale + ", lavorazione=" + lavorazione
				+ ", codiceIstatComune=" + codiceIstatComune + "]";
	}

}
