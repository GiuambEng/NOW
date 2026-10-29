package com.nttdata.tim.now.data.dto.indirizzo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class IndirizzoEoloFwaOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 7309665378114221286L;
	
	@JsonProperty("civico")
	private List<String> civico;
	
	@JsonProperty("codiceEgon")
	private List<String> codiceEgon;

	public List<String> getCivico() {
		return civico;
	}

	public void setCivico(List<String> civico) {
		this.civico = civico;
	}

	public List<String> getCodiceEgon() {
		return codiceEgon;
	}

	public void setCodiceEgon(List<String> codiceEgon) {
		this.codiceEgon = codiceEgon;
	}
}
