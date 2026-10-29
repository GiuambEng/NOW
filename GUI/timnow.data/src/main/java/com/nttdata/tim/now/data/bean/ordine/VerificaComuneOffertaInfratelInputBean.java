package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1060
public class VerificaComuneOffertaInfratelInputBean implements Serializable {
	
	private static final long serialVersionUID = -8949358816892220043L;
	
	//SM_9563
	@JsonProperty("idAsset")
	private String idAsset;

	@JsonProperty("codificaOloAgcom")
	private String codificaOloAgcom;
		
	@JsonProperty("lavorazione")
	private String lavorazione;
	
	@JsonProperty("codiceIstatComuneAsset")
	private String codiceIstatComuneAsset;
		
	@JsonProperty("indirizzoDatiClienteFinale")
	private IndirizzoDatiClienteFinaleInputBean indirizzoDatiClienteFinale;

	public String getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getCodiceIstatComuneAsset() {
		return codiceIstatComuneAsset;
	}

	public void setCodiceIstatComuneAsset(String codiceIstatComuneAsset) {
		this.codiceIstatComuneAsset = codiceIstatComuneAsset;
	}

	public IndirizzoDatiClienteFinaleInputBean getIndirizzoDatiClienteFinale() {
		return indirizzoDatiClienteFinale;
	}

	public void setIndirizzoDatiClienteFinale(IndirizzoDatiClienteFinaleInputBean indirizzoDatiClienteFinale) {
		this.indirizzoDatiClienteFinale = indirizzoDatiClienteFinale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceIstatComuneAsset == null) ? 0 : codiceIstatComuneAsset.hashCode());
		result = prime * result + ((codificaOloAgcom == null) ? 0 : codificaOloAgcom.hashCode());
		result = prime * result + ((idAsset == null) ? 0 : idAsset.hashCode());
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
		VerificaComuneOffertaInfratelInputBean other = (VerificaComuneOffertaInfratelInputBean) obj;
		if (codiceIstatComuneAsset == null) {
			if (other.codiceIstatComuneAsset != null)
				return false;
		} else if (!codiceIstatComuneAsset.equals(other.codiceIstatComuneAsset))
			return false;
		if (codificaOloAgcom == null) {
			if (other.codificaOloAgcom != null)
				return false;
		} else if (!codificaOloAgcom.equals(other.codificaOloAgcom))
			return false;
		if (idAsset == null) {
			if (other.idAsset != null)
				return false;
		} else if (!idAsset.equals(other.idAsset))
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
		return "VerificaComuneOffertaInfratelInputBean [idAsset=" + idAsset + ", codificaOloAgcom=" + codificaOloAgcom
				+ ", lavorazione=" + lavorazione
				+ ", codiceIstatComuneAsset=" + codiceIstatComuneAsset + ", indirizzoDatiClienteFinale="
				+ indirizzoDatiClienteFinale + "]";
	}
}
