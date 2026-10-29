package com.nttdata.tim.now.data.dto.monitoring.warning;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class MonitoraggioKoWarningOutputDTO implements Serializable {

	private static final long serialVersionUID = -8004514755340940692L;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataEstrazione")
	private Date dataEstrazione;

	@JsonProperty("totale")
	private String totale;

	@JsonProperty("causaleErrore")
	private String causaleErrore;

	public Date getDataEstrazione() {
		return dataEstrazione;
	}

	public void setDataEstrazione(Date dataEstrazione) {
		this.dataEstrazione = dataEstrazione;
	}

	public String getTotale() {
		return totale;
	}

	public void setTotale(String totale) {
		this.totale = totale;
	}

	public String getCausaleErrore() {
		return causaleErrore;
	}

	public void setCausaleErrore(String causaleErrore) {
		this.causaleErrore = causaleErrore;
	}

	@Override
	public String toString() {
		return "MonitoraggioKoWarningDTO [dataEstrazione=" + dataEstrazione + ", totale=" + totale + ", causaleErrore="
				+ causaleErrore + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((causaleErrore == null) ? 0 : causaleErrore.hashCode());
		result = prime * result + ((dataEstrazione == null) ? 0 : dataEstrazione.hashCode());
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
		MonitoraggioKoWarningOutputDTO other = (MonitoraggioKoWarningOutputDTO) obj;
		if (causaleErrore == null) {
			if (other.causaleErrore != null)
				return false;
		} else if (!causaleErrore.equals(other.causaleErrore))
			return false;
		if (dataEstrazione == null) {
			if (other.dataEstrazione != null)
				return false;
		} else if (!dataEstrazione.equals(other.dataEstrazione))
			return false;
		if (totale == null) {
			if (other.totale != null)
				return false;
		} else if (!totale.equals(other.totale))
			return false;
		return true;
	}

}
