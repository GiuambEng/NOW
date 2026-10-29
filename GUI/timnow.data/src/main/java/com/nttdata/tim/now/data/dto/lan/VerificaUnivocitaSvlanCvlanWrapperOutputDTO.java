package com.nttdata.tim.now.data.dto.lan;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class VerificaUnivocitaSvlanCvlanWrapperOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 3235630860317630894L;
	
	@JsonProperty("outputVerificaUnivocitaCodiceSVLANCVLanCode")
    private List<SVlanCVlanInOutDto> slanCVlanVerify;

    public List<SVlanCVlanInOutDto> getSlanCVlanVerify() {
        return slanCVlanVerify;
    }

    public void setSlanCVlanVerify(List<SVlanCVlanInOutDto> slanCVlanVerify) {
        this.slanCVlanVerify = slanCVlanVerify;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((slanCVlanVerify == null) ? 0 : slanCVlanVerify.hashCode());
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
        VerificaUnivocitaSvlanCvlanWrapperOutputDTO other = (VerificaUnivocitaSvlanCvlanWrapperOutputDTO) obj;
        if (slanCVlanVerify == null) {
            if (other.slanCVlanVerify != null)
                return false;
        } else if (!slanCVlanVerify.equals(other.slanCVlanVerify))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "VerificaUnivocitaSvlanCvlanWrapperOutputDTO [slanCVlanVerify=" + slanCVlanVerify + "]";
    }


}
