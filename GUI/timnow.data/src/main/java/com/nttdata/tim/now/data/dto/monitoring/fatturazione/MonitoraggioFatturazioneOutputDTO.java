package com.nttdata.tim.now.data.dto.monitoring.fatturazione;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFatturazioneOutputDTO implements Serializable {

	private static final long serialVersionUID = 4523649558528489552L;

	@JsonProperty("famigliaOffertaFatt")
	private List<MonitoraggioFatturazioneFamigliaOffertaOutputDTO> list;

	@JsonProperty("soglia")
	private String soglia;

	@JsonProperty("idFile")
	private String idFile;

	public List<MonitoraggioFatturazioneFamigliaOffertaOutputDTO> getList() {
		return list;
	}

	public void setList(List<MonitoraggioFatturazioneFamigliaOffertaOutputDTO> list) {
		this.list = list;
	}

	public String getSoglia() {
		return soglia;
	}

	public void setSoglia(String soglia) {
		this.soglia = soglia;
	}

	public String getIdFile() {
		return idFile;
	}

	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}

	@Override
	public String toString() {
		return "MonitoraggioFatturazioneOutputDTO [list=" + list + ", soglia=" + soglia + ", idFile=" + idFile + "]";
	}

}
