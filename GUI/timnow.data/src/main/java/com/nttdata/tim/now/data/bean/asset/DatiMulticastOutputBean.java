package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

//RU_1180
@JsonInclude(Include.NON_NULL)
public class DatiMulticastOutputBean implements Serializable {

	private static final long serialVersionUID = 8653432214316068849L;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataAbilitazione")
	private String dataAbilitazione;
	
	@JsonProperty("idRisorsa")
	private String idRisorsa;
	
	@JsonProperty("tipologia")
	private String tipologia;

	public String getDataAbilitazione() {
		return dataAbilitazione;
	}

	public void setDataAbilitazione(String dataAbilitazione) {
		this.dataAbilitazione = dataAbilitazione;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAbilitazione == null) ? 0 : dataAbilitazione.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((tipologia == null) ? 0 : tipologia.hashCode());
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
		DatiMulticastOutputBean other = (DatiMulticastOutputBean) obj;
		if (dataAbilitazione == null) {
			if (other.dataAbilitazione != null)
				return false;
		} else if (!dataAbilitazione.equals(other.dataAbilitazione))
			return false;
		if (idRisorsa == null) {
			if (other.idRisorsa != null)
				return false;
		} else if (!idRisorsa.equals(other.idRisorsa))
			return false;
		if (tipologia == null) {
			if (other.tipologia != null)
				return false;
		} else if (!tipologia.equals(other.tipologia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatiMulticastOutputBean [dataAbilitazione=" + dataAbilitazione + ", idRisorsa=" + idRisorsa
				+ ", tipologia=" + tipologia + "]";
	}	
}
