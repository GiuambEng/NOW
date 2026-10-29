package com.nttdata.tim.now.data.dto.offerta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class DettaglioOffertaWrapperOutputDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = -722620092137310223L;
	
	@JsonProperty("offertaOutput")
	private DettaglioOffertaOutputDTO offerDetail;

	public DettaglioOffertaOutputDTO getOfferDetail() {
		return offerDetail;
	}

	public void setOfferDetail(DettaglioOffertaOutputDTO offerDetail) {
		this.offerDetail = offerDetail;
	}

}
