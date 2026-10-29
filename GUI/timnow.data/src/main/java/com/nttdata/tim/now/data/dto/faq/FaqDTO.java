package com.nttdata.tim.now.data.dto.faq;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class FaqDTO implements Serializable {

	private static final long serialVersionUID = -8056296128741375460L;

	@JsonProperty("Domanda")
	private String domanda;

	@JsonProperty("Risposta")
	private String risposta;

	@JsonProperty("Note")
	private String note;

	@JsonProperty("Operatore")
	private String operatore;

	@JsonProperty("OPERATORE_ULTIMO_AGGTO")
	private String operatoreAggiornamento;

	@JsonProperty("ID_FAQ")
	private String idFaq;

	@JsonProperty("Visibile")
	private String visibile;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("Data_aggiornamento")
	private Date dataAggiornamento;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("Data_inserimento")
	private Date dataInserimento;

	public String getDomanda() {
		return domanda;
	}

	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}

	public String getRisposta() {
		return risposta;
	}

	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public String getVisibile() {
		return visibile;
	}

	public void setVisibile(String visibile) {
		this.visibile = visibile;
	}

	public String getOperatoreAggiornamento() {
		return operatoreAggiornamento;
	}

	public void setOperatoreAggiornamento(String operatoreAggiornamento) {
		this.operatoreAggiornamento = operatoreAggiornamento;
	}

	public String getIdFaq() {
		return idFaq;
	}

	public void setIdFaq(String idFaq) {
		this.idFaq = idFaq;
	}

	public Date getDataAggiornamento() {
		return dataAggiornamento;
	}

	public void setDataAggiornamento(Date dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

}
