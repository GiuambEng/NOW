package com.nttdata.tim.now.data.bean.monitoring.fatturazione;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFatturazioneOutputBean implements Serializable {

	private static final long serialVersionUID = 8647957583095115266L;

	@JsonProperty("famigliaOfferta")
	private List<MonitoraggioFatturazioneFamigliaOffertaOutputBean> list;

	@JsonProperty("soglia")
	private String soglia;

	@JsonProperty("idExportFile")
	private String idFile;

	public List<MonitoraggioFatturazioneFamigliaOffertaOutputBean> getList() {
		return list;
	}

	public void setList(List<MonitoraggioFatturazioneFamigliaOffertaOutputBean> list) {
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
		return "MonitoraggioFatturazioneOutputBean [list=" + list + ", soglia=" + soglia + ", idFile=" + idFile + "]";
	}

}
