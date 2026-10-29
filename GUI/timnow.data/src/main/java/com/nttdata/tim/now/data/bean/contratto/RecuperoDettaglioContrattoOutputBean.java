package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL) 
public class RecuperoDettaglioContrattoOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 1061990449056434181L;
	
	@JsonProperty("dettaglioContratto")
    RecuperoDettaglioContrattoOutputItemBean dettaglioContratto;

    public RecuperoDettaglioContrattoOutputItemBean getDettaglioContratto() {
          return dettaglioContratto;
    }

    public void setDettaglioContratto(RecuperoDettaglioContrattoOutputItemBean dettaglioContratto) {
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
          RecuperoDettaglioContrattoOutputBean other = (RecuperoDettaglioContrattoOutputBean) obj;
          if (dettaglioContratto == null) {
                 if (other.dettaglioContratto != null)
                       return false;
          } else if (!dettaglioContratto.equals(other.dettaglioContratto))
                 return false;
          return true;
    }

    @Override
    public String toString() {
          return "RecuperoDettaglioContrattoOutputBean [dettaglioContratto=" + dettaglioContratto + "]";
    }
    
}

