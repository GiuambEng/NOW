package com.nttdata.tim.now.data.bean.faq;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class FaqBean extends AbstractOutputBean implements Serializable {
	private static final long serialVersionUID = -6386925033022282855L;

	@JsonProperty("question")
	private String domanda;

	@JsonProperty("answer")
	private String risposta;

	@JsonProperty("note")
	private String note;

	@JsonProperty("operator")
	private String operatore;

	@JsonProperty("updateOperator")
	private String operatoreAggiornamento;

	@JsonProperty("idFaq")
	private String idFaq;

	@JsonProperty("visible")
	private boolean visibile;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("updateDate")
	private Date dataAggiornamento;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("insertDate")
	private Date dataInserimento;

	//added only for RU_532 not mapped into DTO
	@JsonProperty("operationType")
	private String operationType;

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

	public boolean isVisibile() {
		return visibile;
	}

	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
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

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAggiornamento == null) ? 0 : dataAggiornamento.hashCode());
		result = prime * result + ((dataInserimento == null) ? 0 : dataInserimento.hashCode());
		result = prime * result + ((domanda == null) ? 0 : domanda.hashCode());
		result = prime * result + ((idFaq == null) ? 0 : idFaq.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((operationType == null) ? 0 : operationType.hashCode());
		result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
		result = prime * result + ((operatoreAggiornamento == null) ? 0 : operatoreAggiornamento.hashCode());
		result = prime * result + ((risposta == null) ? 0 : risposta.hashCode());
		result = prime * result + (visibile ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FaqBean other = (FaqBean) obj;
		if (dataAggiornamento == null) {
			if (other.dataAggiornamento != null)
				return false;
		} else if (!dataAggiornamento.equals(other.dataAggiornamento))
			return false;
		if (dataInserimento == null) {
			if (other.dataInserimento != null)
				return false;
		} else if (!dataInserimento.equals(other.dataInserimento))
			return false;
		if (domanda == null) {
			if (other.domanda != null)
				return false;
		} else if (!domanda.equals(other.domanda))
			return false;
		if (idFaq == null) {
			if (other.idFaq != null)
				return false;
		} else if (!idFaq.equals(other.idFaq))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (operationType == null) {
			if (other.operationType != null)
				return false;
		} else if (!operationType.equals(other.operationType))
			return false;
		if (operatore == null) {
			if (other.operatore != null)
				return false;
		} else if (!operatore.equals(other.operatore))
			return false;
		if (operatoreAggiornamento == null) {
			if (other.operatoreAggiornamento != null)
				return false;
		} else if (!operatoreAggiornamento.equals(other.operatoreAggiornamento))
			return false;
		if (risposta == null) {
			if (other.risposta != null)
				return false;
		} else if (!risposta.equals(other.risposta))
			return false;
		if (visibile != other.visibile)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FaqBean [domanda=" + domanda + ", risposta=" + risposta + ", note=" + note + ", operatore=" + operatore
				+ ", operatoreAggiornamento=" + operatoreAggiornamento + ", idFaq=" + idFaq + ", visibile=" + visibile
				+ ", dataAggiornamento=" + dataAggiornamento + ", dataInserimento=" + dataInserimento
				+ ", operationType=" + operationType + "]";
	}

	

}