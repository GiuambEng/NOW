package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class VerificaIdRisorsaInputBean implements Serializable {

    private static final long serialVersionUID = -6959314056418316773L;

    @JsonProperty("idRisorsa")
    private String idRisorsa;
    
    @JsonProperty("idOfferta")
    private String idOfferta;
    
    @JsonProperty("codiceOloAgcom")
    private String codiceOloAgcom;

    public String getIdRisorsa() {
        return idRisorsa;
    }

    public void setIdRisorsa(String idRisorsa) {
        this.idRisorsa = idRisorsa;
    }

    public String getIdOfferta() {
        return idOfferta;
    }

    public void setIdOfferta(String idOfferta) {
        this.idOfferta = idOfferta;
    }

    public String getCodiceOloAgcom() {
        return codiceOloAgcom;
    }

    public void setCodiceOloAgcom(String codiceOloAgcom) {
        this.codiceOloAgcom = codiceOloAgcom;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codiceOloAgcom == null) ? 0 : codiceOloAgcom.hashCode());
        result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
        result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
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
        VerificaIdRisorsaInputBean other = (VerificaIdRisorsaInputBean) obj;
        if (codiceOloAgcom == null) {
            if (other.codiceOloAgcom != null)
                return false;
        } else if (!codiceOloAgcom.equals(other.codiceOloAgcom))
            return false;
        if (idOfferta == null) {
            if (other.idOfferta != null)
                return false;
        } else if (!idOfferta.equals(other.idOfferta))
            return false;
        if (idRisorsa == null) {
            if (other.idRisorsa != null)
                return false;
        } else if (!idRisorsa.equals(other.idRisorsa))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "VerificaIdRisorsaInputBean [idRisorsa=" + idRisorsa + ", idOfferta=" + idOfferta + ", codiceOloAgcom=" + codiceOloAgcom + "]";
    }

    
}
