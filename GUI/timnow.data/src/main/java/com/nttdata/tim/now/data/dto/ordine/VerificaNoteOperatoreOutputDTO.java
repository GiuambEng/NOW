package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//R1F-20-0236.D
public class VerificaNoteOperatoreOutputDTO implements Serializable {

	private static final long serialVersionUID = -8950778978747297618L;

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
