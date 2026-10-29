package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class RecuperaCampiOffertaVPOutputBean implements Serializable {

	private static final long serialVersionUID = -6590521247351072102L;

	@JsonProperty("codiceKit")
	private String codiceKit;
	
	@JsonProperty("mcr")
	private String mcr;
	
	@JsonProperty("pcr")
    private String pcr;
	
	@JsonProperty("idAdrCrmws")
    private String idAdrCrmws;
	
	@JsonProperty("descrizioneArea")
    private String descrizioneArea;

	@JsonProperty("clliCentrale")
    private String clliCentrale;
	
	public String getCodiceKit() {
		return codiceKit;
	}

	public void setCodiceKit(String codiceKit) {
		this.codiceKit = codiceKit;
	}

	public String getMcr() {
		return mcr;
	}

	public void setMcr(String mcr) {
		this.mcr = mcr;
	}

	public String getPcr() {
		return pcr;
	}

	public void setPcr(String pcr) {
		this.pcr = pcr;
	}

	public String getIdAdrCrmws() {
		return idAdrCrmws;
	}

	public void setIdAdrCrmws(String idAdrCrmws) {
		this.idAdrCrmws = idAdrCrmws;
	}

	public String getDescrizioneArea() {
		return descrizioneArea;
	}

	public void setDescrizioneArea(String descrizioneArea) {
		this.descrizioneArea = descrizioneArea;
	}

	public String getClliCentrale() {
		return clliCentrale;
	}

	public void setClliCentrale(String clliCentrale) {
		this.clliCentrale = clliCentrale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clliCentrale == null) ? 0 : clliCentrale.hashCode());
		result = prime * result + ((codiceKit == null) ? 0 : codiceKit.hashCode());
		result = prime * result + ((descrizioneArea == null) ? 0 : descrizioneArea.hashCode());
		result = prime * result + ((idAdrCrmws == null) ? 0 : idAdrCrmws.hashCode());
		result = prime * result + ((mcr == null) ? 0 : mcr.hashCode());
		result = prime * result + ((pcr == null) ? 0 : pcr.hashCode());
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
		RecuperaCampiOffertaVPOutputBean other = (RecuperaCampiOffertaVPOutputBean) obj;
		if (clliCentrale == null) {
			if (other.clliCentrale != null)
				return false;
		} else if (!clliCentrale.equals(other.clliCentrale))
			return false;
		if (codiceKit == null) {
			if (other.codiceKit != null)
				return false;
		} else if (!codiceKit.equals(other.codiceKit))
			return false;
		if (descrizioneArea == null) {
			if (other.descrizioneArea != null)
				return false;
		} else if (!descrizioneArea.equals(other.descrizioneArea))
			return false;
		if (idAdrCrmws == null) {
			if (other.idAdrCrmws != null)
				return false;
		} else if (!idAdrCrmws.equals(other.idAdrCrmws))
			return false;
		if (mcr == null) {
			if (other.mcr != null)
				return false;
		} else if (!mcr.equals(other.mcr))
			return false;
		if (pcr == null) {
			if (other.pcr != null)
				return false;
		} else if (!pcr.equals(other.pcr))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaCampiOffertaVPOutputBean [codiceKit=" + codiceKit + ", mcr=" + mcr + ", pcr=" + pcr
				+ ", idAdrCrmws=" + idAdrCrmws + ", descrizioneArea=" + descrizioneArea + ", clliCentrale="
				+ clliCentrale + "]";
	}
	
}
