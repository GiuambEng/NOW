
package com.nttdata.tim.now.data.dto.banda;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class VerificaSommaBandePiccoInputDTO implements Serializable {
 
    private static final long serialVersionUID = -3355732886742835631L;

    @JsonProperty("ProfiloTecnicoLinea")
    private String profiloTecnicoLinea;

    @JsonProperty("Offerta")
    private String offerta;

    @JsonProperty("UserVlan")
    private List<BandaOutputDTO> userVlan;

    public String getProfiloTecnicoLinea() {
        return profiloTecnicoLinea;
    }

    public void setProfiloTecnicoLinea(String profiloTecnicoLinea) {
        this.profiloTecnicoLinea = profiloTecnicoLinea;
    }

    public String getOfferta() {
        return offerta;
    }

    public void setOfferta(String offerta) {
        this.offerta = offerta;
    }

    public List<BandaOutputDTO> getUserVlan() {
        return userVlan;
    }

    public void setUserVlan(List<BandaOutputDTO> userVlan) {
        this.userVlan = userVlan;
    }

    @Override
    public String toString() {
        return "VerificaSommaBandePiccoInputDTO [profiloTecnicoLinea=" + profiloTecnicoLinea + ", offerta=" + offerta + ", userVlan=" + userVlan + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
        result = prime * result + ((profiloTecnicoLinea == null) ? 0 : profiloTecnicoLinea.hashCode());
        result = prime * result + ((userVlan == null) ? 0 : userVlan.hashCode());
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
        VerificaSommaBandePiccoInputDTO other = (VerificaSommaBandePiccoInputDTO) obj;
        if (offerta == null) {
            if (other.offerta != null)
                return false;
        } else if (!offerta.equals(other.offerta))
            return false;
        if (profiloTecnicoLinea == null) {
            if (other.profiloTecnicoLinea != null)
                return false;
        } else if (!profiloTecnicoLinea.equals(other.profiloTecnicoLinea))
            return false;
        if (userVlan == null) {
            if (other.userVlan != null)
                return false;
        } else if (!userVlan.equals(other.userVlan))
            return false;
        return true;
    }

}
