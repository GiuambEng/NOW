package com.nttdata.tim.now.data.dto.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

public class DatiSospensioneServizioOutputDTO implements Serializable {

	private static final long serialVersionUID = -4571073719461247191L;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInizioDisabil")
	private String dataInizioDisabil;
	
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
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
