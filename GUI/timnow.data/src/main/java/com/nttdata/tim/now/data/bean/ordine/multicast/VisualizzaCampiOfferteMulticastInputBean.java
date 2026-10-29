package com.nttdata.tim.now.data.bean.ordine.multicast;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1180
@JsonInclude(Include.NON_NULL)
public class VisualizzaCampiOfferteMulticastInputBean {

	@JsonProperty("nomeCampo")
	private String nomeCampo;
	
	@JsonProperty("descrArea")
    private String descrArea;
	
	@JsonProperty("clliFeeder")
    private String clliFeeder;
	
	@JsonProperty("codOloAgcom")
    private String codOloAgcom;
	
	@JsonProperty("idContratto")
    private String idContratto;
	
	@JsonProperty("flagPrimoFeeder")
    private String flagPrimoFeeder;

	public String getNomeCampo() {
		return nomeCampo;
	}

	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}

	public String getDescrArea() {
		return descrArea;
	}

	public void setDescrArea(String descrArea) {
		this.descrArea = descrArea;
	}

	public String getClliFeeder() {
		return clliFeeder;
	}

	public void setClliFeeder(String clliFeeder) {
		this.clliFeeder = clliFeeder;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(String idContratto) {
		this.idContratto = idContratto;
	}

	public String getFlagPrimoFeeder() {
		return flagPrimoFeeder;
	}

	public void setFlagPrimoFeeder(String flagPrimoFeeder) {
		this.flagPrimoFeeder = flagPrimoFeeder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clliFeeder == null) ? 0 : clliFeeder.hashCode());
		result = prime * result + ((codOloAgcom == null) ? 0 : codOloAgcom.hashCode());
		result = prime * result + ((descrArea == null) ? 0 : descrArea.hashCode());
		result = prime * result + ((flagPrimoFeeder == null) ? 0 : flagPrimoFeeder.hashCode());
		result = prime * result + ((idContratto == null) ? 0 : idContratto.hashCode());
		result = prime * result + ((nomeCampo == null) ? 0 : nomeCampo.hashCode());
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
		VisualizzaCampiOfferteMulticastInputBean other = (VisualizzaCampiOfferteMulticastInputBean) obj;
		if (clliFeeder == null) {
			if (other.clliFeeder != null)
				return false;
		} else if (!clliFeeder.equals(other.clliFeeder))
			return false;
		if (codOloAgcom == null) {
			if (other.codOloAgcom != null)
				return false;
		} else if (!codOloAgcom.equals(other.codOloAgcom))
			return false;
		if (descrArea == null) {
			if (other.descrArea != null)
				return false;
		} else if (!descrArea.equals(other.descrArea))
			return false;
		if (flagPrimoFeeder == null) {
			if (other.flagPrimoFeeder != null)
				return false;
		} else if (!flagPrimoFeeder.equals(other.flagPrimoFeeder))
			return false;
		if (idContratto == null) {
			if (other.idContratto != null)
				return false;
		} else if (!idContratto.equals(other.idContratto))
			return false;
		if (nomeCampo == null) {
			if (other.nomeCampo != null)
				return false;
		} else if (!nomeCampo.equals(other.nomeCampo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VisualizzaCampiOfferteMulticastInputBean [nomeCampo=" + nomeCampo + ", descrArea=" + descrArea
				+ ", clliFeeder=" + clliFeeder + ", codOloAgcom=" + codOloAgcom + ", idContratto=" + idContratto
				+ ", flagPrimoFeeder=" + flagPrimoFeeder + "]";
	}
}
