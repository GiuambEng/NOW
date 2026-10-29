package com.nttdata.tim.now.data.bean.help;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class HelpBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 8109714294344271759L;

    @JsonProperty("operatoreAggiornamento")
	private String operatoreAggiornamento;

	@JsonProperty("operatore")
	private String operatore;

	@JsonProperty("note")
	private String note;

	@JsonProperty("titolo")
	private String titolo;

	@JsonProperty("contenuto")
	private String contenuto;

	@JsonProperty("idIHelp")
	private String idIHelp;

	@JsonProperty("ambito")
	private String ambito;

	@JsonProperty("descAmbito")
	private String descAmbito;

	@JsonProperty("visibile")
	private boolean visibile;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInserimento")
	private Date dataInserimento;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataAggiornamento")
	private Date dataAggiornamento;

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public boolean isVisibile() {
		return visibile;
	}

	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getContenuto() {
		return contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}

	public String getIdIHelp() {
		return idIHelp;
	}

	public void setIdIHelp(String idIHelp) {
		this.idIHelp = idIHelp;
	}

	public String getOperatoreAggiornamento() {
		return operatoreAggiornamento;
	}

	public void setOperatoreAggiornamento(String operatoreAggiornamento) {
		this.operatoreAggiornamento = operatoreAggiornamento;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Date getDataAggiornamento() {
		return dataAggiornamento;
	}

	public void setDataAggiornamento(Date dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
	}

	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	public String getDescAmbito() {
		return descAmbito;
	}

	public void setDescAmbito(String descAmbito) {
		this.descAmbito = descAmbito;
	}

}