package com.nttdata.tim.now.data.dto.dac;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.codice.CodiceOutputDTO;

@JsonInclude(Include.NON_NULL)
public class VerificaDacOutputDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = -8984898700758142412L;
	
	@JsonProperty("esito")
	private CodiceOutputDTO outcome;

	public CodiceOutputDTO getOutcome() {
		return outcome;
	}

	public void setOutcome(CodiceOutputDTO outcome) {
		this.outcome = outcome;
	}
	
}
