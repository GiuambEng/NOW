package com.nttdata.tim.now.data.bean.monitoring.fatturazione;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFatturazioneFamigliaOffertaOutputBean implements Serializable {

	private static final long serialVersionUID = -8488189457398496122L;

	@JsonProperty("nomeFamigliaOfferta")
	private String nomeFamigliaOfferta;

	@JsonProperty("fileData")
	private List<MonitoraggioFatturazioneFileOutputBean> list;

	public String getNomeFamigliaOfferta() {
		return nomeFamigliaOfferta;
	}

	public void setNomeFamigliaOfferta(String nomeFamigliaOfferta) {
		this.nomeFamigliaOfferta = nomeFamigliaOfferta;
	}

	public List<MonitoraggioFatturazioneFileOutputBean> getList() {
		return list;
	}

	public void setList(List<MonitoraggioFatturazioneFileOutputBean> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "MonitoraggioFatturazioneFamigliaOffertaOutputBean [nomeFamigliaOfferta=" + nomeFamigliaOfferta
				+ ", list=" + list + "]";
	}

}
