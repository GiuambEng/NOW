package com.nttdata.tim.now.data.dto.centralinga;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1058
@JsonInclude(Include.NON_NULL)
public class ListaCentraliNGAOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -3730977448991163401L;
	
	@JsonProperty("listaCentraliNGA")
	private List<CentraleNGAOutputDTO> listaCentraliNGA;

	public List<CentraleNGAOutputDTO> getListaCentraliGBE() {
		return listaCentraliNGA;
	}

	public void setListaCentraliNGA(List<CentraleNGAOutputDTO> listaCentraliNGA) {
		this.listaCentraliNGA = listaCentraliNGA;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaCentraliNGA == null) ? 0 : listaCentraliNGA.hashCode());
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
		ListaCentraliNGAOutputDTO other = (ListaCentraliNGAOutputDTO) obj;
		if (listaCentraliNGA == null) {
			if (other.listaCentraliNGA != null)
				return false;
		} else if (!listaCentraliNGA.equals(other.listaCentraliNGA))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaCentraliNGAOutputDTO [listaCentraliNGA=" + listaCentraliNGA + "]";
	}

}