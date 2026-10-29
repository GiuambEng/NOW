package com.nttdata.tim.now.data.bean.notifica;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1180
@JsonInclude(Include.NON_NULL)
public class VerificaContrattoMulticastOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 8918890516171924357L;

	@JsonProperty("esito")
	private String esito;

	@JsonProperty("message")
    private String message;
	
	@JsonProperty("idContratto")
    private String idContratto;

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(String idContratto) {
		this.idContratto = idContratto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
		result = prime * result + ((idContratto == null) ? 0 : idContratto.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		VerificaContrattoMulticastOutputBean other = (VerificaContrattoMulticastOutputBean) obj;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
			return false;
		if (idContratto == null) {
			if (other.idContratto != null)
				return false;
		} else if (!idContratto.equals(other.idContratto))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaContrattoMulticastOutputBean [esito=" + esito + ", message=" + message + ", idContratto="
				+ idContratto + "]";
	}

	

}