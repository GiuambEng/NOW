package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL) 
public class ModificaContrattoInputBean implements Serializable{

	private static final long serialVersionUID = -6256837302514223691L;
	
	@JsonProperty("modificaContrattoInput")
	private ModificaContrattoItemInputBean modificaContrattoInput;

	public ModificaContrattoItemInputBean getModificaContrattoInput() {
		return modificaContrattoInput;
	}

	public void setModificaContrattoInput(ModificaContrattoItemInputBean modificaContrattoInput) {
		this.modificaContrattoInput = modificaContrattoInput;
	}

	@Override
    public int hashCode() {
                   final int prime = 31;
                   int result = 1;
                   result = prime * result + ((modificaContrattoInput == null) ? 0 : modificaContrattoInput.hashCode());
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
                   ModificaContrattoInputBean other = (ModificaContrattoInputBean) obj;
                   if (modificaContrattoInput == null) {
                                 if (other.modificaContrattoInput != null)
                                                return false;
                   } else if (!modificaContrattoInput.equals(other.modificaContrattoInput))
                                 return false;
                   return true;
    }

    @Override
    public String toString() {
       return "ModificaContrattoItemInputBean [modificaContrattoInput=" + modificaContrattoInput +  "]";
    }

	
}
