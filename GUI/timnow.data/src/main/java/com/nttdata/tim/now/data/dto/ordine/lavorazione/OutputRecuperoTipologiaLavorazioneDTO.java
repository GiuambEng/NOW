package com.nttdata.tim.now.data.dto.ordine.lavorazione;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class OutputRecuperoTipologiaLavorazioneDTO extends ESBResultDTO implements Serializable {
	
    private static final long serialVersionUID = -6040114346166977043L;

    @JsonProperty("outputRecuperoTipologiaLavorazione")
    private List<RecuperoTipologiaLavorazioneOutputDTO> recuperoTipologiaLavorazione;

    public List<RecuperoTipologiaLavorazioneOutputDTO> getRecuperoTipologiaLavorazione() {
        return recuperoTipologiaLavorazione;
    }

    public void setRecuperoTipologiaLavorazione(List<RecuperoTipologiaLavorazioneOutputDTO> recuperoTipologiaLavorazione) {
        this.recuperoTipologiaLavorazione = recuperoTipologiaLavorazione;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((recuperoTipologiaLavorazione == null) ? 0 : recuperoTipologiaLavorazione.hashCode());
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
        OutputRecuperoTipologiaLavorazioneDTO other = (OutputRecuperoTipologiaLavorazioneDTO) obj;
        if (recuperoTipologiaLavorazione == null) {
            if (other.recuperoTipologiaLavorazione != null)
                return false;
        } else if (!recuperoTipologiaLavorazione.equals(other.recuperoTipologiaLavorazione))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OutputRecuperoTipologiaLavorazioneDTO [recuperoTipologiaLavorazione=" + recuperoTipologiaLavorazione + "]";
    }

}
