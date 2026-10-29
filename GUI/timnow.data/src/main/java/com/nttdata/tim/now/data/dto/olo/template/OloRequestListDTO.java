package com.nttdata.tim.now.data.dto.olo.template;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class OloRequestListDTO extends ESBResultDTO {

	private static final long serialVersionUID = -8809196097361849549L;
	
	@JsonProperty("id_richiesta_olo")
	private List<String> ids;

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

}
