package com.nttdata.tim.now.data.dto.posizionecoda;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class PosizioneCodaOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -6927821878983812672L;
	
	@JsonProperty("Esito")
	private String esito;

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

}
