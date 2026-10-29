package com.nttdata.tim.now.data.bean.notifica;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class DettaglioFileULLSLUBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("numeroRecord")
    private String numeroRecord;

    @JsonProperty("clli")
    private String clli;

    @JsonProperty("distrettoTelefono")
    private String distrettoTelefono;

    @JsonProperty("codiceOrdineOLO")
    private String codiceOrdineOLO;

    @JsonProperty("stato")
    private String stato;

    @JsonProperty("descrizioneErrore")
    private String descrizioneErrore;

    @JsonProperty("dataInizioElab")
    private String dataInizioElab;

    @JsonProperty("contenutoRecord")
    private String contenutoRecord;

    public String getNumeroRecord() {
        return numeroRecord;
    }

    public void setNumeroRecord(String numeroRecord) {
        this.numeroRecord = numeroRecord;
    }

    public String getClli() {
        return clli;
    }

    public void setClli(String clli) {
        this.clli = clli;
    }

    public String getDistrettoTelefono() {
        return distrettoTelefono;
    }

    public void setDistrettoTelefono(String distrettoTelefono) {
        this.distrettoTelefono = distrettoTelefono;
    }

    public String getCodiceOrdineOLO() {
        return codiceOrdineOLO;
    }

    public void setCodiceOrdineOLO(String codiceOrdineOLO) {
        this.codiceOrdineOLO = codiceOrdineOLO;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getDescrizioneErrore() {
        return descrizioneErrore;
    }

    public void setDescrizioneErrore(String descrizioneErrore) {
        this.descrizioneErrore = descrizioneErrore;
    }

    public String getDataInizioElab() {
        return dataInizioElab;
    }

    public void setDataInizioElab(String dataInizioElab) {
        this.dataInizioElab = dataInizioElab;
    }

    public String getContenutoRecord() {
        return contenutoRecord;
    }

    public void setContenutoRecord(String contenutoRecord) {
        this.contenutoRecord = contenutoRecord;
    }
}