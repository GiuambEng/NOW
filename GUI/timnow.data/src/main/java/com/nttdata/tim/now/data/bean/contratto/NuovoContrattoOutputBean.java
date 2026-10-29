package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1276
@JsonInclude(Include.NON_NULL) 
public class NuovoContrattoOutputBean implements Serializable{

	private static final long serialVersionUID = -6668444397510224907L;
	
	@JsonProperty("esito")
	private String esito;
	
	@JsonProperty("idContratto")
	private String idContratto;

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(String idContratto) {
		this.idContratto = idContratto;
	}
}
