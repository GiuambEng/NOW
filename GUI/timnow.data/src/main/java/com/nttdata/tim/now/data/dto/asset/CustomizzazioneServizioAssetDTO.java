package com.nttdata.tim.now.data.dto.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class CustomizzazioneServizioAssetDTO extends ESBResultDTO implements Serializable {
	 
    private static final long serialVersionUID = 2292309400148296015L;

    @JsonProperty("attributoCustomizzazione")
	private String attributoCustomizzazione;

	@JsonProperty("valoreCustomizzazione")
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
        CustomizzazioneServizioAssetDTO other = (CustomizzazioneServizioAssetDTO) obj;
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
        return "CustomizzazioneDTO [attributoCustomizzazione=" + attributoCustomizzazione + ", valoreCustomizzazione=" + valoreCustomizzazione + "]";
    }


}