package com.nttdata.tim.now.data.dto.monitoring.generanotifiche;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class CodiceRichiestaDTO implements Serializable {
	
	private static final long serialVersionUID = -2302128979714623175L;

	@JsonProperty("id_richiesta")
    private String idRichiesta;

    @JsonProperty("id_fam_offerta")
    private String idFamigliaOfferta;

    @JsonProperty("lista_Notifiche")
    private List<NotificationRequestDTO> codiceRichiesta;

    @JsonProperty("ordine_ti")
    private String ordineTi;

    @JsonProperty("id_tplg_lvrz")
    private String idTipologiaLavorazione;

    @JsonProperty("tplg_stato_now")
    private String tipologiaStatoNow;

    @JsonProperty("id_notifica")
    private String idNotifica;

    @JsonProperty("cod_tplg_ntf_Recipient")
    private String codiceTipologiaNotificaRecipient;

    @JsonProperty("cod_tplg_ntf_Donor")
    private String codiceTipologiaNotificaDonor;

    @JsonProperty("cod_tplg_ntf_Donating")
    private String codiceTipologiaNotificaDonating;

    @JsonProperty("struttura_Richiesta_Donor")
    private String strutturaRichiestDonating;

    @JsonProperty("flag_dest_Recipient")
    private boolean flagDestinazioneRecipient;

    @JsonProperty("flag_dest_Donor")
    private boolean flagDestinazioneDonor;

    @JsonProperty("flag_dest_Donating")
    private boolean flagDestinazioneDonating;
    
    @JsonProperty("matricolaOperatoreDaGUI")
    private String matricolaOperatoreDaGui;

    @JsonProperty("cod_tplg_ntf")
    private String codiceTipologiaNotifica;

    @JsonProperty("struttura_richiesta")
    private String strutturaRichiesta;

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

    public List<NotificationRequestDTO> getCodiceRichiesta() {
        return codiceRichiesta;
    }

    public void setCodiceRichiesta(List<NotificationRequestDTO> codiceRichiesta) {
        this.codiceRichiesta = codiceRichiesta;
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

    public String getStrutturaRichiestDonating() {
        return strutturaRichiestDonating;
    }

    public void setStrutturaRichiestDonating(String strutturaRichiestDonating) {
        this.strutturaRichiestDonating = strutturaRichiestDonating;
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

    public String getMatricolaOperatoreDaGui() {
        return matricolaOperatoreDaGui;
    }

    public void setMatricolaOperatoreDaGui(String matricolaOperatoreDaGui) {
        this.matricolaOperatoreDaGui = matricolaOperatoreDaGui;
    }

    public String getCodiceTipologiaNotifica() {
        return codiceTipologiaNotifica;
    }

    public void setCodiceTipologiaNotifica(String codiceTipologiaNotifica) {
        this.codiceTipologiaNotifica = codiceTipologiaNotifica;
    }

    public String getStrutturaRichiesta() {
        return strutturaRichiesta;
    }

    public void setStrutturaRichiesta(String strutturaRichiesta) {
        this.strutturaRichiesta = strutturaRichiesta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codiceRichiesta == null) ? 0 : codiceRichiesta.hashCode());
        result = prime * result + ((codiceTipologiaNotifica == null) ? 0 : codiceTipologiaNotifica.hashCode());
        result = prime * result + ((codiceTipologiaNotificaDonating == null) ? 0 : codiceTipologiaNotificaDonating.hashCode());
        result = prime * result + ((codiceTipologiaNotificaDonor == null) ? 0 : codiceTipologiaNotificaDonor.hashCode());
        result = prime * result + ((codiceTipologiaNotificaRecipient == null) ? 0 : codiceTipologiaNotificaRecipient.hashCode());
        result = prime * result + (flagDestinazioneDonating ? 1231 : 1237);
        result = prime * result + (flagDestinazioneDonor ? 1231 : 1237);
        result = prime * result + (flagDestinazioneRecipient ? 1231 : 1237);
        result = prime * result + ((idFamigliaOfferta == null) ? 0 : idFamigliaOfferta.hashCode());
        result = prime * result + ((idNotifica == null) ? 0 : idNotifica.hashCode());
        result = prime * result + ((idRichiesta == null) ? 0 : idRichiesta.hashCode());
        result = prime * result + ((idTipologiaLavorazione == null) ? 0 : idTipologiaLavorazione.hashCode());
        result = prime * result + ((matricolaOperatoreDaGui == null) ? 0 : matricolaOperatoreDaGui.hashCode());
        result = prime * result + ((ordineTi == null) ? 0 : ordineTi.hashCode());
        result = prime * result + ((strutturaRichiestDonating == null) ? 0 : strutturaRichiestDonating.hashCode());
        result = prime * result + ((strutturaRichiesta == null) ? 0 : strutturaRichiesta.hashCode());
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
        CodiceRichiestaDTO other = (CodiceRichiestaDTO) obj;
        if (codiceRichiesta == null) {
            if (other.codiceRichiesta != null)
                return false;
        } else if (!codiceRichiesta.equals(other.codiceRichiesta))
            return false;
        if (codiceTipologiaNotifica == null) {
            if (other.codiceTipologiaNotifica != null)
                return false;
        } else if (!codiceTipologiaNotifica.equals(other.codiceTipologiaNotifica))
            return false;
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
        if (matricolaOperatoreDaGui == null) {
            if (other.matricolaOperatoreDaGui != null)
                return false;
        } else if (!matricolaOperatoreDaGui.equals(other.matricolaOperatoreDaGui))
            return false;
        if (ordineTi == null) {
            if (other.ordineTi != null)
                return false;
        } else if (!ordineTi.equals(other.ordineTi))
            return false;
        if (strutturaRichiestDonating == null) {
            if (other.strutturaRichiestDonating != null)
                return false;
        } else if (!strutturaRichiestDonating.equals(other.strutturaRichiestDonating))
            return false;
        if (strutturaRichiesta == null) {
            if (other.strutturaRichiesta != null)
                return false;
        } else if (!strutturaRichiesta.equals(other.strutturaRichiesta))
            return false;
        if (tipologiaStatoNow == null) {
            if (other.tipologiaStatoNow != null)
                return false;
        } else if (!tipologiaStatoNow.equals(other.tipologiaStatoNow))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CodiceRichiestaDTO [idRichiesta=" + idRichiesta + ", idFamigliaOfferta=" + idFamigliaOfferta + ", codiceRichiesta=" + codiceRichiesta
                + ", ordineTi=" + ordineTi + ", idTipologiaLavorazione=" + idTipologiaLavorazione + ", tipologiaStatoNow=" + tipologiaStatoNow + ", idNotifica="
                + idNotifica + ", codiceTipologiaNotificaRecipient=" + codiceTipologiaNotificaRecipient + ", codiceTipologiaNotificaDonor="
                + codiceTipologiaNotificaDonor + ", codiceTipologiaNotificaDonating=" + codiceTipologiaNotificaDonating + ", strutturaRichiestDonating="
                + strutturaRichiestDonating + ", flagDestinazioneRecipient=" + flagDestinazioneRecipient + ", flagDestinazioneDonor=" + flagDestinazioneDonor
                + ", flagDestinazioneDonating=" + flagDestinazioneDonating + ", matricolaOperatoreDaGui=" + matricolaOperatoreDaGui
                + ", codiceTipologiaNotifica=" + codiceTipologiaNotifica + ", strutturaRichiesta=" + strutturaRichiesta + "]";
    }


}
