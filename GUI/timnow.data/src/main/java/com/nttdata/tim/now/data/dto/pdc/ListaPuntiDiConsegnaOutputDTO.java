package com.nttdata.tim.now.data.dto.pdc;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class ListaPuntiDiConsegnaOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -9194891920616241859L;
	
	@JsonProperty("listaPDC")
	private List<PuntoDiConsegnaOutputDTO> listaPDC;

	public List<PuntoDiConsegnaOutputDTO> getListaPDC() {
		return listaPDC;
	}

	public void setListaPDC(List<PuntoDiConsegnaOutputDTO> listaPDC) {
		this.listaPDC = listaPDC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaPDC == null) ? 0 : listaPDC.hashCode());
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
		ListaPuntiDiConsegnaOutputDTO other = (ListaPuntiDiConsegnaOutputDTO) obj;
		if (listaPDC == null) {
			if (other.listaPDC != null)
				return false;
		} else if (!listaPDC.equals(other.listaPDC))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaPuntiDiConsegnaOutputDTO [listaPDC=" + listaPDC + "]";
	}

	

}