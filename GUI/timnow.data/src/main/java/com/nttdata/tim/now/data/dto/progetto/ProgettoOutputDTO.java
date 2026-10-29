package com.nttdata.tim.now.data.dto.progetto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class ProgettoOutputDTO implements Serializable {

	private static final long serialVersionUID = 5786373320309745282L;

	@JsonProperty("cod_prgt")
	private String codPrgt;

	@JsonProperty("codfc_olo_agcom")
	private String codfcOloAgcom;

	@JsonProperty("report")
	private String report;

	@JsonProperty("id_prgt")
	private String idPrgt;

	@JsonProperty("flag_fittizio")
	private String flagFittizio;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("datafi_valid")
	private Date datafiValid;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("datainz_valid")
	private Date datainzValid;
	
    @JsonProperty("flagVull")
    private String flagVull;
    
    //SM_11027
    @JsonProperty("oneStep")
    private String oneStep;
    
    //RU_1485
    @JsonProperty("prodottiACatalogo")
    private String prodottiACatalogo;

    public String getCodPrgt() {
        return codPrgt;
    }

    public void setCodPrgt(String codPrgt) {
        this.codPrgt = codPrgt;
    }

    public String getCodfcOloAgcom() {
        return codfcOloAgcom;
    }

    public void setCodfcOloAgcom(String codfcOloAgcom) {
        this.codfcOloAgcom = codfcOloAgcom;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getIdPrgt() {
        return idPrgt;
    }

    public void setIdPrgt(String idPrgt) {
        this.idPrgt = idPrgt;
    }

    public String getFlagFittizio() {
        return flagFittizio;
    }

    public void setFlagFittizio(String flagFittizio) {
        this.flagFittizio = flagFittizio;
    }

    public Date getDatafiValid() {
        return datafiValid;
    }

    public void setDatafiValid(Date datafiValid) {
        this.datafiValid = datafiValid;
    }

    public Date getDatainzValid() {
        return datainzValid;
    }

    public void setDatainzValid(Date datainzValid) {
        this.datainzValid = datainzValid;
    }

    public String getFlagVull() {
        return flagVull;
    }

    public void setFlagVull(String flagVull) {
        this.flagVull = flagVull;
    }

    public String getOneStep() {
		return oneStep;
	}

	public void setOneStep(String oneStep) {
		this.oneStep = oneStep;
	}

	public String getProdottiACatalogo() {
		return prodottiACatalogo;
	}

	public void setProdottiACatalogo(String prodottiACatalogo) {
		this.prodottiACatalogo = prodottiACatalogo;
	}
    
}
