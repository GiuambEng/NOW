package com.nttdata.tim.now.data.bean.offerta;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class DettaglioOffertaWrapperOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -3787789395922121096L;

    @JsonProperty("offerDetail")
	private DettaglioOffertaOutputBean offerDetail;

	public DettaglioOffertaOutputBean getOfferDetail() {
		return offerDetail;
	}

	public void setOfferDetail(DettaglioOffertaOutputBean offerDetail) {
		this.offerDetail = offerDetail;
	}

}