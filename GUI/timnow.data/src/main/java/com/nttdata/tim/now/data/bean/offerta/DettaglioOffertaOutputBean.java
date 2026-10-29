package com.nttdata.tim.now.data.bean.offerta;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.data.bean.ordine.DettaglioOffertaOrdineBean;

@JsonInclude(Include.NON_NULL)
public class DettaglioOffertaOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -948247405738075364L;

    @JsonProperty("offerta")
	private String offerta;

	@JsonProperty("offerTopDetails")
	private Map<String, DettaglioOffertaOrdineBean> offerTopDetails;

	@JsonProperty("offerBotDetails")
	private Map<String, DettaglioOffertaOrdineBean> offerBotDetails;

	@JsonProperty("readonlyDetails")
	private Map<String, DettaglioOffertaOrdineBean> readonlyDetails;

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

	public Map<String, DettaglioOffertaOrdineBean> getOfferBotDetails() {
		return offerBotDetails;
	}

	public void setOfferBotDetails(Map<String, DettaglioOffertaOrdineBean> offerBotDetails) {
		this.offerBotDetails = offerBotDetails;
	}

	public Map<String, DettaglioOffertaOrdineBean> getReadonlyDetails() {
		return readonlyDetails;
	}

	public void setReadonlyDetails(Map<String, DettaglioOffertaOrdineBean> readonlyDetails) {
		this.readonlyDetails = readonlyDetails;
	}

}