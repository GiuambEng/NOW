
package com.nttdata.tim.now.data.dto.monitoring.usertask;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CausaliDTO implements Serializable {
	
	private static final long serialVersionUID = -1923379852384819267L;
	
	@JsonProperty("causaleDaImpostare")
    private String causaleDaImpostare;
	
    @JsonProperty("idCausaleDaImpostare")
    private String idCausaleDaImpostare;

    public String getCausaleDaImpostare() {
        return causaleDaImpostare;
    }
    
    public void setCausaleDaImpostare(String causaleDaImpostare) {
        this.causaleDaImpostare = causaleDaImpostare;
    }
    
    public String getIdCausaleDaImpostare() {
        return idCausaleDaImpostare;
    }
    
    public void setIdCausaleDaImpostare(String idCausaleDaImpostare) {
        this.idCausaleDaImpostare = idCausaleDaImpostare;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((causaleDaImpostare == null) ? 0 : causaleDaImpostare.hashCode());
        result = prime * result + ((idCausaleDaImpostare == null) ? 0 : idCausaleDaImpostare.hashCode());
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
        CausaliDTO other = (CausaliDTO) obj;
        if (causaleDaImpostare == null) {
            if (other.causaleDaImpostare != null)
                return false;
        } else if (!causaleDaImpostare.equals(other.causaleDaImpostare))
            return false;
        if (idCausaleDaImpostare == null) {
            if (other.idCausaleDaImpostare != null)
                return false;
        } else if (!idCausaleDaImpostare.equals(other.idCausaleDaImpostare))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "CausaliDTO [causaleDaImpostare=" + causaleDaImpostare + ", idCausaleDaImpostare=" + idCausaleDaImpostare + "]";
    }

}
