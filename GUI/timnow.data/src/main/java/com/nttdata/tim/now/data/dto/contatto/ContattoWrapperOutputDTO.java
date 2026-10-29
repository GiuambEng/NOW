package com.nttdata.tim.now.data.dto.contatto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ContattoWrapperOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 3186505278624406905L;
	
	@JsonProperty("contactDetailOutput")
    private ContattoOutputDTO contact;

    public ContattoOutputDTO getContact() {
	return contact;
    }

    public void setContact(ContattoOutputDTO contact) {
	this.contact = contact;
    }

}
