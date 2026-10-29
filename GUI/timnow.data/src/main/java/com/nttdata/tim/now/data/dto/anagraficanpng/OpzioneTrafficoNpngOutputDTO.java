package com.nttdata.tim.now.data.dto.anagraficanpng;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

//RU_1203
public class OpzioneTrafficoNpngOutputDTO implements Serializable {

	private static final long serialVersionUID = 6411241539821265063L;

	@JsonProperty("prefissoNPNG")
	private String prefissoNpng;
    
    @JsonProperty("flagValidita")
	private String flagValidita;
    
    @JsonProperty("descrOpzTraffico")
	private String descrOpzTraffico;
    
    @JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataInizioValidita")
	private Date dataInizioValidita;
    
    @JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataFineValidita")
	private Date dataFineValidita;
    
    @JsonProperty("opzTraffico")
	private String opzTraffico;
    
    @JsonProperty("rowId")
	private String rowId;

	public String getPrefissoNpng() {
		return prefissoNpng;
	}

	public void setPrefissoNpng(String prefissoNpng) {
		this.prefissoNpng = prefissoNpng;
	}

	public String getFlagValidita() {
		return flagValidita;
	}

	public void setFlagValidita(String flagValidita) {
		this.flagValidita = flagValidita;
	}

	public String getDescrOpzTraffico() {
		return descrOpzTraffico;
	}

	public void setDescrOpzTraffico(String descrOpzTraffico) {
		this.descrOpzTraffico = descrOpzTraffico;
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

	public String getOpzTraffico() {
		return opzTraffico;
	}

	public void setOpzTraffico(String opzTraffico) {
		this.opzTraffico = opzTraffico;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	

}
