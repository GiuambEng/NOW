package com.nttdata.tim.now.data.dto.ordine.npng;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1203
@JsonInclude(Include.NON_NULL)
public class RicercaOrdiniNpngInputDTO implements Serializable {

	private static final long serialVersionUID = -8587629631189282066L;

	@JsonProperty("oao")
	private String oao;
	
	@JsonProperty("codOrdineOlo")
    private String codOrdineOlo;
	
	@JsonProperty("codOrdineTi")
    private String codOrdineTi;
	
	@JsonProperty("dn")
    private String dn;

	public String getOao() {
		return oao;
	}

	public void setOao(String oao) {
		this.oao = oao;
	}

	public String getCodOrdineOlo() {
		return codOrdineOlo;
	}

	public void setCodOrdineOlo(String codOrdineOlo) {
		this.codOrdineOlo = codOrdineOlo;
	}

	public String getCodOrdineTi() {
		return codOrdineTi;
	}

	public void setCodOrdineTi(String codOrdineTi) {
		this.codOrdineTi = codOrdineTi;
	}

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}
}
