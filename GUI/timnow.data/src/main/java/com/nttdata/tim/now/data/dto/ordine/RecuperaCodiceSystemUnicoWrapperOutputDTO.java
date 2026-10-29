package com.nttdata.tim.now.data.dto.ordine;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1428
@JsonInclude(Include.NON_NULL)
public class RecuperaCodiceSystemUnicoWrapperOutputDTO extends ESBResultDTO{

	private static final long serialVersionUID = 8320878553948562829L;
	
	@JsonProperty("outputCodSystemUnico")
    private List<RecuperaCodiceSystemUnicoOutputDTO> outputCodSystemUnico;

	public List<RecuperaCodiceSystemUnicoOutputDTO> getOutputCodSystemUnico() {
		return outputCodSystemUnico;
	}

	public void setOutputCodSystemUnico(List<RecuperaCodiceSystemUnicoOutputDTO> outputCodSystemUnico) {
		this.outputCodSystemUnico = outputCodSystemUnico;
	}
    
}
