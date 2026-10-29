package com.nttdata.tim.now.data.dto.ordine.tokenizzazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1084
@JsonInclude(Include.NON_NULL)
public class TokenReferenteDTO implements Serializable {

	private static final long serialVersionUID = 7424963111650791274L;

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("tokenMobile")
	private String tokenMobile;
	
	@JsonProperty("tokenFisso")
	private String tokenFisso;
	
	//R1F_20_0236
	@JsonProperty("tokenCF")
	private String tokenCf;
	
	//SM_10454
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("cognome")
	private String cognome;
	
	@JsonProperty("codFiscale")
	private String codFiscale;
	
	@JsonProperty("pIva")
	private String pIva;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTokenMobile() {
		return tokenMobile;
	}

	public void setTokenMobile(String tokenMobile) {
		this.tokenMobile = tokenMobile;
	}

	public String getTokenFisso() {
		return tokenFisso;
	}

	public void setTokenFisso(String tokenFisso) {
		this.tokenFisso = tokenFisso;
	}

	public String getTokenCf() {
		return tokenCf;
	}

	public void setTokenCf(String tokenCf) {
		this.tokenCf = tokenCf;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public String getpIva() {
		return pIva;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}

	public void setpIva(String pIva) {
		this.pIva = pIva;
	}
}
