package com.nttdata.tim.now.data.dto.monitoring.rigenerazionemail;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class NotificheMonitoraggioRigenerazioneMailOutputDTO implements Serializable {

	private static final long serialVersionUID = 5981733339710294497L;

	@JsonFormat(pattern = DateHelper.DATE_BE_LONG, shape = JsonFormat.Shape.STRING, timezone = DateHelper.TIMEZONE_IT)
	@JsonProperty("dataCreazione")
	private Date dataCreazione;

	@JsonProperty("codiceNotifica")
	private String codiceNotifica;

	@JsonProperty("codiceCausaleNow")
	private String codiceCausaleNow;

	@JsonProperty("tipoLavorazione")
	private String tipoLavorazione;
	
	@JsonProperty("codiceCausaleOao")
	private String codiceCausaleOao;
	
	@JsonProperty("destinatario")
	private String destinatario;
	
	@JsonProperty("idNotifica")
	private String idNotifica;

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public String getCodiceNotifica() {
		return codiceNotifica;
	}

	public void setCodiceNotifica(String codiceNotifica) {
		this.codiceNotifica = codiceNotifica;
	}

	public String getCodiceCausaleNow() {
		return codiceCausaleNow;
	}

	public void setCodiceCausaleNow(String codiceCausaleNow) {
		this.codiceCausaleNow = codiceCausaleNow;
	}

	public String getTipoLavorazione() {
		return tipoLavorazione;
	}

	public void setTipoLavorazione(String tipoLavorazione) {
		this.tipoLavorazione = tipoLavorazione;
	}

	public String getCodiceCausaleOao() {
		return codiceCausaleOao;
	}

	public void setCodiceCausaleOao(String codiceCausaleOao) {
		this.codiceCausaleOao = codiceCausaleOao;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getIdNotifica() {
		return idNotifica;
	}

	public void setIdNotifica(String idNotifica) {
		this.idNotifica = idNotifica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceCausaleNow == null) ? 0 : codiceCausaleNow.hashCode());
		result = prime * result + ((codiceCausaleOao == null) ? 0 : codiceCausaleOao.hashCode());
		result = prime * result + ((codiceNotifica == null) ? 0 : codiceNotifica.hashCode());
		result = prime * result + ((dataCreazione == null) ? 0 : dataCreazione.hashCode());
		result = prime * result + ((destinatario == null) ? 0 : destinatario.hashCode());
		result = prime * result + ((idNotifica == null) ? 0 : idNotifica.hashCode());
		result = prime * result + ((tipoLavorazione == null) ? 0 : tipoLavorazione.hashCode());
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
		NotificheMonitoraggioRigenerazioneMailOutputDTO other = (NotificheMonitoraggioRigenerazioneMailOutputDTO) obj;
		if (codiceCausaleNow == null) {
			if (other.codiceCausaleNow != null)
				return false;
		} else if (!codiceCausaleNow.equals(other.codiceCausaleNow))
			return false;
		if (codiceCausaleOao == null) {
			if (other.codiceCausaleOao != null)
				return false;
		} else if (!codiceCausaleOao.equals(other.codiceCausaleOao))
			return false;
		if (codiceNotifica == null) {
			if (other.codiceNotifica != null)
				return false;
		} else if (!codiceNotifica.equals(other.codiceNotifica))
			return false;
		if (dataCreazione == null) {
			if (other.dataCreazione != null)
				return false;
		} else if (!dataCreazione.equals(other.dataCreazione))
			return false;
		if (destinatario == null) {
			if (other.destinatario != null)
				return false;
		} else if (!destinatario.equals(other.destinatario))
			return false;
		if (idNotifica == null) {
			if (other.idNotifica != null)
				return false;
		} else if (!idNotifica.equals(other.idNotifica))
			return false;
		if (tipoLavorazione == null) {
			if (other.tipoLavorazione != null)
				return false;
		} else if (!tipoLavorazione.equals(other.tipoLavorazione))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NotificheMonitoraggioRigenerazioneMailOutputDTO [dataCreazione=" + dataCreazione + ", codiceNotifica="
				+ codiceNotifica + ", codiceCausaleNow=" + codiceCausaleNow + ", tipoLavorazione=" + tipoLavorazione
				+ ", codiceCausaleOao=" + codiceCausaleOao + ", destinatario=" + destinatario + ", idNotifica="
				+ idNotifica + "]";
	}



}