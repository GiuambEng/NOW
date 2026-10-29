package com.nttdata.tim.now.data.dto.cpe;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_921
@JsonInclude(Include.NON_NULL)
public class CpeWrapperOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -5046894005060120268L;
	
	@JsonProperty("outputTipologiaCPE")
	private List<CpeOutputDTO> outputTipologiaCPE;

	public List<CpeOutputDTO> getOutputTipologiaCPE() {
		return outputTipologiaCPE;
	}

	public void setOutputTipologiaCPE(List<CpeOutputDTO> outputTipologiaCPE) {
		this.outputTipologiaCPE = outputTipologiaCPE;
	}

}
