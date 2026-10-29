package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class AttributiOffertaInputBean implements Serializable {

    private static final long serialVersionUID = 6116486008864020918L;

    @JsonProperty("sezioneSuperiore")
    private List<SezioneOffertaInputBean> sezioneSuperiore;
    
    @JsonProperty("sezioneInferiore")
    private List<SezioneOffertaInputBean> sezioneInferiore;

    public List<SezioneOffertaInputBean> getSezioneSuperiore() {
        return sezioneSuperiore;
    }

    public void setSezioneSuperiore(List<SezioneOffertaInputBean> sezioneSuperiore) {
        this.sezioneSuperiore = sezioneSuperiore;
    }

    public List<SezioneOffertaInputBean> getSezioneInferiore() {
        return sezioneInferiore;
    }

    public void setSezioneInferiore(List<SezioneOffertaInputBean> sezioneInferiore) {
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
        AttributiOffertaInputBean other = (AttributiOffertaInputBean) obj;
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
        return "AttributiOffertaInputBean [sezioneSuperiore=" + sezioneSuperiore + ", sezioneInferiore=" + sezioneInferiore + "]";
    }

    
    
}
