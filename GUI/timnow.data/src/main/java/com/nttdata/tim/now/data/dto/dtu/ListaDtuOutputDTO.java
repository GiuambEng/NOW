package com.nttdata.tim.now.data.dto.dtu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaDtuOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 1903941246887584245L;
	
	@JsonProperty("outeventidtujpub")
	private List<DtuOutputDTO> dtus;

	public List<DtuOutputDTO> getDtus() {
		return dtus;
	}

	public void setDtus(List<DtuOutputDTO> dtus) {
		this.dtus = dtus;
	}

}
