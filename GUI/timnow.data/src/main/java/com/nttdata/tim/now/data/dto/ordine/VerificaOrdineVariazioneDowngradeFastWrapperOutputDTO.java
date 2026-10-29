package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;

@JsonInclude(Include.NON_NULL)
public class VerificaOrdineVariazioneDowngradeFastWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 139189605673585201L;
	
	@JsonProperty("outputVerificaOrdineVariazioneDowngradeFast")
    private EsitoDTO checkDowngradeFast;

	public EsitoDTO getCheckDowngradeFast() {
		return checkDowngradeFast;
	}

	public void setCheckDowngradeFast(EsitoDTO checkDowngradeFast) {
		this.checkDowngradeFast = checkDowngradeFast;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkDowngradeFast == null) ? 0 : checkDowngradeFast.hashCode());
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
		VerificaOrdineVariazioneDowngradeFastWrapperOutputDTO other = (VerificaOrdineVariazioneDowngradeFastWrapperOutputDTO) obj;
		if (checkDowngradeFast == null) {
			if (other.checkDowngradeFast != null)
				return false;
		} else if (!checkDowngradeFast.equals(other.checkDowngradeFast))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaOrdineVariazioneDowngradeFastOutputDTO [checkDowngradeFast=" + checkDowngradeFast + "]";
	}

}
