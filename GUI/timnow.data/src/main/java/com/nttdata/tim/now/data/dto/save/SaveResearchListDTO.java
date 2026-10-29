package com.nttdata.tim.now.data.dto.save;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class SaveResearchListDTO extends ESBResultDTO {

	private static final long serialVersionUID = 152796504413132549L;
	
	@JsonProperty("Salvaricerca_Output")
	private List<SaveResearchDTO> saveResearches;

	public List<SaveResearchDTO> getSaveResearches() {
		return saveResearches;
	}

	public void setSaveResearches(List<SaveResearchDTO> saveResearches) {
		this.saveResearches = saveResearches;
	}

}
