package com.nttdata.tim.now.data.dto.monitoring.file;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContatoreMonitoraggioFileOutputDTO implements Serializable {

	private static final long serialVersionUID = 1464178512409030224L;
 
	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("data_acquisizione")
	private Date dataAcquisizione;

	@JsonProperty("id_file_procsto")
	private String idFileProcessato;

	@JsonProperty("nome_file")
	private String nomeFile;

	@JsonProperty("ambito_file")
	private String ambitoFile;

	@JsonProperty("owner")
	private String owner;

	@JsonProperty("sorgente")
	private String sorgente;

	@JsonProperty("quant_ordini_file")
	private String quantitaOrdiniFile;

	@JsonProperty("quant_ordini_crmws")
	private String quantitaOrdiniCrmws;

	@JsonProperty("quant_errati_now")
	private String quantitaErratiNow;

    @JsonProperty("quant_ordini_corretti_now")
    private String quantitaOrdiniCorrettiNow;

    @JsonProperty("quant_ordini_ko_cautelare_now")
    private String quantitaOrdiniKoCautelareNow;

	@JsonProperty("quant_ordini_task_utente")
	private String quantitaOrdiniTaskUtente;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("data_estrazione")
	private Date dataEstrazione;

	@JsonProperty("descr_stato_file")
	private String descrizioneStatoFile;

	@JsonProperty("descrizione_interfaccia")
	private String descrizioneInterfaccia;

	@JsonProperty("quant_ordini_dbcfx")
	private String quantitaOrdiniDbcfx;

	@JsonProperty("quant_ordini_sdr")
	private String quantitaOrdiniSdr;

	public Date getDataAcquisizione() {
		return dataAcquisizione;
	}

	public void setDataAcquisizione(Date dataAcquisizione) {
		this.dataAcquisizione = dataAcquisizione;
	}

	public String getIdFileProcessato() {
		return idFileProcessato;
	}

	public void setIdFileProcessato(String idFileProcessato) {
		this.idFileProcessato = idFileProcessato;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public String getAmbitoFile() {
		return ambitoFile;
	}

	public void setAmbitoFile(String ambitoFile) {
		this.ambitoFile = ambitoFile;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

    public String getSorgente() {
        return sorgente;
	}

    public void setSorgente(String sorgente) {
        this.sorgente = sorgente;
	}

	public String getQuantitaOrdiniFile() {
		return quantitaOrdiniFile;
	}

	public void setQuantitaOrdiniFile(String quantitaOrdiniFile) {
		this.quantitaOrdiniFile = quantitaOrdiniFile;
	}

	public String getQuantitaOrdiniCrmws() {
		return quantitaOrdiniCrmws;
	}

	public void setQuantitaOrdiniCrmws(String quantitaOrdiniCrmws) {
		this.quantitaOrdiniCrmws = quantitaOrdiniCrmws;
	}

    public String getQuantitaErratiNow() {
        return quantitaErratiNow;
	}

    public void setQuantitaErratiNow(String quantitaErratiNow) {
        this.quantitaErratiNow = quantitaErratiNow;
	}

    public String getQuantitaOrdiniCorrettiNow() {
        return quantitaOrdiniCorrettiNow;
	}

    public void setQuantitaOrdiniCorrettiNow(String quantitaOrdiniCorrettiNow) {
        this.quantitaOrdiniCorrettiNow = quantitaOrdiniCorrettiNow;
	}

    public String getQuantitaOrdiniKoCautelareNow() {
        return quantitaOrdiniKoCautelareNow;
	}

    public void setQuantitaOrdiniKoCautelareNow(String quantitaOrdiniKoCautelareNow) {
        this.quantitaOrdiniKoCautelareNow = quantitaOrdiniKoCautelareNow;
	}

	public String getQuantitaOrdiniTaskUtente() {
		return quantitaOrdiniTaskUtente;
	}

	public void setQuantitaOrdiniTaskUtente(String quantitaOrdiniTaskUtente) {
		this.quantitaOrdiniTaskUtente = quantitaOrdiniTaskUtente;
	}

	public Date getDataEstrazione() {
		return dataEstrazione;
	}

	public void setDataEstrazione(Date dataEstrazione) {
		this.dataEstrazione = dataEstrazione;
	}

	public String getDescrizioneStatoFile() {
		return descrizioneStatoFile;
	}

	public void setDescrizioneStatoFile(String descrizioneStatoFile) {
		this.descrizioneStatoFile = descrizioneStatoFile;
	}

    public String getDescrizioneInterfaccia() {
        return descrizioneInterfaccia;
	}

    public void setDescrizioneInterfaccia(String descrizioneInterfaccia) {
        this.descrizioneInterfaccia = descrizioneInterfaccia;
	}

    public String getQuantitaOrdiniDbcfx() {
        return quantitaOrdiniDbcfx;
    }

    public void setQuantitaOrdiniDbcfx(String quantitaOrdiniDbcfx) {
        this.quantitaOrdiniDbcfx = quantitaOrdiniDbcfx;
    }

    public String getQuantitaOrdiniSdr() {
        return quantitaOrdiniSdr;
    }

    public void setQuantitaOrdiniSdr(String quantitaOrdiniSdr) {
        this.quantitaOrdiniSdr = quantitaOrdiniSdr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ambitoFile == null) ? 0 : ambitoFile.hashCode());
		result = prime * result + ((dataAcquisizione == null) ? 0 : dataAcquisizione.hashCode());
		result = prime * result + ((dataEstrazione == null) ? 0 : dataEstrazione.hashCode());
        result = prime * result + ((descrizioneInterfaccia == null) ? 0 : descrizioneInterfaccia.hashCode());
		result = prime * result + ((descrizioneStatoFile == null) ? 0 : descrizioneStatoFile.hashCode());
		result = prime * result + ((idFileProcessato == null) ? 0 : idFileProcessato.hashCode());
		result = prime * result + ((nomeFile == null) ? 0 : nomeFile.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((quantitaErratiNow == null) ? 0 : quantitaErratiNow.hashCode());
        result = prime * result + ((quantitaOrdiniCorrettiNow == null) ? 0 : quantitaOrdiniCorrettiNow.hashCode());
		result = prime * result + ((quantitaOrdiniCrmws == null) ? 0 : quantitaOrdiniCrmws.hashCode());
        result = prime * result + ((quantitaOrdiniDbcfx == null) ? 0 : quantitaOrdiniDbcfx.hashCode());
		result = prime * result + ((quantitaOrdiniFile == null) ? 0 : quantitaOrdiniFile.hashCode());
        result = prime * result + ((quantitaOrdiniKoCautelareNow == null) ? 0 : quantitaOrdiniKoCautelareNow.hashCode());
        result = prime * result + ((quantitaOrdiniSdr == null) ? 0 : quantitaOrdiniSdr.hashCode());
		result = prime * result + ((quantitaOrdiniTaskUtente == null) ? 0 : quantitaOrdiniTaskUtente.hashCode());
        result = prime * result + ((sorgente == null) ? 0 : sorgente.hashCode());
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
		ContatoreMonitoraggioFileOutputDTO other = (ContatoreMonitoraggioFileOutputDTO) obj;
		if (ambitoFile == null) {
			if (other.ambitoFile != null)
				return false;
		} else if (!ambitoFile.equals(other.ambitoFile))
			return false;
		if (dataAcquisizione == null) {
			if (other.dataAcquisizione != null)
				return false;
		} else if (!dataAcquisizione.equals(other.dataAcquisizione))
			return false;
		if (dataEstrazione == null) {
			if (other.dataEstrazione != null)
				return false;
		} else if (!dataEstrazione.equals(other.dataEstrazione))
			return false;
        if (descrizioneInterfaccia == null) {
            if (other.descrizioneInterfaccia != null)
                return false;
        } else if (!descrizioneInterfaccia.equals(other.descrizioneInterfaccia))
            return false;
		if (descrizioneStatoFile == null) {
			if (other.descrizioneStatoFile != null)
				return false;
		} else if (!descrizioneStatoFile.equals(other.descrizioneStatoFile))
			return false;
		if (idFileProcessato == null) {
			if (other.idFileProcessato != null)
				return false;
		} else if (!idFileProcessato.equals(other.idFileProcessato))
			return false;
		if (nomeFile == null) {
			if (other.nomeFile != null)
				return false;
		} else if (!nomeFile.equals(other.nomeFile))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
        if (quantitaErratiNow == null) {
            if (other.quantitaErratiNow != null)
				return false;
        } else if (!quantitaErratiNow.equals(other.quantitaErratiNow))
            return false;
        if (quantitaOrdiniCorrettiNow == null) {
            if (other.quantitaOrdiniCorrettiNow != null)
                return false;
        } else if (!quantitaOrdiniCorrettiNow.equals(other.quantitaOrdiniCorrettiNow))
			return false;
		if (quantitaOrdiniCrmws == null) {
			if (other.quantitaOrdiniCrmws != null)
				return false;
		} else if (!quantitaOrdiniCrmws.equals(other.quantitaOrdiniCrmws))
			return false;
        if (quantitaOrdiniDbcfx == null) {
            if (other.quantitaOrdiniDbcfx != null)
                return false;
        } else if (!quantitaOrdiniDbcfx.equals(other.quantitaOrdiniDbcfx))
            return false;
		if (quantitaOrdiniFile == null) {
			if (other.quantitaOrdiniFile != null)
				return false;
		} else if (!quantitaOrdiniFile.equals(other.quantitaOrdiniFile))
			return false;
        if (quantitaOrdiniKoCautelareNow == null) {
            if (other.quantitaOrdiniKoCautelareNow != null)
				return false;
        } else if (!quantitaOrdiniKoCautelareNow.equals(other.quantitaOrdiniKoCautelareNow))
			return false;
        if (quantitaOrdiniSdr == null) {
            if (other.quantitaOrdiniSdr != null)
				return false;
        } else if (!quantitaOrdiniSdr.equals(other.quantitaOrdiniSdr))
			return false;
		if (quantitaOrdiniTaskUtente == null) {
			if (other.quantitaOrdiniTaskUtente != null)
				return false;
		} else if (!quantitaOrdiniTaskUtente.equals(other.quantitaOrdiniTaskUtente))
			return false;
        if (sorgente == null) {
            if (other.sorgente != null)
				return false;
        } else if (!sorgente.equals(other.sorgente))
			return false;
		return true;
	}

    @Override
    public String toString() {
        return "ContatoreMonitoraggioFileOutputDTO [dataAcquisizione=" + dataAcquisizione + ", idFileProcessato=" + idFileProcessato + ", nomeFile=" + nomeFile
                + ", ambitoFile=" + ambitoFile + ", owner=" + owner + ", sorgente=" + sorgente + ", quantitaOrdiniFile=" + quantitaOrdiniFile
                + ", quantitaOrdiniCrmws=" + quantitaOrdiniCrmws + ", quantitaErratiNow=" + quantitaErratiNow + ", quantitaOrdiniCorrettiNow="
                + quantitaOrdiniCorrettiNow + ", quantitaOrdiniKoCautelareNow=" + quantitaOrdiniKoCautelareNow + ", quantitaOrdiniTaskUtente="
                + quantitaOrdiniTaskUtente + ", dataEstrazione=" + dataEstrazione + ", descrizioneStatoFile=" + descrizioneStatoFile
                + ", descrizioneInterfaccia=" + descrizioneInterfaccia + ", quantitaOrdiniDbcfx=" + quantitaOrdiniDbcfx + ", quantitaOrdiniSdr="
                + quantitaOrdiniSdr + "]";
    }

	
}
