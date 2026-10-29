package com.nttdata.tim.now.data.bean.richiesta;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//SM_9693
@JsonInclude(Include.NON_NULL)
public class EsitiRichiesteInputBean implements Serializable{
	
	private static final long serialVersionUID = -4787450961886079363L;
	
	@JsonProperty("idRichiesta")
	private String idRichiesta;
	
	@JsonProperty("tipoProfilo")
	private String tipoProfilo;
	
	@JsonProperty("codOloAgcom")
	private String codOloAgcom;
	
	@JsonProperty("IPClient")
	private String ipClient;
	
	@JsonProperty("operatore")
	private String operatore;
		
	@JsonProperty("codOrdineOlo")
	private String codOrdineOlo;	


	public String getIdRichiesta() {
		return idRichiesta;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public String getCodOrdineOlo() {
		return codOrdineOlo;
	}

	public String getOperatore() {
		return operatore;
	}

	public String getTipoProfilo() {
		return tipoProfilo;
	}

	public String getIpClient() {
		return ipClient;
	}

	public void setIdRichiesta(String idRichiesta) {
		this.idRichiesta = idRichiesta;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public void setCodOrdineOlo(String codOrdineOlo) {
		this.codOrdineOlo = codOrdineOlo;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public void setTipoProfilo(String tipoProfilo) {
		this.tipoProfilo = tipoProfilo;
	}

	public void setIpClient(String ipClient) {
		this.ipClient = ipClient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOloAgcom == null) ? 0 : codOloAgcom.hashCode());
		result = prime * result + ((codOrdineOlo == null) ? 0 : codOrdineOlo.hashCode());
		result = prime * result + ((idRichiesta == null) ? 0 : idRichiesta.hashCode());
		result = prime * result + ((ipClient == null) ? 0 : ipClient.hashCode());
		result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
		result = prime * result + ((tipoProfilo == null) ? 0 : tipoProfilo.hashCode());
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
		EsitiRichiesteInputBean other = (EsitiRichiesteInputBean) obj;
		if (codOloAgcom == null) {
			if (other.codOloAgcom != null)
				return false;
		} else if (!codOloAgcom.equals(other.codOloAgcom))
			return false;
		if (codOrdineOlo == null) {
			if (other.codOrdineOlo != null)
				return false;
		} else if (!codOrdineOlo.equals(other.codOrdineOlo))
			return false;
		if (idRichiesta == null) {
			if (other.idRichiesta != null)
				return false;
		} else if (!idRichiesta.equals(other.idRichiesta))
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
		if (tipoProfilo == null) {
			if (other.tipoProfilo != null)
				return false;
		} else if (!tipoProfilo.equals(other.tipoProfilo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EsitiRichiesteInputBean [idRichiesta=" + idRichiesta + ", codOloAgcom=" + codOloAgcom
				+ ", codOrdineOlo=" + codOrdineOlo + ", operatore=" + operatore + ", tipoProfilo=" + tipoProfilo
				+ ", ipClient=" + ipClient + "]";
	}
}
