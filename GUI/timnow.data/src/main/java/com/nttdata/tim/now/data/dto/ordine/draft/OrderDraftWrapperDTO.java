package com.nttdata.tim.now.data.dto.ordine.draft;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class OrderDraftWrapperDTO extends ESBResultDTO {

	private static final long serialVersionUID = 5964705933963797908L;
	
	@JsonProperty("structOrdiniBozza")
	private OrderDraftDTO draft;

	public OrderDraftDTO getDraft() {
		return draft;
	}

	public void setDraft(OrderDraftDTO draft) {
		this.draft = draft;
	}

}
