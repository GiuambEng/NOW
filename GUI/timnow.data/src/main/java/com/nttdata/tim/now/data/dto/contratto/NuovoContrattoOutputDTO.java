package com.nttdata.tim.now.data.dto.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1276
@JsonInclude(Include.NON_NULL) 
public class NuovoContrattoOutputDTO implements Serializable{

	private static final long serialVersionUID = -8335612743939898242L;
	
	@JsonProperty("idContratto")
	private String idContratto;
	
	@JsonProperty("esito")
	private String esito;

	public String getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(String idContratto) {
		this.idContratto = idContratto;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}	
}
