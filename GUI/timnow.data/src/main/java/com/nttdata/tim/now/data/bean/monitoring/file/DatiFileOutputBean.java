
package com.nttdata.tim.now.data.bean.monitoring.file;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DatiFileOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = 985743450581L;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataAcquisizione")
    private Date dataAcquisizione;

    @JsonProperty("Elaborati")
    private FileElaboratiOutputBean elaborati;

    @JsonProperty("Acquisiti")
    private FileAcquisitiOutputBean acquisiti;

    @JsonProperty("InElaborazione")
    private FileInElaborazioneOutputBean inElaborazione;

    @JsonProperty("Scartati")
    private FileScartatiOutputBean scartati;

    @JsonProperty("Scaduti")
    private FileScadutiOutputBean scaduti;

    public Date getDataAcquisizione() {
        return dataAcquisizione;
    }

    public void setDataAcquisizione(Date dataAcquisizione) {
        this.dataAcquisizione = dataAcquisizione;
    }

    public FileElaboratiOutputBean getElaborati() {
        return elaborati;
    }

    public void setElaborati(FileElaboratiOutputBean elaborati) {
        this.elaborati = elaborati;
    }

    public FileAcquisitiOutputBean getAcquisiti() {
        return acquisiti;
    }

    public void setAcquisiti(FileAcquisitiOutputBean acquisiti) {
        this.acquisiti = acquisiti;
    }

    public FileInElaborazioneOutputBean getInElaborazione() {
        return inElaborazione;
    }

    public void setInElaborazione(FileInElaborazioneOutputBean inElaborazione) {
        this.inElaborazione = inElaborazione;
    }

    public FileScartatiOutputBean getScartati() {
        return scartati;
    }

    public void setScartati(FileScartatiOutputBean scartati) {
        this.scartati = scartati;
    }

    public FileScadutiOutputBean getScaduti() {
        return scaduti;
    }

    public void setScaduti(FileScadutiOutputBean scaduti) {
        this.scaduti = scaduti;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((acquisiti == null) ? 0 : acquisiti.hashCode());
        result = prime * result + ((dataAcquisizione == null) ? 0 : dataAcquisizione.hashCode());
        result = prime * result + ((elaborati == null) ? 0 : elaborati.hashCode());
        result = prime * result + ((inElaborazione == null) ? 0 : inElaborazione.hashCode());
        result = prime * result + ((scaduti == null) ? 0 : scaduti.hashCode());
        result = prime * result + ((scartati == null) ? 0 : scartati.hashCode());
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
        DatiFileOutputBean other = (DatiFileOutputBean) obj;
        if (acquisiti == null) {
            if (other.acquisiti != null)
                return false;
        } else if (!acquisiti.equals(other.acquisiti))
            return false;
        if (dataAcquisizione == null) {
            if (other.dataAcquisizione != null)
                return false;
        } else if (!dataAcquisizione.equals(other.dataAcquisizione))
            return false;
        if (elaborati == null) {
            if (other.elaborati != null)
                return false;
        } else if (!elaborati.equals(other.elaborati))
            return false;
        if (inElaborazione == null) {
            if (other.inElaborazione != null)
                return false;
        } else if (!inElaborazione.equals(other.inElaborazione))
            return false;
        if (scaduti == null) {
            if (other.scaduti != null)
                return false;
        } else if (!scaduti.equals(other.scaduti))
            return false;
        if (scartati == null) {
            if (other.scartati != null)
                return false;
        } else if (!scartati.equals(other.scartati))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DatiFileOutputBean [dataAcquisizione=" + dataAcquisizione + ", elaborati=" + elaborati + ", acquisiti=" + acquisiti + ", inElaborazione="
                + inElaborazione + ", scartati=" + scartati + ", scaduti=" + scaduti + "]";
    }



}
