package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//SM_10433
@JsonInclude(Include.NON_NULL) 
public class RecuperoFlagMulticastOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 98852441209491017L;
	
	@JsonProperty("flagMulticast")
	private String flagMulticast;

	public String getFlagMulticast() {
		return flagMulticast;
	}

	public void setFlagMulticast(String flagMulticast) {
		this.flagMulticast = flagMulticast;
	}
}
