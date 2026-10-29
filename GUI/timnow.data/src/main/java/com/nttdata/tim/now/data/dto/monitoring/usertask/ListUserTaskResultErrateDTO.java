
package com.nttdata.tim.now.data.dto.monitoring.usertask;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListUserTaskResultErrateDTO implements Serializable {
    
	private static final long serialVersionUID = 1030991731814010069L;

	@JsonProperty("resultCompleted")
    private String resultCompleted;
    
    @JsonProperty("woorkItemId")
    private String woorkItemId;
    
    public String getResultCompleted() {
        return resultCompleted;
    }
    
    public void setResultCompleted(String resultCompleted) {
        this.resultCompleted = resultCompleted;
    }
    
    public String getWoorkItemId() {
        return woorkItemId;
    }
    
    public void setWoorkItemId(String woorkItemId) {
        this.woorkItemId = woorkItemId;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((resultCompleted == null) ? 0 : resultCompleted.hashCode());
        result = prime * result + ((woorkItemId == null) ? 0 : woorkItemId.hashCode());
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
        ListUserTaskResultErrateDTO other = (ListUserTaskResultErrateDTO) obj;
        if (resultCompleted == null) {
            if (other.resultCompleted != null)
                return false;
        } else if (!resultCompleted.equals(other.resultCompleted))
            return false;
        if (woorkItemId == null) {
            if (other.woorkItemId != null)
                return false;
        } else if (!woorkItemId.equals(other.woorkItemId))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
		return "ListUserTaskResultErrateDTO [resultCompleted=" + resultCompleted + ", woorkItemId=" + woorkItemId + "]";
    }
    
}
