package com.nttdata.tim.now.data.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CreateResponseDTO extends ESBResultDTO {

	private static final long serialVersionUID = 8723024612565236719L;
	
	private String processID;

	public String getProcessID() {
		return processID;
	}

	public void setProcessID(String processID) {
		this.processID = processID;
	}

}
