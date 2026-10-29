package com.nttdata.tim.now.data.dto.monitoring.file;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileScadutiOutputDTO extends ESBResultDTO {

    private static final long serialVersionUID = 2233782590623469321L;

    @JsonProperty("tot")
    private String tot;

    public String getTot() {
        return tot;
    }

    public void setTot(String tot) {
        this.tot = tot;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tot == null) ? 0 : tot.hashCode());
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
        FileScadutiOutputDTO other = (FileScadutiOutputDTO) obj;
        if (tot == null) {
            if (other.tot != null)
                return false;
        } else if (!tot.equals(other.tot))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FileScadutiOutputDTO [tot=" + tot + "]";
    }

}
