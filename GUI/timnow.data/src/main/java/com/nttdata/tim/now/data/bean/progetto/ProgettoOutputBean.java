package com.nttdata.tim.now.data.bean.progetto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class ProgettoOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 8728298767065397733L;

    @JsonProperty("cod_prgt")
	private String codPrgt;

	@JsonProperty("codfc_olo_agcom")
	private String codfcOloAgcom;

	@JsonProperty("report")
	private String report;

	@JsonProperty("id_prgt")
	private String idPrgt;

	@JsonProperty("flag_fittizio")
	private boolean flagFittizio;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("datafi_valid")
	private Date datafiValid;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("datainz_valid")
	private Date datainzValid;

    @JsonProperty("flagVull")
    private boolean flagVull;
    
    //SM_11027
    @JsonProperty("oneStep")
    private boolean oneStep;
    
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

    public boolean isFlagFittizio() {
        return flagFittizio;
    }

    public void setFlagFittizio(boolean flagFittizio) {
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

    public boolean isFlagVull() {
        return flagVull;
    }

    public void setFlagVull(boolean flagVull) {
        this.flagVull = flagVull;
    }

    public boolean isOneStep() {
		return oneStep;
	}

	public void setOneStep(boolean oneStep) {
		this.oneStep = oneStep;
	}

	public String getProdottiACatalogo() {
		return prodottiACatalogo;
	}

	public void setProdottiACatalogo(String prodottiACatalogo) {
		this.prodottiACatalogo = prodottiACatalogo;
	}	
}