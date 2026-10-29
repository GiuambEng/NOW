package com.nttdata.tim.now.data.dto.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ESBResultDTO implements Serializable {
	
	private static final long serialVersionUID = 6513978687422878577L;
	
	private ResultDTO result;

	public ResultDTO getResult() {
		return result;
	}

	public void setResult(ResultDTO result) {
		this.result = result;
	}
}