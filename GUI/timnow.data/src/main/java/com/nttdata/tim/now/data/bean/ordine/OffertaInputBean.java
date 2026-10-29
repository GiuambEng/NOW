package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class OffertaInputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -1679341868998112085L;

    @JsonProperty("offerta")
	private String offerta;

	@JsonProperty("offerTopDetails")
	private Map<String, DettaglioOffertaOrdineBean> offerTopDetails;

	@JsonProperty("offerBotDetails")
	private List<DettaglioOffertaOrdineBean> offerBotDetails;

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public Map<String, DettaglioOffertaOrdineBean> getOfferTopDetails() {
		return offerTopDetails;
	}

	public void setOfferTopDetails(Map<String, DettaglioOffertaOrdineBean> offerTopDetails) {
		this.offerTopDetails = offerTopDetails;
	}

	public List<DettaglioOffertaOrdineBean> getOfferBotDetails() {
		return offerBotDetails;
	}

	public void setOfferBotDetails(List<DettaglioOffertaOrdineBean> offerBotDetails) {
		this.offerBotDetails = offerBotDetails;
	}

	@Override
	public String toString() {
		return "OffertaInputBean [offerta=" + offerta + ", offerTopDetails=" + offerTopDetails + ", offerBotDetails="
				+ offerBotDetails + "]";
	}

}