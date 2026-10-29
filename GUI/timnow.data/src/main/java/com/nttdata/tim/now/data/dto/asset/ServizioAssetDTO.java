package com.nttdata.tim.now.data.dto.asset;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ServizioAssetDTO implements Serializable {
	 
    private static final long serialVersionUID = -5844011697809415632L;

    @JsonProperty("prodotto")
	private String prodotto;

	@JsonProperty("customizzazione")
	private List<CustomizzazioneServizioAssetDTO> customizzazione;

    public String getProdotto() {
        return prodotto;
    }

    public void setProdotto(String prodotto) {
        this.prodotto = prodotto;
    }

    public List<CustomizzazioneServizioAssetDTO> getCustomizzazione() {
        return customizzazione;
    }

    public void setCustomizzazione(List<CustomizzazioneServizioAssetDTO> customizzazione) {
        this.customizzazione = customizzazione;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customizzazione == null) ? 0 : customizzazione.hashCode());
        result = prime * result + ((prodotto == null) ? 0 : prodotto.hashCode());
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
        ServizioAssetDTO other = (ServizioAssetDTO) obj;
        if (customizzazione == null) {
            if (other.customizzazione != null)
                return false;
        } else if (!customizzazione.equals(other.customizzazione))
            return false;
        if (prodotto == null) {
            if (other.prodotto != null)
                return false;
        } else if (!prodotto.equals(other.prodotto))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ServizioDTO [prodotto=" + prodotto + ", customizzazione=" + customizzazione + "]";
    }



}