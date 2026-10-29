package com.nttdata.tim.now.data.dto.idullco;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaIdullcoOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -8508037776573570464L;
	
	@JsonProperty("visulizzaIDULLCO")
	private List<IdullcoOutputDTO> visulizzaIDULLCO;

	public List<IdullcoOutputDTO> getVisulizzaIDULLCO() {
		return visulizzaIDULLCO;
	}

	public void setVisulizzaIDULLCO(List<IdullcoOutputDTO> visulizzaIDULLCO) {
		this.visulizzaIDULLCO = visulizzaIDULLCO;
	}

}
