package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class AttributiOffertaInputDTO implements Serializable {

	private static final long serialVersionUID = -3659605636471721812L;

	@JsonProperty("sezioneSuperiore")
    private List<SezioneOffertaInputDTO> sezioneSuperiore;
    
    @JsonProperty("sezioneInferiore")
    private List<SezioneOffertaInputDTO> sezioneInferiore;

    public List<SezioneOffertaInputDTO> getSezioneSuperiore() {
        return sezioneSuperiore;
    }

    public void setSezioneSuperiore(List<SezioneOffertaInputDTO> sezioneSuperiore) {
        this.sezioneSuperiore = sezioneSuperiore;
    }

    public List<SezioneOffertaInputDTO> getSezioneInferiore() {
        return sezioneInferiore;
    }

    public void setSezioneInferiore(List<SezioneOffertaInputDTO> sezioneInferiore) {
        this.sezioneInferiore = sezioneInferiore;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sezioneInferiore == null) ? 0 : sezioneInferiore.hashCode());
        result = prime * result + ((sezioneSuperiore == null) ? 0 : sezioneSuperiore.hashCode());
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
        AttributiOffertaInputDTO other = (AttributiOffertaInputDTO) obj;
        if (sezioneInferiore == null) {
            if (other.sezioneInferiore != null)
                return false;
        } else if (!sezioneInferiore.equals(other.sezioneInferiore))
            return false;
        if (sezioneSuperiore == null) {
            if (other.sezioneSuperiore != null)
                return false;
        } else if (!sezioneSuperiore.equals(other.sezioneSuperiore))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AttributiOffertaInputDTO [sezioneSuperiore=" + sezioneSuperiore + ", sezioneInferiore=" + sezioneInferiore + "]";
    }


}
