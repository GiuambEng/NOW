package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1335
@JsonInclude(Include.NON_NULL)
public class VerificaIdRisorsaSwitchoffFwaWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -6345317770580831196L;
	
	@JsonProperty("outputVerificaIdRisorsaFwa")
    private VerificaIdRisorsaSwitchoffFwaOutputBean outputVerificaIdRisorsaFwa;

	public VerificaIdRisorsaSwitchoffFwaOutputBean getOutputVerificaIdRisorsaFwa() {
		return outputVerificaIdRisorsaFwa;
	}

	public void setOutputVerificaIdRisorsaFwa(VerificaIdRisorsaSwitchoffFwaOutputBean outputVerificaIdRisorsaFwa) {
		this.outputVerificaIdRisorsaFwa = outputVerificaIdRisorsaFwa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(outputVerificaIdRisorsaFwa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VerificaIdRisorsaSwitchoffFwaWrapperOutputBean other = (VerificaIdRisorsaSwitchoffFwaWrapperOutputBean) obj;
		return Objects.equals(outputVerificaIdRisorsaFwa, other.outputVerificaIdRisorsaFwa);
	}

	@Override
	public String toString() {
		return "VerificaIdRisorsaSwitchoffFwaWrapperOutputBean [outputVerificaIdRisorsaFwa="
				+ outputVerificaIdRisorsaFwa + "]";
	}

}
