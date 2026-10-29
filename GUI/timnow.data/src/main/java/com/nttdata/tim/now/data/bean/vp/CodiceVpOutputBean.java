package com.nttdata.tim.now.data.bean.vp;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CodiceVpOutputBean implements Serializable {
	private static final long serialVersionUID = 7810820499136322998L;

	@JsonProperty("codiceVP")
	private String codiceVP;

	@JsonProperty("clli")
	private String clli;

	@JsonProperty("nomeCentrale")
	private String nomeCentrale;

	public String getCodiceVP() {
		return codiceVP;
	}

	public void setCodiceVP(String codiceVP) {
		this.codiceVP = codiceVP;
	}

	public String getClli() {
		return clli;
	}

	public void setClli(String clli) {
		this.clli = clli;
	}

	public String getNomeCentrale() {
		return nomeCentrale;
	}

	public void setNomeCentrale(String nomeCentrale) {
		this.nomeCentrale = nomeCentrale;
	}
}
