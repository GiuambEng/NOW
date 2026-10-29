package com.nttdata.tim.now.data.dto.ordine.lavorazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class RecuperoTipologiaLavorazioneOutputDTO extends ESBResultDTO implements Serializable {
	
    private static final long serialVersionUID = 2170440115699161983L;

    @JsonProperty("flagComunicazione")
    private String flagComunicazione;

    @JsonProperty("flagOrdini")
    private String flagOrdini;

    @JsonProperty("idTipologiaLavorazione")
    private String idTipologiaLavorazione;

    @JsonProperty("tipologiaLavorazione")
    private String tipologiaLavorazione;

    @JsonProperty("tipologiaLavorazioneGUI")
    private String tipologiaLavorazioneGUI;

    @JsonProperty("tipologiaLavorazioneDTU")
    private String tipologiaLavorazioneDTU;

    public String getFlagComunicazione() {
        return flagComunicazione;
    }

    public void setFlagComunicazione(String flagComunicazione) {
        this.flagComunicazione = flagComunicazione;
    }

    public String getFlagOrdini() {
        return flagOrdini;
    }

    public void setFlagOrdini(String flagOrdini) {
        this.flagOrdini = flagOrdini;
    }

    public String getIdTipologiaLavorazione() {
        return idTipologiaLavorazione;
    }

    public void setIdTipologiaLavorazione(String idTipologiaLavorazione) {
        this.idTipologiaLavorazione = idTipologiaLavorazione;
    }

    public String getTipologiaLavorazione() {
        return tipologiaLavorazione;
    }

    public void setTipologiaLavorazione(String tipologiaLavorazione) {
        this.tipologiaLavorazione = tipologiaLavorazione;
    }

    public String getTipologiaLavorazioneGUI() {
        return tipologiaLavorazioneGUI;
    }

    public void setTipologiaLavorazioneGUI(String tipologiaLavorazioneGUI) {
        this.tipologiaLavorazioneGUI = tipologiaLavorazioneGUI;
    }

    public String getTipologiaLavorazioneDTU() {
        return tipologiaLavorazioneDTU;
    }

    public void setTipologiaLavorazioneDTU(String tipologiaLavorazioneDTU) {
        this.tipologiaLavorazioneDTU = tipologiaLavorazioneDTU;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((flagComunicazione == null) ? 0 : flagComunicazione.hashCode());
        result = prime * result + ((flagOrdini == null) ? 0 : flagOrdini.hashCode());
        result = prime * result + ((idTipologiaLavorazione == null) ? 0 : idTipologiaLavorazione.hashCode());
        result = prime * result + ((tipologiaLavorazione == null) ? 0 : tipologiaLavorazione.hashCode());
        result = prime * result + ((tipologiaLavorazioneDTU == null) ? 0 : tipologiaLavorazioneDTU.hashCode());
        result = prime * result + ((tipologiaLavorazioneGUI == null) ? 0 : tipologiaLavorazioneGUI.hashCode());
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
        RecuperoTipologiaLavorazioneOutputDTO other = (RecuperoTipologiaLavorazioneOutputDTO) obj;
        if (flagComunicazione == null) {
            if (other.flagComunicazione != null)
                return false;
        } else if (!flagComunicazione.equals(other.flagComunicazione))
            return false;
        if (flagOrdini == null) {
            if (other.flagOrdini != null)
                return false;
        } else if (!flagOrdini.equals(other.flagOrdini))
            return false;
        if (idTipologiaLavorazione == null) {
            if (other.idTipologiaLavorazione != null)
                return false;
        } else if (!idTipologiaLavorazione.equals(other.idTipologiaLavorazione))
            return false;
        if (tipologiaLavorazione == null) {
            if (other.tipologiaLavorazione != null)
                return false;
        } else if (!tipologiaLavorazione.equals(other.tipologiaLavorazione))
            return false;
        if (tipologiaLavorazioneDTU == null) {
            if (other.tipologiaLavorazioneDTU != null)
                return false;
        } else if (!tipologiaLavorazioneDTU.equals(other.tipologiaLavorazioneDTU))
            return false;
        if (tipologiaLavorazioneGUI == null) {
            if (other.tipologiaLavorazioneGUI != null)
                return false;
        } else if (!tipologiaLavorazioneGUI.equals(other.tipologiaLavorazioneGUI))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RecuperoTipologiaLavorazioneInputDTO [flagComunicazione=" + flagComunicazione + ", flagOrdini=" + flagOrdini + ", idTipologiaLavorazione="
                + idTipologiaLavorazione + ", tipologiaLavorazione=" + tipologiaLavorazione + ", tipologiaLavorazioneGUI=" + tipologiaLavorazioneGUI
                + ", tipologiaLavorazioneDTU=" + tipologiaLavorazioneDTU + "]";
    }

    
}
