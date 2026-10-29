package com.nttdata.tim.now.data.dto.utente;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class UserWrapperDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = 8559817041286504491L;

	@JsonProperty("outputUtente")
	private UserDTO outputUtente;

	public UserDTO getOutputUtente() {
		return outputUtente;
	}

	public void setOutputUtente(UserDTO outputUtente) {
		this.outputUtente = outputUtente;
	}
}
