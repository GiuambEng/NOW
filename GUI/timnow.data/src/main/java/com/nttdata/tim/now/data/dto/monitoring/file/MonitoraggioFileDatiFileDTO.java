package com.nttdata.tim.now.data.dto.monitoring.file;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFileDatiFileDTO implements Serializable {

	private static final long serialVersionUID = -4735150674848967434L;
 
	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataAcquisizione")
	private Date dataAcquisizione;

	@JsonProperty("Elaborati")
	private FileElaboratiOutputDTO elaborati;

	@JsonProperty("Acquisiti")
	private FileAcquisitiOutputDTO acquisiti;

	@JsonProperty("InElaborazione")
	private FileInElaborazioneOutputDTO inElaborazione;

	@JsonProperty("Scartati")
	private FileScartatiOutputDTO scartati;

    @JsonProperty("Scaduti")
    private FileScadutiOutputDTO scaduti;

    public Date getDataAcquisizione() {
        return dataAcquisizione;
    }

    public void setDataAcquisizione(Date dataAcquisizione) {
        this.dataAcquisizione = dataAcquisizione;
    }

    public FileElaboratiOutputDTO getElaborati() {
        return elaborati;
    }

    public void setElaborati(FileElaboratiOutputDTO elaborati) {
        this.elaborati = elaborati;
    }

    public FileAcquisitiOutputDTO getAcquisiti() {
        return acquisiti;
    }

    public void setAcquisiti(FileAcquisitiOutputDTO acquisiti) {
        this.acquisiti = acquisiti;
    }

    public FileInElaborazioneOutputDTO getInElaborazione() {
        return inElaborazione;
    }

    public void setInElaborazione(FileInElaborazioneOutputDTO inElaborazione) {
        this.inElaborazione = inElaborazione;
    }

    public FileScartatiOutputDTO getScartati() {
        return scartati;
    }

    public void setScartati(FileScartatiOutputDTO scartati) {
        this.scartati = scartati;
    }

    public FileScadutiOutputDTO getScaduti() {
        return scaduti;
    }

    public void setScaduti(FileScadutiOutputDTO scaduti) {
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
        MonitoraggioFileDatiFileDTO other = (MonitoraggioFileDatiFileDTO) obj;
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
        return "MonitoraggioFileDatiFileDTO [dataAcquisizione=" + dataAcquisizione + ", elaborati=" + elaborati + ", acquisiti=" + acquisiti
                + ", inElaborazione=" + inElaborazione + ", scartati=" + scartati + ", scaduti=" + scaduti + "]";
    }

    
    
}
