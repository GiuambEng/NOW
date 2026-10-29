package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//SM_9825
@JsonInclude(Include.NON_NULL)
public class VerificaModelloKitMadrOutputDTO implements Serializable {

	private static final long serialVersionUID = 7059413727942099112L;
	
	@JsonProperty("esito")
	private String esito;
	
	@JsonProperty("message")
	private String message;

	public String getEsito() {
		return esito;
	}

	public String getMessage() {
		return message;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
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
		VerificaModelloKitMadrOutputDTO other = (VerificaModelloKitMadrOutputDTO) obj;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
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
		return "VerificaModelloKitMadrOutputDTO [esito=" + esito + ", message=" + message + "]";
	}	
}
