package com.nttdata.tim.now.data.dto.referente;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ReferenteContattatoWrapperOutputDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = 7134184244117369890L;
	
	@JsonProperty("visualizzazioneReferenteContattatoOutput1")
	private List<ReferenteContattatoOutputDTO> visualizzazioneReferentecontattatoOutput;

	public List<ReferenteContattatoOutputDTO> getVisualizzazioneReferentecontattatoOutput() {
		return visualizzazioneReferentecontattatoOutput;
	}

	public void setVisualizzazioneReferentecontattatoOutput(List<ReferenteContattatoOutputDTO> visualizzazioneReferentecontattatoOutput) {
		this.visualizzazioneReferentecontattatoOutput = visualizzazioneReferentecontattatoOutput;
	}
}
