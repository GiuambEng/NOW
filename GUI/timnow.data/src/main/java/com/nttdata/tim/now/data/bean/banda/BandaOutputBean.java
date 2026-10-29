package com.nttdata.tim.now.data.bean.banda;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class BandaOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 3055392235749641286L;

	@JsonProperty("up")
    private String bandaPiccoUP;

	@JsonProperty("down")
    private String bandaPiccoDOWN;

    public String getBandaPiccoUP() {
        return bandaPiccoUP;
	}

    public void setBandaPiccoUP(String bandaPiccoUP) {
        this.bandaPiccoUP = bandaPiccoUP;
	}

    public String getBandaPiccoDOWN() {
        return bandaPiccoDOWN;
	}

    public void setBandaPiccoDOWN(String bandaPiccoDOWN) {
        this.bandaPiccoDOWN = bandaPiccoDOWN;
    }

    @Override
    public String toString() {
        return "BandaOutputBean [bandaPiccoUP=" + bandaPiccoUP + ", bandaPiccoDOWN=" + bandaPiccoDOWN + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bandaPiccoDOWN == null) ? 0 : bandaPiccoDOWN.hashCode());
        result = prime * result + ((bandaPiccoUP == null) ? 0 : bandaPiccoUP.hashCode());
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
        BandaOutputBean other = (BandaOutputBean) obj;
        if (bandaPiccoDOWN == null) {
            if (other.bandaPiccoDOWN != null)
                return false;
        } else if (!bandaPiccoDOWN.equals(other.bandaPiccoDOWN))
            return false;
        if (bandaPiccoUP == null) {
            if (other.bandaPiccoUP != null)
                return false;
        } else if (!bandaPiccoUP.equals(other.bandaPiccoUP))
            return false;
        return true;
	}

}