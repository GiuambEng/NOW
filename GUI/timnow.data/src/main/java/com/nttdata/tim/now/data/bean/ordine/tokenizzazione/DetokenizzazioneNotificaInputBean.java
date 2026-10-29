package com.nttdata.tim.now.data.bean.ordine.tokenizzazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//SM_9693
@JsonInclude(Include.NON_NULL)
public class DetokenizzazioneNotificaInputBean implements Serializable {

	private static final long serialVersionUID = -528110061857186029L;
	
	@JsonProperty("operatore")
	private String operatore;
	
	@JsonProperty("IPClient")
	private String ipClient;
	
	@JsonProperty("idNotifica")
	private String idNotifica;
	
	//SM_10516
	@JsonProperty("tipoProfilo")
	private String tipoProfilo;

	public String getOperatore() {
		return operatore;
	}

	public String getIpClient() {
		return ipClient;
	}

	public String getIdNotifica() {
		return idNotifica;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public void setIpClient(String ipClient) {
		this.ipClient = ipClient;
	}

	public void setIdNotifica(String idNotifica) {
		this.idNotifica = idNotifica;
	}

	public String getTipoProfilo() {
		return tipoProfilo;
	}

	public void setTipoProfilo(String tipoProfilo) {
		this.tipoProfilo = tipoProfilo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNotifica == null) ? 0 : idNotifica.hashCode());
		result = prime * result + ((ipClient == null) ? 0 : ipClient.hashCode());
		result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
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
		DetokenizzazioneNotificaInputBean other = (DetokenizzazioneNotificaInputBean) obj;
		if (idNotifica == null) {
			if (other.idNotifica != null)
				return false;
		} else if (!idNotifica.equals(other.idNotifica))
			return false;
		if (ipClient == null) {
			if (other.ipClient != null)
				return false;
		} else if (!ipClient.equals(other.ipClient))
			return false;
		if (operatore == null) {
			if (other.operatore != null)
				return false;
		} else if (!operatore.equals(other.operatore))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetokenizzazioneNotificaInputBean [operatore=" + operatore + ", ipClient=" + ipClient + ", idNotifica="
				+ idNotifica + "]";
	}
			
}