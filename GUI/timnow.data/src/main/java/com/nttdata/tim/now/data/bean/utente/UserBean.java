package com.nttdata.tim.now.data.bean.utente;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class UserBean extends AbstractOutputBean implements Serializable {
	private static final long serialVersionUID = -5312165940215823260L;

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
	private boolean flagAccorpante;

	@JsonProperty("flagAccorpato")
	private boolean flagAccorpato;

	@JsonProperty("flagDisabilitato")
	private boolean flagDisabilitato;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFineValidita")
	private Date dataFineValidita;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInizioValidita")
	private Date dataInizioValidita;

	@JsonIgnore
	private UserRequestInfoBean requestInfo;

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

	public boolean isFlagAccorpante() {
		return flagAccorpante;
	}

	public void setFlagAccorpante(boolean flagAccorpante) {
		this.flagAccorpante = flagAccorpante;
	}

	public boolean isFlagAccorpato() {
		return flagAccorpato;
	}

	public void setFlagAccorpato(boolean flagAccorpato) {
		this.flagAccorpato = flagAccorpato;
	}

	public boolean isFlagDisabilitato() {
		return flagDisabilitato;
	}

	public void setFlagDisabilitato(boolean flagDisabilitato) {
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

	public UserRequestInfoBean getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(UserRequestInfoBean requestInfo) {
		this.requestInfo = requestInfo;
	}

	@Override
	public String toString() {
		return "UserBean [codiceProfilo=" + codiceProfilo + ", userId=" + userId + ", userAlias=" + userAlias
				+ ", matricola=" + matricola + ", idTipologiaUtente=" + idTipologiaUtente + ", nome=" + nome
				+ ", cognome=" + cognome + ", indirizzoEmail=" + indirizzoEmail + ", codificaOloAgcom="
				+ codificaOloAgcom + ", flagAccorpante=" + flagAccorpante + ", flagAccorpato=" + flagAccorpato
				+ ", flagDisabilitato=" + flagDisabilitato + ", dataFineValidita=" + dataFineValidita
				+ ", dataInizioValidita=" + dataInizioValidita + ", requestInfo=" + requestInfo + "]";
	}

}