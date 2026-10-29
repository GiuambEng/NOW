package com.nttdata.tim.now.data.dto.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL) 
public class ModificaContrattoInputDTO implements Serializable{

	private static final long serialVersionUID = -7695270234774576649L;
	
	@JsonProperty("modificaContrattoInput")
	private ModificaContrattoItemInputDTO modificaContrattoInput;

	public ModificaContrattoItemInputDTO getModificaContrattoInput() {
		return modificaContrattoInput;
	}

	public void setModificaContrattoInput(ModificaContrattoItemInputDTO modificaContrattoInput) {
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
                   ModificaContrattoInputDTO other = (ModificaContrattoInputDTO) obj;
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
