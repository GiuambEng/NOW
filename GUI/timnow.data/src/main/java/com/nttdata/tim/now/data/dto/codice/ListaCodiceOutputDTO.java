package com.nttdata.tim.now.data.dto.codice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaCodiceOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -3988911673050752272L;
	
	@JsonProperty("esito")
	private List<CodiceOutputDTO> codes;

	public List<CodiceOutputDTO> getCodes() {
		return codes;
	}

	public void setCodes(List<CodiceOutputDTO> codes) {
		this.codes = codes;
	}

}
