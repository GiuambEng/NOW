package com.nttdata.tim.now.data.dto.monitoring.fatturazione;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFatturazioneFamigliaOffertaOutputDTO implements Serializable {

	private static final long serialVersionUID = 2743978380691216892L;

	@JsonProperty("nomeFamigliaOfferta")
	private String nomeFamigliaOfferta;

	@JsonProperty("dataXFatt")
	private List<MonitoraggioFatturazioneFileOutputDTO> list;

	public String getNomeFamigliaOfferta() {
		return nomeFamigliaOfferta;
	}

	public void setNomeFamigliaOfferta(String nomeFamigliaOfferta) {
		this.nomeFamigliaOfferta = nomeFamigliaOfferta;
	}

	public List<MonitoraggioFatturazioneFileOutputDTO> getList() {
		return list;
	}

	public void setList(List<MonitoraggioFatturazioneFileOutputDTO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "AMonitoraggioFatturazioneFamigliaOffertaOutputDTO [nomeFamigliaOfferta=" + nomeFamigliaOfferta
				+ ", list=" + list + "]";
	}

}
