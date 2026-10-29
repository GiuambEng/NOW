package com.nttdata.tim.now.data.dto.help;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class HelpDTO implements Serializable {
	
	private static final long serialVersionUID = 159523494589258523L;

	@JsonProperty("OPERATORE_ULTIMO_AGGTO")
	private String operatoreAggiornamento;

	@JsonProperty("Operatore")
	private String operatore;

	@JsonProperty("Note")
	private String note;

	@JsonProperty("Titolo")
	private String titolo;

	@JsonProperty("Contenuto")
	private String contenuto;

	@JsonProperty("Id_IHelp")
	private String idIHelp;

	@JsonProperty("Visibile")
	private String visibile;
	
	@JsonProperty("Id_Ambito")
	private String ambito;

	@JsonProperty("Desc_Ambito")
	private String descAmbito;


	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("Data_inserimento")
	private Date dataInserimento;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("Data_aggiornamento")
	private Date dataAggiornamento;

	public String getVisibile() {
		return visibile;
	}

	public void setVisibile(String visibile) {
		this.visibile = visibile;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
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
