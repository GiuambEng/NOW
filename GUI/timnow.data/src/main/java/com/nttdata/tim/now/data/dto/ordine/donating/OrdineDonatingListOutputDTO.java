package com.nttdata.tim.now.data.dto.ordine.donating;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdineDonatingListOutputDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = 8887267922809791945L;
	
	@JsonProperty("listaOrdiniDonatingOutput")
	private List<OrdineDonatingOutputDTO> list;

	@JsonProperty("listaOrdiniDonatingOutput")
	public List<OrdineDonatingOutputDTO> getList() {
		return list;
	}

	@JsonProperty("listaOrdiniDonatingOutput")
	public void setList(List<OrdineDonatingOutputDTO> list) {
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
		OrdineDonatingListOutputDTO other = (OrdineDonatingListOutputDTO) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdineDonatingListOutputDTO [list=" + list + "]";
	}

}
