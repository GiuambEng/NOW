package com.nttdata.tim.now.data.dto.monitoring.generanotifiche;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class TipologiaNotificheAtteseInputDTO implements Serializable {

	private static final long serialVersionUID = -8377588787345935449L;

	@JsonProperty("idOfferta")
    private String idOfferta;

    @JsonProperty("idStatoNowDa")
    private String idStatoNow;

    @JsonProperty("idTplgLavorazione")
    private String idTipologiaLavorazione;

@JsonProperty("idrichiestaolo")
    private String idrichiestaolo;

    @JsonProperty("checkRecipient")
    private String checkRecipient;
    @JsonProperty("checkDonor")
    private String checkDonor;

    @JsonProperty("checkDonating")
    private String checkDonating;

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

    public String getIdTipologiaLavorazione() {
        return idTipologiaLavorazione;
    }

    public void setIdTipologiaLavorazione(String idTipologiaLavorazione) {
        this.idTipologiaLavorazione = idTipologiaLavorazione;
    }

    public String getCheckRecipient() {
        return checkRecipient;
    }

    public void setCheckRecipient(String checkRecipient) {
        this.checkRecipient = checkRecipient;
    }

    public String getCheckDonor() {
        return checkDonor;
    }

    public void setCheckDonor(String checkDonor) {
        this.checkDonor = checkDonor;
    }

    public String getCheckDonating() {
        return checkDonating;
    }

    public void setCheckDonating(String checkDonating) {
        this.checkDonating = checkDonating;
    }

    @Override
    public String toString() {
        return "TipologiaNotificheAtteseInputDTO [idOfferta=" + idOfferta + ", idStatoNow=" + idStatoNow
                + ", idrichiestaolo=" + idrichiestaolo + ", idTipologiaLavorazione=" + idTipologiaLavorazione
                + ", checkRecipient=" + checkRecipient + ", checkDonor=" + checkDonor + ", checkDonating="
                + checkDonating + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((checkDonating == null) ? 0 : checkDonating.hashCode());
        result = prime * result + ((checkDonor == null) ? 0 : checkDonor.hashCode());
        result = prime * result + ((checkRecipient == null) ? 0 : checkRecipient.hashCode());
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
        TipologiaNotificheAtteseInputDTO other = (TipologiaNotificheAtteseInputDTO) obj;
        if (checkDonating == null) {
            if (other.checkDonating != null)
                return false;
        } else if (!checkDonating.equals(other.checkDonating))
            return false;
        if (checkDonor == null) {
            if (other.checkDonor != null)
                return false;
        } else if (!checkDonor.equals(other.checkDonor))
            return false;
        if (checkRecipient == null) {
            if (other.checkRecipient != null)
                return false;
        } else if (!checkRecipient.equals(other.checkRecipient))
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
