package com.nttdata.tim.now.data.dto.contatto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.oao.OaoDTO;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class ContattoOutputDTO implements Serializable {

	private static final long serialVersionUID = 8690735584818809183L;

	@JsonProperty("idContatto")
	private String idContatto;

	@JsonProperty("primary")
	private String primary;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("cognome")
	private String cognome;

	@JsonProperty("mr_Ms")
	private String titolo;

	@JsonProperty("tipoReferente")
	private String tipoReferente;

	@JsonProperty("metodoContatto")
	private String metodoContatto;

	@JsonProperty("operatore")
	private String operatore;

	@JsonProperty("oao")
	private OaoDTO oao;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataUltimoAggiornamento")
	private Date dataUltimoAggiornamento;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInserimento")
	private Date dataInserimento;

	public OaoDTO getOao() {
		return oao;
	}

	public void setOao(OaoDTO oao) {
		this.oao = oao;
	}

	public String getPrimary() {
		return primary;
	}

	public void setPrimary(String primary) {
		this.primary = primary;
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

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTipoReferente() {
		return tipoReferente;
	}

	public void setTipoReferente(String tipoReferente) {
		this.tipoReferente = tipoReferente;
	}

	public String getMetodoContatto() {
		return metodoContatto;
	}

	public void setMetodoContatto(String metodoContatto) {
		this.metodoContatto = metodoContatto;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public String getIdContatto() {
		return idContatto;
	}

	public void setIdContatto(String idContatto) {
		this.idContatto = idContatto;
	}

	public Date getDataUltimoAggiornamento() {
		return dataUltimoAggiornamento;
	}

	public void setDataUltimoAggiornamento(Date dataUltimoAggiornamento) {
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

}
