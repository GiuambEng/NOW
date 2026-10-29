package com.nttdata.tim.now.data.bean.banda;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;

@JsonInclude(Include.NON_NULL)
public class VerificaSommaBandePiccoOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -2042366140213468765L;
	
	@JsonProperty("outcome")
	private EsitoOutputBean outcome;

	public EsitoOutputBean getOutcome() {
		return outcome;
	}

	public void setOutcome(EsitoOutputBean outcome) {
		this.outcome = outcome;
	}

}