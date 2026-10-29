package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1166
public class RecuperaMacroAreaWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -9040298030216414408L;
	
	@JsonProperty("listaMacroaree")
    private List<RecuperaMacroAreaOutputDTO> listaMacroaree;

	public List<RecuperaMacroAreaOutputDTO> getListaMacroaree() {
		return listaMacroaree;
	}

	public void setListaMacroaree(List<RecuperaMacroAreaOutputDTO> listaMacroaree) {
		this.listaMacroaree = listaMacroaree;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaMacroaree == null) ? 0 : listaMacroaree.hashCode());
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
		RecuperaMacroAreaWrapperOutputDTO other = (RecuperaMacroAreaWrapperOutputDTO) obj;
		if (listaMacroaree == null) {
			if (other.listaMacroaree != null)
				return false;
		} else if (!listaMacroaree.equals(other.listaMacroaree))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaMacroAreaWrapperOutputDTO [listaMacroaree=" + listaMacroaree + "]";
	}	
}
