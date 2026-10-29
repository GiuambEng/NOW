package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;

public class VerificaTicketTTMWrapperOutputDTO extends ESBResultDTO implements Serializable {
	
	private static final long serialVersionUID = 3794606027701227960L;

	@JsonProperty("outputVerificaTicketTTM")
    private EsitoDTO checkTTM;

	public EsitoDTO getCheckTTM() {
		return checkTTM;
	}

	public void setCheckTTM(EsitoDTO checkTTM) {
		this.checkTTM = checkTTM;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkTTM == null) ? 0 : checkTTM.hashCode());
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
		VerificaTicketTTMWrapperOutputDTO other = (VerificaTicketTTMWrapperOutputDTO) obj;
		if (checkTTM == null) {
			if (other.checkTTM != null)
				return false;
		} else if (!checkTTM.equals(other.checkTTM))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaTicketTTMWrapperOutputDTO [checkTTM=" + checkTTM + "]";
	}

	
}
