package com.nttdata.tim.now.data.bean.pps;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class AmbitoMonitoraggioOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 2944149618284377857L;

    @JsonProperty("nome")
	private String ambitoMonitoraggio;

	@JsonProperty("id")
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