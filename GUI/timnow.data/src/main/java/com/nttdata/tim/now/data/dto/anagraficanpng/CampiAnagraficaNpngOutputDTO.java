package com.nttdata.tim.now.data.dto.anagraficanpng;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1203
public class CampiAnagraficaNpngOutputDTO implements Serializable {

	private static final long serialVersionUID = -7133480087826093356L;

	@JsonProperty("listaPrefissi")
	private List<PrefissoNpngItemOutputDTO> listaPrefissi;

    @JsonProperty("listaOpzioneTraffico")
	private List<OpzioneTrafficoNpngItemOutputDTO> listaOpzioneTraffico;

	public List<PrefissoNpngItemOutputDTO> getListaPrefissi() {
		return listaPrefissi;
	}

	public void setListaPrefissi(List<PrefissoNpngItemOutputDTO> listaPrefissi) {
		this.listaPrefissi = listaPrefissi;
	}

	public List<OpzioneTrafficoNpngItemOutputDTO> getListaOpzioneTraffico() {
		return listaOpzioneTraffico;
	}

	public void setListaOpzioneTraffico(List<OpzioneTrafficoNpngItemOutputDTO> listaOpzioneTraffico) {
		this.listaOpzioneTraffico = listaOpzioneTraffico;
	}
}
