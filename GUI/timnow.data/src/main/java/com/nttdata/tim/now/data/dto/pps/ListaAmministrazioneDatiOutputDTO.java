package com.nttdata.tim.now.data.dto.pps;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaAmministrazioneDatiOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -8795138654362336685L;
	
	@JsonProperty("Output_TipologiaReport")
	private List<AmministrazioneDatiOutputDTO> research;

	public List<AmministrazioneDatiOutputDTO> getResearch() {
		return research;
	}

	public void setResearch(List<AmministrazioneDatiOutputDTO> research) {
		this.research = research;
	}

}
