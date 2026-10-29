package com.nttdata.tim.now.data.dto.olo.encoding;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class CodificaOloListDTO extends ESBResultDTO {

	private static final long serialVersionUID = 5259463527373008793L;
	
	@JsonProperty("inputListaRichiesteOlo")
	private CodificaOloDTO oloRequest;

	public CodificaOloDTO getOloRequest() {
		return oloRequest;
	}

	public void setOloRequest(CodificaOloDTO oloRequest) {
		this.oloRequest = oloRequest;
	}

}
