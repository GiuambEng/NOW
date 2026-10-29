package com.nttdata.tim.now.data.bean.dtu;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class SezioneAggiuntiviOutputBean implements Serializable{

    private static final long serialVersionUID = 7476113546332284493L;

    @JsonProperty("numeroAggiuntivo")
    private String numeroAggiuntivo;

    @JsonProperty("accesso")
    private String accesso;
    
    @JsonProperty("direzionalita")
    private String direzionalita;
    
    @JsonProperty("progressivo")
    private String progressivo;
    
    @JsonProperty("stato")
    private String stato;

    public String getNumeroAggiuntivo() {
        return numeroAggiuntivo;
    }

    public void setNumeroAggiuntivo(String numeroAggiuntivo) {
        this.numeroAggiuntivo = numeroAggiuntivo;
    }

    public String getAccesso() {
        return accesso;
    }

    public void setAccesso(String accesso) {
        this.accesso = accesso;
    }

    public String getDirezionalita() {
        return direzionalita;
    }

    public void setDirezionalita(String direzionalita) {
        this.direzionalita = direzionalita;
    }

    public String getProgressivo() {
        return progressivo;
    }

    public void setProgressivo(String progressivo) {
        this.progressivo = progressivo;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((accesso == null) ? 0 : accesso.hashCode());
        result = prime * result + ((direzionalita == null) ? 0 : direzionalita.hashCode());
        result = prime * result + ((numeroAggiuntivo == null) ? 0 : numeroAggiuntivo.hashCode());
        result = prime * result + ((progressivo == null) ? 0 : progressivo.hashCode());
        result = prime * result + ((stato == null) ? 0 : stato.hashCode());
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
        SezioneAggiuntiviOutputBean other = (SezioneAggiuntiviOutputBean) obj;
        if (accesso == null) {
            if (other.accesso != null)
                return false;
        } else if (!accesso.equals(other.accesso))
            return false;
        if (direzionalita == null) {
            if (other.direzionalita != null)
                return false;
        } else if (!direzionalita.equals(other.direzionalita))
            return false;
        if (numeroAggiuntivo == null) {
            if (other.numeroAggiuntivo != null)
                return false;
        } else if (!numeroAggiuntivo.equals(other.numeroAggiuntivo))
            return false;
        if (progressivo == null) {
            if (other.progressivo != null)
                return false;
        } else if (!progressivo.equals(other.progressivo))
            return false;
        if (stato == null) {
            if (other.stato != null)
                return false;
        } else if (!stato.equals(other.stato))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SezioneAggiuntiviOutputBean [numeroAggiuntivo=" + numeroAggiuntivo + ", accesso=" + accesso + ", direzionalita=" + direzionalita
                + ", progressivo=" + progressivo + ", stato=" + stato + "]";
    }
    
    

}
