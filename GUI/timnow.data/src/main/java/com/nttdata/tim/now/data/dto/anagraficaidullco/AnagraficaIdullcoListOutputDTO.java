package com.nttdata.tim.now.data.dto.anagraficaidullco;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class AnagraficaIdullcoListOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -7426436763077743085L;

	@JsonProperty("listaIdullco")
	private List<AnagraficaIdullcoOutputDTO> list;

	public List<AnagraficaIdullcoOutputDTO> getList() {
		return list;
	}

	public void setList(List<AnagraficaIdullcoOutputDTO> list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		AnagraficaIdullcoListOutputDTO other = (AnagraficaIdullcoListOutputDTO) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AnagraficaIdullcoListOutputDTO [list=" + list + "]";
	}

	
}
