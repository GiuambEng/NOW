package com.nttdata.tim.now.data.dto.ordine.fiberstream;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1452
@JsonInclude(Include.NON_NULL)
public class ListaNomeServizioAggiuntivoFiberstreamOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -4002789266284943386L;
	
	@JsonProperty("nomeServizio")
	private List<String> nomeServizio;

	public List<String> getNomeServizio() {
		return nomeServizio;
	}

	public void setNomeServizio(List<String> nomeServizio) {
		this.nomeServizio = nomeServizio;
	}
}
