package com.nttdata.tim.now.data.dto.base;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericListDTO<T> extends ESBResultDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5018146358837797178L;
	
	@JsonProperty("data")
	private List<T> data;
	
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public List<T> getData() {
		return this.data;
	}
	
}
