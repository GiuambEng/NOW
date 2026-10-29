package com.nttdata.tim.now.data.dto.ambito;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaAmbitiOutputDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = 4096053389360932294L;
	
	@JsonProperty("OutputGetMenuHelp")
	private List<AmbitoOutputDTO> list;

	public List<AmbitoOutputDTO> getList() {
		return list;
	}

	public void setList(List<AmbitoOutputDTO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "AmbitoListOutputDTO [list=" + list + "]";
	}

}
