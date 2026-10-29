package com.nttdata.tim.now.data.bean.td;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class CodiceTdBean extends AbstractOutputBean {

    private static final long serialVersionUID = -8339459720320752359L;

    @JsonProperty("codKit")
	private String codKit;

	@JsonProperty("clli")
	private String clli;

	@JsonProperty("idPrimeContractor")
	private String idPrimeContractor;

	public String getCodKit() {
		return codKit;
	}

	public void setCodKit(String codKit) {
		this.codKit = codKit;
	}

	public String getClli() {
		return clli;
	}

	public void setClli(String clli) {
		this.clli = clli;
	}

	public String getIdPrimeContractor() {
		return idPrimeContractor;
	}

	public void setIdPrimeContractor(String idPrimeContractor) {
		this.idPrimeContractor = idPrimeContractor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clli == null) ? 0 : clli.hashCode());
		result = prime * result + ((codKit == null) ? 0 : codKit.hashCode());
		result = prime * result + ((idPrimeContractor == null) ? 0 : idPrimeContractor.hashCode());
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
		CodiceTdBean other = (CodiceTdBean) obj;
		if (clli == null) {
			if (other.clli != null)
				return false;
		} else if (!clli.equals(other.clli))
			return false;
		if (codKit == null) {
			if (other.codKit != null)
				return false;
		} else if (!codKit.equals(other.codKit))
			return false;
		if (idPrimeContractor == null) {
			if (other.idPrimeContractor != null)
				return false;
		} else if (!idPrimeContractor.equals(other.idPrimeContractor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CodiceTdBean [codKit=" + codKit + ", clli=" + clli + ", idPrimeContractor=" + idPrimeContractor + "]";
	}


}
