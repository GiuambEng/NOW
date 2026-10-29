package com.nttdata.tim.now.data.bean.anagraficaidullco;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class AnagraficaIdullcoOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 7671523834941011147L;

	@JsonProperty("idullco")
	private String idullco;

	@JsonProperty("clli")
	private String clli;

	@JsonProperty("codiceGAT")
	private String codiceGAT;

	@JsonProperty("codificaOAO")
	private String codificaOAO;

	@JsonProperty("drcp")
	private String drcp;

	@JsonProperty("centrale")
	private String centrale;

	public String getIdullco() {
		return idullco;
	}

	public void setIdullco(String idullco) {
		this.idullco = idullco;
	}

	public String getClli() {
		return clli;
	}

	public void setClli(String clli) {
		this.clli = clli;
	}

	public String getCodiceGAT() {
		return codiceGAT;
	}

	public void setCodiceGAT(String codiceGAT) {
		this.codiceGAT = codiceGAT;
	}

	public String getCodificaOAO() {
		return codificaOAO;
	}

	public void setCodificaOAO(String codificaOAO) {
		this.codificaOAO = codificaOAO;
	}

	public String getDrcp() {
		return drcp;
	}

	public void setDrcp(String drcp) {
		this.drcp = drcp;
	}

	public String getCentrale() {
		return centrale;
	}

	public void setCentrale(String centrale) {
		this.centrale = centrale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centrale == null) ? 0 : centrale.hashCode());
		result = prime * result + ((clli == null) ? 0 : clli.hashCode());
		result = prime * result + ((codiceGAT == null) ? 0 : codiceGAT.hashCode());
		result = prime * result + ((codificaOAO == null) ? 0 : codificaOAO.hashCode());
		result = prime * result + ((drcp == null) ? 0 : drcp.hashCode());
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
		AnagraficaIdullcoOutputBean other = (AnagraficaIdullcoOutputBean) obj;
		if (centrale == null) {
			if (other.centrale != null)
				return false;
		} else if (!centrale.equals(other.centrale))
			return false;
		if (clli == null) {
			if (other.clli != null)
				return false;
		} else if (!clli.equals(other.clli))
			return false;
		if (codiceGAT == null) {
			if (other.codiceGAT != null)
				return false;
		} else if (!codiceGAT.equals(other.codiceGAT))
			return false;
		if (codificaOAO == null) {
			if (other.codificaOAO != null)
				return false;
		} else if (!codificaOAO.equals(other.codificaOAO))
			return false;
		if (drcp == null) {
			if (other.drcp != null)
				return false;
		} else if (!drcp.equals(other.drcp))
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
		return "AnagraficaIdullcoOutputBean [idullco=" + idullco + ", clli=" + clli + ", codiceGAT=" + codiceGAT
				+ ", codificaOAO=" + codificaOAO + ", drcp=" + drcp + ", centrale=" + centrale + "]";
	}
	
	
}