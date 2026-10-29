package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class CustomizzazioneServizioAssetBean implements Serializable {

    private static final long serialVersionUID = -4744292204377552635L;

    @JsonProperty("attribute")
    private String attributoCustomizzazione;

    @JsonProperty("value")
    private String valoreCustomizzazione;

    public String getAttributoCustomizzazione() {
        return attributoCustomizzazione;
    }

    public void setAttributoCustomizzazione(String attributoCustomizzazione) {
        this.attributoCustomizzazione = attributoCustomizzazione;
    }

    public String getValoreCustomizzazione() {
        return valoreCustomizzazione;
    }

    public void setValoreCustomizzazione(String valoreCustomizzazione) {
        this.valoreCustomizzazione = valoreCustomizzazione;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((attributoCustomizzazione == null) ? 0 : attributoCustomizzazione.hashCode());
        result = prime * result + ((valoreCustomizzazione == null) ? 0 : valoreCustomizzazione.hashCode());
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
        CustomizzazioneServizioAssetBean other = (CustomizzazioneServizioAssetBean) obj;
        if (attributoCustomizzazione == null) {
            if (other.attributoCustomizzazione != null)
                return false;
        } else if (!attributoCustomizzazione.equals(other.attributoCustomizzazione))
            return false;
        if (valoreCustomizzazione == null) {
            if (other.valoreCustomizzazione != null)
                return false;
        } else if (!valoreCustomizzazione.equals(other.valoreCustomizzazione))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CustomizzazioneBean [attributoCustomizzazione=" + attributoCustomizzazione + ", valoreCustomizzazione=" + valoreCustomizzazione + "]";
    }

}