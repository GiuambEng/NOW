package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1270
@JsonInclude(Include.NON_NULL)
public class VerificaProfiloTecnicoLineaX1X2WrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 3307653567332906237L;
	
	@JsonProperty("controlloProfiloTecnicoLineaX1X2Output")
	private VerificaProfiloTecnicoLineaX1X2OutputDTO controlloProfiloTecnicoLineaX1X2Output;

	public VerificaProfiloTecnicoLineaX1X2OutputDTO getControlloProfiloTecnicoLineaX1X2Output() {
		return controlloProfiloTecnicoLineaX1X2Output;
	}

	public void setControlloProfiloTecnicoLineaX1X2Output(
			VerificaProfiloTecnicoLineaX1X2OutputDTO controlloProfiloTecnicoLineaX1X2Output) {
		this.controlloProfiloTecnicoLineaX1X2Output = controlloProfiloTecnicoLineaX1X2Output;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((controlloProfiloTecnicoLineaX1X2Output == null) ? 0
				: controlloProfiloTecnicoLineaX1X2Output.hashCode());
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
		VerificaProfiloTecnicoLineaX1X2WrapperOutputDTO other = (VerificaProfiloTecnicoLineaX1X2WrapperOutputDTO) obj;
		if (controlloProfiloTecnicoLineaX1X2Output == null) {
			if (other.controlloProfiloTecnicoLineaX1X2Output != null)
				return false;
		} else if (!controlloProfiloTecnicoLineaX1X2Output.equals(other.controlloProfiloTecnicoLineaX1X2Output))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaProfiloTecnicoLineaX1X2WrapperOutputDTO [controlloProfiloTecnicoLineaX1X2Output="
				+ controlloProfiloTecnicoLineaX1X2Output + "]";
	}
 }
