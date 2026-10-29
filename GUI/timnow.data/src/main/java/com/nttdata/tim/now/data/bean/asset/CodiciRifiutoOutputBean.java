package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class CodiciRifiutoOutputBean implements Serializable {

	private static final long serialVersionUID = -7826323094726902647L;

	@JsonProperty("codiceMotivoRifiuto")
	private String codiceMotivoRifiuto;

	@JsonProperty("motivoRifiuto")
	private String motivoRifiuto;

	public String getCodiceMotivoRifiuto() {
		return codiceMotivoRifiuto;
	}

	public void setCodiceMotivoRifiuto(String codiceMotivoRifiuto) {
		this.codiceMotivoRifiuto = codiceMotivoRifiuto;
	}

	public String getMotivoRifiuto() {
		return motivoRifiuto;
	}

	public void setMotivoRifiuto(String motivoRifiuto) {
		this.motivoRifiuto = motivoRifiuto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceMotivoRifiuto == null) ? 0 : codiceMotivoRifiuto.hashCode());
		result = prime * result + ((motivoRifiuto == null) ? 0 : motivoRifiuto.hashCode());
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
		CodiciRifiutoOutputBean other = (CodiciRifiutoOutputBean) obj;
		if (codiceMotivoRifiuto == null) {
			if (other.codiceMotivoRifiuto != null)
				return false;
		} else if (!codiceMotivoRifiuto.equals(other.codiceMotivoRifiuto))
			return false;
		if (motivoRifiuto == null) {
			if (other.motivoRifiuto != null)
				return false;
		} else if (!motivoRifiuto.equals(other.motivoRifiuto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CodiciRifiutoOutputBean [codiceMotivoRifiuto=" + codiceMotivoRifiuto + ", motivoRifiuto="
				+ motivoRifiuto + "]";
	}


}