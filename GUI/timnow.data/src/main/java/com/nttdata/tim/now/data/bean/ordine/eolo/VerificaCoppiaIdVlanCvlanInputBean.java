package com.nttdata.tim.now.data.bean.ordine.eolo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1475
@JsonInclude(Include.NON_NULL)
public class VerificaCoppiaIdVlanCvlanInputBean implements Serializable {

	private static final long serialVersionUID = 5424819838928114017L;

	@JsonProperty("offerta")
	private String offerta;

	@JsonProperty("codOloAgcom")
    private String codOloAgcom;
	
	@JsonProperty("idVlanOlo")
    private String idVlanOlo;
	
	@JsonProperty("cvlanId")
    private String cvlanId;

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getIdVlanOlo() {
		return idVlanOlo;
	}

	public void setIdVlanOlo(String idVlanOlo) {
		this.idVlanOlo = idVlanOlo;
	}

	public String getCvlanId() {
		return cvlanId;
	}

	public void setCvlanId(String cvlanId) {
		this.cvlanId = cvlanId;
	}

}