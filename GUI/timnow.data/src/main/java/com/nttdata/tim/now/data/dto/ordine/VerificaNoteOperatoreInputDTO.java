package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//R1F-20-0236.D
@JsonInclude(Include.NON_NULL)
public class VerificaNoteOperatoreInputDTO implements Serializable {

	private static final long serialVersionUID = 2603695962268402619L;

	@JsonProperty("codOloAgcom")
    private String codOloAgcom;
	
	@JsonProperty("note")
	private String note;

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}		
}
