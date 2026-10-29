package com.nttdata.tim.now.data.dto.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL) 
public class RecuperoDettaglioContrattoOutputDTO extends ESBResultDTO implements Serializable{
    
    private static final long serialVersionUID = -359103351980080488L;
    
    @JsonProperty("dettaglioContratto")
    RecuperoDettaglioContrattoOutputItemDTO dettaglioContratto;

    public RecuperoDettaglioContrattoOutputItemDTO getDettaglioContratto() {
          return dettaglioContratto;
    }

    public void setDettaglioContratto(RecuperoDettaglioContrattoOutputItemDTO dettaglioContratto) {
          this.dettaglioContratto = dettaglioContratto;
    }

    @Override
    public int hashCode() {
          final int prime = 31;
          int result = 1;
          result = prime * result + ((dettaglioContratto == null) ? 0 : dettaglioContratto.hashCode());
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
          RecuperoDettaglioContrattoOutputDTO other = (RecuperoDettaglioContrattoOutputDTO) obj;
          if (dettaglioContratto == null) {
                 if (other.dettaglioContratto != null)
                       return false;
          } else if (!dettaglioContratto.equals(other.dettaglioContratto))
                 return false;
          return true;
    }

    @Override
    public String toString() {
          return "RecuperoDettaglioContrattoOutputDTO [dettaglioContratto=" + dettaglioContratto + "]";
    }
    
}

