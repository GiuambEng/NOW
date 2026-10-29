package com.nttdata.tim.now.data.dto.monitoring.fatturazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFatturazioneWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 4329809581662131479L;
	
	@JsonProperty("monitoraggioFatturazioneT0")
	private MonitoraggioFatturazioneOutputDTO monitoraggio;

	public MonitoraggioFatturazioneOutputDTO getMonitoraggio() {
		return monitoraggio;
	}

	public void setMonitoraggio(MonitoraggioFatturazioneOutputDTO monitoraggio) {
		this.monitoraggio = monitoraggio;
	}

	@Override
	public String toString() {
		return "MonitoraggioFatturazioneWrapperOutputDTO [monitoraggio=" + monitoraggio + "]";
	}

}
