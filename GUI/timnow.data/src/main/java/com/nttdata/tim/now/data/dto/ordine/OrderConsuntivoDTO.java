package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class OrderConsuntivoDTO implements Serializable {

	private static final long serialVersionUID = 1844514770485730039L;

	@JsonProperty("flagContributoCliente")
	private String flagContributoCliente;
	
	@JsonProperty("opa")
	private String opa;
	
	@JsonProperty("permessi")
	private String permessi;
	
	@JsonProperty("importoTotale")
	private String importoTotale;
	
	@JsonProperty("note")
	private String note;
	
	@JsonProperty("numGiorniPrevisto")
	private String numGiorniPrevisto;
	
	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInserimento")
	private Date dataInserimento;
	
	@JsonProperty("descrizioneArticolo")
	private String descrizioneArticolo;
	
	@JsonProperty("importoArticolo")
	private String importoArticolo;
	
	@JsonProperty("quantitaArticolo")
	private String quantitaArticolo;

	//RU_869
	@JsonProperty("prezziEspostiIn")
	private String prezziEspostiIn;
		
	public String getFlagContributoCliente() {
		return flagContributoCliente;
	}

	public void setFlagContributoCliente(String flagContributoCliente) {
		this.flagContributoCliente = flagContributoCliente;
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

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		result = prime * result + ((dataInserimento == null) ? 0 : dataInserimento.hashCode());
		result = prime * result + ((descrizioneArticolo == null) ? 0 : descrizioneArticolo.hashCode());
		result = prime * result + ((flagContributoCliente == null) ? 0 : flagContributoCliente.hashCode());
		result = prime * result + ((importoArticolo == null) ? 0 : importoArticolo.hashCode());
		result = prime * result + ((importoTotale == null) ? 0 : importoTotale.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((numGiorniPrevisto == null) ? 0 : numGiorniPrevisto.hashCode());
		result = prime * result + ((opa == null) ? 0 : opa.hashCode());
		result = prime * result + ((permessi == null) ? 0 : permessi.hashCode());
		result = prime * result + ((quantitaArticolo == null) ? 0 : quantitaArticolo.hashCode());
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
		OrderConsuntivoDTO other = (OrderConsuntivoDTO) obj;
		if (dataInserimento == null) {
			if (other.dataInserimento != null)
				return false;
		} else if (!dataInserimento.equals(other.dataInserimento))
			return false;
		if (descrizioneArticolo == null) {
			if (other.descrizioneArticolo != null)
				return false;
		} else if (!descrizioneArticolo.equals(other.descrizioneArticolo))
			return false;
		if (flagContributoCliente == null) {
			if (other.flagContributoCliente != null)
				return false;
		} else if (!flagContributoCliente.equals(other.flagContributoCliente))
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
		if (prezziEspostiIn == null) {
			if (other.prezziEspostiIn != null)
				return false;
		} else if (!prezziEspostiIn.equals(other.prezziEspostiIn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderConsuntivoDTO [flagContributoCliente=" + flagContributoCliente + ", opa=" + opa + ", permessi="
				+ permessi + ", importoTotale=" + importoTotale + ", note=" + note + ", numGiorniPrevisto="
				+ numGiorniPrevisto + ", dataInserimento=" + dataInserimento + ", descrizioneArticolo="
				+ descrizioneArticolo + ", importoArticolo=" + importoArticolo + ", quantitaArticolo="
				+ quantitaArticolo + ", prezziEspostiIn=" + prezziEspostiIn + "]";
	}

	
}




