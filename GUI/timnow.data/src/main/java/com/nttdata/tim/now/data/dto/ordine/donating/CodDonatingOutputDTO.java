package com.nttdata.tim.now.data.dto.ordine.donating;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CodDonatingOutputDTO implements Serializable {

    private static final long serialVersionUID = 3951075518683177438L;

    @JsonProperty("esito")
    private String esito;

    @JsonProperty("message")
    private String message;

    @JsonProperty("codDonating")
    private String codDonating;

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCodDonating() {
        return codDonating;
    }

    public void setCodDonating(String codDonating) {
        this.codDonating = codDonating;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codDonating == null) ? 0 : codDonating.hashCode());
        result = prime * result + ((esito == null) ? 0 : esito.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
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
        CodDonatingOutputDTO other = (CodDonatingOutputDTO) obj;
        if (codDonating == null) {
            if (other.codDonating != null)
                return false;
        } else if (!codDonating.equals(other.codDonating))
            return false;
        if (esito == null) {
            if (other.esito != null)
                return false;
        } else if (!esito.equals(other.esito))
            return false;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CodDonatingOutputDTO [esito=" + esito + ", message=" + message + ", codDonating=" + codDonating + "]";
    }

 
    
}
