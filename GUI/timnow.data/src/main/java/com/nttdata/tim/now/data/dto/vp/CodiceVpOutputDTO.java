package com.nttdata.tim.now.data.dto.vp;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class CodiceVpOutputDTO implements Serializable {
	
	private static final long serialVersionUID = 4165231230505430062L;

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
