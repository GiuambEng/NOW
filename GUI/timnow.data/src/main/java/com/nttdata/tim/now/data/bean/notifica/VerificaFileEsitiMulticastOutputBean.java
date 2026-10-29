package com.nttdata.tim.now.data.bean.notifica;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//CR1-CR4
@JsonInclude(Include.NON_NULL)
public class VerificaFileEsitiMulticastOutputBean implements Serializable {

	private static final long serialVersionUID = 4270263903645237076L;

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