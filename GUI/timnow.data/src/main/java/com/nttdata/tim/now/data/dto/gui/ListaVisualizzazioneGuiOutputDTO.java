package com.nttdata.tim.now.data.dto.gui;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaVisualizzazioneGuiOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 1900536807502303466L;
	
	@JsonProperty("outputGuiDiVisualizzazione")
	private List<VisualizzazioneGuiOutputDTO> guis;

	public List<VisualizzazioneGuiOutputDTO> getGuis() {
		return guis;
	}

	public void setGuis(List<VisualizzazioneGuiOutputDTO> guis) {
		this.guis = guis;
	}

}
