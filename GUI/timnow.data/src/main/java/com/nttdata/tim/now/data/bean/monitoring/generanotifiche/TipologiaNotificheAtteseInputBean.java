package com.nttdata.tim.now.data.bean.monitoring.generanotifiche;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class TipologiaNotificheAtteseInputBean implements Serializable {

    private static final long serialVersionUID = -7122558303482885496L;

    @JsonProperty("idOfferta")
	private String idOfferta;

	@JsonProperty("idStatoNowDa")
	private String idStatoNow;

	@JsonProperty("idRichiestaOlo")
	private String idrichiestaolo;

	@JsonProperty("idTipologiaLavorazione")
	private String idTipologiaLavorazione;

	@JsonProperty("checkRecipient")
	private boolean checkRecipient;

	@JsonProperty("checkDonor")
	private boolean checkDonor;

	@JsonProperty("checkDonating")
	private boolean checkDonating;

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getIdStatoNow() {
		return idStatoNow;
	}

	public void setIdStatoNow(String idStatoNow) {
		this.idStatoNow = idStatoNow;
	}

	public String getIdrichiestaolo() {
		return idrichiestaolo;
	}

	public void setIdrichiestaolo(String idrichiestaolo) {
		this.idrichiestaolo = idrichiestaolo;
	}

	public boolean isCheckRecipient() {
		return checkRecipient;
	}

	public void setCheckRecipient(boolean checkRecipient) {
		this.checkRecipient = checkRecipient;
	}

	public boolean isCheckDonor() {
		return checkDonor;
	}

	public void setCheckDonor(boolean checkDonor) {
		this.checkDonor = checkDonor;
	}

	public boolean isCheckDonating() {
		return checkDonating;
	}

	public void setCheckDonating(boolean checkDonating) {
		this.checkDonating = checkDonating;
	}

	public String getIdTipologiaLavorazione() {
		return idTipologiaLavorazione;
	}

	public void setIdTipologiaLavorazione(String idTipologiaLavorazione) {
		this.idTipologiaLavorazione = idTipologiaLavorazione;
	}

	@Override
	public String toString() {
		return "TipologiaNotificheAtteseInputBean [idOfferta=" + idOfferta + ", idStatoNow=" + idStatoNow
				+ ", idrichiestaolo=" + idrichiestaolo + ", idTipologiaLavorazione=" + idTipologiaLavorazione
				+ ", checkRecipient=" + checkRecipient + ", checkDonor=" + checkDonor + ", checkDonating="
				+ checkDonating + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (checkDonating ? 1231 : 1237);
		result = prime * result + (checkDonor ? 1231 : 1237);
		result = prime * result + (checkRecipient ? 1231 : 1237);
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((idStatoNow == null) ? 0 : idStatoNow.hashCode());
		result = prime * result + ((idTipologiaLavorazione == null) ? 0 : idTipologiaLavorazione.hashCode());
		result = prime * result + ((idrichiestaolo == null) ? 0 : idrichiestaolo.hashCode());
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
		TipologiaNotificheAtteseInputBean other = (TipologiaNotificheAtteseInputBean) obj;
		if (checkDonating != other.checkDonating)
			return false;
		if (checkDonor != other.checkDonor)
			return false;
		if (checkRecipient != other.checkRecipient)
			return false;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		if (idStatoNow == null) {
			if (other.idStatoNow != null)
				return false;
		} else if (!idStatoNow.equals(other.idStatoNow))
			return false;
		if (idTipologiaLavorazione == null) {
			if (other.idTipologiaLavorazione != null)
				return false;
		} else if (!idTipologiaLavorazione.equals(other.idTipologiaLavorazione))
			return false;
		if (idrichiestaolo == null) {
			if (other.idrichiestaolo != null)
				return false;
		} else if (!idrichiestaolo.equals(other.idrichiestaolo))
			return false;
		return true;
	}

}