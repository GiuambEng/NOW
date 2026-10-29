package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class VisualizzaCampiOfferteVLANOutputBean implements Serializable {

	private static final long serialVersionUID = 9118018521638037257L;

	@JsonProperty("codiceTDKit")
	private String codiceTDKit;
	
	@JsonProperty("clliCentrale")
    private String clliCentrale;
	
	@JsonProperty("banda")
    private String banda;

	@JsonProperty("profiloBMC")
    private String profiloBMC;
	
	@JsonProperty("area")
    private String area;
	
	@JsonProperty("idArea")
    private String idArea;
	
	@JsonProperty("macroarea")
    private String macroarea;
	
	@JsonProperty("idMacroarea")
    private String idMacroarea;
	
	//RU_1155
	@JsonProperty("bandaMulticos3")
    private String bandaMulticos3;

	@JsonProperty("bandaMulticos5")
    private String bandaMulticos5;

	public String getCodiceTDKit() {
		return codiceTDKit;
	}

	public void setCodiceTDKit(String codiceTDKit) {
		this.codiceTDKit = codiceTDKit;
	}

	public String getClliCentrale() {
		return clliCentrale;
	}

	public void setClliCentrale(String clliCentrale) {
		this.clliCentrale = clliCentrale;
	}

	public String getBanda() {
		return banda;
	}

	public void setBanda(String banda) {
		this.banda = banda;
	}

	public String getProfiloBMC() {
		return profiloBMC;
	}

	public void setProfiloBMC(String profiloBMC) {
		this.profiloBMC = profiloBMC;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getIdArea() {
		return idArea;
	}

	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}

	public String getMacroarea() {
		return macroarea;
	}

	public void setMacroarea(String macroarea) {
		this.macroarea = macroarea;
	}

	public String getIdMacroarea() {
		return idMacroarea;
	}

	public void setIdMacroarea(String idMacroarea) {
		this.idMacroarea = idMacroarea;
	}

	public String getBandaMulticos3() {
		return bandaMulticos3;
	}

	public String getBandaMulticos5() {
		return bandaMulticos5;
	}

	public void setBandaMulticos3(String bandaMulticos3) {
		this.bandaMulticos3 = bandaMulticos3;
	}

	public void setBandaMulticos5(String bandaMulticos5) {
		this.bandaMulticos5 = bandaMulticos5;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((banda == null) ? 0 : banda.hashCode());
		result = prime * result + ((bandaMulticos3 == null) ? 0 : bandaMulticos3.hashCode());
		result = prime * result + ((bandaMulticos5 == null) ? 0 : bandaMulticos5.hashCode());
		result = prime * result + ((clliCentrale == null) ? 0 : clliCentrale.hashCode());
		result = prime * result + ((codiceTDKit == null) ? 0 : codiceTDKit.hashCode());
		result = prime * result + ((idArea == null) ? 0 : idArea.hashCode());
		result = prime * result + ((idMacroarea == null) ? 0 : idMacroarea.hashCode());
		result = prime * result + ((macroarea == null) ? 0 : macroarea.hashCode());
		result = prime * result + ((profiloBMC == null) ? 0 : profiloBMC.hashCode());
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
		VisualizzaCampiOfferteVLANOutputBean other = (VisualizzaCampiOfferteVLANOutputBean) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (banda == null) {
			if (other.banda != null)
				return false;
		} else if (!banda.equals(other.banda))
			return false;
		if (bandaMulticos3 == null) {
			if (other.bandaMulticos3 != null)
				return false;
		} else if (!bandaMulticos3.equals(other.bandaMulticos3))
			return false;
		if (bandaMulticos5 == null) {
			if (other.bandaMulticos5 != null)
				return false;
		} else if (!bandaMulticos5.equals(other.bandaMulticos5))
			return false;
		if (clliCentrale == null) {
			if (other.clliCentrale != null)
				return false;
		} else if (!clliCentrale.equals(other.clliCentrale))
			return false;
		if (codiceTDKit == null) {
			if (other.codiceTDKit != null)
				return false;
		} else if (!codiceTDKit.equals(other.codiceTDKit))
			return false;
		if (idArea == null) {
			if (other.idArea != null)
				return false;
		} else if (!idArea.equals(other.idArea))
			return false;
		if (idMacroarea == null) {
			if (other.idMacroarea != null)
				return false;
		} else if (!idMacroarea.equals(other.idMacroarea))
			return false;
		if (macroarea == null) {
			if (other.macroarea != null)
				return false;
		} else if (!macroarea.equals(other.macroarea))
			return false;
		if (profiloBMC == null) {
			if (other.profiloBMC != null)
				return false;
		} else if (!profiloBMC.equals(other.profiloBMC))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VisualizzaCampiOfferteVLANOutputBean [codiceTDKit=" + codiceTDKit + ", clliCentrale=" + clliCentrale
				+ ", banda=" + banda + ", profiloBMC=" + profiloBMC + ", area=" + area + ", idArea=" + idArea
				+ ", macroarea=" + macroarea + ", idMacroarea=" + idMacroarea + ", bandaMulticos3=" + bandaMulticos3
				+ ", bandaMulticos5=" + bandaMulticos5 + "]";
	}

	
}
