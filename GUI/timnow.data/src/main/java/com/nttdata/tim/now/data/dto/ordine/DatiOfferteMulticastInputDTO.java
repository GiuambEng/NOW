package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1180
@JsonInclude(Include.NON_NULL)
public class DatiOfferteMulticastInputDTO implements Serializable {

	private static final long serialVersionUID = -1341931208585572372L;

	@JsonProperty("idVlanOlo")
	private Integer idVlanOlo;
	
	@JsonProperty("codiceTdKit")
	private String codiceTdKit;

	@JsonProperty("clliFeeder")
	private String clliFeeder;
	
	@JsonProperty("asNumber")
	private String asNumber;
	
	@JsonProperty("macroArea")
	private String macroArea;

	@JsonProperty("bandaFeeder")
	private String bandaFeeder;
	
	@JsonProperty("ipSessione")
	private String ipSessione;
	
	@JsonProperty("primoFeeder")
	private String primoFeeder;
	
	//RU_1205
	@JsonProperty("clliFeederSuccessivi")
	private List<ClliFeederSuccessivoInputDTO> clliFeederSuccessivi;

	public Integer getIdVlanOlo() {
		return idVlanOlo;
	}

	public void setIdVlanOlo(Integer idVlanOlo) {
		this.idVlanOlo = idVlanOlo;
	}

	public String getCodiceTdKit() {
		return codiceTdKit;
	}

	public void setCodiceTdKit(String codiceTdKit) {
		this.codiceTdKit = codiceTdKit;
	}

	public String getClliFeeder() {
		return clliFeeder;
	}

	public void setClliFeeder(String clliFeeder) {
		this.clliFeeder = clliFeeder;
	}

	public String getAsNumber() {
		return asNumber;
	}

	public void setAsNumber(String asNumber) {
		this.asNumber = asNumber;
	}

	public String getMacroArea() {
		return macroArea;
	}

	public void setMacroArea(String macroArea) {
		this.macroArea = macroArea;
	}

	public String getBandaFeeder() {
		return bandaFeeder;
	}

	public void setBandaFeeder(String bandaFeeder) {
		this.bandaFeeder = bandaFeeder;
	}

	public String getIpSessione() {
		return ipSessione;
	}

	public void setIpSessione(String ipSessione) {
		this.ipSessione = ipSessione;
	}

	public String getPrimoFeeder() {
		return primoFeeder;
	}

	public void setPrimoFeeder(String primoFeeder) {
		this.primoFeeder = primoFeeder;
	}

	public List<ClliFeederSuccessivoInputDTO> getClliFeederSuccessivi() {
		return clliFeederSuccessivi;
	}

	public void setClliFeederSuccessivi(List<ClliFeederSuccessivoInputDTO> clliFeederSuccessivi) {
		this.clliFeederSuccessivi = clliFeederSuccessivi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asNumber == null) ? 0 : asNumber.hashCode());
		result = prime * result + ((bandaFeeder == null) ? 0 : bandaFeeder.hashCode());
		result = prime * result + ((clliFeeder == null) ? 0 : clliFeeder.hashCode());
		result = prime * result + ((clliFeederSuccessivi == null) ? 0 : clliFeederSuccessivi.hashCode());
		result = prime * result + ((codiceTdKit == null) ? 0 : codiceTdKit.hashCode());
		result = prime * result + ((idVlanOlo == null) ? 0 : idVlanOlo.hashCode());
		result = prime * result + ((ipSessione == null) ? 0 : ipSessione.hashCode());
		result = prime * result + ((macroArea == null) ? 0 : macroArea.hashCode());
		result = prime * result + ((primoFeeder == null) ? 0 : primoFeeder.hashCode());
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
		DatiOfferteMulticastInputDTO other = (DatiOfferteMulticastInputDTO) obj;
		if (asNumber == null) {
			if (other.asNumber != null)
				return false;
		} else if (!asNumber.equals(other.asNumber))
			return false;
		if (bandaFeeder == null) {
			if (other.bandaFeeder != null)
				return false;
		} else if (!bandaFeeder.equals(other.bandaFeeder))
			return false;
		if (clliFeeder == null) {
			if (other.clliFeeder != null)
				return false;
		} else if (!clliFeeder.equals(other.clliFeeder))
			return false;
		if (clliFeederSuccessivi == null) {
			if (other.clliFeederSuccessivi != null)
				return false;
		} else if (!clliFeederSuccessivi.equals(other.clliFeederSuccessivi))
			return false;
		if (codiceTdKit == null) {
			if (other.codiceTdKit != null)
				return false;
		} else if (!codiceTdKit.equals(other.codiceTdKit))
			return false;
		if (idVlanOlo == null) {
			if (other.idVlanOlo != null)
				return false;
		} else if (!idVlanOlo.equals(other.idVlanOlo))
			return false;
		if (ipSessione == null) {
			if (other.ipSessione != null)
				return false;
		} else if (!ipSessione.equals(other.ipSessione))
			return false;
		if (macroArea == null) {
			if (other.macroArea != null)
				return false;
		} else if (!macroArea.equals(other.macroArea))
			return false;
		if (primoFeeder == null) {
			if (other.primoFeeder != null)
				return false;
		} else if (!primoFeeder.equals(other.primoFeeder))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatiOfferteMulticastInputDTO [idVlanOlo=" + idVlanOlo + ", codiceTdKit=" + codiceTdKit + ", clliFeeder="
				+ clliFeeder + ", asNumber=" + asNumber + ", macroArea=" + macroArea + ", bandaFeeder=" + bandaFeeder
				+ ", ipSessione=" + ipSessione + ", primoFeeder=" + primoFeeder + ", clliFeederSuccessivi="
				+ clliFeederSuccessivi + "]";
	}

	
}
