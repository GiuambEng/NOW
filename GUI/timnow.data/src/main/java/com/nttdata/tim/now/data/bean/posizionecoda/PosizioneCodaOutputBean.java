package com.nttdata.tim.now.data.bean.posizionecoda;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class PosizioneCodaOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -7157265621316664219L;
    @JsonProperty("esito")
	private String esito;

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

}