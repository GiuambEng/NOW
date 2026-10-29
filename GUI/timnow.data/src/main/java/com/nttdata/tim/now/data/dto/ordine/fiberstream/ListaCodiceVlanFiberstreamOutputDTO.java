package com.nttdata.tim.now.data.dto.ordine.fiberstream;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1452
@JsonInclude(Include.NON_NULL)
public class ListaCodiceVlanFiberstreamOutputDTO extends ESBResultDTO {


	private static final long serialVersionUID = -6223572326209900763L;
	
	@JsonProperty("attributi")
	private List<CodiceVlanFiberstreamOutputDTO> attributi;

	public List<CodiceVlanFiberstreamOutputDTO> getAttributi() {
		return attributi;
	}

	public void setAttributi(List<CodiceVlanFiberstreamOutputDTO> attributi) {
		this.attributi = attributi;
	}

}
