package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL) 
public class RecuperoContrattiOutputBean extends AbstractOutputBean implements Serializable{

    
    private static final long serialVersionUID = -8486070501067972005L;
    
    @JsonProperty("recuperoContrattoOutput")
    RecuperoContrattiOutputItemBean recuperoContrattoOutput;

    public RecuperoContrattiOutputItemBean getRecuperoContrattoOutput() {
          return recuperoContrattoOutput;
    }

    public void setRecuperoContrattoOutput(RecuperoContrattiOutputItemBean recuperoContrattoOutput) {
          this.recuperoContrattoOutput = recuperoContrattoOutput;
    }

    @Override
    public int hashCode() {
          final int prime = 31;
          int result = 1;
          result = prime * result + ((recuperoContrattoOutput == null) ? 0 : recuperoContrattoOutput.hashCode());
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
          RecuperoContrattiOutputBean other = (RecuperoContrattiOutputBean) obj;
          if (recuperoContrattoOutput == null) {
                 if (other.recuperoContrattoOutput != null)
                       return false;
          } else if (!recuperoContrattoOutput.equals(other.recuperoContrattoOutput))
                 return false;
          return true;
    }

    @Override
    public String toString() {
          return "RecuperoContrattiBean [recuperoContrattoOutput=" + recuperoContrattoOutput + "]";
    }
    
    
}

