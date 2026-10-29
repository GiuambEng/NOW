package com.nttdata.tim.now.data.bean.monitoring.generanotifiche;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class RichiestaGeneraNotificheInputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -6701294726235484932L;

    @JsonProperty("idRichiestaOlo")
    private String idRichiesta;

    @JsonProperty("idFamigliaOfferta")
    private String idFamigliaOfferta;

    @JsonProperty("ordineTi")
    private String ordineTi;

    @JsonProperty("tipologiaLavorazione")
    private String idTipologiaLavorazione;

    @JsonProperty("statoNowDa")
    private String tipologiaStatoNow;

    @JsonProperty("idNotifica")
    private String idNotifica;

    @JsonProperty("tipologiaNotificaRecipent")
    private String codiceTipologiaNotificaRecipient;

    @JsonProperty("tipologiaNotificaDonor")
    private String codiceTipologiaNotificaDonor;

    @JsonProperty("tipologiaNotificaDonating")
    private String codiceTipologiaNotificaDonating;

    @JsonProperty("strutturaRichiestaRecipient")
    private String strutturaRichiestaRecipient;

    @JsonProperty("strutturaRichiestaDonor")
    private String strutturaRichiestaDonor;

    @JsonProperty("strutturaRichiestaDonating")
    private String strutturaRichiestaDonating;

    @JsonProperty("flagDestinazioneRecipient")
    private boolean flagDestinazioneRecipient;

    @JsonProperty("flagDestinazioneDonor")
    private boolean flagDestinazioneDonor;

    @JsonProperty("flagDestinazioneDonating")
    private boolean flagDestinazioneDonating;

    public String getIdRichiesta() {
        return idRichiesta;
    }

    public void setIdRichiesta(String idRichiesta) {
        this.idRichiesta = idRichiesta;
    }

    public String getIdFamigliaOfferta() {
        return idFamigliaOfferta;
    }

    public void setIdFamigliaOfferta(String idFamigliaOfferta) {
        this.idFamigliaOfferta = idFamigliaOfferta;
    }

    public String getOrdineTi() {
        return ordineTi;
    }

    public void setOrdineTi(String ordineTi) {
        this.ordineTi = ordineTi;
    }

    public String getIdTipologiaLavorazione() {
        return idTipologiaLavorazione;
    }

    public void setIdTipologiaLavorazione(String idTipologiaLavorazione) {
        this.idTipologiaLavorazione = idTipologiaLavorazione;
    }

    public String getTipologiaStatoNow() {
        return tipologiaStatoNow;
    }

    public void setTipologiaStatoNow(String tipologiaStatoNow) {
        this.tipologiaStatoNow = tipologiaStatoNow;
    }

    public String getIdNotifica() {
        return idNotifica;
    }

    public void setIdNotifica(String idNotifica) {
        this.idNotifica = idNotifica;
    }

    public String getCodiceTipologiaNotificaRecipient() {
        return codiceTipologiaNotificaRecipient;
    }

    public void setCodiceTipologiaNotificaRecipient(String codiceTipologiaNotificaRecipient) {
        this.codiceTipologiaNotificaRecipient = codiceTipologiaNotificaRecipient;
    }

    public String getCodiceTipologiaNotificaDonor() {
        return codiceTipologiaNotificaDonor;
    }

    public void setCodiceTipologiaNotificaDonor(String codiceTipologiaNotificaDonor) {
        this.codiceTipologiaNotificaDonor = codiceTipologiaNotificaDonor;
    }

    public String getCodiceTipologiaNotificaDonating() {
        return codiceTipologiaNotificaDonating;
    }

    public void setCodiceTipologiaNotificaDonating(String codiceTipologiaNotificaDonating) {
        this.codiceTipologiaNotificaDonating = codiceTipologiaNotificaDonating;
    }

    public String getStrutturaRichiestaRecipient() {
        return strutturaRichiestaRecipient;
    }

    public void setStrutturaRichiestaRecipient(String strutturaRichiestaRecipient) {
        this.strutturaRichiestaRecipient = strutturaRichiestaRecipient;
    }

    public String getStrutturaRichiestaDonor() {
        return strutturaRichiestaDonor;
    }

    public void setStrutturaRichiestaDonor(String strutturaRichiestaDonor) {
        this.strutturaRichiestaDonor = strutturaRichiestaDonor;
    }

    public String getStrutturaRichiestaDonating() {
        return strutturaRichiestaDonating;
    }

    public void setStrutturaRichiestaDonating(String strutturaRichiestaDonating) {
        this.strutturaRichiestaDonating = strutturaRichiestaDonating;
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
        return "RichiestaInputBean [idRichiesta=" + idRichiesta + ", idFamigliaOfferta=" + idFamigliaOfferta
                + ", ordineTi=" + ordineTi + ", idTipologiaLavorazione=" + idTipologiaLavorazione
                + ", tipologiaStatoNow=" + tipologiaStatoNow + ", idNotifica=" + idNotifica
                + ", codiceTipologiaNotificaRecipient=" + codiceTipologiaNotificaRecipient
                + ", codiceTipologiaNotificaDonor=" + codiceTipologiaNotificaDonor
                + ", codiceTipologiaNotificaDonating=" + codiceTipologiaNotificaDonating
                + ", strutturaRichiestaRecipient=" + strutturaRichiestaRecipient + ", strutturaRichiestaDonor="
                + strutturaRichiestaDonor + ", strutturaRichiestaDonating=" + strutturaRichiestaDonating
                + ", flagDestinazioneRecipient=" + flagDestinazioneRecipient + ", flagDestinazioneDonor="
                + flagDestinazioneDonor + ", flagDestinazioneDonating=" + flagDestinazioneDonating + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((codiceTipologiaNotificaDonating == null) ? 0 : codiceTipologiaNotificaDonating.hashCode());
        result = prime * result
                + ((codiceTipologiaNotificaDonor == null) ? 0 : codiceTipologiaNotificaDonor.hashCode());
        result = prime * result
                + ((codiceTipologiaNotificaRecipient == null) ? 0 : codiceTipologiaNotificaRecipient.hashCode());
        result = prime * result + (flagDestinazioneDonating ? 1231 : 1237);
        result = prime * result + (flagDestinazioneDonor ? 1231 : 1237);
        result = prime * result + (flagDestinazioneRecipient ? 1231 : 1237);
        result = prime * result + ((idFamigliaOfferta == null) ? 0 : idFamigliaOfferta.hashCode());
        result = prime * result + ((idNotifica == null) ? 0 : idNotifica.hashCode());
        result = prime * result + ((idRichiesta == null) ? 0 : idRichiesta.hashCode());
        result = prime * result + ((idTipologiaLavorazione == null) ? 0 : idTipologiaLavorazione.hashCode());
        result = prime * result + ((ordineTi == null) ? 0 : ordineTi.hashCode());
        result = prime * result + ((strutturaRichiestaDonating == null) ? 0 : strutturaRichiestaDonating.hashCode());
        result = prime * result + ((strutturaRichiestaDonor == null) ? 0 : strutturaRichiestaDonor.hashCode());
        result = prime * result + ((strutturaRichiestaRecipient == null) ? 0 : strutturaRichiestaRecipient.hashCode());
        result = prime * result + ((tipologiaStatoNow == null) ? 0 : tipologiaStatoNow.hashCode());
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
        RichiestaGeneraNotificheInputBean other = (RichiestaGeneraNotificheInputBean) obj;
        if (codiceTipologiaNotificaDonating == null) {
            if (other.codiceTipologiaNotificaDonating != null)
                return false;
        } else if (!codiceTipologiaNotificaDonating.equals(other.codiceTipologiaNotificaDonating))
            return false;
        if (codiceTipologiaNotificaDonor == null) {
            if (other.codiceTipologiaNotificaDonor != null)
                return false;
        } else if (!codiceTipologiaNotificaDonor.equals(other.codiceTipologiaNotificaDonor))
            return false;
        if (codiceTipologiaNotificaRecipient == null) {
            if (other.codiceTipologiaNotificaRecipient != null)
                return false;
        } else if (!codiceTipologiaNotificaRecipient.equals(other.codiceTipologiaNotificaRecipient))
            return false;
        if (flagDestinazioneDonating != other.flagDestinazioneDonating)
            return false;
        if (flagDestinazioneDonor != other.flagDestinazioneDonor)
            return false;
        if (flagDestinazioneRecipient != other.flagDestinazioneRecipient)
            return false;
        if (idFamigliaOfferta == null) {
            if (other.idFamigliaOfferta != null)
                return false;
        } else if (!idFamigliaOfferta.equals(other.idFamigliaOfferta))
            return false;
        if (idNotifica == null) {
            if (other.idNotifica != null)
                return false;
        } else if (!idNotifica.equals(other.idNotifica))
            return false;
        if (idRichiesta == null) {
            if (other.idRichiesta != null)
                return false;
        } else if (!idRichiesta.equals(other.idRichiesta))
            return false;
        if (idTipologiaLavorazione == null) {
            if (other.idTipologiaLavorazione != null)
                return false;
        } else if (!idTipologiaLavorazione.equals(other.idTipologiaLavorazione))
            return false;
        if (ordineTi == null) {
            if (other.ordineTi != null)
                return false;
        } else if (!ordineTi.equals(other.ordineTi))
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
        if (tipologiaStatoNow == null) {
            if (other.tipologiaStatoNow != null)
                return false;
        } else if (!tipologiaStatoNow.equals(other.tipologiaStatoNow))
            return false;
        return true;
    }

}