package com.nttdata.tim.now.data.dto.jpub;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaJpubOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 647260171518419498L;
	
	@JsonProperty("outputeventijpub")
	private List<JpubOutputDTO> jpubs;

	public List<JpubOutputDTO> getJpubs() {
		return jpubs;
	}

	public void setJpubs(List<JpubOutputDTO> jpubs) {
		this.jpubs = jpubs;
	}

}
