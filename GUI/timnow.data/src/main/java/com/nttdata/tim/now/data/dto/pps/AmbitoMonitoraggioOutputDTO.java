package com.nttdata.tim.now.data.dto.pps;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class AmbitoMonitoraggioOutputDTO implements Serializable {

	private static final long serialVersionUID = -6023783315600655772L;

	@JsonProperty("Ambito_Monitoraggio")
	private String ambitoMonitoraggio;

	@JsonProperty("ID_PPS_Ambito_Monitoraggio")
	private String idAmbitoMonitoraggio;

	public String getAmbitoMonitoraggio() {
		return ambitoMonitoraggio;
	}

	public void setAmbitoMonitoraggio(String ambitoMonitoraggio) {
		this.ambitoMonitoraggio = ambitoMonitoraggio;
	}

	public String getIdAmbitoMonitoraggio() {
		return idAmbitoMonitoraggio;
	}

	public void setIdAmbitoMonitoraggio(String idAmbitoMonitoraggio) {
		this.idAmbitoMonitoraggio = idAmbitoMonitoraggio;
	}

}
