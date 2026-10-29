package com.nttdata.tim.now.data.bean.dac;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.data.bean.codice.CodiceOutputBean;

@JsonInclude(Include.NON_NULL)
public class VerificaDacOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 1362129188676044913L;

    @JsonProperty("outcome")
	private CodiceOutputBean outcome;

	public CodiceOutputBean getOutcome() {
		return outcome;
	}

	public void setOutcome(CodiceOutputBean outcome) {
		this.outcome = outcome;
	}

}