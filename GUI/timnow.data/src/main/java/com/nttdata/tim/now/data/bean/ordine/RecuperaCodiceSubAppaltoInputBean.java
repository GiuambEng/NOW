package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1393
public class RecuperaCodiceSubAppaltoInputBean implements Serializable {

	private static final long serialVersionUID = 4619001766633972854L;

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
