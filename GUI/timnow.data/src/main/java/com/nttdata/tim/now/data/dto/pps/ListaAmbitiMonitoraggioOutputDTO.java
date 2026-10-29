package com.nttdata.tim.now.data.dto.pps;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaAmbitiMonitoraggioOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -274428665903084507L;
	
	@JsonProperty("output_AmbitoMonitoraggio")
	private List<AmbitoMonitoraggioOutputDTO> scopes;

	public List<AmbitoMonitoraggioOutputDTO> getScopes() {
		return scopes;
	}

	public void setScopes(List<AmbitoMonitoraggioOutputDTO> scopes) {
		this.scopes = scopes;
	}

}
