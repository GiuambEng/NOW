package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecuperaCodiceServizioSystemUnicoInputBean implements Serializable {

	private static final long serialVersionUID = -5205168316604935111L;
	
	@JsonProperty("codificaOloAgcom")
	private String codificaOloAgcom;
	
	@JsonProperty("idullco")
	private String idullco;
	
	@JsonProperty("idsluco")
	private String idsluco;
	
	@JsonProperty("idOfferta")
	private String idOfferta;
	
	@JsonProperty("datiClienteFinale")
	private IndirizzoDatiClienteFinaleInputBean datiClienteFinale;
	
	@JsonProperty("flagCodiceServizio")
	boolean flagCodiceServizio;
	
	@JsonProperty("RU1560")
	private String ru1560;

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getIdullco() {
		return idullco;
	}

	public void setIdullco(String idullco) {
		this.idullco = idullco;
	}

	public String getIdsluco() {
		return idsluco;
	}

	public void setIdsluco(String idsluco) {
		this.idsluco = idsluco;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public IndirizzoDatiClienteFinaleInputBean getDatiClienteFinale() {
		return datiClienteFinale;
	}

	public void setDatiClienteFinale(IndirizzoDatiClienteFinaleInputBean datiClienteFinale) {
		this.datiClienteFinale = datiClienteFinale;
	}

	public boolean isFlagCodiceServizio() {
		return flagCodiceServizio;
	}

	public void setFlagCodiceServizio(boolean flagCodiceServizio) {
		this.flagCodiceServizio = flagCodiceServizio;
	}
	
	public void setRu1560(String ru1560) {
		this.ru1560 = ru1560;
	}
	
	public String getRu1560() {
		return this.ru1560;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codificaOloAgcom == null) ? 0 : codificaOloAgcom.hashCode());
		result = prime * result + ((datiClienteFinale == null) ? 0 : datiClienteFinale.hashCode());
		result = prime * result + (flagCodiceServizio ? 1231 : 1237);
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((idsluco == null) ? 0 : idsluco.hashCode());
		result = prime * result + ((idullco == null) ? 0 : idullco.hashCode());
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
		RecuperaCodiceServizioSystemUnicoInputBean other = (RecuperaCodiceServizioSystemUnicoInputBean) obj;
		if (codificaOloAgcom == null) {
			if (other.codificaOloAgcom != null)
				return false;
		} else if (!codificaOloAgcom.equals(other.codificaOloAgcom))
			return false;
		if (datiClienteFinale == null) {
			if (other.datiClienteFinale != null)
				return false;
		} else if (!datiClienteFinale.equals(other.datiClienteFinale))
			return false;
		if (flagCodiceServizio != other.flagCodiceServizio)
			return false;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		if (idsluco == null) {
			if (other.idsluco != null)
				return false;
		} else if (!idsluco.equals(other.idsluco))
			return false;
		if (idullco == null) {
			if (other.idullco != null)
				return false;
		} else if (!idullco.equals(other.idullco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaCodiceServizioSystemUnicoInputBean [codificaOloAgcom=" + codificaOloAgcom + ", idullco="
				+ idullco + ", idsluco=" + idsluco + ", idOfferta=" + idOfferta + ", datiClienteFinale="
				+ datiClienteFinale + ", flagCodiceServizio=" + flagCodiceServizio + "]";
	}
	
}
