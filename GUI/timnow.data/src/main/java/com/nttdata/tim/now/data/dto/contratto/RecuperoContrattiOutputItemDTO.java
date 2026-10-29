package com.nttdata.tim.now.data.dto.contratto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL) 
public class RecuperoContrattiOutputItemDTO extends ESBResultDTO implements Serializable {
	
	private static final long serialVersionUID = -4056139719626544016L;
    
	@JsonProperty("tipologiaContrattoOutput")
    private List<TipologiaContrattoOutputDTO> tipologiaContrattoOutput;

    public List<TipologiaContrattoOutputDTO> getTipologiaContrattoOutput() {
          return tipologiaContrattoOutput;
    }

    public void setTipologiaContrattoOutput(List<TipologiaContrattoOutputDTO> tipologiaContrattoOutput) {
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
          RecuperoContrattiOutputItemDTO other = (RecuperoContrattiOutputItemDTO) obj;
          if (tipologiaContrattoOutput == null) {
                 if (other.tipologiaContrattoOutput != null)
                       return false;
          } else if (!tipologiaContrattoOutput.equals(other.tipologiaContrattoOutput))
                 return false;
          return true;
    }

    @Override
    public String toString() {
          return "RecuperoContrattiOutputItemDTO [tipologiaContrattoOutput=" + tipologiaContrattoOutput + "]";
    }
    


}
