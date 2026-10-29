package com.nttdata.tim.now.data.dto.ordine.donating;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class RecuperoCodiceDonatingOutputDTO extends ESBResultDTO implements Serializable {

    private static final long serialVersionUID = -8004168114330081856L;

    @JsonProperty("CodDonating1")
    private CodDonatingOutputDTO codDonating1;

    @JsonProperty("CodDonating2")
    private CodDonatingOutputDTO codDonating2;

    public CodDonatingOutputDTO getCodDonating1() {
        return codDonating1;
    }

    public void setCodDonating1(CodDonatingOutputDTO codDonating1) {
        this.codDonating1 = codDonating1;
    }

    public CodDonatingOutputDTO getCodDonating2() {
        return codDonating2;
    }

    public void setCodDonating2(CodDonatingOutputDTO codDonating2) {
        this.codDonating2 = codDonating2;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codDonating1 == null) ? 0 : codDonating1.hashCode());
        result = prime * result + ((codDonating2 == null) ? 0 : codDonating2.hashCode());
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
        RecuperoCodiceDonatingOutputDTO other = (RecuperoCodiceDonatingOutputDTO) obj;
        if (codDonating1 == null) {
            if (other.codDonating1 != null)
                return false;
        } else if (!codDonating1.equals(other.codDonating1))
            return false;
        if (codDonating2 == null) {
            if (other.codDonating2 != null)
                return false;
        } else if (!codDonating2.equals(other.codDonating2))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RecuperoCodiceDonatingOutputDTO [codDonating1=" + codDonating1 + ", codDonating2=" + codDonating2 + "]";
    }

    
}
