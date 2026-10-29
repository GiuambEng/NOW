package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class VerificaIdRisorsaOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 7973335439401614334L;

    @JsonProperty("descrizione")
    private String descrizione;

    @JsonProperty("esito")
    private String esito;

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
        result = prime * result + ((esito == null) ? 0 : esito.hashCode());
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
        VerificaIdRisorsaOutputBean other = (VerificaIdRisorsaOutputBean) obj;
        if (descrizione == null) {
            if (other.descrizione != null)
                return false;
        } else if (!descrizione.equals(other.descrizione))
            return false;
        if (esito == null) {
            if (other.esito != null)
                return false;
        } else if (!esito.equals(other.esito))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "VerificaIdRisorsaOutputBean [descrizione=" + descrizione + ", esito=" + esito + "]";
    }

    
    
}
