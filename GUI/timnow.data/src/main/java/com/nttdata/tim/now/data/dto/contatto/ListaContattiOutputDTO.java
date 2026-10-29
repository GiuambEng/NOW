package com.nttdata.tim.now.data.dto.contatto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class ListaContattiOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = -5318383732174685620L;
	
	@JsonProperty("contactListOutput")
    private List<ContattoOutputDTO> contacts;

    public List<ContattoOutputDTO> getContacts() {
	return contacts;
    }

    public void setContacts(List<ContattoOutputDTO> contacts) {
	this.contacts = contacts;
    }

}
