package com.nttdata.tim.now.data.dto.offerta;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class DettaglioOffertaOutputDTO implements Serializable {

	private static final long serialVersionUID = -3187810008823568728L;

	@JsonProperty("offerta")
	private String offerta;

	@JsonProperty("sezioneSuperiore")
	private List<OfferDetailDTO> offerTopDetails;

	@JsonProperty("sezioneInferiore")
	private List<OfferDetailDTO> offerBotDetails;

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public List<OfferDetailDTO> getOfferTopDetails() {
		return offerTopDetails;
	}

	public void setOfferTopDetails(List<OfferDetailDTO> offerTopDetails) {
		this.offerTopDetails = offerTopDetails;
	}

	public List<OfferDetailDTO> getOfferBotDetails() {
		return offerBotDetails;
	}

	public void setOfferBotDetails(List<OfferDetailDTO> offerBotDetails) {
		this.offerBotDetails = offerBotDetails;
	}

}
