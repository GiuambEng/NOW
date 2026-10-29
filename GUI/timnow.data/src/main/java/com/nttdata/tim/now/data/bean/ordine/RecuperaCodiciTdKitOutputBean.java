package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//SM_9825
@JsonInclude(Include.NON_NULL)
public class RecuperaCodiciTdKitOutputBean implements Serializable {

	private static final long serialVersionUID = -790326273275809897L;

	@JsonProperty("codiceTdKit")
    private String codiceTdKit;

    @JsonProperty("modelloKit")
    private String modelloKit;

    @JsonProperty("clli")
    private String clli;

	public String getCodiceTdKit() {
		return codiceTdKit;
	}

	public String getModelloKit() {
		return modelloKit;
	}

	public String getClli() {
		return clli;
	}

	public void setCodiceTdKit(String codiceTdKit) {
		this.codiceTdKit = codiceTdKit;
	}

	public void setModelloKit(String modelloKit) {
		this.modelloKit = modelloKit;
	}

	public void setClli(String clli) {
		this.clli = clli;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clli == null) ? 0 : clli.hashCode());
		result = prime * result + ((codiceTdKit == null) ? 0 : codiceTdKit.hashCode());
		result = prime * result + ((modelloKit == null) ? 0 : modelloKit.hashCode());
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
		RecuperaCodiciTdKitOutputBean other = (RecuperaCodiciTdKitOutputBean) obj;
		if (clli == null) {
			if (other.clli != null)
				return false;
		} else if (!clli.equals(other.clli))
			return false;
		if (codiceTdKit == null) {
			if (other.codiceTdKit != null)
				return false;
		} else if (!codiceTdKit.equals(other.codiceTdKit))
			return false;
		if (modelloKit == null) {
			if (other.modelloKit != null)
				return false;
		} else if (!modelloKit.equals(other.modelloKit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaCodiciTdKitOutputBean [codiceTdKit=" + codiceTdKit + ", modelloKit=" + modelloKit + ", clli="
				+ clli + "]";
	}

}