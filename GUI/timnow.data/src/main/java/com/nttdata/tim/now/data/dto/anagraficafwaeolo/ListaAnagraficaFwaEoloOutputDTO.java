package com.nttdata.tim.now.data.dto.anagraficafwaeolo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1479
@JsonInclude(Include.NON_NULL)
public class ListaAnagraficaFwaEoloOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 8817751651418382349L;

	@JsonProperty("listaAnagraficaFWAEOLO")
	private List<AnagraficaFwaEoloOutputDTO> listaAnagraficaFwaEolo;

	public List<AnagraficaFwaEoloOutputDTO> getListaAnagraficaFwaEolo() {
		return listaAnagraficaFwaEolo;
	}

	public void setListaAnagraficaFwaEolo(List<AnagraficaFwaEoloOutputDTO> listaAnagraficaFwaEolo) {
		this.listaAnagraficaFwaEolo = listaAnagraficaFwaEolo;
	}	
}