
package com.nttdata.tim.now.data.dto.monitoring.usertask;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserTaskListaCausaliDTO extends ESBResultDTO {
	
    private static final long serialVersionUID = -5945692328855607864L;
    
    @JsonProperty("causali")
    private List<CausaliDTO> causali;
    
    public List<CausaliDTO> getCausali() {
        return causali;
    }
    
    public void setCausali(List<CausaliDTO> causali) {
        this.causali = causali;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((causali == null) ? 0 : causali.hashCode());
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
        UserTaskListaCausaliDTO other = (UserTaskListaCausaliDTO) obj;
        if (causali == null) {
            if (other.causali != null)
                return false;
        } else if (!causali.equals(other.causali))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "UserTaskListaCausaliDTO [causali=" + causali + "]";
    }

}
