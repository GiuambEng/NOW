
package com.nttdata.tim.now.data.dto.monitoring.usertask;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModUserTaskCausaliOutputDTO extends ESBResultDTO{

	private static final long serialVersionUID = 1013942016537804193L;
	
	@JsonProperty("listUserTaskResultErrate")
    private List<ListUserTaskResultErrateDTO> listUserTaskResultErrate;
	
    @JsonProperty("listUserTaskResultSbagliateDTU")
    private List<ListUserTaskResultSbagliateDTUDTO> listUserTaskResultSbagliateDTU;
    
    @JsonProperty("listUserTaskResultImproprie")
    private ListUserTaskResultImproprieDTO listUserTaskResultImproprie;
    
    public List<ListUserTaskResultErrateDTO> getListUserTaskResultErrate() {
        return listUserTaskResultErrate;
    }
    
    public void setListUserTaskResultErrate(List<ListUserTaskResultErrateDTO> listUserTaskResultErrate) {
        this.listUserTaskResultErrate = listUserTaskResultErrate;
    }
    
    public List<ListUserTaskResultSbagliateDTUDTO> getListUserTaskResultSbagliateDTU() {
        return listUserTaskResultSbagliateDTU;
    }
    
    public void setListUserTaskResultSbagliateDTU(List<ListUserTaskResultSbagliateDTUDTO> listUserTaskResultSbagliateDTU) {
        this.listUserTaskResultSbagliateDTU = listUserTaskResultSbagliateDTU;
    }
    
    public ListUserTaskResultImproprieDTO getListUserTaskResultImproprie() {
        return listUserTaskResultImproprie;
    }
    
    public void setListUserTaskResultImproprie(ListUserTaskResultImproprieDTO listUserTaskResultImproprie) {
        this.listUserTaskResultImproprie = listUserTaskResultImproprie;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((listUserTaskResultErrate == null) ? 0 : listUserTaskResultErrate.hashCode());
        result = prime * result + ((listUserTaskResultImproprie == null) ? 0 : listUserTaskResultImproprie.hashCode());
        result = prime * result + ((listUserTaskResultSbagliateDTU == null) ? 0 : listUserTaskResultSbagliateDTU.hashCode());
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
        ModUserTaskCausaliOutputDTO other = (ModUserTaskCausaliOutputDTO) obj;
        if (listUserTaskResultErrate == null) {
            if (other.listUserTaskResultErrate != null)
                return false;
        } else if (!listUserTaskResultErrate.equals(other.listUserTaskResultErrate))
            return false;
        if (listUserTaskResultImproprie == null) {
            if (other.listUserTaskResultImproprie != null)
                return false;
        } else if (!listUserTaskResultImproprie.equals(other.listUserTaskResultImproprie))
            return false;
        if (listUserTaskResultSbagliateDTU == null) {
            if (other.listUserTaskResultSbagliateDTU != null)
                return false;
        } else if (!listUserTaskResultSbagliateDTU.equals(other.listUserTaskResultSbagliateDTU))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
		return "ModUserTaskCausaliOutputDTO [listUserTaskResultErrate=" + listUserTaskResultErrate
				+ ", listUserTaskResultSbagliateDTU=" + listUserTaskResultSbagliateDTU
				+ ", listUserTaskResultImproprie=" + listUserTaskResultImproprie + "]";
    }
    
}
