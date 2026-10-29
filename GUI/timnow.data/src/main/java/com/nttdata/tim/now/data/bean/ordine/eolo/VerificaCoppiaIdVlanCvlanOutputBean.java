package com.nttdata.tim.now.data.bean.ordine.eolo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1475
@JsonInclude(Include.NON_NULL)
public class VerificaCoppiaIdVlanCvlanOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = 5424819838928114017L;

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