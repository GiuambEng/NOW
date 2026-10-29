package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1060
public class VerificaComuneOffertaInfratelWrapperOutputBean extends AbstractOutputBean implements Serializable {
	
	private static final long serialVersionUID = -1190856400463738452L;
	
	@JsonProperty("VerificaComuneOffertaInfratelOutput")
	private VerificaComuneOffertaInfratelOutputBean verificaComuneOffertaInfratelOutput;

	public VerificaComuneOffertaInfratelOutputBean getVerificaComuneOffertaInfratelOutput() {
		return verificaComuneOffertaInfratelOutput;
	}

	public void setVerificaComuneOffertaInfratelOutput(
			VerificaComuneOffertaInfratelOutputBean verificaComuneOffertaInfratelOutput) {
		this.verificaComuneOffertaInfratelOutput = verificaComuneOffertaInfratelOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((verificaComuneOffertaInfratelOutput == null) ? 0 : verificaComuneOffertaInfratelOutput.hashCode());
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
		VerificaComuneOffertaInfratelWrapperOutputBean other = (VerificaComuneOffertaInfratelWrapperOutputBean) obj;
		if (verificaComuneOffertaInfratelOutput == null) {
			if (other.verificaComuneOffertaInfratelOutput != null)
				return false;
		} else if (!verificaComuneOffertaInfratelOutput.equals(other.verificaComuneOffertaInfratelOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaComuneOffertaInfratelWrapperOutputBean [verificaComuneOffertaInfratelOutput="
				+ verificaComuneOffertaInfratelOutput + "]";
	}

   
	
}
