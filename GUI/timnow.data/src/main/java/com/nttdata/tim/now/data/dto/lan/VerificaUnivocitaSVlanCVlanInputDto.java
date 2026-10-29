package com.nttdata.tim.now.data.dto.lan;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class VerificaUnivocitaSVlanCVlanInputDto implements Serializable {

    private static final long serialVersionUID = 4244983164327849883L;

    @JsonProperty("verificaUnivocitaSVLANCVLanCode")
	private List<SVlanCVlanInOutDto> verificaUnivocitaSVLANCVLanCode;

    @JsonProperty("lavorazione")
    private String lavorazione;

	public List<SVlanCVlanInOutDto> getVerificaUnivocitaSVLANCVLanCode() {
		return verificaUnivocitaSVLANCVLanCode;
	}

	public void setVerificaUnivocitaSVLANCVLanCode(List<SVlanCVlanInOutDto> verificaUnivocitaSVLANCVLanCode) {
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
		VerificaUnivocitaSVlanCVlanInputDto other = (VerificaUnivocitaSVlanCVlanInputDto) obj;
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
		return "VerificaUnivocitaSVlanCVlanInputDto [verificaUnivocitaSVLANCVLanCode=" + verificaUnivocitaSVLANCVLanCode
				+ ", lavorazione=" + lavorazione + "]";
	}


         
}