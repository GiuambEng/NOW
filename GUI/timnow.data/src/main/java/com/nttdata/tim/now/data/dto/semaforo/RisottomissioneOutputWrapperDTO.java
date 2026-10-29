package com.nttdata.tim.now.data.dto.semaforo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class RisottomissioneOutputWrapperDTO extends ESBResultDTO implements Serializable{
    
    private static final long serialVersionUID = -253868206205196304L;

    @JsonProperty("OutputRisottomissioneFileInElaborazione")
    private RisottomissioneOutputDTO risottomissione;

    public RisottomissioneOutputDTO getRisottomissione() {
        return risottomissione;
    }

    public void setRisottomissione(RisottomissioneOutputDTO risottomissione) {
        this.risottomissione = risottomissione;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((risottomissione == null) ? 0 : risottomissione.hashCode());
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
        RisottomissioneOutputWrapperDTO other = (RisottomissioneOutputWrapperDTO) obj;
        if (risottomissione == null) {
            if (other.risottomissione != null)
                return false;
        } else if (!risottomissione.equals(other.risottomissione))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RisottomissioneOutputWrapperDTO [risottomissione=" + risottomissione + "]";
    }
    
    


}
