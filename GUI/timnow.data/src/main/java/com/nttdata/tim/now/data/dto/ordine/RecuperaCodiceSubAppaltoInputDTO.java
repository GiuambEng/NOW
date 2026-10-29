package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1393
public class RecuperaCodiceSubAppaltoInputDTO implements Serializable {

	private static final long serialVersionUID = -1638639480883738080L;

	@JsonProperty("codOloAgcom")
	private String codOloAgcom;
	
	@JsonProperty("idGpon")
	private String idGpon;

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getIdGpon() {
		return idGpon;
	}

	public void setIdGpon(String idGpon) {
		this.idGpon = idGpon;
	}
}
