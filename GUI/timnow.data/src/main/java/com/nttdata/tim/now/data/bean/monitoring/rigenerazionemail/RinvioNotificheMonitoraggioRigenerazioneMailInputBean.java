package com.nttdata.tim.now.data.bean.monitoring.rigenerazionemail;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class RinvioNotificheMonitoraggioRigenerazioneMailInputBean implements Serializable {

	private static final long serialVersionUID = 8449109610991041758L;

	@JsonProperty("idNotifica")
	private String idNotifica;

	@JsonFormat(pattern = DateHelper.DATE_FE_LONG, shape = JsonFormat.Shape.STRING)
	@JsonProperty("timestampInvio")
	private Date timestampInvio;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNotifica == null) ? 0 : idNotifica.hashCode());
		result = prime * result + ((timestampInvio == null) ? 0 : timestampInvio.hashCode());
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
		RinvioNotificheMonitoraggioRigenerazioneMailInputBean other = (RinvioNotificheMonitoraggioRigenerazioneMailInputBean) obj;
		if (idNotifica == null) {
			if (other.idNotifica != null)
				return false;
		} else if (!idNotifica.equals(other.idNotifica))
			return false;
		if (timestampInvio == null) {
			if (other.timestampInvio != null)
				return false;
		} else if (!timestampInvio.equals(other.timestampInvio))
			return false;
		return true;
	}

	public String getIdNotifica() {
		return idNotifica;
	}

	public void setIdNotifica(String idNotifica) {
		this.idNotifica = idNotifica;
	}

	public Date getTimestampInvio() {
		return timestampInvio;
	}

	public void setTimestampInvio(Date timestampInvio) {
		this.timestampInvio = timestampInvio;
	}

	@Override
	public String toString() {
		return "RinvioNotificheMonitoraggioRigenerazioneMailInputBean [idNotifica=" + idNotifica + ", timestampInvio="
				+ timestampInvio + "]";
	}


}
