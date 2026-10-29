package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class DatiReferentiOnFieldInputDTO implements Serializable {

	private static final long serialVersionUID = -7756990809148047818L;

	@JsonProperty("nomeOnField")
    private String nomeOnField;
    
    @JsonProperty("cognomeOnField")
    private String cognomeOnField;
    
    @JsonProperty("telefonoFissoOnField")
    private String telefonoFissoOnField;
    
    @JsonProperty("cellulareOnField")
    private String cellulareOnField;

    public String getNomeOnField() {
        return nomeOnField;
    }

    public void setNomeOnField(String nomeOnField) {
        this.nomeOnField = nomeOnField;
    }

    public String getCognomeOnField() {
        return cognomeOnField;
    }

    public void setCognomeOnField(String cognomeOnField) {
        this.cognomeOnField = cognomeOnField;
    }

    public String getTelefonoFissoOnField() {
        return telefonoFissoOnField;
    }

    public void setTelefonoFissoOnField(String telefonoFissoOnField) {
        this.telefonoFissoOnField = telefonoFissoOnField;
    }

    public String getCellulareOnField() {
        return cellulareOnField;
    }

    public void setCellulareOnField(String cellulareOnField) {
        this.cellulareOnField = cellulareOnField;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cellulareOnField == null) ? 0 : cellulareOnField.hashCode());
        result = prime * result + ((cognomeOnField == null) ? 0 : cognomeOnField.hashCode());
        result = prime * result + ((nomeOnField == null) ? 0 : nomeOnField.hashCode());
        result = prime * result + ((telefonoFissoOnField == null) ? 0 : telefonoFissoOnField.hashCode());
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
        DatiReferentiOnFieldInputDTO other = (DatiReferentiOnFieldInputDTO) obj;
        if (cellulareOnField == null) {
            if (other.cellulareOnField != null)
                return false;
        } else if (!cellulareOnField.equals(other.cellulareOnField))
            return false;
        if (cognomeOnField == null) {
            if (other.cognomeOnField != null)
                return false;
        } else if (!cognomeOnField.equals(other.cognomeOnField))
            return false;
        if (nomeOnField == null) {
            if (other.nomeOnField != null)
                return false;
        } else if (!nomeOnField.equals(other.nomeOnField))
            return false;
        if (telefonoFissoOnField == null) {
            if (other.telefonoFissoOnField != null)
                return false;
        } else if (!telefonoFissoOnField.equals(other.telefonoFissoOnField))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DatiReferentiOnFieldDTO [nomeOnField=" + nomeOnField + ", cognomeOnField=" + cognomeOnField + ", telefonoFissoOnField=" + telefonoFissoOnField
                + ", cellulareOnField=" + cellulareOnField + "]";
    }
    
    
}
