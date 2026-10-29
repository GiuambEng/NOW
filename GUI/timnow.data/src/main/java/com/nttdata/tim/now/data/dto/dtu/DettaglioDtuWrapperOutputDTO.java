package com.nttdata.tim.now.data.dto.dtu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class DettaglioDtuWrapperOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -309282661499745588L;
	
	@JsonProperty("outputdettDtu")
	private DettaglioDtuOutputDTO dtu;

	public DettaglioDtuOutputDTO getDtu() {
		return dtu;
	}

	public void setDtu(DettaglioDtuOutputDTO dtu) {
		this.dtu = dtu;
	}

}
