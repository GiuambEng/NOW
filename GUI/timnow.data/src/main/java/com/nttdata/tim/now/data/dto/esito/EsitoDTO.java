package com.nttdata.tim.now.data.dto.esito;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class EsitoDTO extends ESBResultDTO {

	private static final long serialVersionUID = -6279797239531483957L;

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
