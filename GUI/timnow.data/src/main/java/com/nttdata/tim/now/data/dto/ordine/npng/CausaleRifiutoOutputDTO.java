package com.nttdata.tim.now.data.dto.ordine.npng;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1203
public class CausaleRifiutoOutputDTO implements Serializable {

	private static final long serialVersionUID = 4590753152757661109L;
	
	@JsonProperty("idCausale")
	private String idCausale;
	
	@JsonProperty("idCausale")
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
