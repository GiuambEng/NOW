package com.nttdata.tim.now.data.dto.contratto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class ListaContrattiOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = 2336569997310011995L;
	
	@JsonProperty("contratto")
	private List<ContrattoOutputDTO> contracts;

	public List<ContrattoOutputDTO> getContracts() {
		return contracts;
	}

	public void setContracts(List<ContrattoOutputDTO> contracts) {
		this.contracts = contracts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contracts == null) ? 0 : contracts.hashCode());
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
		ListaContrattiOutputDTO other = (ListaContrattiOutputDTO) obj;
		if (contracts == null) {
			if (other.contracts != null)
				return false;
		} else if (!contracts.equals(other.contracts))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaContrattiOutputDTO [contracts=" + contracts + "]";
	}

}
