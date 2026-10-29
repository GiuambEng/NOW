
package com.nttdata.tim.now.data.dto.monitoring.usertask;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserTaskOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -4137021151177026212L;

	@JsonProperty("UserTaskCausaliErrate")
    private List<UserTaskCausaliErrateDTO> userTaskCausaliErrate;
    
    @JsonProperty("UserTaskCausaliImproprie")
    private List<UserTaskCausaliImproprieDTO> userTaskCausaliImproprie;
    
    @JsonProperty("UserTaskCausaliSbagliateDTU")
    private List<UserTaskCausaliSbagliateDTO> userTaskCausaliSbagliate;
    
    public List<UserTaskCausaliErrateDTO> getUserTaskCausaliErrate() {
        return userTaskCausaliErrate;
    }
    public void setUserTaskCausaliErrate(List<UserTaskCausaliErrateDTO> userTaskCausaliErrate) {
        this.userTaskCausaliErrate = userTaskCausaliErrate;
    }
    public List<UserTaskCausaliImproprieDTO> getUserTaskCausaliImproprie() {
        return userTaskCausaliImproprie;
    }
    public void setUserTaskCausaliImproprie(List<UserTaskCausaliImproprieDTO> userTaskCausaliImproprie) {
        this.userTaskCausaliImproprie = userTaskCausaliImproprie;
    }
    public List<UserTaskCausaliSbagliateDTO> getUserTaskCausaliSbagliate() {
        return userTaskCausaliSbagliate;
    }
    public void setUserTaskCausaliSbagliate(List<UserTaskCausaliSbagliateDTO> userTaskCausaliSbagliate) {
        this.userTaskCausaliSbagliate = userTaskCausaliSbagliate;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userTaskCausaliErrate == null) ? 0 : userTaskCausaliErrate.hashCode());
        result = prime * result + ((userTaskCausaliImproprie == null) ? 0 : userTaskCausaliImproprie.hashCode());
        result = prime * result + ((userTaskCausaliSbagliate == null) ? 0 : userTaskCausaliSbagliate.hashCode());
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
        UserTaskOutputDTO other = (UserTaskOutputDTO) obj;
        if (userTaskCausaliErrate == null) {
            if (other.userTaskCausaliErrate != null)
                return false;
        } else if (!userTaskCausaliErrate.equals(other.userTaskCausaliErrate))
            return false;
        if (userTaskCausaliImproprie == null) {
            if (other.userTaskCausaliImproprie != null)
                return false;
        } else if (!userTaskCausaliImproprie.equals(other.userTaskCausaliImproprie))
            return false;
        if (userTaskCausaliSbagliate == null) {
            if (other.userTaskCausaliSbagliate != null)
                return false;
        } else if (!userTaskCausaliSbagliate.equals(other.userTaskCausaliSbagliate))
            return false;
        return true;
    }
    @Override
    public String toString() {
		return "UserTaskOutputDTO [userTaskCausaliErrate=" + userTaskCausaliErrate + ", userTaskCausaliImproprie="
				+ userTaskCausaliImproprie + ", userTaskCausaliSbagliate=" + userTaskCausaliSbagliate + "]";
    }

    
}
