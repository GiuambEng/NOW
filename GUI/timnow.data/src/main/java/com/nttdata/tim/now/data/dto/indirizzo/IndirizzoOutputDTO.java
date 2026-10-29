package com.nttdata.tim.now.data.dto.indirizzo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class IndirizzoOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 182317975081093329L;
	
	@JsonProperty("items")
	private List<String> items;

	public List<String> getItems() {
		return items;
	}

	@JsonSetter("provincia")
	public void setProvince(List<String> items) {
		this.items = items;
	}

	@JsonSetter("comune")
	public void setComuni(List<String> items) {
		this.items = items;
	}

	@JsonSetter("particellaToponomastica")
	public void setParticelle(List<String> items) {
		this.items = items;
	}

	@JsonSetter("indirizzo")
	public void setIndirizzi(List<String> items) {
		this.items = items;
	}

	@JsonSetter("civico")
	public void setCivici(List<String> items) {
		this.items = items;
	}
	
	//RU_1475
	@JsonSetter("codiceEgon")
	public void setCodiciEgon(List<String> items) {
		this.items = items;
	}

}
