package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1181
@JsonInclude(Include.NON_NULL)
public class VerificaRecuperoModemOutputBean implements Serializable {

	private static final long serialVersionUID = 4731599357798307061L;

	@JsonProperty("esito")
	private String esito;
	
	@JsonProperty("message")
    private String message;
	
	@JsonProperty("statoRestituzioneProdotti")
    private String statoRestituzioneProdotti;

	public String getEsito() {
		return esito;
	}

	public String getMessage() {
		return message;
	}

	public String getStatoRestituzioneProdotti() {
		return statoRestituzioneProdotti;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatoRestituzioneProdotti(String statoRestituzioneProdotti) {
		this.statoRestituzioneProdotti = statoRestituzioneProdotti;
	}
	
}
