package com.nttdata.tim.now.data.dto.ordine.donating;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecuperoCodiceDonatingWrapperOutputDTO implements Serializable {

    private static final long serialVersionUID = 1658469629741194691L;

    @JsonProperty("RecuperoCodDonatingOutput")
    private RecuperoCodiceDonatingOutputDTO recuperocoddonating;

    public RecuperoCodiceDonatingOutputDTO getRecuperocoddonating() {
        return recuperocoddonating;
    }

    public void setRecuperocoddonating(RecuperoCodiceDonatingOutputDTO recuperocoddonating) {
        this.recuperocoddonating = recuperocoddonating;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((recuperocoddonating == null) ? 0 : recuperocoddonating.hashCode());
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
        RecuperoCodiceDonatingWrapperOutputDTO other = (RecuperoCodiceDonatingWrapperOutputDTO) obj;
        if (recuperocoddonating == null) {
            if (other.recuperocoddonating != null)
                return false;
        } else if (!recuperocoddonating.equals(other.recuperocoddonating))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RecuperoCodiceDonatingWrapperOutputDTO [recuperocoddonating=" + recuperocoddonating + "]";
    }


}
