package com.nttdata.tim.now.data.dto.monitoring.generanotifiche;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class RichiestaGeneraNotificheInputDTO implements Serializable {

	private static final long serialVersionUID = 3005876535077670202L;

	@JsonProperty("id_richiesta")
	private String idRichiesta;

	@JsonProperty("id_fam_offerta")
	private String idFamigliaOfferta;

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

	@JsonProperty("struttura_richiesta_Recipient")
	private String strutturaRichiestaRecipient;

	@JsonProperty("struttura_richiesta_Donor")
	private String strutturaRichiestaDonor;

	@JsonProperty("struttura_richiesta_Donating")
	private String strutturaRichiestaDonating;

	@JsonProperty("flag_dest_Recipient")
	private String flagDestinazioneRecipient;

	@JsonProperty("flag_dest_Donor")
	private String flagDestinazioneDonor;

	@JsonProperty("flag_dest_Donating")
	private String flagDestinazioneDonating;
	
	@JsonProperty("matricolaOperatoreDaGUI")
	private String matricolaOperatoreDaGUI;

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

    public String getFlagDestinazioneRecipient() {
        return flagDestinazioneRecipient;
    }

    public void setFlagDestinazioneRecipient(String flagDestinazioneRecipient) {
        this.flagDestinazioneRecipient = flagDestinazioneRecipient;
    }

    public String getFlagDestinazioneDonor() {
        return flagDestinazioneDonor;
    }

    public void setFlagDestinazioneDonor(String flagDestinazioneDonor) {
        this.flagDestinazioneDonor = flagDestinazioneDonor;
    }

    public String getFlagDestinazioneDonating() {
        return flagDestinazioneDonating;
    }

    public void setFlagDestinazioneDonating(String flagDestinazioneDonating) {
        this.flagDestinazioneDonating = flagDestinazioneDonating;
    }

    public String getMatricolaOperatoreDaGUI() {
        return matricolaOperatoreDaGUI;
    }

    public void setMatricolaOperatoreDaGUI(String matricolaOperatoreDaGUI) {
        this.matricolaOperatoreDaGUI = matricolaOperatoreDaGUI;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codiceTipologiaNotificaDonating == null) ? 0 : codiceTipologiaNotificaDonating.hashCode());
        result = prime * result + ((codiceTipologiaNotificaDonor == null) ? 0 : codiceTipologiaNotificaDonor.hashCode());
        result = prime * result + ((codiceTipologiaNotificaRecipient == null) ? 0 : codiceTipologiaNotificaRecipient.hashCode());
        result = prime * result + ((flagDestinazioneDonating == null) ? 0 : flagDestinazioneDonating.hashCode());
        result = prime * result + ((flagDestinazioneDonor == null) ? 0 : flagDestinazioneDonor.hashCode());
        result = prime * result + ((flagDestinazioneRecipient == null) ? 0 : flagDestinazioneRecipient.hashCode());
        result = prime * result + ((idFamigliaOfferta == null) ? 0 : idFamigliaOfferta.hashCode());
        result = prime * result + ((idNotifica == null) ? 0 : idNotifica.hashCode());
        result = prime * result + ((idRichiesta == null) ? 0 : idRichiesta.hashCode());
        result = prime * result + ((idTipologiaLavorazione == null) ? 0 : idTipologiaLavorazione.hashCode());
        result = prime * result + ((matricolaOperatoreDaGUI == null) ? 0 : matricolaOperatoreDaGUI.hashCode());
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
        RichiestaGeneraNotificheInputDTO other = (RichiestaGeneraNotificheInputDTO) obj;
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
        if (flagDestinazioneDonating == null) {
            if (other.flagDestinazioneDonating != null)
                return false;
        } else if (!flagDestinazioneDonating.equals(other.flagDestinazioneDonating))
            return false;
        if (flagDestinazioneDonor == null) {
            if (other.flagDestinazioneDonor != null)
                return false;
        } else if (!flagDestinazioneDonor.equals(other.flagDestinazioneDonor))
            return false;
        if (flagDestinazioneRecipient == null) {
            if (other.flagDestinazioneRecipient != null)
                return false;
        } else if (!flagDestinazioneRecipient.equals(other.flagDestinazioneRecipient))
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
        if (matricolaOperatoreDaGUI == null) {
            if (other.matricolaOperatoreDaGUI != null)
                return false;
        } else if (!matricolaOperatoreDaGUI.equals(other.matricolaOperatoreDaGUI))
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

    @Override
    public String toString() {
        return "RichiestaGeneraNotificheInputDTO [idRichiesta=" + idRichiesta + ", idFamigliaOfferta=" + idFamigliaOfferta + ", ordineTi=" + ordineTi
                + ", idTipologiaLavorazione=" + idTipologiaLavorazione + ", tipologiaStatoNow=" + tipologiaStatoNow + ", idNotifica=" + idNotifica
                + ", codiceTipologiaNotificaRecipient=" + codiceTipologiaNotificaRecipient + ", codiceTipologiaNotificaDonor=" + codiceTipologiaNotificaDonor
                + ", codiceTipologiaNotificaDonating=" + codiceTipologiaNotificaDonating + ", strutturaRichiestaRecipient=" + strutturaRichiestaRecipient
                + ", strutturaRichiestaDonor=" + strutturaRichiestaDonor + ", strutturaRichiestaDonating=" + strutturaRichiestaDonating
                + ", flagDestinazioneRecipient=" + flagDestinazioneRecipient + ", flagDestinazioneDonor=" + flagDestinazioneDonor
                + ", flagDestinazioneDonating=" + flagDestinazioneDonating + ", matricolaOperatoreDaGUI=" + matricolaOperatoreDaGUI + "]";
    }


}
