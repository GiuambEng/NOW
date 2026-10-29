package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;

//RU_1089
@JsonInclude(Include.NON_NULL)
public class VerificaCongruenzaClusterComuneVlanOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -6838772845918951379L;
	
	@JsonProperty("VerificaCongruenzaClusterComuneVlanOutput")
    private EsitoOutputBean verificaCongruenzaClusterComuneVlanOutput;

	public EsitoOutputBean getVerificaCongruenzaClusterComuneVlanOutput() {
		return verificaCongruenzaClusterComuneVlanOutput;
	}

	public void setVerificaCongruenzaClusterComuneVlanOutput(EsitoOutputBean verificaCongruenzaClusterComuneVlanOutput) {
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
		VerificaCongruenzaClusterComuneVlanOutputBean other = (VerificaCongruenzaClusterComuneVlanOutputBean) obj;
		if (verificaCongruenzaClusterComuneVlanOutput == null) {
			if (other.verificaCongruenzaClusterComuneVlanOutput != null)
				return false;
		} else if (!verificaCongruenzaClusterComuneVlanOutput.equals(other.verificaCongruenzaClusterComuneVlanOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaCongruenzaClusterComuneVlanOutputBean [verificaCongruenzaClusterComuneVlanOutput="
				+ verificaCongruenzaClusterComuneVlanOutput + "]";
	}

	
    
}
