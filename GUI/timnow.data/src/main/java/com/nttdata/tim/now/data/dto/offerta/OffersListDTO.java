package com.nttdata.tim.now.data.dto.offerta;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class OffersListDTO extends ESBResultDTO {

	private static final long serialVersionUID = -7155964027995667618L;
	
	@JsonProperty("offers")
	private List<DettaglioOffertaOutputDTO> offers;

	public List<DettaglioOffertaOutputDTO> getOffers() {
		return offers;
	}

	public void setOffers(List<DettaglioOffertaOutputDTO> offers) {
		this.offers = offers;
	}

}
