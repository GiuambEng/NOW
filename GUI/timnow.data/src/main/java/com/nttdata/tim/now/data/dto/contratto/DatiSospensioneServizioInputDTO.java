package com.nttdata.tim.now.data.dto.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class DatiSospensioneServizioInputDTO implements Serializable {

	private static final long serialVersionUID = -8810069035608702385L;

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
