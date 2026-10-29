
package com.nttdata.tim.now.data.dto.monitoring.usertask;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModUserTaskCausaliInputDTO implements Serializable {
    
	private static final long serialVersionUID = 238443560722486259L;

	@JsonProperty("ModUserTaskCausaliErrate")
    private List<ModUserTaskCausaliErrateDTO> modUserTaskCausaliErrate;
    
    @JsonProperty("ModUserTaskCausaliImproprie")
    private List<ModUserTaskCausaliImproprieDTO> modUserTaskCausaliImproprie;
    
    @JsonProperty("ModUserTaskCausaliSbagliateDTU")
    private List<ModUserTaskCausaliSbagliateDTO> modUserTaskCausaliSbagliate;

    public List<ModUserTaskCausaliErrateDTO> getModUserTaskCausaliErrate() {
        return modUserTaskCausaliErrate;
    }

    public void setModUserTaskCausaliErrate(List<ModUserTaskCausaliErrateDTO> modUserTaskCausaliErrate) {
        this.modUserTaskCausaliErrate = modUserTaskCausaliErrate;
    }

    public List<ModUserTaskCausaliImproprieDTO> getModUserTaskCausaliImproprie() {
        return modUserTaskCausaliImproprie;
    }

    public void setModUserTaskCausaliImproprie(List<ModUserTaskCausaliImproprieDTO> modUserTaskCausaliImproprie) {
        this.modUserTaskCausaliImproprie = modUserTaskCausaliImproprie;
    }

    public List<ModUserTaskCausaliSbagliateDTO> getModUserTaskCausaliSbagliate() {
        return modUserTaskCausaliSbagliate;
    }

    public void setModUserTaskCausaliSbagliate(List<ModUserTaskCausaliSbagliateDTO> modUserTaskCausaliSbagliate) {
        this.modUserTaskCausaliSbagliate = modUserTaskCausaliSbagliate;
    }

    @Override
    public String toString() {
        return "ModUserTaskCausaliInputDTO [modUserTaskCausaliErrate=" + modUserTaskCausaliErrate + ", modUserTaskCausaliImproprie="
                + modUserTaskCausaliImproprie + ", modUserTaskCausaliSbagliate=" + modUserTaskCausaliSbagliate + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((modUserTaskCausaliErrate == null) ? 0 : modUserTaskCausaliErrate.hashCode());
        result = prime * result + ((modUserTaskCausaliImproprie == null) ? 0 : modUserTaskCausaliImproprie.hashCode());
        result = prime * result + ((modUserTaskCausaliSbagliate == null) ? 0 : modUserTaskCausaliSbagliate.hashCode());
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
        ModUserTaskCausaliInputDTO other = (ModUserTaskCausaliInputDTO) obj;
        if (modUserTaskCausaliErrate == null) {
            if (other.modUserTaskCausaliErrate != null)
                return false;
        } else if (!modUserTaskCausaliErrate.equals(other.modUserTaskCausaliErrate))
            return false;
        if (modUserTaskCausaliImproprie == null) {
            if (other.modUserTaskCausaliImproprie != null)
                return false;
        } else if (!modUserTaskCausaliImproprie.equals(other.modUserTaskCausaliImproprie))
            return false;
        if (modUserTaskCausaliSbagliate == null) {
            if (other.modUserTaskCausaliSbagliate != null)
                return false;
        } else if (!modUserTaskCausaliSbagliate.equals(other.modUserTaskCausaliSbagliate))
            return false;
        return true;
    }

}
