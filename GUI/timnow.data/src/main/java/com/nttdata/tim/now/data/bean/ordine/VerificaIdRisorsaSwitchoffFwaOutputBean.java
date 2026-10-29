package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1335
@JsonInclude(Include.NON_NULL)
public class VerificaIdRisorsaSwitchoffFwaOutputBean implements Serializable {

	private static final long serialVersionUID = -1154678778796188297L;

	@JsonProperty("esito")
	private String esito;
	
	@JsonProperty("message")
    private String message;

	public String getEsito() {
		return esito;
	}

	public String getMessage() {
		return message;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}
