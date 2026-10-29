package com.nttdata.tim.now.data.dto.news;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class NewsDTO implements Serializable {

	private static final long serialVersionUID = 4543939031122105689L;

	@JsonProperty("CONTENUTO")
	private String contenuto;

	@JsonProperty("ID_NEWS")
	private String idNews;

	@JsonProperty("NOTE")
	private String note;

	@JsonProperty("OPERATORE")
	private String operatore;

	@JsonProperty("TITOLO")
	private String titolo;

	@JsonProperty("OPERATORE_ULTIMA_MODIFICA")
	private String operatoreUltimaModifica;

	@JsonProperty("FLAG_VISIBILITA")
	private String flagVisibilita;

	@JsonProperty("FLAG_ELIMINA")
	private String flagElimina;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("DATE_INSERIMENTO")
	private Date dateInserimento;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("DATE_ULTIMA_MODIFICA")
	private Date dateUltimaModifica;

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

	public String getFlagElimina() {
		return flagElimina;
	}

	public void setFlagElimina(String flagElimina) {
		this.flagElimina = flagElimina;
	}

	public String getFlagVisibilita() {
		return flagVisibilita;
	}

	public void setFlagVisibilita(String flagVisibilita) {
		this.flagVisibilita = flagVisibilita;
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

}
