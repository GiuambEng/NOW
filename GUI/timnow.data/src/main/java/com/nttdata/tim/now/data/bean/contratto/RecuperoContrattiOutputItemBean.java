package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL) 
public class RecuperoContrattiOutputItemBean extends AbstractOutputBean implements Serializable{
    
    private static final long serialVersionUID = 899505048702320649L;
    
    @JsonProperty("tipologiaContrattoOutput")
    private List<TipologiaContrattoOutputBean> tipologiaContrattoOutput;

    public List<TipologiaContrattoOutputBean> getTipologiaContrattoOutput() {
          return tipologiaContrattoOutput;
    }

    public void setTipologiaContrattoOutput(List<TipologiaContrattoOutputBean> tipologiaContrattoOutput) {
          this.tipologiaContrattoOutput = tipologiaContrattoOutput;
    }

    @Override
    public int hashCode() {
          final int prime = 31;
          int result = 1;
          result = prime * result + ((tipologiaContrattoOutput == null) ? 0 : tipologiaContrattoOutput.hashCode());
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
          RecuperoContrattiOutputItemBean other = (RecuperoContrattiOutputItemBean) obj;
          if (tipologiaContrattoOutput == null) {
                 if (other.tipologiaContrattoOutput != null)
                       return false;
          } else if (!tipologiaContrattoOutput.equals(other.tipologiaContrattoOutput))
                 return false;
          return true;
    }

    @Override
    public String toString() {
          return "RecuperoContrattiOutputItemBean [tipologiaContrattoOutput=" + tipologiaContrattoOutput + "]";
    }
    
}