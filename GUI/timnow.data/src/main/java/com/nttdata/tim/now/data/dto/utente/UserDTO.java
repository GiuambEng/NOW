package com.nttdata.tim.now.data.dto.utente;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class UserDTO extends ESBResultDTO {

	private static final long serialVersionUID = 202814956524876405L;

	@JsonProperty("codiceProfilo")
	private String codiceProfilo;

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("userAlias")
	private String userAlias;

	@JsonProperty("matricola")
	private String matricola;

	@JsonProperty("idTipologiaUtente")
	private String idTipologiaUtente;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("cognome")
	private String cognome;

	@JsonProperty("indirizzoEmail")
	private String indirizzoEmail;

	@JsonProperty("codificaOloAgcom")
	private String codificaOloAgcom;

	@JsonProperty("flagAccorpante")
	private String flagAccorpante;

	@JsonProperty("flagAccorpato")
	private String flagAccorpato;

	@JsonProperty("flagDisabilitato")
	private String flagDisabilitato;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFineValidita")
	private Date dataFineValidita;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInizioValidita")
	private Date dataInizioValidita;

	public String getCodiceProfilo() {
		return codiceProfilo;
	}

	public void setCodiceProfilo(String codiceProfilo) {
		this.codiceProfilo = codiceProfilo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getIdTipologiaUtente() {
		return idTipologiaUtente;
	}

	public void setIdTipologiaUtente(String idTipologiaUtente) {
		this.idTipologiaUtente = idTipologiaUtente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzoEmail() {
		return indirizzoEmail;
	}

	public void setIndirizzoEmail(String indirizzoEmail) {
		this.indirizzoEmail = indirizzoEmail;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getFlagAccorpante() {
		return flagAccorpante;
	}

	public void setFlagAccorpante(String flagAccorpante) {
		this.flagAccorpante = flagAccorpante;
	}

	public String getFlagAccorpato() {
		return flagAccorpato;
	}

	public void setFlagAccorpato(String flagAccorpato) {
		this.flagAccorpato = flagAccorpato;
	}

	public String getFlagDisabilitato() {
		return flagDisabilitato;
	}

	public void setFlagDisabilitato(String flagDisabilitato) {
		this.flagDisabilitato = flagDisabilitato;
	}

	public Date getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(Date dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	public Date getDataInizioValidita() {
		return dataInizioValidita;
	}

	public void setDataInizioValidita(Date dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

}
