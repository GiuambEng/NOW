
package com.nttdata.tim.now.data.bean.monitoring.usertask;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModUserTaskCausaliOutputBean extends AbstractOutputBean implements Serializable{

    private static final long serialVersionUID = 8076717495474569986L;
    @JsonProperty("listUserTaskResultErrate")
    private List<ListUserTaskResultErrateBean> listUserTaskResultErrate;
    @JsonProperty("listUserTaskResultSbagliateDTU")
    private List<ListUserTaskResultSbagliateDTUBean> listUserTaskResultSbagliateDTU;
    @JsonProperty("listUserTaskResultImproprie")
    private ListUserTaskResultImproprieBean listUserTaskResultImproprie;
    public List<ListUserTaskResultErrateBean> getListUserTaskResultErrate() {
        return listUserTaskResultErrate;
    }
    public void setListUserTaskResultErrate(List<ListUserTaskResultErrateBean> listUserTaskResultErrate) {
        this.listUserTaskResultErrate = listUserTaskResultErrate;
    }
    public List<ListUserTaskResultSbagliateDTUBean> getListUserTaskResultSbagliateDTU() {
        return listUserTaskResultSbagliateDTU;
    }
    public void setListUserTaskResultSbagliateDTU(List<ListUserTaskResultSbagliateDTUBean> listUserTaskResultSbagliateDTU) {
        this.listUserTaskResultSbagliateDTU = listUserTaskResultSbagliateDTU;
    }
    public ListUserTaskResultImproprieBean getListUserTaskResultImproprie() {
        return listUserTaskResultImproprie;
    }
    public void setListUserTaskResultImproprie(ListUserTaskResultImproprieBean listUserTaskResultImproprie) {
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
        ModUserTaskCausaliOutputBean other = (ModUserTaskCausaliOutputBean) obj;
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
        return "ModUserTaskCausaliOutputBean [listUserTaskResultErrate=" + listUserTaskResultErrate + ", listUserTaskResultSbagliateDTU="
                + listUserTaskResultSbagliateDTU + ", listUserTaskResultImproprie=" + listUserTaskResultImproprie + "]";
    }

    
}
