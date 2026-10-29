package com.nttdata.tim.now.data.dto.vp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.codice.CodiceOutputDTO;

@JsonInclude(Include.NON_NULL)
public class MaxVCVPOutputDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = 8297773840641712215L;

	@JsonProperty("esito")
	private CodiceOutputDTO esito;

	public CodiceOutputDTO getEsito() {
		return esito;
	}

	public void setEsito(CodiceOutputDTO esito) {
		this.esito = esito;
	}

}
