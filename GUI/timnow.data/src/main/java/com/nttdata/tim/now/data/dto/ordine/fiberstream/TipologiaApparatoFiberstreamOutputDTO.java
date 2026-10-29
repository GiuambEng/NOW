package com.nttdata.tim.now.data.dto.ordine.fiberstream;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1452
@JsonInclude(Include.NON_NULL)
public class TipologiaApparatoFiberstreamOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 3298864911707831899L;

	@JsonProperty("tipologiaApparato")
	private String tipologiaApparato;

	public String getTipologiaApparato() {
		return tipologiaApparato;
	}

	public void setTipologiaApparato(String tipologiaApparato) {
		this.tipologiaApparato = tipologiaApparato;
	}
}
