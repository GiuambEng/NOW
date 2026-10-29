package com.nttdata.tim.now.data.dto.ordine.tracking;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class OrderTrackingInputLevel2DTO implements Serializable {

	private static final long serialVersionUID = -8133909218603309590L;

	@JsonProperty("idRichiestaOlo")
	private String idRichiestaOlo;

	@JsonProperty("codOloAgcom_utente")
	private String  codOloAgcomUtente;
	
	@JsonProperty("inizio_tracciamento")
	private String inizioTracciamento;

	@JsonProperty("fine_tracciamento")
	private String fineTracciamento;

	@JsonProperty("profilo_utente")
	private String profiloUtente;

	public String getIdRichiestaOlo() {
		return idRichiestaOlo;
	}

	public void setIdRichiestaOlo(String idRichiestaOlo) {
		this.idRichiestaOlo = idRichiestaOlo;
	}

	public String getCodOloAgcomUtente() {
		return codOloAgcomUtente;
	}

	public void setCodOloAgcomUtente(String codOloAgcomUtente) {
		this.codOloAgcomUtente = codOloAgcomUtente;
	}

	public String getInizioTracciamento() {
		return inizioTracciamento;
	}

	public void setInizioTracciamento(String inizioTracciamento) {
		this.inizioTracciamento = inizioTracciamento;
	}

	public String getFineTracciamento() {
		return fineTracciamento;
	}

	public void setFineTracciamento(String fineTracciamento) {
		this.fineTracciamento = fineTracciamento;
	}

	public String getProfiloUtente() {
		return profiloUtente;
	}

	public void setProfiloUtente(String profiloUtente) {
		this.profiloUtente = profiloUtente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOloAgcomUtente == null) ? 0 : codOloAgcomUtente.hashCode());
		result = prime * result + ((fineTracciamento == null) ? 0 : fineTracciamento.hashCode());
		result = prime * result + ((idRichiestaOlo == null) ? 0 : idRichiestaOlo.hashCode());
		result = prime * result + ((inizioTracciamento == null) ? 0 : inizioTracciamento.hashCode());
		result = prime * result + ((profiloUtente == null) ? 0 : profiloUtente.hashCode());
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
		OrderTrackingInputLevel2DTO other = (OrderTrackingInputLevel2DTO) obj;
		if (codOloAgcomUtente == null) {
			if (other.codOloAgcomUtente != null)
				return false;
		} else if (!codOloAgcomUtente.equals(other.codOloAgcomUtente))
			return false;
		if (fineTracciamento == null) {
			if (other.fineTracciamento != null)
				return false;
		} else if (!fineTracciamento.equals(other.fineTracciamento))
			return false;
		if (idRichiestaOlo == null) {
			if (other.idRichiestaOlo != null)
				return false;
		} else if (!idRichiestaOlo.equals(other.idRichiestaOlo))
			return false;
		if (inizioTracciamento == null) {
			if (other.inizioTracciamento != null)
				return false;
		} else if (!inizioTracciamento.equals(other.inizioTracciamento))
			return false;
		if (profiloUtente == null) {
			if (other.profiloUtente != null)
				return false;
		} else if (!profiloUtente.equals(other.profiloUtente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderTrackingInputLevel2DTO [idRichiestaOlo=" + idRichiestaOlo + ", codOloAgcomUtente="
				+ codOloAgcomUtente + ", inizioTracciamento=" + inizioTracciamento + ", fineTracciamento="
				+ fineTracciamento + ", profiloUtente=" + profiloUtente + "]";
	}

	
}