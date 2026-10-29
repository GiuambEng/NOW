package com.nttdata.tim.now.data.dto.ordine.npng;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1203
@JsonInclude(Include.NON_NULL)
public class RicercaOrdiniNpngOutputDTO implements Serializable {

	private static final long serialVersionUID = -7152801394419585772L;

	@JsonProperty("codOrdineOlo")
	private String codOrdineOlo;
	
	@JsonProperty("stato")
	private String stato;

	@JsonProperty("olo")
	private String olo;
	
	@JsonProperty("idOrdine")
	private String idOrdine;
	
	@JsonProperty("dn")
	private String dn;
	
	@JsonProperty("codOrdineTi")
	private String codOrdineTi;

	public String getCodOrdineOlo() {
		return codOrdineOlo;
	}

	public void setCodOrdineOlo(String codOrdineOlo) {
		this.codOrdineOlo = codOrdineOlo;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getOlo() {
		return olo;
	}

	public void setOlo(String olo) {
		this.olo = olo;
	}

	public String getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(String idOrdine) {
		this.idOrdine = idOrdine;
	}

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public String getCodOrdineTi() {
		return codOrdineTi;
	}

	public void setCodOrdineTi(String codOrdineTi) {
		this.codOrdineTi = codOrdineTi;
	}
}
