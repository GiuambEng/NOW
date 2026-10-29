package com.nttdata.tim.now.data.bean.ordine.fiberstream;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1452
@JsonInclude(Include.NON_NULL)
public class TipologiaApparatoFiberstreamOutputBean extends AbstractOutputBean {

	@JsonProperty("tipologiaApparato")
	private String tipologiaApparato;

	public String getTipologiaApparato() {
		return tipologiaApparato;
	}

	public void setTipologiaApparato(String tipologiaApparato) {
		this.tipologiaApparato = tipologiaApparato;
	}

}