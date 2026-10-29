package com.nttdata.tim.now.data.bean.esito;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class EsitoOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 249663177130666908L;

    @JsonProperty("esito")
	private String esito;

	@JsonProperty("message")
	private String message;

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}