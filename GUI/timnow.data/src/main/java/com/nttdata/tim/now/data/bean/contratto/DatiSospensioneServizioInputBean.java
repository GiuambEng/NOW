package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_10292
@JsonInclude(Include.NON_NULL) 
public class DatiSospensioneServizioInputBean implements Serializable{

	private static final long serialVersionUID = 5975876702590035869L;
	
	@JsonProperty("dataInizioDisabil")
	private String dataInizioDisabil;
	
	@JsonProperty("dataFineDisabil")
	private String dataFineDisabil;
	
	@JsonProperty("flagDisabil")
	private String flagDisabil;

	public String getDataInizioDisabil() {
		return dataInizioDisabil;
	}

	public String getDataFineDisabil() {
		return dataFineDisabil;
	}

	public String getFlagDisabil() {
		return flagDisabil;
	}

	public void setDataInizioDisabil(String dataInizioDisabil) {
		this.dataInizioDisabil = dataInizioDisabil;
	}

	public void setDataFineDisabil(String dataFineDisabil) {
		this.dataFineDisabil = dataFineDisabil;
	}

	public void setFlagDisabil(String flagDisabil) {
		this.flagDisabil = flagDisabil;
	}
	

}
