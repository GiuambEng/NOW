package com.nttdata.tim.now.data.dto.centraligbe;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class ListaCentraliGBEOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -2541851138244566065L;

	@JsonProperty("listaCentraliGBE")
	private List<CentraleGBEOutputDTO> listaCentraliGBE;

	public List<CentraleGBEOutputDTO> getListaCentraliGBE() {
		return listaCentraliGBE;
	}

	public void setListaCentraliGBE(List<CentraleGBEOutputDTO> listaCentraliGBE) {
		this.listaCentraliGBE = listaCentraliGBE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaCentraliGBE == null) ? 0 : listaCentraliGBE.hashCode());
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
		ListaCentraliGBEOutputDTO other = (ListaCentraliGBEOutputDTO) obj;
		if (listaCentraliGBE == null) {
			if (other.listaCentraliGBE != null)
				return false;
		} else if (!listaCentraliGBE.equals(other.listaCentraliGBE))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaCentraliGBEOutputDTO [listaCentraliGBE=" + listaCentraliGBE + "]";
	}

}