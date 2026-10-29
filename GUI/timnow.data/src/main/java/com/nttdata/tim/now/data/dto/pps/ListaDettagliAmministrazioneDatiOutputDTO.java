package com.nttdata.tim.now.data.dto.pps;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaDettagliAmministrazioneDatiOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 1171770766583188009L;
	
	@JsonProperty("Output_Visualizzazione_Dettaglio")
	private List<DettaglioAmministrazioneDatiOutputDTO> detail;

	public List<DettaglioAmministrazioneDatiOutputDTO> getDetail() {
		return detail;
	}

	public void setDetail(List<DettaglioAmministrazioneDatiOutputDTO> detail) {
		this.detail = detail;
	}
}
