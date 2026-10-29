package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_994
@JsonInclude(Include.NON_NULL)
public class VerificaOrdineVariazioneDowngradeFastInputDTO implements Serializable {

	private static final long serialVersionUID = -6477343533494785633L;

	@JsonProperty("idTicketTTM")
	private String idTicketTTM;
	
	@JsonProperty("idRisorsa")
	private String idRisorsa;

	public String getIdTicketTTM() {
		return idTicketTTM;
	}

	public void setIdTicketTTM(String idTicketTTM) {
		this.idTicketTTM = idTicketTTM;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((idTicketTTM == null) ? 0 : idTicketTTM.hashCode());
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
		VerificaOrdineVariazioneDowngradeFastInputDTO other = (VerificaOrdineVariazioneDowngradeFastInputDTO) obj;
		if (idRisorsa == null) {
			if (other.idRisorsa != null)
				return false;
		} else if (!idRisorsa.equals(other.idRisorsa))
			return false;
		if (idTicketTTM == null) {
			if (other.idTicketTTM != null)
				return false;
		} else if (!idTicketTTM.equals(other.idTicketTTM))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaTicketTTMInputDTO [idTicketTTM=" + idTicketTTM + ", idRisorsa=" + idRisorsa + "]";
	}
	
	
}
