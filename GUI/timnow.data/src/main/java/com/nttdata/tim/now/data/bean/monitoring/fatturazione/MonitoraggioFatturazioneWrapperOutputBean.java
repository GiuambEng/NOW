package com.nttdata.tim.now.data.bean.monitoring.fatturazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFatturazioneWrapperOutputBean extends AbstractOutputBean implements Serializable{

	private static final long serialVersionUID = -2473791862301987339L;
	
	@JsonProperty("monitoraggi")
	private MonitoraggioFatturazioneOutputBean monitoraggio;

	public MonitoraggioFatturazioneOutputBean getMonitoraggio() {
		return monitoraggio;
	}

	public void setMonitoraggio(MonitoraggioFatturazioneOutputBean monitoraggio) {
		this.monitoraggio = monitoraggio;
	}

	@Override
	public String toString() {
		return "MonitoraggioFatturazioneWrapperOutputBean [monitoraggio=" + monitoraggio + "]";
	}

}
