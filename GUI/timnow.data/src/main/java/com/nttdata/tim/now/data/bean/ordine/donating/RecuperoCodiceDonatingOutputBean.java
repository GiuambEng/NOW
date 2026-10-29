package com.nttdata.tim.now.data.bean.ordine.donating;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class RecuperoCodiceDonatingOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 7496613674382079922L;

    @JsonProperty("codDonating1")
    private CodDonatingOutputBean codDonating1;

    @JsonProperty("codDonating2")
    private CodDonatingOutputBean codDonating2;

    public CodDonatingOutputBean getCodDonating1() {
        return codDonating1;
    }

    public void setCodDonating1(CodDonatingOutputBean codDonating1) {
        this.codDonating1 = codDonating1;
    }

    public CodDonatingOutputBean getCodDonating2() {
        return codDonating2;
    }

    public void setCodDonating2(CodDonatingOutputBean codDonating2) {
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
        RecuperoCodiceDonatingOutputBean other = (RecuperoCodiceDonatingOutputBean) obj;
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
        return "RecuperoCodiceDonatingOutputBean [codDonating1=" + codDonating1 + ", codDonating2=" + codDonating2 + "]";
    }

    
}
