package com.nttdata.tim.now.data.dto.ricerca;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class FieldsResearchListDTO extends ESBResultDTO {

	private static final long serialVersionUID = -2479522347500855468L;
	
	@JsonProperty("outputRicercaCampi")
	private List<FieldsResearchDTO> fieldsResearch;

	public List<FieldsResearchDTO> getFieldsResearch() {
		return fieldsResearch;
	}

	public void setFieldsResearch(List<FieldsResearchDTO> fieldsResearch) {
		this.fieldsResearch = fieldsResearch;
	}

    @Override
    public String toString() {
        return "FieldsResearchListDTO [fieldsResearch=" + fieldsResearch + "]";
    }

	
}
