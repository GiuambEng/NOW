package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class RecuperaCARInputBean implements Serializable{

	private static final long serialVersionUID = 7744968540897205850L;

	@JsonProperty("idOfferta")
	private String idOfferta;
	
	@JsonProperty("famigliaVLAN")
    private String famigliaVLAN;
	
	@JsonProperty("codiceTDKIT")
    private String codiceTDKIT;
	
	@JsonProperty("ftthOnly")
    private String ftthOnly;
	
	@JsonProperty("supermacroarea")
    private String supermacroarea;
	
	@JsonProperty("lavorazione")
    private String lavorazione;
	
	@JsonProperty("ccLib")
    private String ccLib;
	
	@JsonProperty("cos")
    private String cos;
	
	@JsonProperty("macroarea")
    private String macroArea;
	
	@JsonProperty("area")
    private String area;

	//SM_9917
	@JsonProperty("bmcLight")
    private String bmcLight;
	
	//SM_9825
	@JsonProperty("idAsset")
    private String idAsset;

	@JsonProperty("sottolavorazione")
    private String sottolavorazione;
	
	//RU_1502
	@JsonProperty("flagDRG")
    private String flagDRG;

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getFamigliaVLAN() {
		return famigliaVLAN;
	}

	public void setFamigliaVLAN(String famigliaVLAN) {
		this.famigliaVLAN = famigliaVLAN;
	}

	public String getCodiceTDKIT() {
		return codiceTDKIT;
	}

	public void setCodiceTDKIT(String codiceTDKIT) {
		this.codiceTDKIT = codiceTDKIT;
	}

	public String getFtthOnly() {
		return ftthOnly;
	}

	public void setFtthOnly(String ftthOnly) {
		this.ftthOnly = ftthOnly;
	}

	public String getSupermacroarea() {
		return supermacroarea;
	}

	public void setSupermacroarea(String supermacroarea) {
		this.supermacroarea = supermacroarea;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getCcLib() {
		return ccLib;
	}

	public void setCcLib(String ccLib) {
		this.ccLib = ccLib;
	}

	public String getCos() {
		return cos;
	}

	public void setCos(String cos) {
		this.cos = cos;
	}

	public String getMacroArea() {
		return macroArea;
	}

	public void setMacroArea(String macroArea) {
		this.macroArea = macroArea;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}

	public String getSottolavorazione() {
		return sottolavorazione;
	}

	public void setSottolavorazione(String sottolavorazione) {
		this.sottolavorazione = sottolavorazione;
	}

	public String getBmcLight() {
		return bmcLight;
	}

	public void setBmcLight(String bmcLight) {
		this.bmcLight = bmcLight;
	}

	public String getFlagDRG() {
		return flagDRG;
	}

	public void setFlagDRG(String flagDRG) {
		this.flagDRG = flagDRG;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((ccLib == null) ? 0 : ccLib.hashCode());
		result = prime * result + ((codiceTDKIT == null) ? 0 : codiceTDKIT.hashCode());
		result = prime * result + ((cos == null) ? 0 : cos.hashCode());
		result = prime * result + ((famigliaVLAN == null) ? 0 : famigliaVLAN.hashCode());
		result = prime * result + ((ftthOnly == null) ? 0 : ftthOnly.hashCode());
		result = prime * result + ((idAsset == null) ? 0 : idAsset.hashCode());
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((lavorazione == null) ? 0 : lavorazione.hashCode());
		result = prime * result + ((macroArea == null) ? 0 : macroArea.hashCode());
		result = prime * result + ((sottolavorazione == null) ? 0 : sottolavorazione.hashCode());
		result = prime * result + ((supermacroarea == null) ? 0 : supermacroarea.hashCode());
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
		RecuperaCARInputBean other = (RecuperaCARInputBean) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (ccLib == null) {
			if (other.ccLib != null)
				return false;
		} else if (!ccLib.equals(other.ccLib))
			return false;
		if (codiceTDKIT == null) {
			if (other.codiceTDKIT != null)
				return false;
		} else if (!codiceTDKIT.equals(other.codiceTDKIT))
			return false;
		if (cos == null) {
			if (other.cos != null)
				return false;
		} else if (!cos.equals(other.cos))
			return false;
		if (famigliaVLAN == null) {
			if (other.famigliaVLAN != null)
				return false;
		} else if (!famigliaVLAN.equals(other.famigliaVLAN))
			return false;
		if (ftthOnly == null) {
			if (other.ftthOnly != null)
				return false;
		} else if (!ftthOnly.equals(other.ftthOnly))
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
		if (lavorazione == null) {
			if (other.lavorazione != null)
				return false;
		} else if (!lavorazione.equals(other.lavorazione))
			return false;
		if (macroArea == null) {
			if (other.macroArea != null)
				return false;
		} else if (!macroArea.equals(other.macroArea))
			return false;
		if (sottolavorazione == null) {
			if (other.sottolavorazione != null)
				return false;
		} else if (!sottolavorazione.equals(other.sottolavorazione))
			return false;
		if (supermacroarea == null) {
			if (other.supermacroarea != null)
				return false;
		} else if (!supermacroarea.equals(other.supermacroarea))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaCARInputBean [idOfferta=" + idOfferta + ", famigliaVLAN=" + famigliaVLAN + ", codiceTDKIT="
				+ codiceTDKIT + ", ftthOnly=" + ftthOnly + ", supermacroarea=" + supermacroarea + ", lavorazione="
				+ lavorazione + ", ccLib=" + ccLib + ", cos=" + cos + ", macroArea=" + macroArea + ", area=" + area
				+ ", idAsset=" + idAsset + ", sottolavorazione=" + sottolavorazione + "]";
	}
}
