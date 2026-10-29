package com.nttdata.tim.now.data.bean.ordine.fiberstream;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1452
@JsonInclude(Include.NON_NULL)
public class NomeServizioAggiuntivoFiberstreamOutputBean extends AbstractOutputBean {

	@JsonProperty("nomeServizio")
	private String nomeServizio;

	public String getNomeServizio() {
		return nomeServizio;
	}

	public void setNomeServizio(String nomeServizio) {
		this.nomeServizio = nomeServizio;
	}

}