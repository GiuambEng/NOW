package com.nttdata.tim.now.data.bean.export;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;

public class ExportableDataInputBean implements Serializable {

	private static final long serialVersionUID = 7195455461119021674L;

	@JsonProperty("advancedResearch")
	private RicercaAvanzataInputBean advancedResearch;

	public RicercaAvanzataInputBean getAdvancedResearch() {
		return advancedResearch;
	}

	public void setAdvancedResearch(RicercaAvanzataInputBean advancedResearch) {
		this.advancedResearch = advancedResearch;
	}

    @Override
    public String toString() {
        return "ExportableDataInputBean [advancedResearch=" + advancedResearch + "]";
    }
	
	

}
