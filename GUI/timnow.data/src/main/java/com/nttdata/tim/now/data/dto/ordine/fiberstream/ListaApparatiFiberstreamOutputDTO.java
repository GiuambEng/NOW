package com.nttdata.tim.now.data.dto.ordine.fiberstream;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1462
@JsonInclude(Include.NON_NULL)
public class ListaApparatiFiberstreamOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -7124933334183202701L;
	
	@JsonProperty("codiceNMU")
	private List<String> codiceNmu;

	public List<String> getCodiceNmu() {
		return codiceNmu;
	}

	public void setCodiceNmu(List<String> codiceNmu) {
		this.codiceNmu = codiceNmu;
	}
}
