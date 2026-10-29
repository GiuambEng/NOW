package com.nttdata.tim.now.data.bean.lan;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class VerificaUnivocitaSVlanCVlanInputBean implements Serializable {

    private static final long serialVersionUID = 3192198332459040890L;

    @JsonProperty("svlancvlan")
	private List<SVlanCVlanInOutBean> verificaUnivocitaSVLANCVLanCode;

    @JsonProperty("lavorazione")
    private String lavorazione;

	public List<SVlanCVlanInOutBean> getVerificaUnivocitaSVLANCVLanCode() {
		return verificaUnivocitaSVLANCVLanCode;
	}

	public void setVerificaUnivocitaSVLANCVLanCode(List<SVlanCVlanInOutBean> verificaUnivocitaSVLANCVLanCode) {
		this.verificaUnivocitaSVLANCVLanCode = verificaUnivocitaSVLANCVLanCode;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lavorazione == null) ? 0 : lavorazione.hashCode());
		result = prime * result
				+ ((verificaUnivocitaSVLANCVLanCode == null) ? 0 : verificaUnivocitaSVLANCVLanCode.hashCode());
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
		VerificaUnivocitaSVlanCVlanInputBean other = (VerificaUnivocitaSVlanCVlanInputBean) obj;
		if (lavorazione == null) {
			if (other.lavorazione != null)
				return false;
		} else if (!lavorazione.equals(other.lavorazione))
			return false;
		if (verificaUnivocitaSVLANCVLanCode == null) {
			if (other.verificaUnivocitaSVLANCVLanCode != null)
				return false;
		} else if (!verificaUnivocitaSVLANCVLanCode.equals(other.verificaUnivocitaSVLANCVLanCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaUnivocitaSVlanCVlanInputBean [verificaUnivocitaSVLANCVLanCode="
				+ verificaUnivocitaSVLANCVLanCode + ", lavorazione=" + lavorazione + "]";
	}

    

}