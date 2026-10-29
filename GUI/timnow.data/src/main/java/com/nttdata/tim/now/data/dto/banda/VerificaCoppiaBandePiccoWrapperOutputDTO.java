package com.nttdata.tim.now.data.dto.banda;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class VerificaCoppiaBandePiccoWrapperOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 992254287625612430L;
	
	@JsonProperty("outputVerificaCoppiaBandePicco")
	private List<VerificaCoppiaBandePiccoOutputDTO> outbands;

	public List<VerificaCoppiaBandePiccoOutputDTO> getOutbands() {
		return outbands;
	}

	public void setOutbands(List<VerificaCoppiaBandePiccoOutputDTO> outbands) {
		this.outbands = outbands;
	}

}
