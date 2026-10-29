package com.nttdata.tim.now.data.bean.anagraficanpng;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

//RU_1203
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ModificaOpzioneTrafficoInputBean implements Serializable {

	private static final long serialVersionUID = 1674669982770840868L;
	
    @JsonProperty("idOpzTraffico")
	private String idOpzTraffico;
    
    @JsonProperty("idPrefisso")
	private String idPrefisso;
    
    @JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataInizioValidita")
	private Date dataInizioValidita;
    
    @JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataFineValidita")
	private Date dataFineValidita;
    
    @JsonProperty("rowId")
	private String rowId;
    
    @JsonProperty("operatore")
	private String operatore;

	public String getIdOpzTraffico() {
		return idOpzTraffico;
	}

	public void setIdOpzTraffico(String idOpzTraffico) {
		this.idOpzTraffico = idOpzTraffico;
	}

	public String getIdPrefisso() {
		return idPrefisso;
	}

	public void setIdPrefisso(String idPrefisso) {
		this.idPrefisso = idPrefisso;
	}

	public Date getDataInizioValidita() {
		return dataInizioValidita;
	}

	public void setDataInizioValidita(Date dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public Date getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(Date dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

}
