package com.nttdata.tim.now.data.dto.faq;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaFaqDTO extends ESBResultDTO {

	private static final long serialVersionUID = -4571772159445790652L;
	
	@JsonProperty("FAQ_Output")
	private List<FaqDTO> faqs;

	public List<FaqDTO> getFaqs() {
		return faqs;
	}

	public void setFaqs(List<FaqDTO> faqs) {
		this.faqs = faqs;
	}

}
