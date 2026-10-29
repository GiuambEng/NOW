package com.nttdata.tim.now.data.dto.td;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class CodiceTdDTO implements Serializable {

    private static final long serialVersionUID = -6182402757966318793L;

    @JsonProperty("COD_KIT")
	private String codKit;
	
	@JsonProperty("CLLI")
	private String clli;

	@JsonProperty("ID_PRIME_CONTRACTOR")
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
		CodiceTdDTO other = (CodiceTdDTO) obj;
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
		return "CodiceTdDTO [codKit=" + codKit + ", clli=" + clli + ", idPrimeContractor=" + idPrimeContractor + "]";
	}


}
