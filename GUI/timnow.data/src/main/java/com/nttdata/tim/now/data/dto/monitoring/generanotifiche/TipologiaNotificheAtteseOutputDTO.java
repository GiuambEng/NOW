package com.nttdata.tim.now.data.dto.monitoring.generanotifiche;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class TipologiaNotificheAtteseOutputDTO implements Serializable {

	private static final long serialVersionUID = -1489979413251259626L;

	@JsonProperty("codiceTipologiaNotificaDonating")
	private String tipologiaNotificaDonating;

	@JsonProperty("codiceTipologiaNotificaDonor")
	private String tipologiaNotificaDonor;

	@JsonProperty("codiceTipologiaNotificaRecipient")
	private String tipologiaNotificaRecipent;

	@JsonProperty("statoNowA")
	private String statoNowA;

	@JsonProperty("statoNowDa")
	private String statoNowDa;

	@JsonProperty("tipologiaLavorazione")
	private String tipologiaLavorazione;

	@JsonProperty("strutturaRichiestaDonating")
	private String strutturaRichiestaDonating;

	@JsonProperty("strutturaRichiestaDonor")
	private String strutturaRichiestaDonor;

	@JsonProperty("strutturaRichiestaRecipient")
	private String strutturaRichiestaRecipient;

	@JsonProperty("idrichiestaolo")
	private String idRichiestaOlo;

	@JsonProperty("descrCodTipoDonating")
	private String descrizioneCodiceDonating;

	@JsonProperty("descrCodTipoDonor")
	private String descrizioneCodiceTipoDonor;

	@JsonProperty("descrCodTipoRecipient")
	private String descrizioneCodiceTipoRecipient;

	@JsonProperty("flag_dest_Recipient")
	private boolean flagDestinazioneRecipient;

	@JsonProperty("flag_dest_Donor")
	private boolean flagDestinazioneDonor;

	@JsonProperty("flag_dest_Donating")
	private boolean flagDestinazioneDonating;

	public String getTipologiaNotificaDonating() {
		return tipologiaNotificaDonating;
	}

	public void setTipologiaNotificaDonating(String tipologiaNotificaDonating) {
		this.tipologiaNotificaDonating = tipologiaNotificaDonating;
	}

	public String getTipologiaNotificaDonor() {
		return tipologiaNotificaDonor;
	}

	public void setTipologiaNotificaDonor(String tipologiaNotificaDonor) {
		this.tipologiaNotificaDonor = tipologiaNotificaDonor;
	}

	public String getTipologiaNotificaRecipent() {
		return tipologiaNotificaRecipent;
	}

	public void setTipologiaNotificaRecipent(String tipologiaNotificaRecipent) {
		this.tipologiaNotificaRecipent = tipologiaNotificaRecipent;
	}

	public String getStatoNowA() {
		return statoNowA;
	}

	public void setStatoNowA(String statoNowA) {
		this.statoNowA = statoNowA;
	}

	public String getStatoNowDa() {
		return statoNowDa;
	}

	public void setStatoNowDa(String statoNowDa) {
		this.statoNowDa = statoNowDa;
	}

	public String getTipologiaLavorazione() {
		return tipologiaLavorazione;
	}

	public void setTipologiaLavorazione(String tipologiaLavorazione) {
		this.tipologiaLavorazione = tipologiaLavorazione;
	}

	public String getStrutturaRichiestaDonating() {
		return strutturaRichiestaDonating;
	}

	public void setStrutturaRichiestaDonating(String strutturaRichiestaDonating) {
		this.strutturaRichiestaDonating = strutturaRichiestaDonating;
	}

	public String getStrutturaRichiestaDonor() {
		return strutturaRichiestaDonor;
	}

	public void setStrutturaRichiestaDonor(String strutturaRichiestaDonor) {
		this.strutturaRichiestaDonor = strutturaRichiestaDonor;
	}

	public String getStrutturaRichiestaRecipient() {
		return strutturaRichiestaRecipient;
	}

	public void setStrutturaRichiestaRecipient(String strutturaRichiestaRecipient) {
		this.strutturaRichiestaRecipient = strutturaRichiestaRecipient;
	}

	public String getIdRichiestaOlo() {
		return idRichiestaOlo;
	}

	public void setIdRichiestaOlo(String idRichiestaOlo) {
		this.idRichiestaOlo = idRichiestaOlo;
	}

	public String getDescrizioneCodiceDonating() {
		return descrizioneCodiceDonating;
	}

	public void setDescrizioneCodiceDonating(String descrizioneCodiceDonating) {
		this.descrizioneCodiceDonating = descrizioneCodiceDonating;
	}

	public String getDescrizioneCodiceTipoDonor() {
		return descrizioneCodiceTipoDonor;
	}

	public void setDescrizioneCodiceTipoDonor(String descrizioneCodiceTipoDonor) {
		this.descrizioneCodiceTipoDonor = descrizioneCodiceTipoDonor;
	}

	public String getDescrizioneCodiceTipoRecipient() {
		return descrizioneCodiceTipoRecipient;
	}

	public void setDescrizioneCodiceTipoRecipient(String descrizioneCodiceTipoRecipient) {
		this.descrizioneCodiceTipoRecipient = descrizioneCodiceTipoRecipient;
	}

	public boolean isFlagDestinazioneRecipient() {
		return flagDestinazioneRecipient;
	}

	public void setFlagDestinazioneRecipient(boolean flagDestinazioneRecipient) {
		this.flagDestinazioneRecipient = flagDestinazioneRecipient;
	}

	public boolean isFlagDestinazioneDonor() {
		return flagDestinazioneDonor;
	}

	public void setFlagDestinazioneDonor(boolean flagDestinazioneDonor) {
		this.flagDestinazioneDonor = flagDestinazioneDonor;
	}

	public boolean isFlagDestinazioneDonating() {
		return flagDestinazioneDonating;
	}

	public void setFlagDestinazioneDonating(boolean flagDestinazioneDonating) {
		this.flagDestinazioneDonating = flagDestinazioneDonating;
	}

	@Override
	public String toString() {
		return "TipologiaNotificheAtteseOutputDTO [tipologiaNotificaDonating=" + tipologiaNotificaDonating
				+ ", tipologiaNotificaDonor=" + tipologiaNotificaDonor + ", tipologiaNotificaRecipent="
				+ tipologiaNotificaRecipent + ", statoNowA=" + statoNowA + ", statoNowDa=" + statoNowDa
				+ ", tipologiaLavorazione=" + tipologiaLavorazione + ", strutturaRichiestaDonating="
				+ strutturaRichiestaDonating + ", strutturaRichiestaDonor=" + strutturaRichiestaDonor
				+ ", strutturaRichiestaRecipient=" + strutturaRichiestaRecipient + ", idRichiestaOlo=" + idRichiestaOlo
				+ ", descrizioneCodiceDonating=" + descrizioneCodiceDonating + ", descrizioneCodiceTipoDonor="
				+ descrizioneCodiceTipoDonor + ", descrizioneCodiceTipoRecipient=" + descrizioneCodiceTipoRecipient
				+ ", flagDestinazioneRecipient=" + flagDestinazioneRecipient + ", flagDestinazioneDonor="
				+ flagDestinazioneDonor + ", flagDestinazioneDonating=" + flagDestinazioneDonating + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrizioneCodiceDonating == null) ? 0 : descrizioneCodiceDonating.hashCode());
		result = prime * result + ((descrizioneCodiceTipoDonor == null) ? 0 : descrizioneCodiceTipoDonor.hashCode());
		result = prime * result
				+ ((descrizioneCodiceTipoRecipient == null) ? 0 : descrizioneCodiceTipoRecipient.hashCode());
		result = prime * result + (flagDestinazioneDonating ? 1231 : 1237);
		result = prime * result + (flagDestinazioneDonor ? 1231 : 1237);
		result = prime * result + (flagDestinazioneRecipient ? 1231 : 1237);
		result = prime * result + ((idRichiestaOlo == null) ? 0 : idRichiestaOlo.hashCode());
		result = prime * result + ((statoNowA == null) ? 0 : statoNowA.hashCode());
		result = prime * result + ((statoNowDa == null) ? 0 : statoNowDa.hashCode());
		result = prime * result + ((strutturaRichiestaDonating == null) ? 0 : strutturaRichiestaDonating.hashCode());
		result = prime * result + ((strutturaRichiestaDonor == null) ? 0 : strutturaRichiestaDonor.hashCode());
		result = prime * result + ((strutturaRichiestaRecipient == null) ? 0 : strutturaRichiestaRecipient.hashCode());
		result = prime * result + ((tipologiaLavorazione == null) ? 0 : tipologiaLavorazione.hashCode());
		result = prime * result + ((tipologiaNotificaDonating == null) ? 0 : tipologiaNotificaDonating.hashCode());
		result = prime * result + ((tipologiaNotificaDonor == null) ? 0 : tipologiaNotificaDonor.hashCode());
		result = prime * result + ((tipologiaNotificaRecipent == null) ? 0 : tipologiaNotificaRecipent.hashCode());
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
		TipologiaNotificheAtteseOutputDTO other = (TipologiaNotificheAtteseOutputDTO) obj;
		if (descrizioneCodiceDonating == null) {
			if (other.descrizioneCodiceDonating != null)
				return false;
		} else if (!descrizioneCodiceDonating.equals(other.descrizioneCodiceDonating))
			return false;
		if (descrizioneCodiceTipoDonor == null) {
			if (other.descrizioneCodiceTipoDonor != null)
				return false;
		} else if (!descrizioneCodiceTipoDonor.equals(other.descrizioneCodiceTipoDonor))
			return false;
		if (descrizioneCodiceTipoRecipient == null) {
			if (other.descrizioneCodiceTipoRecipient != null)
				return false;
		} else if (!descrizioneCodiceTipoRecipient.equals(other.descrizioneCodiceTipoRecipient))
			return false;
		if (flagDestinazioneDonating != other.flagDestinazioneDonating)
			return false;
		if (flagDestinazioneDonor != other.flagDestinazioneDonor)
			return false;
		if (flagDestinazioneRecipient != other.flagDestinazioneRecipient)
			return false;
		if (idRichiestaOlo == null) {
			if (other.idRichiestaOlo != null)
				return false;
		} else if (!idRichiestaOlo.equals(other.idRichiestaOlo))
			return false;
		if (statoNowA == null) {
			if (other.statoNowA != null)
				return false;
		} else if (!statoNowA.equals(other.statoNowA))
			return false;
		if (statoNowDa == null) {
			if (other.statoNowDa != null)
				return false;
		} else if (!statoNowDa.equals(other.statoNowDa))
			return false;
		if (strutturaRichiestaDonating == null) {
			if (other.strutturaRichiestaDonating != null)
				return false;
		} else if (!strutturaRichiestaDonating.equals(other.strutturaRichiestaDonating))
			return false;
		if (strutturaRichiestaDonor == null) {
			if (other.strutturaRichiestaDonor != null)
				return false;
		} else if (!strutturaRichiestaDonor.equals(other.strutturaRichiestaDonor))
			return false;
		if (strutturaRichiestaRecipient == null) {
			if (other.strutturaRichiestaRecipient != null)
				return false;
		} else if (!strutturaRichiestaRecipient.equals(other.strutturaRichiestaRecipient))
			return false;
		if (tipologiaLavorazione == null) {
			if (other.tipologiaLavorazione != null)
				return false;
		} else if (!tipologiaLavorazione.equals(other.tipologiaLavorazione))
			return false;
		if (tipologiaNotificaDonating == null) {
			if (other.tipologiaNotificaDonating != null)
				return false;
		} else if (!tipologiaNotificaDonating.equals(other.tipologiaNotificaDonating))
			return false;
		if (tipologiaNotificaDonor == null) {
			if (other.tipologiaNotificaDonor != null)
				return false;
		} else if (!tipologiaNotificaDonor.equals(other.tipologiaNotificaDonor))
			return false;
		if (tipologiaNotificaRecipent == null) {
			if (other.tipologiaNotificaRecipent != null)
				return false;
		} else if (!tipologiaNotificaRecipent.equals(other.tipologiaNotificaRecipent))
			return false;
		return true;
	}

}
