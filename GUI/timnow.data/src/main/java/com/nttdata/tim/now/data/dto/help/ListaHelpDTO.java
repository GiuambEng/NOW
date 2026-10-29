package com.nttdata.tim.now.data.dto.help;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaHelpDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = -2995318313498388892L;
	
	@JsonProperty("IHelpOutput")
	private List<HelpDTO> helps;

	public List<HelpDTO> getHelps() {
		return helps;
	}

	public void setHelps(List<HelpDTO> helps) {
		this.helps = helps;
	}

}
