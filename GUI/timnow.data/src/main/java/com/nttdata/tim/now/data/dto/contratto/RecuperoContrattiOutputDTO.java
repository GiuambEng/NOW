package com.nttdata.tim.now.data.dto.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL) 
public class RecuperoContrattiOutputDTO implements Serializable{

	private static final long serialVersionUID = -3295643083788389167L;

    @JsonProperty("recuperoContrattoOutput")
    RecuperoContrattiOutputItemDTO recuperoContrattoOutput;

    public RecuperoContrattiOutputItemDTO getRecuperoContrattoOutput() {
          return recuperoContrattoOutput;
    }

    public void setRecuperoContrattoOutput(RecuperoContrattiOutputItemDTO recuperoContrattoOutput) {
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
          RecuperoContrattiOutputDTO other = (RecuperoContrattiOutputDTO) obj;
          if (recuperoContrattoOutput == null) {
                 if (other.recuperoContrattoOutput != null)
                       return false;
          } else if (!recuperoContrattoOutput.equals(other.recuperoContrattoOutput))
                 return false;
          return true;
    }

    @Override
    public String toString() {
          return "RecuperoContrattiOutputDTO [recuperoContrattoOutput=" + recuperoContrattoOutput + "]";
    }
}

