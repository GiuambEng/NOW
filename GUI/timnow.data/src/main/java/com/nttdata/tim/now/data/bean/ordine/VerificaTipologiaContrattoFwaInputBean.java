package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class VerificaTipologiaContrattoFwaInputBean implements Serializable {

	private static final long serialVersionUID = -6182704219179624006L;

	@JsonProperty("codOloAgcom")
	private String codOloAgcom;
	
	@JsonProperty("idContratto")
	private String idContratto;
	
	@JsonProperty("codiceProgetto")
	private String codiceProgetto;
	
	//SM_9996
	@JsonProperty("profiloFwa")
	private String profiloFwa;

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(String idContratto) {
		this.idContratto = idContratto;
	}

	public String getCodiceProgetto() {
		return codiceProgetto;
	}

	public void setCodiceProgetto(String codiceProgetto) {
		this.codiceProgetto = codiceProgetto;
	}

	public String getProfiloFwa() {
		return profiloFwa;
	}

	public void setProfiloFwa(String profiloFwa) {
		this.profiloFwa = profiloFwa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOloAgcom == null) ? 0 : codOloAgcom.hashCode());
		result = prime * result + ((codiceProgetto == null) ? 0 : codiceProgetto.hashCode());
		result = prime * result + ((idContratto == null) ? 0 : idContratto.hashCode());
		result = prime * result + ((profiloFwa == null) ? 0 : profiloFwa.hashCode());
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
		VerificaTipologiaContrattoFwaInputBean other = (VerificaTipologiaContrattoFwaInputBean) obj;
		if (codOloAgcom == null) {
			if (other.codOloAgcom != null)
				return false;
		} else if (!codOloAgcom.equals(other.codOloAgcom))
			return false;
		if (codiceProgetto == null) {
			if (other.codiceProgetto != null)
				return false;
		} else if (!codiceProgetto.equals(other.codiceProgetto))
			return false;
		if (idContratto == null) {
			if (other.idContratto != null)
				return false;
		} else if (!idContratto.equals(other.idContratto))
			return false;
		if (profiloFwa == null) {
			if (other.profiloFwa != null)
				return false;
		} else if (!profiloFwa.equals(other.profiloFwa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaTipologiaContrattoFwaInputBean [codOloAgcom=" + codOloAgcom + ", idContratto=" + idContratto
				+ ", codiceProgetto=" + codiceProgetto + ", profiloFwa=" + profiloFwa + "]";
	}

	
}
