package com.nttdata.tim.now.data.bean.news;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class NewsBean extends AbstractOutputBean implements Serializable {
	private static final long serialVersionUID = 2767033591769743832L;

	@JsonProperty("content")
	private String contenuto;

	@JsonProperty("idNews")
	private String idNews;

	@JsonProperty("note")
	private String note;

	@JsonProperty("operator")
	private String operatore;

	@JsonProperty("title")
	private String titolo;

	@JsonProperty("updateOperator")
	private String operatoreUltimaModifica;

	@JsonProperty("visible")
	private boolean flagVisibilita;

	@JsonProperty("delete")
	private boolean flagElimina;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("insertDate")
	private Date dateInserimento;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("updateDate")
	private Date dateUltimaModifica;
	
	//added only for RU_532 not mapped into DTO
	@JsonProperty("operationType")
	private String operationType;

	public String getContenuto() {
		return contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}

	public String getIdNews() {
		return idNews;
	}

	public void setIdNews(String idNews) {
		this.idNews = idNews;
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

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getOperatoreUltimaModifica() {
		return operatoreUltimaModifica;
	}

	public void setOperatoreUltimaModifica(String operatoreUltimaModifica) {
		this.operatoreUltimaModifica = operatoreUltimaModifica;
	}

	public boolean isFlagVisibilita() {
		return flagVisibilita;
	}

	public void setFlagVisibilita(boolean flagVisibilita) {
		this.flagVisibilita = flagVisibilita;
	}

	public boolean isFlagElimina() {
		return flagElimina;
	}

	public void setFlagElimina(boolean flagElimina) {
		this.flagElimina = flagElimina;
	}

	public Date getDateInserimento() {
		return dateInserimento;
	}

	public void setDateInserimento(Date dateInserimento) {
		this.dateInserimento = dateInserimento;
	}

	public Date getDateUltimaModifica() {
		return dateUltimaModifica;
	}

	public void setDateUltimaModifica(Date dateUltimaModifica) {
		this.dateUltimaModifica = dateUltimaModifica;
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
		result = prime * result + ((contenuto == null) ? 0 : contenuto.hashCode());
		result = prime * result + ((dateInserimento == null) ? 0 : dateInserimento.hashCode());
		result = prime * result + ((dateUltimaModifica == null) ? 0 : dateUltimaModifica.hashCode());
		result = prime * result + (flagElimina ? 1231 : 1237);
		result = prime * result + (flagVisibilita ? 1231 : 1237);
		result = prime * result + ((idNews == null) ? 0 : idNews.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((operationType == null) ? 0 : operationType.hashCode());
		result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
		result = prime * result + ((operatoreUltimaModifica == null) ? 0 : operatoreUltimaModifica.hashCode());
		result = prime * result + ((titolo == null) ? 0 : titolo.hashCode());
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
		NewsBean other = (NewsBean) obj;
		if (contenuto == null) {
			if (other.contenuto != null)
				return false;
		} else if (!contenuto.equals(other.contenuto))
			return false;
		if (dateInserimento == null) {
			if (other.dateInserimento != null)
				return false;
		} else if (!dateInserimento.equals(other.dateInserimento))
			return false;
		if (dateUltimaModifica == null) {
			if (other.dateUltimaModifica != null)
				return false;
		} else if (!dateUltimaModifica.equals(other.dateUltimaModifica))
			return false;
		if (flagElimina != other.flagElimina)
			return false;
		if (flagVisibilita != other.flagVisibilita)
			return false;
		if (idNews == null) {
			if (other.idNews != null)
				return false;
		} else if (!idNews.equals(other.idNews))
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
		if (operatoreUltimaModifica == null) {
			if (other.operatoreUltimaModifica != null)
				return false;
		} else if (!operatoreUltimaModifica.equals(other.operatoreUltimaModifica))
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NewsBean [contenuto=" + contenuto + ", idNews=" + idNews + ", note=" + note + ", operatore=" + operatore
				+ ", titolo=" + titolo + ", operatoreUltimaModifica=" + operatoreUltimaModifica + ", flagVisibilita="
				+ flagVisibilita + ", flagElimina=" + flagElimina + ", dateInserimento=" + dateInserimento
				+ ", dateUltimaModifica=" + dateUltimaModifica + ", operationType=" + operationType + "]";
	}


}