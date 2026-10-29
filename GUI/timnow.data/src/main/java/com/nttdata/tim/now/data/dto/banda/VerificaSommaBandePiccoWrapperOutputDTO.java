package com.nttdata.tim.now.data.dto.banda;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class VerificaSommaBandePiccoWrapperOutputDTO extends ESBResultDTO  {

	private static final long serialVersionUID = 4087333366073342672L;
	
	@JsonProperty("outputVerificaSommaBandePicco")
    private VerificaSommaBandePiccoOutputDTO outputVerificaSommaBandePicco;

    public VerificaSommaBandePiccoOutputDTO getOutputVerificaSommaBandePicco() {
        return outputVerificaSommaBandePicco;
    }
    public void setOutputVerificaSommaBandePicco(VerificaSommaBandePiccoOutputDTO outputVerificaSommaBandePicco) {
        this.outputVerificaSommaBandePicco = outputVerificaSommaBandePicco;
    }

}
