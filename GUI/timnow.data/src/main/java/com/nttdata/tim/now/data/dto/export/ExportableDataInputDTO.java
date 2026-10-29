package com.nttdata.tim.now.data.dto.export;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

@JsonInclude(Include.NON_NULL)
public class ExportableDataInputDTO extends ESBResultDTO {
 
	private static final long serialVersionUID = 1865091053391483213L;

	@JsonProperty("RicercaAvanzata_xmlToExcel")
	private AdvancedResearchInputDTO advancedResearch;

	public AdvancedResearchInputDTO getAdvancedResearch() {
		return advancedResearch;
	}

	public void setAdvancedResearch(AdvancedResearchInputDTO advancedResearch) {
		this.advancedResearch = advancedResearch;
	}

}
