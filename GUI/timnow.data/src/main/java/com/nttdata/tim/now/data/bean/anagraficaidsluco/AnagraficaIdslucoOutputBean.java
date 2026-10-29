package com.nttdata.tim.now.data.bean.anagraficaidsluco;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class AnagraficaIdslucoOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 4469799389064434927L;

	@JsonProperty("idsluco")
	private String idsluco;

	@JsonProperty("clli")
	private String clli;

	@JsonProperty("da")
	private String da;

	@JsonProperty("a")
	private String a;

	@JsonProperty("codificaOAO")
	private String codificaOAO;

	public String getIdsluco() {
		return idsluco;
	}

	public void setIdsluco(String idsluco) {
		this.idsluco = idsluco;
	}

	public String getClli() {
		return clli;
	}

	public void setClli(String clli) {
		this.clli = clli;
	}

	public String getDa() {
		return da;
	}

	public void setDa(String da) {
		this.da = da;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getCodificaOAO() {
		return codificaOAO;
	}

	public void setCodificaOAO(String codificaOAO) {
		this.codificaOAO = codificaOAO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((clli == null) ? 0 : clli.hashCode());
		result = prime * result + ((codificaOAO == null) ? 0 : codificaOAO.hashCode());
		result = prime * result + ((da == null) ? 0 : da.hashCode());
		result = prime * result + ((idsluco == null) ? 0 : idsluco.hashCode());
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
		AnagraficaIdslucoOutputBean other = (AnagraficaIdslucoOutputBean) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (clli == null) {
			if (other.clli != null)
				return false;
		} else if (!clli.equals(other.clli))
			return false;
		if (codificaOAO == null) {
			if (other.codificaOAO != null)
				return false;
		} else if (!codificaOAO.equals(other.codificaOAO))
			return false;
		if (da == null) {
			if (other.da != null)
				return false;
		} else if (!da.equals(other.da))
			return false;
		if (idsluco == null) {
			if (other.idsluco != null)
				return false;
		} else if (!idsluco.equals(other.idsluco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AnagraficaIdslucoOutputBean [idsluco=" + idsluco + ", clli=" + clli + ", da=" + da + ", a=" + a
				+ ", codificaOAO=" + codificaOAO + "]";
	}

	
}