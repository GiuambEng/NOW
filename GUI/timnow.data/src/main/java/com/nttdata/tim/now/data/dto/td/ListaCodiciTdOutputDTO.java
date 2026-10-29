package com.nttdata.tim.now.data.dto.td;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaCodiciTdOutputDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = -8469961541430186283L;

	@JsonProperty("VisualizzaCodiceTD_Output")
	private List<CodiceTdDTO> codiciTD;

	public List<CodiceTdDTO> getCodiciTD() {
		return codiciTD;
	}

	public void setCodiciTD(List<CodiceTdDTO> codiciTD) {
		this.codiciTD = codiciTD;
	}
}
