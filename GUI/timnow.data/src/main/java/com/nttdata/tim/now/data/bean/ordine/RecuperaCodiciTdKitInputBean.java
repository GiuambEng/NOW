package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//SM_9825
@JsonInclude(Include.NON_NULL)
public class RecuperaCodiciTdKitInputBean implements Serializable {

	private static final long serialVersionUID = -4590582444220314641L;

	@JsonProperty("lavorazione")
	private String lavorazione;
	
	@JsonProperty("famigliaVlan")
    private String famigliaVlan;
	
	@JsonProperty("cos")
    private String cos;
	
	@JsonProperty("codiceTdKitAsset")
    private String codiceTdKitAsset;
	
	@JsonProperty("codOloAgcom")
    private String codOloAgcom;
	
	//RU_1166
	@JsonProperty("supermacroarea")
    private String superMacroArea;
	
	@JsonProperty("ccLib")
    private String ccLib;
	
	@JsonProperty("bmcLight")
    private String bmcLight;
	
	@JsonProperty("idOfferta")
    private String idOfferta;

	public String getLavorazione() {
		return lavorazione;
	}

	public String getFamigliaVlan() {
		return famigliaVlan;
	}

	public String getCos() {
		return cos;
	}

	public String getCodiceTdKitAsset() {
		return codiceTdKitAsset;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public void setFamigliaVlan(String famigliaVlan) {
		this.famigliaVlan = famigliaVlan;
	}

	public void setCos(String cos) {
		this.cos = cos;
	}

	public void setCodiceTdKitAsset(String codiceTdKitAsset) {
		this.codiceTdKitAsset = codiceTdKitAsset;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getSuperMacroArea() {
		return superMacroArea;
	}

	public String getCcLib() {
		return ccLib;
	}

	public String getBmcLight() {
		return bmcLight;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setSuperMacroArea(String superMacroArea) {
		this.superMacroArea = superMacroArea;
	}

	public void setCcLib(String ccLib) {
		this.ccLib = ccLib;
	}

	public void setBmcLight(String bmcLight) {
		this.bmcLight = bmcLight;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bmcLight == null) ? 0 : bmcLight.hashCode());
		result = prime * result + ((ccLib == null) ? 0 : ccLib.hashCode());
		result = prime * result + ((codOloAgcom == null) ? 0 : codOloAgcom.hashCode());
		result = prime * result + ((codiceTdKitAsset == null) ? 0 : codiceTdKitAsset.hashCode());
		result = prime * result + ((cos == null) ? 0 : cos.hashCode());
		result = prime * result + ((famigliaVlan == null) ? 0 : famigliaVlan.hashCode());
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((lavorazione == null) ? 0 : lavorazione.hashCode());
		result = prime * result + ((superMacroArea == null) ? 0 : superMacroArea.hashCode());
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
		RecuperaCodiciTdKitInputBean other = (RecuperaCodiciTdKitInputBean) obj;
		if (bmcLight == null) {
			if (other.bmcLight != null)
				return false;
		} else if (!bmcLight.equals(other.bmcLight))
			return false;
		if (ccLib == null) {
			if (other.ccLib != null)
				return false;
		} else if (!ccLib.equals(other.ccLib))
			return false;
		if (codOloAgcom == null) {
			if (other.codOloAgcom != null)
				return false;
		} else if (!codOloAgcom.equals(other.codOloAgcom))
			return false;
		if (codiceTdKitAsset == null) {
			if (other.codiceTdKitAsset != null)
				return false;
		} else if (!codiceTdKitAsset.equals(other.codiceTdKitAsset))
			return false;
		if (cos == null) {
			if (other.cos != null)
				return false;
		} else if (!cos.equals(other.cos))
			return false;
		if (famigliaVlan == null) {
			if (other.famigliaVlan != null)
				return false;
		} else if (!famigliaVlan.equals(other.famigliaVlan))
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
		if (superMacroArea == null) {
			if (other.superMacroArea != null)
				return false;
		} else if (!superMacroArea.equals(other.superMacroArea))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaCodiciTdKitInputBean [lavorazione=" + lavorazione + ", famigliaVlan=" + famigliaVlan + ", cos="
				+ cos + ", codiceTdKitAsset=" + codiceTdKitAsset + ", codOloAgcom=" + codOloAgcom + ", superMacroArea="
				+ superMacroArea + ", ccLib=" + ccLib + ", bmcLight=" + bmcLight + ", idOfferta=" + idOfferta + "]";
	}
}
