
package com.nttdata.tim.now.data.bean.monitoring.usertask;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserTaskOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -3966091185769584989L;
    @JsonProperty("userTaskCausaliErrate")
    private List<UserTaskCausaliErrateBean> userTaskCausaliErrate;
    @JsonProperty("userTaskCausaliImproprie")
    private List<UserTaskCausaliImproprieBean> userTaskCausaliImproprie;
    @JsonProperty("userTaskCausaliSbagliate")
    private List<UserTaskCausaliSbagliateBean> userTaskCausaliSbagliate;
    public List<UserTaskCausaliErrateBean> getUserTaskCausaliErrate() {
        return userTaskCausaliErrate;
    }
    public void setUserTaskCausaliErrate(List<UserTaskCausaliErrateBean> userTaskCausaliErrate) {
        this.userTaskCausaliErrate = userTaskCausaliErrate;
    }
    public List<UserTaskCausaliImproprieBean> getUserTaskCausaliImproprie() {
        return userTaskCausaliImproprie;
    }
    public void setUserTaskCausaliImproprie(List<UserTaskCausaliImproprieBean> userTaskCausaliImproprie) {
        this.userTaskCausaliImproprie = userTaskCausaliImproprie;
    }
    public List<UserTaskCausaliSbagliateBean> getUserTaskCausaliSbagliate() {
        return userTaskCausaliSbagliate;
    }
    public void setUserTaskCausaliSbagliate(List<UserTaskCausaliSbagliateBean> userTaskCausaliSbagliate) {
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
        UserTaskOutputBean other = (UserTaskOutputBean) obj;
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
        return "UserTaskBeanOutput [userTaskCausaliErrate=" + userTaskCausaliErrate + ", userTaskCausaliImproprie=" + userTaskCausaliImproprie
                + ", userTaskCausaliSbagliate=" + userTaskCausaliSbagliate + "]";
    }

    
}
