package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1150
public class RecuperaIdGponWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 3942911404292605115L;
	
	@JsonProperty("outputIdGpon")
	private List<RecuperaIdGponOutputDTO> outputIdGpon;

	public List<RecuperaIdGponOutputDTO> getOutputIdGpon() {
		return outputIdGpon;
	}

	public void setOutputIdGpon(List<RecuperaIdGponOutputDTO> outputIdGpon) {
		this.outputIdGpon = outputIdGpon;
	}

	
}
