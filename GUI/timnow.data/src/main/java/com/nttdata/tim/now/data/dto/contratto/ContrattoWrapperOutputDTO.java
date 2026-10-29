package com.nttdata.tim.now.data.dto.contratto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ContrattoWrapperOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -7973866339549058876L;
	
	@JsonProperty("dettaglioContratto")
	private ContrattoOutputDTO contract;

	public ContrattoOutputDTO getContract() {
		return contract;
	}

	public void setContract(ContrattoOutputDTO contract) {
		this.contract = contract;
	}

}
