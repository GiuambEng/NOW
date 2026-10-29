package com.nttdata.tim.now.data.bean.ordine.tokenizzazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1084
@JsonInclude(Include.NON_NULL)
public class NumeriReferenteBean implements Serializable {

	private static final long serialVersionUID = 1769064719333307156L;

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("numeroMobile")
	private String numeroMobile;
	
	@JsonProperty("numeroFisso")
	private String numeroFisso;
	
	//R1F-20-0236
	@JsonProperty("pIva")
	private String pIva;
	
	@JsonProperty("codFiscale")
	private String codFiscale;
	
	@JsonProperty("cognome")
	private String cognome;
	
	@JsonProperty("nome")
	private String nome;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumeroMobile() {
		return numeroMobile;
	}

	public void setNumeroMobile(String numeroMobile) {
		this.numeroMobile = numeroMobile;
	}

	public String getNumeroFisso() {
		return numeroFisso;
	}

	public void setNumeroFisso(String numeroFisso) {
		this.numeroFisso = numeroFisso;
	}

	public String getpIva() {
		return pIva;
	}

	public void setpIva(String pIva) {
		this.pIva = pIva;
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
