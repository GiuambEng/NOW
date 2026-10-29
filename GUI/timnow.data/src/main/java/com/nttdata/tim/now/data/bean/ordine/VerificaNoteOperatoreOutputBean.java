package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//R1F-20-0236.D
@JsonInclude(Include.NON_NULL)
public class VerificaNoteOperatoreOutputBean implements Serializable {

	private static final long serialVersionUID = 4380156302192153548L;

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
