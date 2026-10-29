package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class VerificaCompatibilitaLavorazioneOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -4907946000165116895L;

    @JsonProperty("codice")
	private String codice;

	@JsonProperty("descrizione")
	private String descrizione;

    @JsonProperty("scenario")
    private String scenario;

    @JsonProperty("codiceTrasformazione")
    private String codiceTrasformazione;

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getCodiceTrasformazione() {
        return codiceTrasformazione;
    }

    public void setCodiceTrasformazione(String codiceTrasformazione) {
        this.codiceTrasformazione = codiceTrasformazione;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codice == null) ? 0 : codice.hashCode());
        result = prime * result + ((codiceTrasformazione == null) ? 0 : codiceTrasformazione.hashCode());
        result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
        result = prime * result + ((scenario == null) ? 0 : scenario.hashCode());
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
        VerificaCompatibilitaLavorazioneOutputBean other = (VerificaCompatibilitaLavorazioneOutputBean) obj;
        if (codice == null) {
            if (other.codice != null)
                return false;
        } else if (!codice.equals(other.codice))
            return false;
        if (codiceTrasformazione == null) {
            if (other.codiceTrasformazione != null)
                return false;
        } else if (!codiceTrasformazione.equals(other.codiceTrasformazione))
            return false;
        if (descrizione == null) {
            if (other.descrizione != null)
                return false;
        } else if (!descrizione.equals(other.descrizione))
            return false;
        if (scenario == null) {
            if (other.scenario != null)
                return false;
        } else if (!scenario.equals(other.scenario))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "VerificaCompatibilitaLavorazioneOutputBean [codice=" + codice + ", descrizione=" + descrizione + ", scenario=" + scenario
                + ", codiceTrasformazione=" + codiceTrasformazione + "]";
    }

    

}
