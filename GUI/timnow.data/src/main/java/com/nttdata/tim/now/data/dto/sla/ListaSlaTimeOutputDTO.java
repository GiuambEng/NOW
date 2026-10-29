package com.nttdata.tim.now.data.dto.sla;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class ListaSlaTimeOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = -6341175165765598734L;
	
	@JsonProperty("visualizzazioneSlaTime")
	private List<SlaTimeOutputDTO> slaTimes;

	public List<SlaTimeOutputDTO> getSlaTimes() {
		return slaTimes;
	}

	public void setSlaTimes(List<SlaTimeOutputDTO> slaTimes) {
		this.slaTimes = slaTimes;
	}

}
