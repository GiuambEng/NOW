package com.nttdata.tim.now.data.dto.ordine.npng;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1203
public class RicercaOrdiniNpngWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -8801374272058184942L;
	
	@JsonProperty("ricercaOrdiniOutput")
	private List<RicercaOrdiniNpngOutputDTO> ricercaOrdiniOutput;

	public List<RicercaOrdiniNpngOutputDTO> getRicercaOrdiniOutput() {
		return ricercaOrdiniOutput;
	}

	public void setRicercaOrdiniOutput(List<RicercaOrdiniNpngOutputDTO> ricercaOrdiniOutput) {
		this.ricercaOrdiniOutput = ricercaOrdiniOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ricercaOrdiniOutput == null) ? 0 : ricercaOrdiniOutput.hashCode());
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
		RicercaOrdiniNpngWrapperOutputDTO other = (RicercaOrdiniNpngWrapperOutputDTO) obj;
		if (ricercaOrdiniOutput == null) {
			if (other.ricercaOrdiniOutput != null)
				return false;
		} else if (!ricercaOrdiniOutput.equals(other.ricercaOrdiniOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RicercaOrdiniNpngWrapperOutputDTO [ricercaOrdiniOutput=" + ricercaOrdiniOutput + "]";
	}
 }
