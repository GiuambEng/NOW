package com.nttdata.tim.now.data.dto.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ESBAUTHResultDTO extends ESBResultDTO implements Serializable {
	
	private static final long serialVersionUID = 7041797477695027171L;

	private ESBBaseResultDTO esito;

	public ESBBaseResultDTO getEsito() {
		return esito;
	}

	public void setEsito(ESBBaseResultDTO esito) {
		this.esito = esito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		ESBAUTHResultDTO other = (ESBAUTHResultDTO) obj;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ESBAUTHResultDTO [esito=" + esito + "]";
	}

	
}