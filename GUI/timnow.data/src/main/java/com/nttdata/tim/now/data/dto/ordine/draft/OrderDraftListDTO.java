package com.nttdata.tim.now.data.dto.ordine.draft;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
@JsonInclude(Include.NON_NULL)
public class OrderDraftListDTO extends ESBResultDTO {

	private static final long serialVersionUID = -8895746497645713765L;
	
	@JsonProperty("ordiniInBozza")
	private List<OrderDraftDTO> drafts;

	public List<OrderDraftDTO> getDrafts() {
		return drafts;
	}

	public void setDrafts(List<OrderDraftDTO> drafts) {
		this.drafts = drafts;
	}

}
