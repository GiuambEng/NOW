package com.nttdata.tim.now.data.dto.ordine.donating;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdineDonatingDetailListOutputDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = 179984103723803398L;
	
	@JsonProperty("OutputOrdiniDonatingDettaglio")
	private List<OrdineDonatingDetailOutputDTO> list;

	@JsonProperty("OutputOrdiniDonatingRichieste")
	private List<OrdineDonatingRichiesteOutputDTO> listRichieste;

	public List<OrdineDonatingDetailOutputDTO> getList() {
		return list;
	}

	public void setList(List<OrdineDonatingDetailOutputDTO> list) {
		this.list = list;
	}

	public List<OrdineDonatingRichiesteOutputDTO> getListRichieste() {
		return listRichieste;
	}

	public void setListRichieste(List<OrdineDonatingRichiesteOutputDTO> listRichieste) {
		this.listRichieste = listRichieste;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((listRichieste == null) ? 0 : listRichieste.hashCode());
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
		OrdineDonatingDetailListOutputDTO other = (OrdineDonatingDetailListOutputDTO) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (listRichieste == null) {
			if (other.listRichieste != null)
				return false;
		} else if (!listRichieste.equals(other.listRichieste))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdineDonatingDetailListOutputDTO [list=" + list + ", listRichieste=" + listRichieste + "]";
	}
	

}
