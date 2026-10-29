package com.nttdata.tim.now.data.dto.eventiopenfiber;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1492
@JsonInclude(Include.NON_NULL)
public class ListaEventiOpenFiberOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 3282904288069596370L;
	
	@JsonProperty("outputEventiOF")
	private List<EventoOpenFiberOutputDTO> eventiOF;

	public List<EventoOpenFiberOutputDTO> getEventiOF() {
		return eventiOF;
	}

	public void setEventiOF(List<EventoOpenFiberOutputDTO> eventiOF) {
		this.eventiOF = eventiOF;
	}

}
