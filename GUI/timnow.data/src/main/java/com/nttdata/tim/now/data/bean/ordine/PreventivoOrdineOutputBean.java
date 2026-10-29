package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

public class PreventivoOrdineOutputBean implements Serializable {
	
	private static final long serialVersionUID = -6178625614544957816L;

	@JsonFormat(pattern = DateHelper.DATE_FE, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataAccettazioneOao")
	private Date dataAccettazioneOao;
	
	@JsonFormat(pattern = DateHelper.DATE_FE, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataPreventivo")
	private Date dataPreventivo;
	
	@JsonProperty("contributoCliente")
	private String contributoCliente;
	
	@JsonProperty("opa")
	private String opa;
	
	@JsonProperty("permessi")
	private String permessi;
	
	@JsonProperty("timeoutAccettazione")
	private String timeoutAccettazione;
	
	@JsonProperty("importoTotale")
	private String importoTotale;
	
	@JsonProperty("note")
	private String note;
	
	@JsonProperty("numGiorniPrevisto")
	private String numGiorniPrevisto;
	
	@JsonProperty("stato")
	private String stato;
	
	@JsonFormat(pattern = DateHelper.DATE_FE, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataUltimaModifica")
	private Date dataUltimaModifica;
	
	@JsonFormat(pattern = DateHelper.DATE_FE, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInserimento")
	private Date dataInserimento;
	
	@JsonFormat(pattern = DateHelper.DATE_FE, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataTimeoutAccettazione")
	private Date dataTimeoutAccettazione;
	
	@JsonProperty("descrizioneArticolo")
	private String descrizioneArticolo;
	
	@JsonProperty("importoArticolo")
	private String importoArticolo;
	
	@JsonProperty("quantitaArticolo")
	private String quantitaArticolo;

	//RU_869
	@JsonProperty("prezziEspostiIn")
	private String prezziEspostiIn;
	
	public Date getDataAccettazioneOao() {
		return dataAccettazioneOao;
	}

	public void setDataAccettazioneOao(Date dataAccettazioneOao) {
		this.dataAccettazioneOao = dataAccettazioneOao;
	}

	public Date getDataPreventivo() {
		return dataPreventivo;
	}

	public void setDataPreventivo(Date dataPreventivo) {
		this.dataPreventivo = dataPreventivo;
	}

	public String getContributoCliente() {
		return contributoCliente;
	}

	public void setContributoCliente(String contributoCliente) {
		this.contributoCliente = contributoCliente;
	}

	public String getOpa() {
		return opa;
	}

	public void setOpa(String opa) {
		this.opa = opa;
	}

	public String getPermessi() {
		return permessi;
	}

	public void setPermessi(String permessi) {
		this.permessi = permessi;
	}

	public String getTimeoutAccettazione() {
		return timeoutAccettazione;
	}

	public void setTimeoutAccettazione(String timeoutAccettazione) {
		this.timeoutAccettazione = timeoutAccettazione;
	}

	public String getImportoTotale() {
		return importoTotale;
	}

	public void setImportoTotale(String importoTotale) {
		this.importoTotale = importoTotale;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNumGiorniPrevisto() {
		return numGiorniPrevisto;
	}

	public void setNumGiorniPrevisto(String numGiorniPrevisto) {
		this.numGiorniPrevisto = numGiorniPrevisto;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Date getDataTimeoutAccettazione() {
		return dataTimeoutAccettazione;
	}

	public void setDataTimeoutAccettazione(Date dataTimeoutAccettazione) {
		this.dataTimeoutAccettazione = dataTimeoutAccettazione;
	}

	public String getDescrizioneArticolo() {
		return descrizioneArticolo;
	}

	public void setDescrizioneArticolo(String descrizioneArticolo) {
		this.descrizioneArticolo = descrizioneArticolo;
	}

	public String getImportoArticolo() {
		return importoArticolo;
	}

	public void setImportoArticolo(String importoArticolo) {
		this.importoArticolo = importoArticolo;
	}

	public String getQuantitaArticolo() {
		return quantitaArticolo;
	}

	public void setQuantitaArticolo(String quantitaArticolo) {
		this.quantitaArticolo = quantitaArticolo;
	}
	
	public String getPrezziEspostiIn() {
		return prezziEspostiIn;
	}

	public void setPrezziEspostiIn(String prezziEspostiIn) {
		this.prezziEspostiIn = prezziEspostiIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contributoCliente == null) ? 0 : contributoCliente.hashCode());
		result = prime * result + ((dataAccettazioneOao == null) ? 0 : dataAccettazioneOao.hashCode());
		result = prime * result + ((dataInserimento == null) ? 0 : dataInserimento.hashCode());
		result = prime * result + ((dataPreventivo == null) ? 0 : dataPreventivo.hashCode());
		result = prime * result + ((dataTimeoutAccettazione == null) ? 0 : dataTimeoutAccettazione.hashCode());
		result = prime * result + ((dataUltimaModifica == null) ? 0 : dataUltimaModifica.hashCode());
		result = prime * result + ((descrizioneArticolo == null) ? 0 : descrizioneArticolo.hashCode());
		result = prime * result + ((importoArticolo == null) ? 0 : importoArticolo.hashCode());
		result = prime * result + ((importoTotale == null) ? 0 : importoTotale.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((numGiorniPrevisto == null) ? 0 : numGiorniPrevisto.hashCode());
		result = prime * result + ((opa == null) ? 0 : opa.hashCode());
		result = prime * result + ((permessi == null) ? 0 : permessi.hashCode());
		result = prime * result + ((quantitaArticolo == null) ? 0 : quantitaArticolo.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		result = prime * result + ((timeoutAccettazione == null) ? 0 : timeoutAccettazione.hashCode());
		result = prime * result + ((prezziEspostiIn == null) ? 0 : prezziEspostiIn.hashCode());
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
		PreventivoOrdineOutputBean other = (PreventivoOrdineOutputBean) obj;
		if (contributoCliente == null) {
			if (other.contributoCliente != null)
				return false;
		} else if (!contributoCliente.equals(other.contributoCliente))
			return false;
		if (dataAccettazioneOao == null) {
			if (other.dataAccettazioneOao != null)
				return false;
		} else if (!dataAccettazioneOao.equals(other.dataAccettazioneOao))
			return false;
		if (dataInserimento == null) {
			if (other.dataInserimento != null)
				return false;
		} else if (!dataInserimento.equals(other.dataInserimento))
			return false;
		if (dataPreventivo == null) {
			if (other.dataPreventivo != null)
				return false;
		} else if (!dataPreventivo.equals(other.dataPreventivo))
			return false;
		if (dataTimeoutAccettazione == null) {
			if (other.dataTimeoutAccettazione != null)
				return false;
		} else if (!dataTimeoutAccettazione.equals(other.dataTimeoutAccettazione))
			return false;
		if (dataUltimaModifica == null) {
			if (other.dataUltimaModifica != null)
				return false;
		} else if (!dataUltimaModifica.equals(other.dataUltimaModifica))
			return false;
		if (descrizioneArticolo == null) {
			if (other.descrizioneArticolo != null)
				return false;
		} else if (!descrizioneArticolo.equals(other.descrizioneArticolo))
			return false;
		if (importoArticolo == null) {
			if (other.importoArticolo != null)
				return false;
		} else if (!importoArticolo.equals(other.importoArticolo))
			return false;
		if (importoTotale == null) {
			if (other.importoTotale != null)
				return false;
		} else if (!importoTotale.equals(other.importoTotale))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (numGiorniPrevisto == null) {
			if (other.numGiorniPrevisto != null)
				return false;
		} else if (!numGiorniPrevisto.equals(other.numGiorniPrevisto))
			return false;
		if (opa == null) {
			if (other.opa != null)
				return false;
		} else if (!opa.equals(other.opa))
			return false;
		if (permessi == null) {
			if (other.permessi != null)
				return false;
		} else if (!permessi.equals(other.permessi))
			return false;
		if (quantitaArticolo == null) {
			if (other.quantitaArticolo != null)
				return false;
		} else if (!quantitaArticolo.equals(other.quantitaArticolo))
			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		if (timeoutAccettazione == null) {
			if (other.timeoutAccettazione != null)
				return false;
		} else if (!timeoutAccettazione.equals(other.timeoutAccettazione))
			return false;
		if (prezziEspostiIn == null) {
			if (other.prezziEspostiIn != null)
				return false;
		} else if (!prezziEspostiIn.equals(other.prezziEspostiIn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PreventivoOrdineOutputBean [dataAccettazioneOao=" + dataAccettazioneOao + ", dataPreventivo="
				+ dataPreventivo + ", contributoCliente=" + contributoCliente + ", opa=" + opa + ", permessi="
				+ permessi + ", timeoutAccettazione=" + timeoutAccettazione + ", importoTotale=" + importoTotale
				+ ", note=" + note + ", numGiorniPrevisto=" + numGiorniPrevisto + ", stato=" + stato
				+ ", dataUltimaModifica=" + dataUltimaModifica + ", dataInserimento=" + dataInserimento
				+ ", dataTimeoutAccettazione=" + dataTimeoutAccettazione + ", descrizioneArticolo="
				+ descrizioneArticolo + ", importoArticolo=" + importoArticolo + ", quantitaArticolo="
				+ quantitaArticolo + ", prezziEspostiIn=" + prezziEspostiIn + "]";
	}

}
