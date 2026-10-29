package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1393
public class RecuperaCodiceSystemUnicoInputDTO implements Serializable {

	private static final long serialVersionUID = -4721241919849091291L;

	@JsonProperty("codOloAgcom")
	private String codOloAgcom;
	
	@JsonProperty("idGpon")
	private String idGpon;
	
	@JsonProperty("systemType")
	private String systemType;

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

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
}
