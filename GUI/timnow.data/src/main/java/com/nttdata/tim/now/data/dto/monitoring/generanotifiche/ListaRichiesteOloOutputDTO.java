package com.nttdata.tim.now.data.dto.monitoring.generanotifiche;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaRichiesteOloOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 7444727476934347301L;
	
	@JsonProperty("outputListaRichiesteOlo")
	private List<RichiestaOloOutputDTO> oloRequests;

	public List<RichiestaOloOutputDTO> getOloRequests() {
		return oloRequests;
	}

	public void setOloRequests(List<RichiestaOloOutputDTO> oloRequests) {
		this.oloRequests = oloRequests;
	}

	@Override
	public String toString() {
		return "ListaRichiesteOloOutputDTO [oloRequests=" + oloRequests + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oloRequests == null) ? 0 : oloRequests.hashCode());
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
		ListaRichiesteOloOutputDTO other = (ListaRichiesteOloOutputDTO) obj;
		if (oloRequests == null) {
			if (other.oloRequests != null)
				return false;
		} else if (!oloRequests.equals(other.oloRequests))
			return false;
		return true;
	}

}
