package com.nttdata.tim.now.data.bean.monitoring.kocautelare;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class MonitoraggioKoCautelareOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -5962066156256291885L;

    @JsonProperty("servizio")
	private String servizio;

	@JsonProperty("totale")
	private String totale;

	@JsonProperty("causaleEsito")
	private String causaleEsito;

	public String getServizio() {
		return servizio;
	}

	public void setServizio(String servizio) {
		this.servizio = servizio;
	}

	public String getTotale() {
		return totale;
	}

	public void setTotale(String totale) {
		this.totale = totale;
	}

	public String getCausaleEsito() {
		return causaleEsito;
	}

	public void setCausaleEsito(String causaleEsito) {
		this.causaleEsito = causaleEsito;
	}

}