package com.nttdata.tim.now.data.dto.contatto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaRiferimentiContattoOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -4373016313417055654L;
	
	@JsonProperty("riferimentiContatti")
	private List<RiferimentiContattoOutputDTO> references;

	public List<RiferimentiContattoOutputDTO> getReferences() {
		return references;
	}

	public void setReferences(List<RiferimentiContattoOutputDTO> references) {
		this.references = references;
	}

}
