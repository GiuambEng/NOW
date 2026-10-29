package com.nttdata.tim.now.data.bean.notifica;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class StatoFileMigrazioneUllSluBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("nomeFile")
    private String nomeFile;

    @JsonProperty("idFileProcsoInput")
    private String idFileProcsoInput;

    @JsonProperty("numeroRecord")
    private String numeroRecord;

    @JsonProperty("idStatoElabStag")
    private String idStatoElabStag;

    @JsonProperty("dataInserimento")
    private String dataInserimento;

    @JsonProperty("dataAggiornamento")
    private String dataAggiornamento;

    @JsonProperty("descrizioneErrore")
    private String descrizioneErrore;

    @JsonProperty("idOperatore")
    private String idOperatore;

    @JsonProperty("statoElaborazione")
    private String statoElaborazione;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNomeFile() { return nomeFile; }
    public void setNomeFile(String nomeFile) { this.nomeFile = nomeFile; }
    public String getIdFileProcsoInput() { return idFileProcsoInput; }
    public void setIdFileProcsoInput(String idFileProcsoInput) { this.idFileProcsoInput = idFileProcsoInput; }
    public String getNumeroRecord() { return numeroRecord; }
    public void setNumeroRecord(String numeroRecord) { this.numeroRecord = numeroRecord; }
    public void setNumeroRecord(Integer numeroRecord) { this.numeroRecord = numeroRecord != null ? String.valueOf(numeroRecord) : null; }
    public String getIdStatoElabStag() { return idStatoElabStag; }
    public void setIdStatoElabStag(String idStatoElabStag) { this.idStatoElabStag = idStatoElabStag; }
    public String getDataInserimento() { return dataInserimento; }
    public void setDataInserimento(String dataInserimento) { this.dataInserimento = dataInserimento; }
    public String getDataAggiornamento() { return dataAggiornamento; }
    public void setDataAggiornamento(String dataAggiornamento) { this.dataAggiornamento = dataAggiornamento; }
    public String getDescrizioneErrore() { return descrizioneErrore; }
    public void setDescrizioneErrore(String descrizioneErrore) { this.descrizioneErrore = descrizioneErrore; }
    public String getIdOperatore() { return idOperatore; }
    public void setIdOperatore(String idOperatore) { this.idOperatore = idOperatore; }
    public String getStatoElaborazione() { return statoElaborazione; }
    public void setStatoElaborazione(String statoElaborazione) { this.statoElaborazione = statoElaborazione; }

    @JsonIgnore
    public String getIdFile() { return id; }

    @JsonIgnore
    public void setIdFile(String idFile) { this.id = idFile; }

    @JsonIgnore
    public String getDataUltimoAggiornamento() { return dataAggiornamento; }

    @JsonIgnore
    public void setDataUltimoAggiornamento(String dataUltimoAggiornamento) { this.dataAggiornamento = dataUltimoAggiornamento; }

    @JsonIgnore
    public Integer getNumeroOrdini() {
        if (numeroRecord == null || numeroRecord.trim().isEmpty()) {
            return null;
        }
        try {
            return Integer.valueOf(numeroRecord.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @JsonIgnore
    public void setNumeroOrdini(Integer numeroOrdini) {
        this.numeroRecord = numeroOrdini != null ? String.valueOf(numeroOrdini) : null;
    }

    @JsonIgnore
    public void setNumeroOrdini(String numeroOrdini) {
        this.numeroRecord = numeroOrdini;
    }
}