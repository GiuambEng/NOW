package com.nttdata.tim.now.data.dto.monitoring.kodel103;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//Change Request #42013
@JsonInclude(Include.NON_NULL)
public class MonitoraggioKoDelibera103ListDTO extends ESBResultDTO {

	private static final long serialVersionUID = -6620793904490864230L;
	
	@JsonProperty("listaMonitoraggioKO")
	private List<MonitoraggioKoDel103OutputDTO> listaMonitoraggioKo;

	public List<MonitoraggioKoDel103OutputDTO> getListaMonitoraggioKo() {
		return listaMonitoraggioKo;
	}

	public void setListaMonitoraggioKo(List<MonitoraggioKoDel103OutputDTO> listaMonitoraggioKo) {
		this.listaMonitoraggioKo = listaMonitoraggioKo;
	}
	
}
