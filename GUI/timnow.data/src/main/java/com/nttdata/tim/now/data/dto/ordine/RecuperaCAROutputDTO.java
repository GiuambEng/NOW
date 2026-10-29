package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecuperaCAROutputDTO implements Serializable {

	private static final long serialVersionUID = -250243407253670059L;

	@JsonProperty("aggregatoBMCLight")
	private String aggregatoBMCLight;

	@JsonProperty("ftthOnly")
	private String ftthOnly;

	@JsonProperty("codiceCAR")
	private String codiceCAR;

	@JsonProperty("tipologiaComune")
	private String tipologiaComune;

	@JsonProperty("macroArea")
	private String macroArea;

	// RU_1155
	@JsonProperty("bandaCar")
	private String bandaCar;

	// RU_1502
	@JsonProperty("DRG")
	private String DRG;

	public String getAggregatoBMCLight() {
		return aggregatoBMCLight;
	}

	public String getFtthOnly() {
		return ftthOnly;
	}

	public String getCodiceCAR() {
		return codiceCAR;
	}

	public String getTipologiaComune() {
		return tipologiaComune;
	}

	public String getMacroArea() {
		return macroArea;
	}

	public void setAggregatoBMCLight(String aggregatoBMCLight) {
		this.aggregatoBMCLight = aggregatoBMCLight;
	}

	public void setFtthOnly(String ftthOnly) {
		this.ftthOnly = ftthOnly;
	}

	public void setCodiceCAR(String codiceCAR) {
		this.codiceCAR = codiceCAR;
	}

	public void setTipologiaComune(String tipologiaComune) {
		this.tipologiaComune = tipologiaComune;
	}

	public void setMacroArea(String macroArea) {
		this.macroArea = macroArea;
	}

	public String getBandaCar() {
		return bandaCar;
	}

	public void setBandaCar(String bandaCar) {
		this.bandaCar = bandaCar;
	}

	public String getDRG() {
		return DRG;
	}

	public void setDRG(String dRG) {
		DRG = dRG;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aggregatoBMCLight == null) ? 0 : aggregatoBMCLight.hashCode());
		result = prime * result + ((bandaCar == null) ? 0 : bandaCar.hashCode());
		result = prime * result + ((codiceCAR == null) ? 0 : codiceCAR.hashCode());
		result = prime * result + ((ftthOnly == null) ? 0 : ftthOnly.hashCode());
		result = prime * result + ((macroArea == null) ? 0 : macroArea.hashCode());
		result = prime * result + ((tipologiaComune == null) ? 0 : tipologiaComune.hashCode());
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
		RecuperaCAROutputDTO other = (RecuperaCAROutputDTO) obj;
		if (aggregatoBMCLight == null) {
			if (other.aggregatoBMCLight != null)
				return false;
		} else if (!aggregatoBMCLight.equals(other.aggregatoBMCLight))
			return false;
		if (bandaCar == null) {
			if (other.bandaCar != null)
				return false;
		} else if (!bandaCar.equals(other.bandaCar))
			return false;
		if (codiceCAR == null) {
			if (other.codiceCAR != null)
				return false;
		} else if (!codiceCAR.equals(other.codiceCAR))
			return false;
		if (ftthOnly == null) {
			if (other.ftthOnly != null)
				return false;
		} else if (!ftthOnly.equals(other.ftthOnly))
			return false;
		if (macroArea == null) {
			if (other.macroArea != null)
				return false;
		} else if (!macroArea.equals(other.macroArea))
			return false;
		if (tipologiaComune == null) {
			if (other.tipologiaComune != null)
				return false;
		} else if (!tipologiaComune.equals(other.tipologiaComune))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaCAROutputDTO [aggregatoBMCLight=" + aggregatoBMCLight + ", ftthOnly=" + ftthOnly
				+ ", codiceCAR=" + codiceCAR + ", tipologiaComune=" + tipologiaComune + ", macroArea=" + macroArea
				+ ", bandaCar=" + bandaCar + "]";
	}
}
