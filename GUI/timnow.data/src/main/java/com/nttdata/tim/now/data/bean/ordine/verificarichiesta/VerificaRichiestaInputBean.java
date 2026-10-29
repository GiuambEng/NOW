package com.nttdata.tim.now.data.bean.ordine.verificarichiesta;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class VerificaRichiestaInputBean implements Serializable {

	private static final long serialVersionUID = 2033728774006425776L;
	private String causaleRichiesta;
	private String codiceRichiesta;
	private String ordineTIRichiestaOlo;
	private String dad;
	private String dac;
	private String fasciaOraria;
	public String getCausaleRichiesta() {
		return causaleRichiesta;
	}
	public void setCausaleRichiesta(String causaleRichiesta) {
		this.causaleRichiesta = causaleRichiesta;
	}
	public String getCodiceRichiesta() {
		return codiceRichiesta;
	}
	public void setCodiceRichiesta(String codiceRichiesta) {
		this.codiceRichiesta = codiceRichiesta;
	}
	public String getOrdineTIRichiestaOlo() {
		return ordineTIRichiestaOlo;
	}
	public void setOrdineTIRichiestaOlo(String ordineTIRichiestaOlo) {
		this.ordineTIRichiestaOlo = ordineTIRichiestaOlo;
	}
	public String getDad() {
		return dad;
	}
	public void setDad(String dad) {
		this.dad = dad;
	}
	public String getDac() {
		return dac;
	}
	public void setDac(String dac) {
		this.dac = dac;
	}
	public String getFasciaOraria() {
		return fasciaOraria;
	}
	public void setFasciaOraria(String fasciaOraria) {
		this.fasciaOraria = fasciaOraria;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((causaleRichiesta == null) ? 0 : causaleRichiesta.hashCode());
		result = prime * result + ((codiceRichiesta == null) ? 0 : codiceRichiesta.hashCode());
		result = prime * result + ((dac == null) ? 0 : dac.hashCode());
		result = prime * result + ((dad == null) ? 0 : dad.hashCode());
		result = prime * result + ((fasciaOraria == null) ? 0 : fasciaOraria.hashCode());
		result = prime * result + ((ordineTIRichiestaOlo == null) ? 0 : ordineTIRichiestaOlo.hashCode());
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
		VerificaRichiestaInputBean other = (VerificaRichiestaInputBean) obj;
		if (causaleRichiesta == null) {
			if (other.causaleRichiesta != null)
				return false;
		} else if (!causaleRichiesta.equals(other.causaleRichiesta))
			return false;
		if (codiceRichiesta == null) {
			if (other.codiceRichiesta != null)
				return false;
		} else if (!codiceRichiesta.equals(other.codiceRichiesta))
			return false;
		if (dac == null) {
			if (other.dac != null)
				return false;
		} else if (!dac.equals(other.dac))
			return false;
		if (dad == null) {
			if (other.dad != null)
				return false;
		} else if (!dad.equals(other.dad))
			return false;
		if (fasciaOraria == null) {
			if (other.fasciaOraria != null)
				return false;
		} else if (!fasciaOraria.equals(other.fasciaOraria))
			return false;
		if (ordineTIRichiestaOlo == null) {
			if (other.ordineTIRichiestaOlo != null)
				return false;
		} else if (!ordineTIRichiestaOlo.equals(other.ordineTIRichiestaOlo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "VerificaRichiestaInputBean [causaleRichiesta=" + causaleRichiesta + ", codiceRichiesta="
				+ codiceRichiesta + ", ordineTIRichiestaOlo=" + ordineTIRichiestaOlo + ", dad=" + dad + ", dac=" + dac
				+ ", fasciaOraria=" + fasciaOraria + "]";
	}
	
	
	
	
}