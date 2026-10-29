package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//R1F-20-0236.D
@JsonInclude(Include.NON_NULL)
public class VerificaNoteOperatoreInputBean implements Serializable {

	private static final long serialVersionUID = 352444288774452715L;

	@JsonProperty("note")
	private String note;
	
	@JsonProperty("codOloAgcom")
    private String codOloAgcom;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}
}
