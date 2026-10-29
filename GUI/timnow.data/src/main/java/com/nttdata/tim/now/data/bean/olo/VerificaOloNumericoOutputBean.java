package com.nttdata.tim.now.data.bean.olo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class VerificaOloNumericoOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = 8898411025295802739L;

	@JsonProperty("esito")
	private String esito;

	@JsonProperty("codiciOlo")
	private List<CodiceOloOutputBean> codiciOlo;

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public List<CodiceOloOutputBean> getCodiciOlo() {
		return codiciOlo;
	}

	public void setCodiciOlo(List<CodiceOloOutputBean> codiciOlo) {
		this.codiciOlo = codiciOlo;
	}

	@Override
	public String toString() {
		return "VerificaOloNumericoOutputBean [esito=" + esito + ", codiciOlo=" + codiciOlo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiciOlo == null) ? 0 : codiciOlo.hashCode());
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
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
		VerificaOloNumericoOutputBean other = (VerificaOloNumericoOutputBean) obj;
		if (codiciOlo == null) {
			if (other.codiciOlo != null)
				return false;
		} else if (!codiciOlo.equals(other.codiciOlo))
			return false;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
			return false;
		return true;
	}

}
