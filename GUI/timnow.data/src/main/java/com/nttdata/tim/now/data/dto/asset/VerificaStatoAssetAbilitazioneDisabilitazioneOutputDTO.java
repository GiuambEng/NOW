package com.nttdata.tim.now.data.dto.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1184
public class VerificaStatoAssetAbilitazioneDisabilitazioneOutputDTO implements Serializable {

	private static final long serialVersionUID = -8476670775400093045L;

	@JsonProperty("esito")
    private String esito;

    @JsonProperty("message")
    private String message;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
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
		VerificaStatoAssetAbilitazioneDisabilitazioneOutputDTO other = (VerificaStatoAssetAbilitazioneDisabilitazioneOutputDTO) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaAbilitazioneDisabilitazioneAssetOutputDTO [esito=" + esito + ", message=" + message + "]";
	}    
}
