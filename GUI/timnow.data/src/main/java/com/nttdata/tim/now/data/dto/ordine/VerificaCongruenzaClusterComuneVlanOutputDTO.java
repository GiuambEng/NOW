package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;

//RU_1089
public class VerificaCongruenzaClusterComuneVlanOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -2863585111151652906L;

	@JsonProperty("VerificaCongruenzaClusterComuneVlanOutput")
	private EsitoDTO verificaCongruenzaClusterComuneVlanOutput;

	public EsitoDTO getVerificaCongruenzaClusterComuneVlanOutput() {
		return verificaCongruenzaClusterComuneVlanOutput;
	}

	public void setVerificaCongruenzaClusterComuneVlanOutput(EsitoDTO verificaCongruenzaClusterComuneVlanOutput) {
		this.verificaCongruenzaClusterComuneVlanOutput = verificaCongruenzaClusterComuneVlanOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verificaCongruenzaClusterComuneVlanOutput == null) ? 0
				: verificaCongruenzaClusterComuneVlanOutput.hashCode());
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
		VerificaCongruenzaClusterComuneVlanOutputDTO other = (VerificaCongruenzaClusterComuneVlanOutputDTO) obj;
		if (verificaCongruenzaClusterComuneVlanOutput == null) {
			if (other.verificaCongruenzaClusterComuneVlanOutput != null)
				return false;
		} else if (!verificaCongruenzaClusterComuneVlanOutput.equals(other.verificaCongruenzaClusterComuneVlanOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaCongruenzaClusterComuneVlanOutputDTO [verificaCongruenzaClusterComuneVlanOutput="
				+ verificaCongruenzaClusterComuneVlanOutput + "]";
	}
 }
