package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1181
@JsonInclude(Include.NON_NULL)
public class VerificaRecuperoModemWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -8064057274238872278L;
	
	@JsonProperty("outputVerificaRecuperoModem")
    private VerificaRecuperoModemOutputBean outputVerificaRecuperoModem;

	public VerificaRecuperoModemOutputBean getOutputVerificaRecuperoModem() {
		return outputVerificaRecuperoModem;
	}

	public void setOutputVerificaRecuperoModem(VerificaRecuperoModemOutputBean outputVerificaRecuperoModem) {
		this.outputVerificaRecuperoModem = outputVerificaRecuperoModem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputVerificaRecuperoModem == null) ? 0 : outputVerificaRecuperoModem.hashCode());
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
		VerificaRecuperoModemWrapperOutputBean other = (VerificaRecuperoModemWrapperOutputBean) obj;
		if (outputVerificaRecuperoModem == null) {
			if (other.outputVerificaRecuperoModem != null)
				return false;
		} else if (!outputVerificaRecuperoModem.equals(other.outputVerificaRecuperoModem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaRecuperoModemWrapperOutputBean [outputVerificaRecuperoModem=" + outputVerificaRecuperoModem
				+ "]";
	}

}
