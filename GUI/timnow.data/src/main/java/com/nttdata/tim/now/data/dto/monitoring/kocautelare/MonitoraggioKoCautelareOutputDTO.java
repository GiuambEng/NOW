package com.nttdata.tim.now.data.dto.monitoring.kocautelare;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class MonitoraggioKoCautelareOutputDTO implements Serializable {

	private static final long serialVersionUID = 1398604622432175061L;

	@JsonProperty("Servizio")
	private String servizio;

	@JsonProperty("Totale")
	private String totale;

	@JsonProperty("CausaleEsito")
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

	@Override
	public String toString() {
		return "MonitoraggioKoCautelareDTO [servizio=" + servizio + ", totale=" + totale + ", causaleEsito="
				+ causaleEsito + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((causaleEsito == null) ? 0 : causaleEsito.hashCode());
		result = prime * result + ((servizio == null) ? 0 : servizio.hashCode());
		result = prime * result + ((totale == null) ? 0 : totale.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonitoraggioKoCautelareOutputDTO other = (MonitoraggioKoCautelareOutputDTO) obj;
		if (causaleEsito == null) {
			if (other.causaleEsito != null)
				return false;
		} else if (!causaleEsito.equals(other.causaleEsito))
			return false;
		if (servizio == null) {
			if (other.servizio != null)
				return false;
		} else if (!servizio.equals(other.servizio))
			return false;
		if (totale == null) {
			if (other.totale != null)
				return false;
		} else if (!totale.equals(other.totale))
			return false;
		return true;
	}

}
