package com.nttdata.tim.now.data.bean.contatto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.data.bean.oao.OaoBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class ContattoOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -2394757410705684338L;

	@JsonProperty("primary")
	private boolean primary;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("cognome")
	private String cognome;

	@JsonProperty("mr_MS")
	private String titolo;

	@JsonProperty("tipoReferente")
	private String tipoReferente;

	@JsonProperty("metodoContatto")
	private String metodoContatto;

	@JsonProperty("operatore")
	private String operatore;

	@JsonProperty("idContatto")
	private String idContatto;

	@JsonProperty("oao")
	private OaoBean oao;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataUltimoAggiornamento")
	private Date dataUltimoAggiornamento;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInserimento")
	private Date dataInserimento;

	public OaoBean getOao() {
		return oao;
	}

	public void setOao(OaoBean oao) {
		this.oao = oao;
	}

	public boolean getPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
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