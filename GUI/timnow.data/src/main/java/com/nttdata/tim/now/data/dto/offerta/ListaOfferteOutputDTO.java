package com.nttdata.tim.now.data.dto.offerta;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaOfferteOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -4596604681714707347L;
	
	@JsonProperty("listaOffertaoutput")
	private List<OffertaOutputDTO> offers;

	public List<OffertaOutputDTO> getOffers() {
		return offers;
	}

	public void setOffers(List<OffertaOutputDTO> offers) {
		this.offers = offers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offers == null) ? 0 : offers.hashCode());
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
		ListaOfferteOutputDTO other = (ListaOfferteOutputDTO) obj;
		if (offers == null) {
			if (other.offers != null)
				return false;
		} else if (!offers.equals(other.offers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaOfferteOutputDTO [offers=" + offers + "]";
	}
	

}
