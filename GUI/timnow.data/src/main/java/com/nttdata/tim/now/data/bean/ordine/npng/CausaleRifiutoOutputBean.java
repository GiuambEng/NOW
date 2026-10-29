package com.nttdata.tim.now.data.bean.ordine.npng;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1203
@JsonInclude(Include.NON_NULL)
public class CausaleRifiutoOutputBean implements Serializable {

	private static final long serialVersionUID = 4958143300855550095L;
	
	@JsonProperty("idCausale")
	private String idCausale;
	
	@JsonProperty("descrizione")
	private String descrizione;
	
	public String getIdCausale() {
		return idCausale;
	}
	public void setIdCausale(String idCausale) {
		this.idCausale = idCausale;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
