package com.nttdata.tim.now.data.dto.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//SM_10433
@JsonInclude(Include.NON_NULL) 
public class RecuperoFlagMulticastOutputDTO extends ESBResultDTO implements Serializable {
	
	private static final long serialVersionUID = 7171142430390093473L;
	
	@JsonProperty("flagMulticast")
	private String flagMulticast;

	public String getFlagMulticast() {
		return flagMulticast;
	}

	public void setFlagMulticast(String flagMulticast) {
		this.flagMulticast = flagMulticast;
	}
	
 }
